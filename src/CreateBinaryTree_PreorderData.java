import  java.io.*;
import java.util.*;
public class CreateBinaryTree_PreorderData {
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
    }
}
