
import java.util.*;
import java.io.*;



public class UsingBFS{
	
	public class Pair{
		public int v;
		public int weight;
		Pair(int v,int w){
			this.v = v;
			this.weight = w;
		}
	}

	public  void addEdgeDirected(ArrayList<ArrayList<Pair>> graph,int v,int u,int w){
		graph.get(v).add(new Pair(u,w));
	}
	
	public void dfs(int s,ArrayList<ArrayList<Pair>> graph,boolean[] visited,Stack<Integer> st){
		visited[s] = true;
		
		for(Pair ele : graph.get(s)){
			if(!visited[ele.v]){
				dfs(ele.v,graph,visited,st);
			}
		}
		st.push(s);
	}
	
	public int[] getMinimumDistance(int source,int V,ArrayList<ArrayList<Pair>> graph){
		int[] distance = new int[V+1];
		for(int i=1;i<=V;i++) distance[i] = Integer.MAX_VALUE;
		
		//topological sorting
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!visited[i]) dfs(i,graph,visited,st);
		}
		
		distance[source]=0;
		
		while(!st.isEmpty()){
			int node = st.pop();
			if(distance[node]!=Integer.MAX_VALUE){
				for(Pair ele : graph.get(node)){
					if(distance[node]+ele.weight<distance[ele.v]){
						distance[ele.v] = distance[node]+ele.weight; 
					}
				}
			}
		}
		
		return distance;
		
	}
	
	
	public static void main(String[] args){
		
		UsingBFS g = new UsingBFS();
		
		ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Pair>());
		
		g.addEdgeDirected(graph,1,2,1);
		g.addEdgeDirected(graph,2,3,3);
		g.addEdgeDirected(graph,2,7,5);
		g.addEdgeDirected(graph,3,5,2);
		g.addEdgeDirected(graph,7,5,7);
		
		g.addEdgeDirected(graph,4,6,2);
		
		int source = 1;
		int[] distance = g.getMinimumDistance(source,V,graph);
		System.out.println("From source "+source);
		for(int i=1;i<=V;i++) System.out.print(i+": "+distance[i]+" |");
		System.out.println();
		
	}
}
