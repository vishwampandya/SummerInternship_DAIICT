/*UnDirected Graph*/

/*Or in simple words , a graph with odd cycle is not an bipatre graph , rest all graphs are bipatre graphs*/

import java.util.*;
import java.io.*;



public class UsingDFS{
	
	

	public  void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
		graph.get(u).add(v);
	}
	
	public boolean isBipatre(int s,ArrayList<ArrayList<Integer>> graph,int[] color){
		for(int ele : graph.get(s)){
			if(color[s]==-1){
				color[ele] = 1 - color[s];
				if(!isBipatre(ele,graph,color)) return false;
			}
			else if(color[ele]==color[s]) return false;
			
		}
		
		return true;
	}
	
	public boolean checkBipatre(ArrayList<ArrayList<Integer>> graph,int V){
		int[] color = new int[V+1];
		Arrays.fill(color,-1);
		for(int i=1;i<=V;i++){
			if(color[i]==-1){
				color[i] = 1;
				if(!isBipatre(i,graph,color)) return false;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args){
		
		UsingDFS g = new UsingDFS();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeUndirected(graph,1,2);
		g.addEdgeUndirected(graph,2,3);
		g.addEdgeUndirected(graph,2,7);
		g.addEdgeUndirected(graph,3,5);
		g.addEdgeUndirected(graph,7,5);
		
		g.addEdgeUndirected(graph,4,6);
		
		
		if(g.checkBipatre(graph,V)) System.out.println("This graph is a bipatre graph!");
		else System.out.println("This graph is not a bipatre graph!");
		
	}
}
