/* *题目：
 *  完美数列
 * *思路：
 *  先排序，从最大的开始，每找一个最大的，然后在已有距离的基础上继续探测更大距离。
 * *技法：
 *  Arrays.sort(数组)
 */

 
import java.util.*;
 
public class Hello{
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int p = in.nextInt();
        
        int tmp;
        int [] list = new int [N];
        for(int i = 0; i < N; ++i){
        	list[i] = in.nextInt();
        }
        
        // ascending
        Arrays.sort(list);
        
        int dist = 0;  // length
        for(int i = N-1; i > 0; --i){
        	// based on current dist, search from j to 0, 0 <- j = i-dist ... i
        	for(int j = i-dist; j >= 0; --j){
        		
        		if(list[i] / (double)list[j] > p){
        			break;
        		}
        		
        		// larger dist appears
        		dist++;
        	}
        }
        System.out.println(dist);
        
        in.close();
    }
}