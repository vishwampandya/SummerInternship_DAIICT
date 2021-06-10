/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class DFStraversal{

public static void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
	graph.get(v).add(u);
	graph.get(u).add(v);
}

public static void dfs(int i,ArrayList<ArrayList<Integer>> graph,boolean[] visited,ArrayList<Integer> dfs){
	dfs.add(i);
	visited[i]=true;
	for(Integer ele : graph.get(i)){
		if(!visited[ele]){
			dfs(ele,graph,visited,dfs);
		}
	}
}

public static ArrayList<Integer> getDFS(ArrayList<ArrayList<Integer>> graph,int n){
	ArrayList<Integer> dfs = new ArrayList<Integer>();
	boolean[] visited = new boolean[n+1];
	
	for(int i=1;i<=n;i++){
		if(!visited[i]){
			dfs(i,graph,visited,dfs);
		}
	}
	
	return dfs;
}
/*
public static ArrayList<Integer> getDFS(ArrayList<ArrayList<Integer>> graph,int n){
	ArrayList<Integer> dfs = new ArrayList<Integer>();
	boolean[] visited = new boolean[n+1];
	
	for(int i=1;i<=n;i++){
		if(!visited[i]){
			Stack<Integer> st = new Stack<Integer>();
			st.push(i);
			while(!st.empty()){
				int node = st.pop();
				visited[node] = true;
				dfs.add(node);
				for(Integer ele : graph.get(node)){
					if(!visited[ele]){
						st.push(ele);
						visited[ele]=true;
					}
				}
			}
		}
	}
	
	return dfs;
}
*/
	
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
		
		
		ArrayList<Integer> dfs = getDFS(graph,n);
		for(int a : dfs) System.out.print(a+" ");
		System.out.println();
		
	}
}
