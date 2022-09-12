public class CreateBinaryTree_FromPostInOrder {
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static int Search(int In[],int instart,int inend,int value){
        for(int i=instart;i<=inend;i++){
            if(In[i]==value)
                return i;
        }
        return  -1;
    }
    public static Node CreateBnaryTree(int In[],int Post[],int instart,int inend,int poststart,int postend){
        if(instart>inend)
            return null;
        Node tnode=new Node(Post[postend]);
        if(instart==inend)
            return tnode;
        int index=Search(In,instart,inend,tnode.data);
        tnode.left=CreateBnaryTree(In,Post,instart,index-1,poststart,poststart+index-instart-1);
tnode.right=CreateBnaryTree(In,Post,index+1,inend,postend-inend+index,postend-1);
return  tnode;
    }
    public  static  void display(Node node){
        if(node==null)
            return;
        display((node.left));
        display(node.right);
        System.out.print(node.data+" ");
    }

    public static void main(String[] args) {
        int In[]={4, 8, 2, 5, 1, 6, 3, 7};
        int Post[]={8, 4, 5, 2, 6, 7, 3, 1};
        int len=In.length;
        Node root=CreateBnaryTree(In,Post,0,len-1,0,len-1);
        display(root);
    }
}
