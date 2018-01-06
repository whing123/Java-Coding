/* *题目：
 *  旧键盘打字
 * *思路：
 *  用set收集坏的键，并且检查'+'，对输出字符串逐个判断是否坏，小写字母看其大写是否在set，大写字母还要判断'+'，其他的普通判断
 * *技法：
 *  HashSet的使用，add，contains，char大小写转换，字母数字判断
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