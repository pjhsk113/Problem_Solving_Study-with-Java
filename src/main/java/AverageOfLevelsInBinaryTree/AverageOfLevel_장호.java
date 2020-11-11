package AverageOfLevelsInBinaryTree;

import swapnodesinpairs.swap_nodes_in_pairs_장호;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AverageOfLevel_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));

        assertThat(solution.averageOfLevels(root)).containsExactly(3.0, 14.5, 11.0);
    }

    static public class TreeNode {
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

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            return new ArrayList<>();
        }
    }
}
