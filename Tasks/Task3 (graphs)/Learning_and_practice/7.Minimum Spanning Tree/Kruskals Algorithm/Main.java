import java.util.*;
import java.io.*;

class Node implements Comparator<Node>{
	int u,v,w;
	Node(int u,int v,int w){
		this.u = u;
		this.v = v;
		this.w = w;
	}
	Node(){}
	public int getU(){return u;};
	public int getV(){return v;};
	public int getW(){return w;};
	
	@Override
	public int compare(Node n1,Node n2){
		if(n1.getW() < n2.getW()) return -1;
		else if(n1.getW() > n2.getW()) return 1;
		return 0;
	}
	
}
class DisjoinSet{
	public int findParent(int node,int[] parent){
	
		if(node==parent[node]) return node;
		return parent[node] = findParent(parent[node],parent);
		
	}
	public void union(int u,int v,int[] parent,int[] rank){
		if(rank[u]<rank[v]){
			parent[u] = v;
		}
		else if(rank[v]<rank[u]){
			parent[v] = u;
		}
		else{
			parent[v] = parent[u];
			rank[u]++;
		}
	}
	public ArrayList<Node> kruskalAlgo(ArrayList<Node> adj,int n){
		ArrayList<Node> mst = new ArrayList<Node>();
		Collections.sort(adj,new Node());
		
		/*Disjoint set data structure*/
		int[] parent = new int[n];
		int[] rank = new int[n];
		Arrays.fill(rank,0);
		for(int i=0;i<n;i++) parent[i] = i;
		
		
		
		int costMst = 0;
		for(Node ele : adj){
			if(findParent(ele.getU(),parent)!=findParent(ele.getV(),parent)){
				mst.add(ele);
				costMst	 += ele.getW();
				union(ele.getU(),ele.getV(),parent,rank);
			}
		}
		
		return mst;
	}
}

public class Main{
	public static void main(String[] args){
		DisjoinSet d = new DisjoinSet();
		ArrayList<Node> adj = new ArrayList<Node>();
		
		int n = 5;
		adj.add(new Node(0,1,2));
		adj.add(new Node(0,3,6));
		adj.add(new Node(1,3,8));
		adj.add(new Node(1,2,3));
		adj.add(new Node(1,4,5));
		adj.add(new Node(2,4,7));
		
		ArrayList<Node> mst = d.kruskalAlgo(adj,n);
		for(Node ele : mst) System.out.println(ele.getU()+"-"+ele.getV()+" ("+ele.getW()+")");
	}
}
