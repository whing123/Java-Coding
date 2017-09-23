/* *题目：
 *  组个最小数
 * *思路：
 *  将0到9从左往右排列，大数在右小数在左，用第一个非0数替代leading 0
 * *技法：
 *  StringBuffer的使用，append()，leading 0的处理
 */


import java.util.*;

public class Hello{ 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int N = 10;
		
		// store input numbers
		int [] array = new int[N];
		for(int i = 0; i < N; i++ ){
			array[i] = in.nextInt();
		}
		
		
		StringBuffer res = new StringBuffer();
		// leading 0 is not allowed
		for(int i = 1; i < N; i++){
			if(array[i] != 0){
				array[i]--;
				res.append(i);
				break;
			}
		}
		
		// from 0 to 9 adding them to the sequence
		for(int i = 0; i < N; i++ ){
			while(array[i] != 0){
				res.append(i);
				array[i]--;
			}
		}
		
		System.out.println(res);
	}
}

