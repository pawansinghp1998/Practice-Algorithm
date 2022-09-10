import java.util.Stack;

public class BinaryTree_LargestBST {
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
        public static  class LBST{
            Node lnode;
            int size;
        }
        public static class  BST{
            int min;
            int max;
            boolean isBSt;
        }
        public static BST isBST(Node node){
            if(node==null){
                BST bp=new BST();
                bp.min=Integer.MAX_VALUE;
                bp.max=Integer.MIN_VALUE;
                bp.isBSt=true;
                return bp;
            }
            BST ls=isBST(node.left);
            BST rs=isBST(node.right);
            BST mp=new BST();
            mp.isBSt= ls.isBSt && rs.isBSt &&(node.data>=ls.max && node.data<=rs.min);
            mp.max=Math.max(node.data,Math.max(ls.max,rs.max));
            mp.min=Math.min(node.data, Math.min(ls.min,rs.min));
            return mp;

        }
    static LBST max=new LBST();
        public  static  LBST FindLargestBST(Node node){
            if(node==null){
                LBST lb=new LBST();
                lb.size=0;
                lb.lnode=null;
                return lb;
            }
            LBST ls=FindLargestBST(node.left);
            LBST rs=FindLargestBST(node.right);
            if(isBST(node).isBSt && ls.size+rs.size+1 >max.size)
            {
            max.size=ls.size+rs.size+1;
            max.lnode=node;
            }
            LBST lb2=new LBST();
            lb2.size=ls.size+ rs.size+1;
            lb2.lnode=node;
            return lb2;
        }
        //second method to find the largest Binary Search Tree
        public static class  BST2{
            int min;
            int max;
            boolean isBSt;
            Node lbstRoot;
            int lbstSize;
        }
    public static BST2 isBST2(Node node){
        if(node==null){
            BST2 bp=new BST2();
            bp.min=Integer.MAX_VALUE;
            bp.max=Integer.MIN_VALUE;
            bp.isBSt=true;
            bp.lbstSize=0;
            bp.lbstRoot=null;
            return bp;
        }
        BST2 ls=isBST2(node.left);
        BST2 rs=isBST2(node.right);
        BST2 mp=new BST2();
        mp.isBSt= ls.isBSt && rs.isBSt &&(node.data>=ls.max && node.data<=rs.min);
        mp.max=Math.max(node.data,Math.max(ls.max,rs.max));
        mp.min=Math.min(node.data, Math.min(ls.min,rs.min));
        if(mp.isBSt)
        {
mp.lbstRoot=node;
mp.lbstSize=ls.lbstSize+ rs.lbstSize+1;
        }
        else if(ls.lbstSize>rs.lbstSize){
            mp.lbstSize= ls.lbstSize;
        }
        else mp.lbstSize= rs.lbstSize;
        return mp;

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
            FindLargestBST(root);
            System.out.println(max.lnode.data);
            System.out.println(max.size);
            BST2 mp=isBST2(root);
            System.out.println(mp.lbstRoot.data);
            System.out.println(mp.lbstSize);
        }
    }

