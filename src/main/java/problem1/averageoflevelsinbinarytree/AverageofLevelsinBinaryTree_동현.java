package problem1.averageoflevelsinbinarytree;

import swapnodesinpairs.swap_nodes_in_pairs_동현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AverageofLevelsinBinaryTree_동현 {

     public static void main(String[] args) {
         Solution solution = new Solution();

         TreeNode root = new TreeNode(3);
         root.left = new TreeNode(9);
         root.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));

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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            int[] sum = new int[200];
            int[] count = new int[200];
            Arrays.fill(sum,0);
            Arrays.fill(count,0);

            dfs(root,0,sum,count);

            int i = 0;
            while(count[i] != 0) {
                ans.add((double)sum[i]/count[i]);
                i++;
            }

            return ans;
        }

        void dfs(TreeNode node,int level,int[] sum,int[] count) {
            if(node != null) {
                sum[level] += node.val;
                count[level]++;
                dfs(node.left,level+1,sum,count);
                dfs(node.right,level+1,sum,count);
            }
        }
    }

}
