package problem1.averageoflevelsinbinarytree;

import java.util.ArrayList;
import java.util.List;

public class AverageofLevelsinBinaryTree_동현 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        List<Double> doubles = solution.averageOfLevels(root);
        System.out.println(doubles.toString());

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        List<Carry> carries = new ArrayList<>();

        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();


            dfs(root, 0);

            for (Carry c: carries) {
                ans.add((double)c.sum / c.count);
            }
            return ans;
        }

        void dfs(TreeNode node, int level) {
            if (node == null)
                return;
            if (carries.size() == level) {
                carries.add(new Carry(node.val, 1));
            } else {
                Carry c = carries.get(level);
                c.sum += node.val;
                c.count++;
            }


            dfs(node.left, level + 1);
            dfs(node.right, level + 1);

        }

        static class Carry {
            public Carry(double sum, int count) {
                this.sum = sum;
                this.count = count;
            }

            public double sum;
            public int count;
        }
    }

}
