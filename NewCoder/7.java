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
    	
    	// 3333
    	if(cnt == A.length() && cnt > 3){
    		System.out.printf("%04d - %04d = 0000", Integer.parseInt(A), Integer.parseInt(A));
    		return;
    	}
    	
    	A = String.format("%04d", Integer.parseInt(A));
    	
    	while(true){
    		char [] a = A.toCharArray();
    		Arrays.sort(a);   // ascending
    		String A1 = String.valueOf(a);
    		
    		// descending
    		for(int i = 0; i < a.length / 2; i++)
    		{
    		    char temp = a[i];
    		    a[i] = a[a.length - i - 1];
    		    a[a.length - i - 1] = temp;
    		}
    		String A2 = String.valueOf(a);
    		
    		int res = Integer.parseInt(A2) - Integer.parseInt(A1);
    		A = String.format("%04d", res);
    		
    		System.out.printf(A2 + " - " + A1 + " = " + A + "\n");	
    		
    		if(A.equals("6174")){
    			break;
    		}
    	}
    	
    	
    	in.close();
    }
}
