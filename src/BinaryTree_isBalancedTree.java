import java.util.Stack;

public class BinaryTree_isBalancedTree {
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
        public static class BTPair{
            boolean isBT;
            int height;
        }
        public  static BTPair isBalancedTree(Node node){
            if(node==null){
                BTPair tt=new BTPair();
                tt.isBT=true;
                tt.height=0;
                return  tt;
            }
            BTPair ls=isBalancedTree(node.left);
            BTPair rs=isBalancedTree(node.right);
            BTPair bt=new BTPair();
            bt.height=Math.max(ls.height,rs.height)+1;
            bt.isBT= ls.isBT && rs.isBT && Math.abs(ls.height- rs.height)<=1;
            return bt;
        }
        //second method
    static  boolean isbalanced=true;
        public  static int isBalanced(Node node){
            if(node==null)
                return 0;
            int lh=isBalanced((node.left));
            int rh=isBalanced(node.right);
            if(lh-rh>1)
                isbalanced=false;
            return Math.max(lh,rh)+1;
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
            Integer[] arr={50,25,12,null,null, 37,30,13,null,null,null,null,75,62,null,70,null,null,87,null,null};
            Node root=new Node(arr[0],null,null);
            Pair rp=new Pair(root,1);
            Stack<Pair> st=new Stack<>();
            st.push(rp);
            int index=0;
            while(st.size()>0) {
                Pair top = st.peek();
                if (top.state == 1) {
                    index++;
                    if (arr[index] != null) {
                        Node ln = new Node(arr[index], null, null);
                        top.node.left = ln;
                        Pair lp = new Pair(ln, 1);
                        st.push(lp);
                    } else {
                        top.node.left = null;
                    }
                    top.state++;
                } else if (top.state == 2) {
                    index++;
                    if (arr[index] != null) {
                        Node rn = new Node(arr[index], null, null);
                        top.node.right = rn;
                        Pair rightp = new Pair(rn, 1);
                        st.push(rightp);
                    } else {
                        top.node.right = null;
                    }
                    top.state++;
                } else {
                    st.pop();
                }
            }
            display(root);
            BTPair bt= isBalancedTree(root);
            System.out.println(bt.isBT);
            isBalanced(root);
            System.out.println(isbalanced);
        }
    }

