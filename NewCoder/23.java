/* *题目：
 *  最长公共子序列
 * *思路：
 *  动态规划，见CSDN博客
 * *技法：
 *  动态规划
 */
 
import java.util.*;

public class Hello{
    public static void main(String argv[]){
 
    }
    
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        int [][]dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; ++i){
            for(int j = 0; j < m+1; ++j){
                dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}