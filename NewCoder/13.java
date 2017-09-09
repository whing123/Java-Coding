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
