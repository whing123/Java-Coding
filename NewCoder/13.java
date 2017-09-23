/* *题目：
 *  D进制的A+B
 * *思路：
 *  短除法实现10进制转2到10进制
 * *技法：
 *  10进制转2到10进制，短除法，String和int的转换，StringBuffer的反转
 */

import java.util.Scanner; 

public class HelloWorld {
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
	    	int A = in.nextInt();
	    	int B = in.nextInt();
	    	int D = in.nextInt();
	    	
	    	int sum = A + B;
	    	String res = Dec2Any(sum, D);
	    	
	    	System.out.println(res);
    	}
    	in.close();
    }
    
    // base (1, 10]
    public static String Dec2Any(int n, int base){
    	StringBuffer res = new StringBuffer();
    	int remainer = 0;
    	while(n >= base){
    		remainer = n % base;
    		n /= base;
    		
    		res.append(Integer.toString(remainer));
    	}
    	res.append(Integer.toString(n));
    	
    	return res.reverse().toString();
    }
}
