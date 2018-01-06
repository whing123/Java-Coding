/* *题目：
 *  放苹果
 * *思路：
 *  动态规划，见CSDN博客
 * *技法：
 *  动态规划
 */
 
import java.util.Scanner;

public class Hello{
    public static void main(String argv[]){
        Scanner in = new Scanner(System.in);
        
        int m, n;
        
        while(in.hasNext()){
            m = in.nextInt();
            n = in.nextInt();
            
            System.out.println(dpFunc(m,n));
        }
    }
    
    public static int dpFunc(int m, int n){
        if(m <= 1 || n == 1){
            return 1;
        }
        
        int [][]dp = new int[n+1][m+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
            	dp[i][j] = 1;
        	}
        }
        
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= m; j++){
            	if(i > j){
                    dp[i][j] = dp[j][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-i]; 
                }
        	}
        }
        
        return dp[n][m];
    }
}