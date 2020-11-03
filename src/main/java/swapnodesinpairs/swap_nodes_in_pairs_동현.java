package swapnodesinpairs;


import static org.assertj.core.api.Assertions.assertThat;

public class swap_nodes_in_pairs_동현 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode output = new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3))));
        assertThat(solution.swapPairs(head)).isEqualTo(output);

        head = new ListNode();
        output = new ListNode();
        assertThat(solution.swapPairs(head)).isEqualTo(output);

        head = new ListNode(1);
        output = new ListNode(1);
        assertThat(solution.swapPairs(head)).isEqualTo(output);
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {

            return null;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
