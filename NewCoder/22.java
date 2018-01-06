/* *题目：
 *  最长递增子序列
 * *思路：
 *  动态规划，见CSDN博客
 * *技法：
 *  动态规划
 */
 
import java.util.*;

public class Hello{
    public static void main(String argv[]){
 
    }
    
    public int findLongest(int[] A, int n) {
        // write code here
        
        int [] dp = new int[n];
        
        int res = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(A[j] <= A[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            
            // find largest
            if(dp[i] > res){
                res = dp[i];
            }
        }
        
        return res;
    }
}