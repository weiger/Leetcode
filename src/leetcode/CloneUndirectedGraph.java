package leetcode;
import java.util.*;

public class CloneUndirectedGraph {

	static class UndirectedGraphNode {
		 int label;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { 
			 label = x; 
			 neighbors = new ArrayList<UndirectedGraphNode>(); 
		 }
	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null)
			return node;
		
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		
		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
		
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		
		map.put(node, head);
		queue.offer(node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode top = queue.poll();
			
			for(UndirectedGraphNode son : top.neighbors){
				
				if(!map.containsKey(son)){
					UndirectedGraphNode copy = new UndirectedGraphNode(son.label);
					map.put(son, copy);
					
					map.get(son).neighbors.add(copy);
					queue.offer(son);
				}else{
					map.get(son).neighbors.add(map.get(son));
				}
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
