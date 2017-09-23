/* *题目：
 *  科学计数法 
 * *思路：
 *  先将字符串以E分开split，指数部分转为整数，代表小数点移动的方向和位数。数字部分的符号为最终符号。再将数字部分以小数点分割。
 *  对于数字部分0.0或0的直接输出之。接着输出符号，并向左或向右移动小数点，向左移动时注意0.开头的形式和插0，向右移动时注意去掉leading 0和小数点的位置。
 * *技法：
 *  字符串的分割，寻找指定字符的下标，插入字符，leading 0的自动去除
 */


import java.util.Scanner;

public class Hello {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String ENum = in.next();
			String [] parts = ENum.split("E");
			
			int tail = Integer.parseInt(parts[1]); // how many 0s
			String sign = parts[0].charAt(0) == '+' ? "" : "-";
			
			String partLeft;  // . before
			String partRight; // . after
			int indexOfDot = parts[0].indexOf('.');
			if(indexOfDot == -1){
				partLeft = parts[0].substring(1, parts[0].length());
				partRight = "";
			}else{
				partLeft = parts[0].substring(1, indexOfDot);
				partRight = parts[0].substring(indexOfDot+1, parts[0].length());
			}
			
			if(Integer.parseInt(partLeft) == 0 && (partRight == "" || Integer.parseInt(partRight) == 0)){
				System.out.println(parts[0]);
				continue;
			}
			
			// sign, first
			System.out.print(sign);
			
			// move '.' to proper location
			int cnt = Math.abs(tail);
			if(tail < 0){  // move left
				System.out.print("0.");
				int  i = 1;
				while(i < cnt){
					System.out.print("0");
					i++;
				}
				System.out.println(partLeft+partRight);
			}else{
				if(cnt >= partRight.length()){  // adding 0s
					
					System.out.print(remove0(partLeft+partRight));
					
					int tmp = cnt - partRight.length();
					int i = 0;
					while(i < tmp){
						System.out.print("0");
						i++;
					}
					System.out.println();
				}else{  // no need for 0s
					StringBuffer newRight = new StringBuffer(partRight);
					newRight = newRight.insert(cnt, '.');
					partRight = newRight.toString();
					
					System.out.println(remove0(partLeft+partRight));
				}
			}			
		}
	
		in.close();
	}
	
	// remove leading 0s
	static String remove0(String str){
		StringBuffer newStr = new StringBuffer(str);
		while(1 < newStr.length()){
			if(newStr.charAt(0) == '0' && newStr.charAt(1) == '0'){
				newStr = newStr.delete(0,1);
			}else if(newStr.charAt(0) == '0' && '0' < newStr.charAt(1) && newStr.charAt(1) <= '9'){
				newStr = newStr.delete(0,1);
				break;
			}else if(newStr.charAt(1) == '.'){
				break;
			}else if(newStr.charAt(0) != '0'){
				break;
			}
		}
		
		return newStr.toString();
	}
}

