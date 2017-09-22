
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

