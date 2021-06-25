/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class Optimized{

class Pair implements Comparator<Pair>{
	int v,weight;
	Pair(int v,int weight){
		this.v = v;
		this.weight = weight;
	}
	Pair(){}
	public int getV(){return v;}
	public int getWeight(){return weight;}
	
	@Override
	public int compare(Pair p1,Pair p2){
		if(p1.getWeight()<p2.getWeight()){
			return -1;
		}
		else if(p1.getWeight()>p2.getWeight()){
			return 1;
		}
		return 0;
	}
}

public  void addEdgeUndirected(ArrayList<ArrayList<Pair>> graph,int v,int u,int w){
	graph.get(v).add(new Pair(u,w));
	graph.get(u).add(new Pair(v,w));
}
public  int[] getMST(ArrayList<ArrayList<Pair>> graph,int n){
	int[] key = new int[n+1];
	boolean[] mst = new boolean[n+1];
	int[] parent = new int[n+1];
	Arrays.fill(key,Integer.MAX_VALUE);
	Arrays.fill(parent,-1);
	
	PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n,new Pair());
	key[1] = 0;
	pq.add(new Pair(1,key[1]));
	
	
	for(int i=1;i<=n-1;i++){
		Pair node = pq.poll();
		mst[node.getV()]=true;
		System.out.println(i);
		for(Pair ele : graph.get(node.getV())){
			if(!mst[ele.getV()] && (ele.getWeight() < key[ele.getV()])){
				
				key[ele.getV()] = ele.getWeight();
				parent[ele.getV()] = node.getV(); 
				pq.add(new Pair(ele.getV(),ele.getWeight()));
			}
		}
	}
	
	return parent;
}
	
	public static void main(String[] args){
		Optimized g = new Optimized();	
		
		ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();
		int n=6;
		for(int i=0;i<=n;i++) graph.add(new ArrayList<Pair>());
		
		g.addEdgeUndirected(graph,1,2,3);
		g.addEdgeUndirected(graph,2,3,2);
		g.addEdgeUndirected(graph,2,6,1);
		g.addEdgeUndirected(graph,6,5,6);
		g.addEdgeUndirected(graph,6,5,4);
		
		//g.addEdgeUndirected(graph,4,6,5);
		
		
		int[] parent = g.getMST(graph,n);
		
		System.out.println("origin - 1");
		for(int i=2;i<=n;i++){
			System.out.println(parent[i]+" - "+i);
		}
		System.out.println();
		
	}
}
