import  java.io.*;
import java.util.*;
public class BinaryTree_Size {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right)
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
    public static int size(Node node)
    {
        if(node==null)
            return 0;
        int ls=size(node.left);
        int rs=size(node.right);
        return ls+rs+1;
    }
    public static int sum(Node node)
    {
        if(node==null)
            return 0;
        int ls=sum(node.left);
        int rs=sum(node.right);
        return ls+rs+node.data;
    }
    public static int max(Node node){
        if(node==null)
            return Integer.MIN_VALUE;
        int maxleft=max(node.left);
        int maxright=max(node.right);
        if(node.data>maxleft && node.data>maxright)
            return node.data;
        else if(maxleft>node.data && maxleft>maxright)
        return maxleft;
        else
            return maxright;
    }
    public static int height(Node node)
    {
        if(node==null)
            return -1;
        int lh=height(node.left);
        int rh=height(node.right);
        int th=Math.max(lh,rh)+1;
        return th;
    }
    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null, 37,30,null,null,null,75,62,null,70,null,null,87,null};
        Node root=new Node(arr[0],null,null);
        Pair rp=new Pair(root,1);
        Stack<Pair> st=new Stack<>();
        st.push(rp);
        int index=0;
        while(st.size()>0 && index<arr.length-1){
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

            }else{
                st.pop();
            }
        }
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));
    }
}
