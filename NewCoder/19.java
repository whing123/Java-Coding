/* *��Ŀ��
 *  �ɼ��̴���
 * *˼·��
 *  ��set�ռ����ļ������Ҽ��'+'��������ַ�������ж��Ƿ񻵣�Сд��ĸ�����д�Ƿ���set����д��ĸ��Ҫ�ж�'+'����������ͨ�ж�
 * *������
 *  HashSet��ʹ�ã�add��contains��char��Сдת������ĸ�����ж�
 */
 
import java.util.*;
 
public class Hello{
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        String invalid = in.next();
        String words = in.next();
        
        Set<Character> set = new HashSet();
        
        for(int i = 0; i < invalid.length(); i++){
        	set.add(invalid.charAt(i));
        }
        
        boolean isUp = set.contains('+');
        
        for(int i = 0; i < words.length(); i++){
        	char ch = words.charAt(i);
        	if('a'<= ch && ch <='z' && !set.contains(Character.toUpperCase(ch))){ // a-z
        		System.out.print(ch);
        	}else if('A'<= ch && ch <='Z' && !set.contains(ch) && !isUp){ // A-Z
        		System.out.print(ch);
        	}else if(!Character.isLetter(ch) && !set.contains(ch)){ // others
        		System.out.print(ch);
        	}
        }
        System.out.println(); // do not forget
        
        in.close();
    }
}