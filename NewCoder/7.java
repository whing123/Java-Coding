/* *题目：
 *  数字黑洞
 * *思路：
 *  先检查四个数字是否相等的特殊情况，然后对字符串的字符升序降序排列，转成int作差输出，下一循环又转成4位字符串
 * *技法：
 *  字符串format转换，字符串到字符数组转换，字符数组排序与手动降序，String to int，格式化输出
 */

import java.util.Scanner;
import java.util.Arrays;


public class HelloWorld {
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	String A = in.next();
    	
    	char A0 = A.charAt(0);
    	int cnt = 1;
    	for(int i = 1; i < A.length(); i++){
    		if(A.charAt(i) == A0){
    			cnt ++;
    		}
    	}
    	
    	// e.g. 3333 6666
    	if(cnt == A.length() && cnt > 3){
    		System.out.printf("%04d - %04d = 0000", Integer.parseInt(A), Integer.parseInt(A));
    		return;
    	}
    	
        // e.g. 333 33 3 to 0333 0033 0003
    	A = String.format("%04d", Integer.parseInt(A));
    	
    	while(true){
    		char [] a = A.toCharArray();
    		Arrays.sort(a);   // ascending
    		String A1 = String.valueOf(a);
    		
    		// from ascending to descending
    		for(int i = 0; i < a.length / 2; i++)
    		{
    		    char temp = a[i];
    		    a[i] = a[a.length - i - 1];
    		    a[a.length - i - 1] = temp;
    		}
    		String A2 = String.valueOf(a);
    		
    		int res = Integer.parseInt(A2) - Integer.parseInt(A1);
    		A = String.format("%04d", res); // do not forget
    		
    		System.out.printf(A2 + " - " + A1 + " = " + A + "\n");	
    		
    		if(A.equals("6174")){
    			break;
    		}
    	}
    	
    	
    	in.close();
    }
}
