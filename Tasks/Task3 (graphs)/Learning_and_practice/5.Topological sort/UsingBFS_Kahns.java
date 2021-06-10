/*UnDirected Graph*/

/*Or in simple words , a graph with odd cycle is not an bipatre graph , rest all graphs are bipatre graphs*/

import java.util.*;
import java.io.*;



public class UsingBFS_Kahns{
	
	public void addEdgeDirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
	}
	
	public ArrayList<Integer> getTopogolicalSort(ArrayList<ArrayList<Integer>> graph,int V){
		ArrayList<Integer> topoList = new ArrayList<Integer>();
		
		//calculating indegrees
		int[] inDegrees = new int[V+1];
		for(int i=1;i<=V;i++){
			for(Integer ele : graph.get(i)){
				inDegrees[ele]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[V+1];
		
		for(int i=1;i<=V;i++){
			if(inDegrees[i]==0) q.add(i);
		}
		while(!q.isEmpty()){
		
			int node = q.poll();
			topoList.add(node);
			
			for(Integer ele : graph.get(node)){
				inDegrees[ele]--;
				
				if(inDegrees[ele]==0){
				 	q.add(ele);
				}
			}
		}
		
		return topoList;
	}
	
	public static void main(String[] args){
		
		UsingBFS_Kahns g = new UsingBFS_Kahns();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeDirected(graph,1,2);
		g.addEdgeDirected(graph,2,3);
		g.addEdgeDirected(graph,2,7);
		g.addEdgeDirected(graph,3,5);
		g.addEdgeDirected(graph,7,5);
		
		g.addEdgeDirected(graph,4,6);
		
		
		
		ArrayList<Integer> topo = g.getTopogolicalSort(graph,V);
		for(Integer i : topo){
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
}
