class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);

        ListNode prev=null,slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null) prev.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=sortedListToBST(head==slow ? null:head);
        root.right=sortedListToBST(slow.next);

        return root;
    }
}