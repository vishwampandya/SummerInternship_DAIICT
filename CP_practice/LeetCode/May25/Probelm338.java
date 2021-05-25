/*338. Counting Bits*/
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        ans[0]=0;
        if(n>0) ans[1]=1;
        int t=0;
        for(int i=2;i<=n;i++){
            if(isPowerOf2(i)){
                t=0;
                ans[i] = 1;
                continue;
            }
            t++;
            ans[i] = 1 + ans[t];
            
        }
        
        return ans;
    }
    public boolean isPowerOf2(int x){
        return x!=0 && ((x&(x-1)) == 0);
    }
}
