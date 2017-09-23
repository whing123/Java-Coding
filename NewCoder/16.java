/* *��Ŀ��
 *  �ɼ���
 * *˼·��
 *  �Ƚ�����ת���ɴ�д��������map��ǵ�һ��������ַ����У��ٷ���ǵڶ��εģ����δ����ǵġ�
 * *������
 *  LinkedHashMap��¼����˳��Map���������
 */

import java.util.*;

public class Hello{ 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String org = in.next();
		String now = in.next();
		
		// to upper case
		org = org.toUpperCase();
		now = now.toUpperCase();
		
		// keep order
		Map<Character, Boolean> map = new LinkedHashMap();
		// set false for first input
		for(int i = 0; i < org.length(); i++){
			// if already contained
			if(map.containsKey(org.charAt(i))){
				continue;
			}
			map.put(org.charAt(i), false);
		}
		// set true for second input
		for(int i = 0; i < now.length(); i++){
			map.put(now.charAt(i), true);
		}
		
		Iterator it = map.entrySet().iterator();
    	while(it.hasNext()){
    		Map.Entry<Character, Boolean> e = (Map.Entry<Character, Boolean>) it.next();
    		// if still false, which didn't appear in second input
    		if(!e.getValue()){
    			System.out.print(e.getKey());
    		}
    	}
    	System.out.println(); // do not forget '\n'
    	
    	in.close();
	}
}

