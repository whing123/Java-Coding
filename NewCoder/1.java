import java.util.Scanner;

public class HelloWorld {
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
         
        int i = 0;
        while(i < T){
            long A = in.nextLong();
            long B = in.nextLong();
            long C = in.nextLong();
             
            if(A+B > C){
                System.out.println("Case #"+ (i+1) +": true");
            }else{
                System.out.println("Case #"+ (i+1) +": false");
            }
            
            i++;
        }
        
        in.close();
    }
  
}
