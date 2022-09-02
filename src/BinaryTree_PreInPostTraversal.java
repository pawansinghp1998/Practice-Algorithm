
import java.util.*;
public class BinaryTree_PreInPostTraversal {
        public static class Node{
            int data;
            Node left;
            Node right;
            Node(int data, Node left, Node right)
            {
                this.data=data;
                this.left=left;
                this.right=right;
            }
        }
        public static class Pair{
            Node node;
            int state;
            Pair(Node node, int state){
                this.node=node;
                this.state=state;
            }
        }
        public static void display(Node node)
        {
            String pre="";
            String in="";
            String post="";
            Stack<Pair> stack=new Stack<>();
            Pair rp=new Pair(node ,1);
            stack.push(rp);
            while(stack.size()>0)
            {
                Pair top=stack.peek();
if(top.state==1)
{
    pre+=top.node.data+" ";
    top.state++;
    if(top.node.left!=null) {
        Pair left = new Pair(top.node.left, 1);
        stack.push(left);
    }
}
else if(top.state==2)
{
    in+=top.node.data+" ";
    top.state++;
    if(top.node.right!=null) {
        Pair right = new Pair(top.node.right, 1);
        stack.push(right);
    }
}
else{
    post+=top.node.data+" ";
    stack.pop();
}
            }
            System.out.println(pre);
            System.out.println(in);
            System.out.println(post);
        }
    public static void disp(Node node)
    {
        if(node==null)
            return;
        String str="";
        str+=node.left==null?".":node.left.data+" ";
        str+="<-"+node.data+"->";
        str+=node.right==null?".":node.right.data+" ";
        System.out.println(str);
        disp(node.left);
        disp(node.right);
    }
        public static void main(String[] args) {
            Integer[] arr={50,25,12,null,null, 37,30,null,null,null,75,62,null,70,null,null,87,null,null};
            Node root=new Node(arr[0],null,null);
            Pair rp=new Pair(root,1);
            Stack<Pair> st=new Stack<>();
            st.push(rp);
            int index=0;
            while(st.size()>0){
                Pair top=st.peek();
                if(top.state==1){
                    index ++;
                    if(arr[index]!=null){
                        Node ln=new Node(arr[index],null,null);
                        top.node.left=ln;
                        Pair lp=new Pair(ln,1);
                        st.push(lp);
                    }
                    else{
                        top.node.left=null;
                    }
                    top.state++;
                }else if (top.state==2){
                    index++;
                    if(arr[index]!=null)
                    {
                        Node rn=new Node(arr[index],null,null);
                        top.node.right=rn;
                        Pair rightp=new Pair(rn,1);
                        st.push(rightp);
                    }
                    else{
                        top.node.right=null;
                    }
                    top.state++;
                } else{
                    st.pop();
                }
            }
            //display(root);
            disp(root);
            display(root);
        }
    }

