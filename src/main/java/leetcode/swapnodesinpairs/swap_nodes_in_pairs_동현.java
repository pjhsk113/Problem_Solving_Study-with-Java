package leetcode.swapnodesinpairs;


import java.util.Objects;

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
            ListNode prevNode = new ListNode(0);
            prevNode.next = head;
            ListNode newHead = prevNode;

            while(prevNode.next != null && prevNode.next.next != null) {
                ListNode node1 = prevNode.next;
                ListNode node2 = node1.next;
                ListNode nextNode = node2.next;

                prevNode.next = node2;
                node2.next = node1;
                node1.next = nextNode;

                prevNode = node1;
            }


            return newHead.next;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
