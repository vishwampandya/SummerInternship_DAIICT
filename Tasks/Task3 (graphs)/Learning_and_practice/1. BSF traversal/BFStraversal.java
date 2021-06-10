/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class BFStraversal{

public static void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
	graph.get(v).add(u);
	graph.get(u).add(v);
}
public static ArrayList<Integer> getBFS(ArrayList<ArrayList<Integer>> graph,int n){
	ArrayList<Integer> bfs = new ArrayList<Integer>();
	boolean[] visited = new boolean[n+1];
	
	for(int i=1;i<=n;i++){
		if(!visited[i]){
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(i);
			visited[i] = true;
			while(!que.isEmpty()){
				Integer node = que.poll();
				bfs.add(node);
				
				for(Integer ele : graph.get(node)){
					if(!visited[ele]){
						visited[ele]=true;
						que.add(ele);
					}
				}
			}
		}
	}
	
	return bfs;
}
	
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int n=7;
		for(int i=0;i<=n;i++) graph.add(new ArrayList<Integer>());
		
		addEdgeUndirected(graph,1,2);
		addEdgeUndirected(graph,2,3);
		addEdgeUndirected(graph,2,7);
		addEdgeUndirected(graph,3,5);
		addEdgeUndirected(graph,7,5);
		
		addEdgeUndirected(graph,4,6);
		
		
		ArrayList<Integer> bfs = getBFS(graph,n);
		for(int a : bfs) System.out.print(a+" ");
		System.out.println();
		
	}
}
