import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
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
        	int temp;
        	int count=0;
        	int min = Integer.MAX_VALUE;
        	for(int i=0;i<n;i++){
        		temp = input.nextInt();
        		if(temp==min){
        			count++;
        		}
        		else if(temp<min){
        			min = temp;
        			count = 1;
        		}
        	}
        	int ans = n-count;
        	System.out.println(ans);
        }
    }
}
