import java.util.Scanner; 

public class HelloWorld {
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	int N = in.nextInt();
    	int D = in.nextInt();
    	
    	int count [] = new int[N];  // kucun
    	double price [] = new double[N];  // zongjia	
    	double perPrice [] = new double[N];  // danjia
    
    	for(int i = 0; i < N; ++i){
    		count[i] = in.nextInt();
    	}
    	
    	for(int i = 0; i < N; ++i){
    		price[i] = in.nextDouble();
    		perPrice[i] = price[i] / count[i];
    	}
    	
    	// sort mao pao
    	double temp = 0;
    	for (int i = N-1; i > 0; i--) {
    		for (int j = 0; j < i; j++) {
    		    if(perPrice[j] < perPrice[j+1]){
    		    	temp = perPrice[j];
    		    	perPrice[j] = perPrice[j+1];
    		    	perPrice[j+1] = temp;

    		    	temp = count[j];
    				count[j] = count[j+1];
    				count[j+1] = (int) temp;
    				
    				temp = price[j];
    				price[j] = price[j+1];
    				price[j+1] = (int) temp;
    		    }
    		}
    	}
    	
    	
    	double outPrice = 0;
    	int index = 0;
    	while(D > 0){
    		
    		if(D > count[index]){
    			D -= count[index];
    			outPrice += price[index];
    		}else{
    			outPrice += price[index] / count[index] * D;
    			break;
    		}
    		
    		/*
    		int delta = (count[index] > D ? D : count[index]);
            D -= delta;
            if(D > 0){
                outPrice += price[index];
            }else{
                outPrice += delta / (double)count[index] * price[index];
            }
            */
    		
    		index++;
    	}
    	
    	System.out.printf("%.2f\n", outPrice);
    	
    	in.close();
    }
}
