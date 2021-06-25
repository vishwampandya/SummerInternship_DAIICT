

import java.util.*;
import java.io.*;



public class DijkstrasAlgorithm{
	
	class Pair implements Comparator<Pair>{
		int v,weight;
		Pair(int v,int weight){
			this.v = v;
			this.weight = weight;
		}
		Pair(){}
		public int getV(){ return v;}
		public int getWeight(){ return weight;};
		
		@Override
		public int compare(Pair p1,Pair p2){
			if(p1.weight<p2.weight) return -1;
			if(p1.weight>p2.weight) return 1;
			return 0;
		}
	}
	

	public void addEdgeUndirected(ArrayList<ArrayList<Pair>> graph,int v,int u,int weight){
		graph.get(v).add(new Pair(u,weight));
		graph.get(u).add(new Pair(u,weight));
	}
	
	public int[] getMinimumDistance(int source,int V,ArrayList<ArrayList<Pair>> graph){
		int[] distance = new int[V+1];
		for(int i=1;i<=V;i++) distance[i] = Integer.MAX_VALUE;
		
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(V+1,new Pair());
		pq.add(new Pair(source,0));
		distance[source]=0;
		
		while(pq.size()>0){
			Pair node = pq.poll();
			for(Pair ele : graph.get(node.getV())){
				if( (distance[node.getV()]+ele.getWeight() < distance[ele.getV()]) ){
					distance[ele.getV()] = distance[node.getV()]+ele.getWeight();
					pq.add(new Pair(ele.getV(),distance[ele.getV()]));
				}
			}
		}
		
		return distance;
		
	}
	
	
	public static void main(String[] args){
		
		DijkstrasAlgorithm g = new DijkstrasAlgorithm();
		
		ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Pair>());
		
		g.addEdgeUndirected(graph,1,2,3);
		g.addEdgeUndirected(graph,2,3,1);
		g.addEdgeUndirected(graph,2,7,6);
		g.addEdgeUndirected(graph,3,5,4);
		g.addEdgeUndirected(graph,7,5,9);
		
		//g.addEdgeUndirected(graph,4,6,2);
		
		int source = 1;
		int[] distance = g.getMinimumDistance(source,V,graph);
		System.out.println("From source "+source);
		for(int i=1;i<=V;i++) System.out.print(i+": "+distance[i]+" |");
		System.out.println();
		
	}
}
