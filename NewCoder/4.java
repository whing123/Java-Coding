/* *题目：
 *  数素数
 * *思路：
 *  实现素数判断方法，先找到第M个，再接着找N-M个
 * *技法：
 *  素数判断
 */

import java.util.Scanner;

public class HelloWorld {
	
	public static boolean isPrime(int a){
		if(a < 2){
			return false;
		}else{
			for(int i = 2; i <= Math.sqrt(a); ++i){
				if(a % i == 0){
					return false;
				}
			}
		}
		
		return true;	
	}
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	int M = in.nextInt();
    	int N = in.nextInt();
    	
    	int cnt = 0;
    	int count = N - M + 1;
    	int prime = 0;
    	
        // find Mth prime
    	for(int i = 2; ; ++i){
    		if(isPrime(i)){
    			cnt++;
    			if(cnt == M){
    				prime = i;
    				break;
    			}
    		}
    	}
    	
        // find next N-M+1 primes
    	cnt = 0;
    	for(int i = prime; ; ++i){
    		if(isPrime(i)){
    			System.out.print(i);
    			
    			cnt++;
    			if(cnt == count){
    				break;
    			}
    			
    			if(cnt % 10 == 0){
    				System.out.print("\n");
    			}else{
    				System.out.print(" ");
    			}
    		}
    	}
    	
    	in.close();
    }
}
