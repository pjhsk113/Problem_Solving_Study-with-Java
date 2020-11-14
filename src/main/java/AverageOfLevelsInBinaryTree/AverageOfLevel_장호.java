package AverageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
            Queue<TreeNode> q = new LinkedList<>();
            List<Double> avg = new ArrayList<>();
            double sum = 0, nodeCnt = 0;

            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    avg.add((sum / nodeCnt));
                    sum = 0;
                    nodeCnt = 0;
                    q.add(null);

                    if (q.peek() == null) {
                        break;
                    } else {
                        continue;
                    }
                }

                sum += node.val;
                nodeCnt += 1;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            return avg;
        }
    }
}
