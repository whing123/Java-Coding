/* *题目：
 *  个位数统计
 * *思路：
 *  遍历字符串，用map累计每种数字出现的次数，最后遍历map输出
 * *技法：
 *  升序Map TreeMap的插入和遍历，char to int
 */

import java.util.Scanner; 
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class HelloWorld {
	
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	String N = in.next();
    	
    	TreeMap<Integer, Integer> map = new TreeMap();
    	for(int i = 0; i < N.length(); i++) {
    		
    		// char to int
    		//int key = Character.getNumericValue(N.charAt(i));
    		int key = Character.digit(N.charAt(i), 10);
    		if(!map.containsKey(key)){
    			map.put(key, 1);
    		}else{
    			int val = map.get(key);
    			map.put(key, val+1);
    		}
    	}
    	
    	// traversal
    	Iterator it = map.entrySet().iterator();
    	while(it.hasNext()){
    		Map.Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>) it.next();
    		System.out.println((int)e.getKey()+ ":" + e.getValue());
    	}

    	in.close();
    }
}
