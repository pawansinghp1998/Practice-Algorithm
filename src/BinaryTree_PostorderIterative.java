import java.util.Stack;

public class BinaryTree_PostorderIterative {
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
        TreeNode current=root;
        while (!stack.isEmpty()|| current!=null)
        {
            if(current!=null)
            {
               stack.push(current);
               current=current.left;
            }
            else{
                TreeNode temp=stack.peek().right;
                if(temp==null)
                {
                    temp=stack.pop();
                    System.out.println(temp.data);
                    while(!stack.isEmpty() && temp==stack.peek().right)
                    {
                        temp=stack.pop();
                        System.out.println((temp.data));
                    }
                }
                else{
                    current=temp;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        BinaryTree_PostorderIterative bt=new BinaryTree_PostorderIterative();
        bt.createBinaryTree();
        bt.preorder(bt.root);
    }
}
