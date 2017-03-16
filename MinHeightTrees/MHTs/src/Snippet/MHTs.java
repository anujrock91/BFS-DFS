package Snippet;
import java.util.*;

public class MHTs {
	
	 public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        if(n==0){ return new ArrayList(); } 
	        if(n==1){ ArrayList<Integer> z = new ArrayList<Integer>(); z.add(n); return z;}
			int min = Integer.MAX_VALUE;
			int [] visit = new int[n];
			ArrayList<Integer> result = new ArrayList<>();
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
			for(int edge[]: edges){
				if(map.containsKey(edge[0])){
					map.get(edge[0]).add(edge[1]);
					visit[edge[0]] = 0;
				}
				else{
					ArrayList<Integer> newList = new ArrayList<>();
					newList.add(edge[1]);
					map.put(edge[0], newList);
					visit[edge[0]] = 1;
				}
				if(map.containsKey(edge[1])){
					map.get(edge[1]).add(edge[0]);
					visit[edge[1]] = 0;
				}
				else{
					ArrayList<Integer> newList = new ArrayList<>();
					newList.add(edge[0]);
					map.put(edge[1], newList);
					visit[edge[1]] = 1;
				}
			}
			
			for(int i=0;i<visit.length;i++){
				if(visit[i] != 1){
					int height = DFS(i, null, visit, map);
					if(height < min){
						result.clear();
						result.add(i);
						min = height;
					}
					else if(height == min){
						result.add(i);
					}
				}
			}
			
			if(result.size()==0){
			    for(int i=0;i<n;i++){
			        result.add(i);
			    }
			}
			return result;
	    }
		
		
		private int DFS(int node, Integer parent, int visit[], HashMap<Integer, ArrayList<Integer>> map){
			if(visit[node] == 1){ return 1; }
			int max = Integer.MIN_VALUE;
			ArrayList<Integer> childs = map.get(node);
			for(Integer child: childs){
				if(parent!=null && child==parent){ continue; }
				else{
					max = Math.max(max, DFS(child, node, visit, map));
				}
			}
			return max+1;
		}
	
	
	
	public static void main(String args[]){
		int [][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(new MHTs().findMinHeightTrees(6, edges));
	}
}