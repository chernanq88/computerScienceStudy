package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {
    static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;

    }



    public static void main(String[] args) {

        TreeNode four=new TreeNode();
        four.value=400;

        TreeNode five=new TreeNode();
        five.value=500;

        TreeNode two=new TreeNode();
        two.value=200;
        two.left=four;
        two.right=five;

        TreeNode three=new TreeNode();
        three.value=300;

        TreeNode one=new TreeNode();
        one.value=100;
        one.left=two;
        one.right=three;



    }


    static void traverseWithQueue(TreeNode node){

        Stack<TreeNode> stack=new Stack<>();
        stack.add(node);
        while (stack.size()>0){
            if(node.left!=null){

            }
            if(node.right!=null){

            }
        }










    }





}
