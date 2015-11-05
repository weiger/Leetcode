package leetcode;

public class ReverseNodesInKGroup {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public static ListNode reverseAsKGroup(ListNode head, int k){
		if(head == null) return null;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy, cur = head;
		int step = 0;
		
		while(cur != null){
			ListNode pos = cur.next;
			step++;
			
			if(step == k){                //             pos
				pre = reverse(pre,pos);   //pre->1->2->3->4->5   reverse(pre,pos)区间
				step = 0;
			}
			
			cur = pos;
		}
		return dummy.next;
	}
	
	public static ListNode reverse(ListNode pre, ListNode pos){
		ListNode last = pre.next;
		ListNode cur = last.next;
		
		while(cur != pos){
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2; node2.next = node3; 
		node3.next = node4; node4.next = node5;
		
		ListNode head = reverseAsKGroup(node1,2);
		while(head != null){
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

}
