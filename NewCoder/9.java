/* *题目：
 *  福尔摩斯的约会
 * *思路：
 *  先在前两个字符串里找week，第一对相同的A-G，再继续找hour 0-9或A-N，再在后两个字符串找相同字母，下标表示分钟。
 * *技法：
 *  字符串按下标取字符，判断字符属于字母或数字，格式化输出（前导0）
 */

import java.util.Scanner; 

public class HelloWorld {
	
	public final static String weekDay [] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	String A = in.next();
    	String B = in.next();
    	String C = in.next();
    	String D = in.next();
    	
    	boolean flag1 = true;
    	boolean flag2 = false;
    	for(int i = 0; i < A.length(); ++i){
    		char week = A.charAt(i);
    		
            // find week
    		if(flag1 && 'A' <= week && week <= 'G'){
    			if(B.charAt(i) == week){
    				System.out.print(weekDay[week-'A']);
    				flag1 = false;  // no longer in
    				flag2 = true;   // else if can in
    			}
    		}else if(flag2 && ('A' <= week && week <= 'N' || '0' <= week && week <= '9')){ // find hour
    			if(B.charAt(i) == week){
	    			if('0' <= week && week <= '9'){
	    				System.out.printf(" %02d:", week-'0');
	    			}else{
	    				System.out.printf(" %02d:", week-'A' + 10);
	    			}
	    			break;
    			}
    		}
    	}
    	
    	for(int i = 0; i < C.length(); ++i){
    		char week = C.charAt(i);
    		if('A' <= week && week <= 'Z' || 'a' <= week && week <= 'z'){ // find minute
    			if(D.charAt(i) == week){
    				System.out.printf("%02d", i);
    				break;
    			}
    		}
    	
    	}
    	
    	in.close();
    }
}
