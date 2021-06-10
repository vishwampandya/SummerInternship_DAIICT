/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class UsingBFS_Kahns{
	
	

	public void addEdgeDirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
	}
	
	public boolean checkCycle(ArrayList<ArrayList<Integer>> graph,int V){
		int[] indegree = new int[V+1];
		for(int i=1;i<=V;i++){
			for(Integer ele : graph.get(i)){
				indegree[ele]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=V;i++) if(indegree[i]==0) q.add(i);
		
		int count = 0;
		while(!q.isEmpty()){
			int node = q.poll();
			count++;
			for(Integer ele : graph.get(node)){
				indegree[ele]--;
				if(indegree[ele]==0) q.add(ele);
			}
		}
		
		return (count==V)?false:true;
		
	}
	
	public static void main(String[] args){
		
		UsingBFS_Kahns g = new UsingBFS_Kahns();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=5;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeDirected(graph,1,2);
		g.addEdgeDirected(graph,2,3);
		g.addEdgeDirected(graph,2,5);
		g.addEdgeDirected(graph,3,4);
		g.addEdgeDirected(graph,5,4);
		//g.addEdgeDirected(graph,4,2);
		
		if(g.checkCycle(graph,V))System.out.println("It has a cycle!");
		else System.out.println("It doesnot have a cycle!");	
		
	}
}





