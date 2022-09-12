public class BinaryTree_FromInPreOrder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static int search(int In[],int start,int end,int value){
        for(int i=start;i<=end;i++){
            if(In[i]==value){
                return i;
            }
        }
        return -1;
    }
    static int c=0;
    public  static  Node CreateBinaryTree(int Pre[],int In[],int instart,int inend){
        if(instart>inend)
            return null;
        Node tnode=new Node(Pre[c++]);
        if(instart==inend){
            return tnode;
        }
        int index=search(In,instart,inend,tnode.data);
        tnode.left=CreateBinaryTree(Pre,In,instart,index-1);
        tnode.right=CreateBinaryTree(Pre,In,index+1,inend);
        return tnode;

    }
public static void display(Node node){
        if(node==null)
            return ;
        System.out.print(node.data+" ");
        display(node.left);
        display(node.right);
}
    public static void main(String[] args) {
        int Pre[]={1, 2, 4, 5, 3, 6};
        int In[]={4, 2, 5, 1, 6, 3 };
        int len=Pre.length;

        Node root=CreateBinaryTree(Pre,In,0,len-1);
        display(root);
    }
}
