/* *��Ŀ��
 *  �ھ�������ļ�ǿ
 * *˼·��
 *  ��Map�ۼƸ�ѧУ�ĵ÷֣�ÿ��һ�������find Max
 * *������
 *  Map�Ĳ��������
 */
 
import java.util.*;
 
public class Hello{
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        int N = in.nextInt();
        
        Map<Integer, Integer> map = new HashMap();
        int school = 0;
        int score = 0;
        
        int maxSchool = 0;
        int maxScore = 0;
        for(int i = 0; i < N; ++i){
        	school = in.nextInt();
        	score = in.nextInt();
        	
        	// insert
        	if(map.containsKey(school)){
        		map.put(school, score + map.get(school));
        	}else{
        		map.put(school, score);
        	}
        	
        	// find Max
        	if(map.get(school) > maxScore){
        		maxScore = map.get(school);
        		maxSchool = school;
        	}
        }
        
        System.out.println(maxSchool+" "+maxScore);
          
        in.close();
    }
}