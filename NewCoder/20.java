/* *��Ŀ��
 *  ��������
 * *˼·��
 *  �����򣬴����Ŀ�ʼ��ÿ��һ�����ģ�Ȼ�������о���Ļ����ϼ���̽�������롣
 * *������
 *  Arrays.sort(����)
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