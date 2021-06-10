/*UnDirected Graph*/

/*Or in simple words , a graph with odd cycle is not an bipatre graph , rest all graphs are bipatre graphs*/

import java.util.*;
import java.io.*;



public class UsingDFS{
	
	

	
	public void addEdgeDirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
	}
	
	public void topoSort(int s,ArrayList<ArrayList<Integer>> graph,Stack<Integer> st,boolean[] visited){
		visited[s]=true;
		for(Integer ele : graph.get(s)){
			if(!visited[ele]){
				visited[ele] = true;
				topoSort(ele,graph,st,visited);
			}
		}
		st.push(s);
	}
	
	public ArrayList<Integer> getTopogolicalSort(ArrayList<ArrayList<Integer>> graph,int V){
		ArrayList<Integer> topoList = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[V+1];
		
		for(int i=1;i<=V;i++){
			if(!visited[i]){
				topoSort(i,graph,st,visited);
			}	
		}	
		
		while(!st.isEmpty()){
			topoList.add(st.pop());
		}
		
		return topoList;
	}
	
	
	public static void main(String[] args){
		
		UsingDFS g = new UsingDFS();
		
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
