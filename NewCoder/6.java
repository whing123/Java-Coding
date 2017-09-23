/* *题目：
 *  部分 A+B
 * *思路：
 *  先找出两个子数字String，若无则0，然后长范围整数相加
 * *技法：
 *  substring的使用，int to String，长范围整数相加
 */

import java.util.Scanner;

public class HelloWorld {
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	
    	String A = in.next();
    	String aStr = in.next();
    	int a = Integer.parseInt(aStr);
    	String subA = "";
    	
    	String B = in.next();
    	String bStr = in.next();
    	int b = Integer.parseInt(bStr);
    	String subB = "";
    	
    	// aaa...
    	for(int i = 0; i < A.length(); i++){
    		if(A.substring(i,i+1).equals(aStr)){
    			subA += aStr;
    		}
    	}
    	
    	// bbb...
    	for(int i = 0; i < B.length(); i++){
    		if(B.substring(i,i+1).equals(bStr)){
    			subB += bStr;
    		}
    	}
    	
    	// find nothing, not exists
    	if(subA.equals("")){
    		aStr = "0";
    	}
    	if(subB.equals("")){
    		bStr = "0";
    	}
    	
    	// if 000...
    	subA = aStr.equals("0") ? aStr : subA;
    	subB = bStr.equals("0") ? bStr : subB;
    	
    	// 12334 
    	//    12
    	// 123 : extra
    	String extra = subA.length() > subB.length() ? subA.substring(subB.length(), subA.length()) : subB.substring(subA.length(), subB.length());
    	int minSize = subA.length() > subB.length() ? subB.length() : subA.length();
    	
    	String res = "";
    	
    	int carry = 0;
    	int up = 0;
    	for(int i = minSize-1; i >= 0 ; --i){  // from right to left
    		up = carry + Integer.parseInt(subA.substring(i,i+1)) + Integer.parseInt(subB.substring(i,i+1));
    		carry = up > 9 ? 1 : 0;
    		up = carry == 1 ? up-10 : up;
    		
    		res = Integer.toString(up) + res;
    	}
    	
    	for(int i = extra.length()-1; i >= 0; --i){  // extra length
    		up = carry + Integer.parseInt(extra.substring(i,i+1));
    		carry = up > 9 ? 1 : 0;
    		up = carry == 1 ? up-10 : up;
    		
    		res = Integer.toString(up) + res;
    	}
    	
    	if(carry > 0) // do not forget the last carry
    		res = Integer.toString(carry) + res;
    	
    	
    	System.out.print(res);
    	
    	in.close();
    }
}
