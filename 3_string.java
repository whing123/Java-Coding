import java.util.Scanner;

public class HelloWorld {
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	String A = in.next();
    	String B = in.next();
    	
    	String res = "";
    	String pre = "";
    	
    	int Q = 0;
    	int R = 0;
    	
    	int a = 0;
    	int b = Integer.parseInt(B);
    	for(int i = 0; i < A.length(); ++i){
    		a = Integer.parseInt(pre + A.substring(i, i+1));
    		if(a < b && i+1 < A.length()){  //ºóÒÆÒ»Î»
    			res += "0";
    			a = Integer.parseInt(A.substring(i, i+2));
    			i++;
    		}
    		
    		Q = a / b;
    		R = a % b;
    		
    		if(R == 0){
    			pre = "";
    		}else{
    			pre = Integer.toString(R);
    		}
    		
    		res += Integer.toString(Q);
    		
    	}
    	
    	if(res.charAt(0) == '0'){
    		res = res.substring(1);
    	}
    	
    	System.out.print(res + " " + R);
    	
    	in.close();
    }
  
}
