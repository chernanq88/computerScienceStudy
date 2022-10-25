package trees;

public class TreeClass {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

    }

    public static void main(String[] args) {


        TreeNode left=new TreeNode();
        left.value=1;

        TreeNode right=new TreeNode();
        right.value=3;


        TreeNode root=new TreeNode();
        root.value=2;
        root.left=left;
        root.right=right;

        System.out.println("Inorder");
        traverseTreeInorder(root);

        System.out.println("Preorder");
        traverseTreePreorder(root);

        System.out.println("Postorder");
        traverseTreePostOrder(root);
    }



    static void traverseTreeInorder(TreeNode root){

        if(root.left!=null)
            traverseTreeInorder(root.left);

        System.out.println(root.value);

        if (root.right!=null)
            traverseTreeInorder(root.right);

    }

    static void traverseTreePreorder(TreeNode root){

        System.out.println(root.value);

        if(root.left!=null)
            traverseTreePreorder(root.left);

        if (root.right!=null)
            traverseTreePreorder(root.right);

    }

    static void traverseTreePostOrder(TreeNode root){

        if(root.left!=null)
            traverseTreePostOrder(root.left);

        if (root.right!=null)
            traverseTreePostOrder(root.right);

        System.out.println(root.value);

    }

}
