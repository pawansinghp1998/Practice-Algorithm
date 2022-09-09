import java.util.Stack;

public class BinaryTree_isBST {
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
        public static class BSTPair{
            int min;
            int max;
            boolean isBST;
        }
        public static BSTPair isTreeBST(Node node){
            if(node==null){
                BSTPair mp=new BSTPair();
                mp.min=Integer.MAX_VALUE;
                mp.max=Integer.MIN_VALUE;
                mp.isBST=true;
                return mp;
            }
            BSTPair ls=isTreeBST(node.left);
            BSTPair rs=isTreeBST(node.right);
            BSTPair bp=new BSTPair();
            bp.isBST=(node.data>=ls.max && node.data<= rs.min) && ls.isBST && rs.isBST;
            bp.min=Math.min(node.data, Math.min(ls.min,rs.min));
            bp.max=Math.max(node.data,Math.max(ls.max,rs.max));
return  bp;
        }
        public static void display(Node node)
        {
            if(node==null)
                return;
            String str="";
            str+=node.left==null?".":node.left.data+" ";
            str+="<-"+node.data+"->";
            str+=node.right==null?".":node.right.data+" ";
            System.out.println(str);
            display(node.left);
            display(node.right);
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
            display(root);
            BSTPair bp= isTreeBST(root);
           System.out.println(bp.isBST);

        }
    }


