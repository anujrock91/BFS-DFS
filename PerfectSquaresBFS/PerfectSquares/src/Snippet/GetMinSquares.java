package Snippet;
import java.util.LinkedList;

public class GetMinSquares {
	
	public int getMin(int n){
		int num = (int)Math.sqrt(n);
		LinkedList<Integer> que = new LinkedList<>();
		//que.addFirst(0);
		
		for(int i=1;i<=num;i++){
			que.addLast(i*i); 
		}
		
		que.addLast(0);
		int count = 1;
		while(!que.isEmpty()){
			int curr = que.removeFirst();
			if(curr == 0){
				++count;
				que.addLast(0);
			}
			else{
				if(curr == n){ return count; }
				else{
					for(int i=1;i<=num;i++){
						que.addLast((i*i)+curr);
					}
				}
			}
		}
		return n;
	}
	
	public static void main(String args[]){
		System.out.println(new GetMinSquares().getMin(13));
	}
}