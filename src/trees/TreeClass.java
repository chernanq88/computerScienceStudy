package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TreeClass {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

    }

    /**
     *                  1
     *              2        3
     *          4     5   6    7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode four=new TreeNode();
        four.value=4;

        TreeNode six=new TreeNode();
        six.value=6;

        TreeNode five=new TreeNode();
        five.value=5;

        TreeNode seven= new TreeNode();
        seven.value=7;



        TreeNode two=new TreeNode();
        two.value=2;
        two.left=four;
        two.right=five;

        TreeNode three=new TreeNode();
        three.value=3;
        three.left= six;
        three.right=seven;


        TreeNode one=new TreeNode();
        one.value=1;
        one.left=two;
        one.right=three;

        System.out.println("Inorder");
        traverseTreeInorder(one);

        System.out.println("Preorder");
        traverseTreePreorder(one);

        System.out.println("Postorder");
        traverseTreePostOrder(one);

        System.out.println();
        System.out.println();

        printAllPaths(one, new ArrayList<>());
        result.forEach(list->{
            list.forEach(System.out::print);
            System.out.println();
        });
    }


    /**
        o(n)
     */
    static void traverseTreeInorder(TreeNode root){

        if(root.left!=null)
            traverseTreeInorder(root.left);

        System.out.println(root.value);

        if (root.right!=null)
            traverseTreeInorder(root.right);

    }

    /**
     * o(n)
     * @param root
     */
    static void traverseTreePreorder(TreeNode root){

        System.out.println(root.value);

        if(root.left!=null)
            traverseTreePreorder(root.left);

        if (root.right!=null)
            traverseTreePreorder(root.right);

    }

    /**
     o(n)
     */
    static void traverseTreePostOrder(TreeNode root){

        if(root.left!=null)
            traverseTreePostOrder(root.left);

        if (root.right!=null)
            traverseTreePostOrder(root.right);

        System.out.println(root.value);

    }


    /**
     *
     *  o (m +n)
     *  s log(n)
     *
     *  1 2 4
     *  1 2 5
     *  1 3 6
     *  1 3 7
     *
     *
     */
    static List<List<Integer>> result=new ArrayList<>();
    static void printAllPaths(TreeNode node, List<Integer> list){

        if (node==null)
            return;

        list.add(node.value);

        if(node.left!=null)
            printAllPaths(node.left, list);

        if (node.right!=null)
            printAllPaths(node.right, list);

        if (node.right==null && node.left==null)
            result.add(new ArrayList<>(list));

        list.remove(list.size()-1);

    }



}
