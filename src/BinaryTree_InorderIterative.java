import java.util.Stack;

public class BinaryTree_InorderIterative {
    private TreeNode root;
    private class TreeNode{
        private TreeNode left;
        private  TreeNode right;
        private int data;
        public TreeNode (int data){
            this.data=data;
        }
    }
    public void createBinaryTree(){
        TreeNode first=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        TreeNode fifth=new TreeNode(5);
        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        second.right=fifth;
    }
    public void preorder(TreeNode root)
    {
        if(root==null) {
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while (!stack.isEmpty()|| temp!=null)
        {
            if(temp!=null)
            {
                stack.push(temp);
                temp=temp.left;
            }
            else{
                temp=stack.pop();
                System.out.println(temp.data);
                temp=temp.right;
            }
        }
    }
    public static void main(String[] args)
    {
        BinaryTree_InorderIterative bt=new BinaryTree_InorderIterative();
        bt.createBinaryTree();
        bt.preorder(bt.root);
    }
}