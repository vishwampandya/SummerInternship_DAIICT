/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class BruteForce{

class Pair{
	int v,weight;
	Pair(int v,int weight){
		this.v = v;
		this.weight = weight;
	}
	public int getV(){return v;}
	public int getWeight(){return weight;}
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
	
	key[1] = 0;
	
	for(int i=1;i<=n-1;i++){//for n-1 edges
		//get minimun key who is not in mst
		int min = Integer.MAX_VALUE;
		int minPos = 1;
		for(int v=1;v<=n;v++){
			if(min>key[v] && !mst[v]){
				min = key[v];
				minPos = v;
			}
		}
		mst[minPos] = true;
		int node = minPos;
		
		for(Pair ele : graph.get(node)){
			if(!mst[ele.getV()] && (ele.getWeight()<key[ele.getV()]) ){
				key[ele.getV()] = ele.getWeight();
				parent[ele.getV()] = node;
			}
		}
	}
	
	return parent;
}
	
	public static void main(String[] args){
		BruteForce g = new BruteForce();	
		
		ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();
		int n=7;
		for(int i=0;i<=n;i++) graph.add(new ArrayList<Pair>());
		
		g.addEdgeUndirected(graph,1,2,3);
		g.addEdgeUndirected(graph,2,3,2);
		g.addEdgeUndirected(graph,2,7,1);
		g.addEdgeUndirected(graph,3,5,6);
		g.addEdgeUndirected(graph,7,5,4);
		
		//g.addEdgeUndirected(graph,4,6,5);
		
		
		int[] parent = g.getMST(graph,n);
		
		System.out.println("origin - 1");
		for(int i=2;i<=n;i++){
			System.out.println(parent[i]+" - "+i);
		}
		System.out.println();
		
	}
}
