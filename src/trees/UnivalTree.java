package trees;

public class UnivalTree {
    static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;

    }



    public static void main(String[] args) {

        TreeNode four=new TreeNode();
        four.value=5;

        TreeNode five=new TreeNode();
        five.value=5;

        TreeNode seven= new TreeNode();
        seven.value=5;

        TreeNode two=new TreeNode();
        two.value=1;
        two.left=four;
        two.right=five;

        TreeNode three=new TreeNode();
        three.value=5;
        three.right=seven;

        TreeNode one=new TreeNode();
        one.value=5;
        one.left=two;
        one.right=three;

        areYouUnivalue(one);
        System.out.println(univalCounter);

    }


    static int univalCounter =0;

    /**
     * bottom - up  approach
     *
     *                  5
     *              1       5
     *          5     5        5
     *
     * Time complexity
     * O(n) every node is visited only once
     *
     * Space Complexity
     * o(n) if every node only has one child
     *
     */
    static boolean areYouUnivalue(TreeNode node){

        if (node==null)
            return false;

        boolean left=true;
        boolean right=true;

        if (node.right==null && node.left==null) {
            univalCounter++;
            return true;
        }

        if(node.left!=null) {
            left = areYouUnivalue(node.left);
        }

        if (node.right != null) {
            right = areYouUnivalue(node.right);
        }

        if(!left || (node.left!=null && node.left.value!= node.value) ) {
            return false;
        }

        if(!right || (node.right!=null && node.right.value!= node.value) ) {
            return false;
        }

        univalCounter++;
        return true;
    }





}
