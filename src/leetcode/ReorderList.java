package leetcode;
import java.util.*;
public class ReorderList {
	public static void reorderList(ListNode head) {
	       
        if(head == null)
            return ;
        
        LinkedList<ListNode> list1 = new LinkedList<ListNode>();
        LinkedList<ListNode> list2 = new LinkedList<ListNode>();
        
        ListNode temp = head;
        int len = 0, i = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        if(len <= 2)
            return ;
        
        temp = head;
        while(i < len){
            if(i < (len-1)/2){
                list1.add(temp);
            }
            
            if(i >= (len-1)/2){
                list2.addFirst(temp);
            }
            
            temp = temp.next;
            i++;
        }
        
        
        
        int len1 = 0,len2 = 0;
        while(len1 < list1.size() && len2 < list2.size()){
            list1.get(len1).next = list2.get(len2);
            len1++;
            if(len1 < list1.size()){
                list2.get(len2).next = list1.get(len1);
                len2++;
            }
        }
        
        while(len1 < list1.size()-1){
            list1.get(len1).next = list1.get(++len1);
        }
        while(len2 < list2.size()-1){
            list2.get(len2).next = list2.get(++len2);
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		
		reorderList(node1);
		
		while(node1!=null){
			System.out.println(node1.val);
			node1 = node1.next;
		}
		
	}

}
class ListNode {
	 int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }