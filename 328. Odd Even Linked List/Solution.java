class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode index = head, lastNode = null, temp = null;
        int size = 0;
        int i = 1;
        while (index != null) {
            size++;
            if (index.next == null)
                lastNode = index;
            index = index.next;

        }
        index = head;
        while (index != null && index.next != null && i < size) {
            if (i % 2 == 1 && size != 2) {
                temp = index.next;
                index.next = temp.next;
                temp.next = null;
                lastNode.next = temp;
                lastNode = temp;
                i++;
            }
            index = index.next;
            i++;
        }
        return head;
    }
}
