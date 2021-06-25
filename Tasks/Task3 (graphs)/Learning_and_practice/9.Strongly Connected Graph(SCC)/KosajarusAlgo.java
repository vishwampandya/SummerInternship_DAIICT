/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class KosajarusAlgo{
	
	

	public void addEdgeDirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
	}
	public void dfs(int s,ArrayList<ArrayList<Integer>> graph,boolean[] visited,Stack<Integer> st){
		visited[s] = true;
		for(Integer ele : graph.get(s)){
			if(!visited[ele]){
				dfs(ele,graph,visited,st);
			}
		}
		st.push(s);
	}
	public ArrayList<Integer> revDFS(int s,ArrayList<ArrayList<Integer>> tGraph,boolean[] visited){
		visited[s] = true;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(Integer ele : tGraph.get(s)){
			if(!visited[ele]){
				al.add(ele);
				al.addAll(revDFS(s,tGraph,visited));
			}
		}
		
		return al;
	}
	public ArrayList<ArrayList<Integer>> getSCC(ArrayList<ArrayList<Integer>> graph,int n){
		ArrayList<ArrayList<Integer>> scc = new ArrayList<ArrayList<Integer>>();
		
		/*getting topo sort*/
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[n+1];
		for(int i=1;i<=n;i++){
			if(!visited[i]){
				dfs(i,graph,visited,st);
			}
		}
		
		ArrayList<ArrayList<Integer>> tGraph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=n;i++) tGraph.add(new ArrayList<Integer>());
		
		/*Transpoing graph (reversing edge)*/
		for(int i=0;i<n;i++){
			for(Integer ele : graph.get(i)){
				tGraph.get(ele).add(i);
			}
		}
		
		Arrays.fill(visited,false);
		while(!st.isEmpty()){
			int node = st.pop();
			if(!visited[node]){
				scc.add(revDFS(node,tGraph,visited));
			}
		}
		
		return scc;
	}
	
	public static void main(String[] args){
		
		KosajarusAlgo g = new KosajarusAlgo();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeDirected(graph,1,2);
		g.addEdgeDirected(graph,2,3);
		g.addEdgeDirected(graph,2,7);
		g.addEdgeDirected(graph,3,5);
		g.addEdgeDirected(graph,7,5);
		
		g.addEdgeDirected(graph,4,6);
		g.addEdgeDirected(graph,6,4);
		//g.addEdgeDirected(graph,4,6);
		//g.addEdgeDirected(graph,6,7);
		//g.addEdgeDirected(graph,7,4);
		
		
		ArrayList<ArrayList<Integer>> scc = g.getSCC(graph,V);
		for(ArrayList<Integer> s : scc){
			for(Integer ele : s){
				System.out.print(ele+" ");
			}
			System.out.println();
		}
		
	}
}
