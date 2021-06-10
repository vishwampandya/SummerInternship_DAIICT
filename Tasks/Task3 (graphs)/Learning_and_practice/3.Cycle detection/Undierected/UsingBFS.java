/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class UsingBFS{
	
	class Node{
		int cur;
		int prev;
		Node(int cur,int prev){
			this.cur = cur;
			this.prev = prev;
		}
	}

	public  void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
		graph.get(u).add(v);
	}
	
	public  boolean isCycle(int s,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
		Queue<Node> que = new LinkedList<Node>();
		que.add(new Node(s,-1));
		visited[s] = true;
		while(!que.isEmpty()){
			int node = que.peek().cur;
			int prev = que.peek().prev;
			que.remove();
			for(int ele : graph.get(node)){
				if(!visited[ele]){
					que.add(new Node(ele,node));
					visited[ele]=true;
				}
				else if(prev!=node) return true;
			}
		}
		return false;
	}

	public  boolean detectCycle(ArrayList<ArrayList<Integer>> graph,int V){
		boolean[] visited = new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!visited[i]){
				if(isCycle(i,graph,visited)) return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args){
		
		UsingBFS g = new UsingBFS();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeUndirected(graph,1,2);
		g.addEdgeUndirected(graph,2,3);
		g.addEdgeUndirected(graph,2,7);
		g.addEdgeUndirected(graph,3,5);
		g.addEdgeUndirected(graph,7,5);
		
		g.addEdgeUndirected(graph,4,6);
		
		
		if(g.detectCycle(graph,V)) System.out.println("This graph has a cycle!");
		else System.out.println("This graph doesn't have any cycle!");
		
	}
}
