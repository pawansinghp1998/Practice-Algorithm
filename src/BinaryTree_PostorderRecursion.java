public class BinaryTree_PostorderRecursion {
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
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args)
    {
        BinaryTree_PostorderRecursion bt=new BinaryTree_PostorderRecursion();
        bt.createBinaryTree();
        bt.preorder(bt.root);
    }
}