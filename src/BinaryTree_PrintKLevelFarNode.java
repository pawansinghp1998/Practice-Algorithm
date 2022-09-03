import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree_PrintKLevelFarNode {
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
    static ArrayList<Node> path=new ArrayList<>();
        public static void PrintKNodeFar(Node node, int data,int k){
            find(node,data);
            for(int i=0;i< path.size();i++){
                KLevelDown(path.get(i),k-i,i==0?null:path.get(i-1));
            }
        }
        public static boolean find(Node node, int data){
        if(node==null)
            return false;
        if(node.data==data){
            path.add(node);
            return true;
        }
        boolean left=find(node.left,data);
        if(left){
            path.add(node);
            return  true;
        }
        boolean right=find(node.right,data);
        if(right){
            path.add(node);
            return true;
        }
        return false;
        }
        public static void KLevelDown(Node node, int k ,Node blocker)
        {
            if(node==null || k<0 || node==blocker)
                return;
            if(k==0)
                System.out.println(node.data);
            KLevelDown(node.left,k-1,blocker);
            KLevelDown(node.right,k-1,blocker);
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
            PrintKNodeFar(root,70,1);
        }
    }

