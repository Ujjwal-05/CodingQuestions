package Coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class BinaryTreeQuestions {
    public static void main(String[] args) {

/*
    A Binary Tree is a hierarchical data structure in which each node has at most two children, called the left child and the right child.

    Full Binary Tree: A Full Binary Tree is a binary tree in which every node has either 0 or 2 children.

    Perfect Binary Tree: A Perfect Binary Tree is a binary tree in which all internal nodes have exactly 2 children and all leaf nodes are at the same level.
    Number of nodes = 2^h - 1

    Balanced Binary Tree: A Balanced Binary Tree is a binary tree in which the height difference between the left and right subtrees of any node is at most 1.
    Height of tree is max log(N)
    Examples: AVL Tree, Red-Black Tree

    Degenerate (Skewed) Binary Tree: A Degenerate Binary Tree is a binary tree in which each parent node has only one child, forming a structure similar to a linked list.

    Traversal Techniques: BFS and DFS(Inorder, Preorder, Postorder)

                1
              /   \
             2     3
           /   \  /   \
          4     5 6     7
               /       / \
              8       9  10

        Inorder:    4, 2, 8, 5, 1, 6, 3, 9, 7, 10
        Preorder:   1, 2, 4, 5, 8, 3, 6, 7, 9, 10
        Postorder:  4, 8, 5, 2, 6, 9, 10, 7, 3, 1
        BFS:        1, 2, 3, 4, 5, 6, 7, 8, 9, 10

    //Traversals:

    class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        preorder(root,result);
        return result;
    }

    void preorder(TreeNode root,List<Integer> result){

        if(root==null) return;
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);   // Left
        result.add(root.val);         // Root
        inorder(root.right, result);  // Right
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postorder(root.left, result);   // Left
        postorder(root.right, result);  // Right
        result.add(root.val);           // Root
    }

    //BFS: list of all nodes

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        List<Integer> list=new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            list.add(temp.val);

            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);

        }
        return list;
    }

    //BFS: list of list all nodes:

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> level=new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            result.add(level);
        }

        return result;
    }

*/
        TreeNode root= new TreeNode();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result=new ArrayList<>();

        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> level=new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);

                result.add(level);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }

    }
}
