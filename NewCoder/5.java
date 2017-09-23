/* *题目：
 *  锤子剪刀布
 * *思路：
 *  尝试所有AB输赢的情况，统计每人的输赢以及出牌获胜情况
 * *技法：
 *  字符串equals比较，数组中找最大数并记录其index
 */

import java.util.Scanner;

public class HelloWorld {
	
	final static char[] arr={'B', 'C', 'J'};
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	
    	int N = in.nextInt();
    	int i = 0;
    	
    	String A = "";
    	String B = "";
    	
    	int A_cnt [] = new int []{0,0,0};  // B C J
    	int A_wins[] = new int []{0,0,0};  // win fail -
    	int B_cnt [] = new int []{0,0,0};
    	int B_wins[] = new int []{0,0,0};
    	while(i < N){
    		A = in.next();
    		B = in.next();
    		
    		if(A.equals(B)){
    			A_wins[2]++;
    			B_wins[2]++;
    		}
    		
    		else if(A.equals("C") && B.equals("J")){
    			A_cnt[1]++;
    			A_wins[0]++;
    			B_wins[1]++;
    		}
    		
    		else if(A.equals("J") && B.equals("B")){
    			A_cnt[2]++;
    			A_wins[0]++;
    			B_wins[1]++;
    		}
    		
    		else if(A.equals("B") && B.equals("C")){
    			A_cnt[0]++;
    			A_wins[0]++;
    			B_wins[1]++;
    		}
    		
    		else if(A.equals("C") && B.equals("B")){
    			A_wins[1]++;
    			B_wins[0]++;
    			B_cnt[0]++;
    		}
    		
    		else if(A.equals("J") && B.equals("C")){
    			A_wins[1]++;
    			B_wins[0]++;
    			B_cnt[1]++;
    		}
    		
    		else if(A.equals("B") && B.equals("J")){
    			A_wins[1]++;
    			B_wins[0]++;
    			B_cnt[2]++;
    		}
    		
    		i++;
    	}
    	 
    	System.out.println(A_wins[0] + " " + A_wins[2] + " " + A_wins[1]);
    	System.out.println(B_wins[0] + " " + B_wins[2] + " " + B_wins[1]);
    	
    	check(A_cnt);
    	System.out.print(" ");
    	check(B_cnt);
    	
    	in.close();
    }
    
    // find max
    public static void check(int [] m){
    	
    	int cnt = 0;
    	int ch = 0;
    	for(int i = 0; i < m.length; ++i){
    		if(m[i] > cnt){
    			cnt = m[i];
    			ch = i;
    		}
    	}
    	
    	System.out.print(arr[ch]);
    }
}
