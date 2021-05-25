import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args){
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while(testCase-->0){
        	int n = input.nextInt();
        	long[] arr = new long[n];
        	for(int i=0;i<n;i++){
        		arr[i] = input.nextLong();
        	}
        	int ans = getAns(n,arr);
        	System.out.println(ans);
        }
    }
    static int getAns(int n,long[] arr){
    	long[] prr = new long[n-1];
    	for(int i=0;i<n-1;i++){
    		prr[i] = arr[i]-arr[i+1];
    		if(prr[i]<0) prr[i] = (-1)*prr[i];
    	}
    	
    	Arrays.sort(arr);
    	//can be brought down to On
    	Arrays.sort(prr);
    	
    	long min = prr[0];
    	int i=n-1;
    	int count=0;
    	while(arr[i]>min){
    		i--;
    		count++;
    		if(i<=0) break;
    	}
    	int toBeDeleted = count;
    	if(toBeDeleted>=n){
    		toBeDeleted--;
    	}
    	int ans = n - toBeDeleted;
    	return ans;
    }
}



























