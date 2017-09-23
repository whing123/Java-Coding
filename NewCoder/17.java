/* *题目：
 *  查验身份证
 * *思路：
 *  将权重，Z与M的校验关系做成查找表，输入一个身份证，判断前17位是否都为数字，然后求校验位，判断校验位是否一致。
 * *技法：
 *  判断字符是否在0-9，char to int
 */
 
import java.util.*;
 
public class Hello{
     
    static final int [] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    static final char [] Z2M = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    static final int modNum = 11;
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        int N = in.nextInt();
        String ID;
         
        int count = 0;
        for(int i = 0; i < N; i++){
            ID = in.next();
             
            // check first 17 bits all 0-9
            boolean flag = false;
            for(int j = 0; j < 17; j++){
                if(!('0' <= ID.charAt(j) && ID.charAt(j) <= '9')){
                    flag = true;
                }
            }
            if(flag){
                System.out.println(ID);
                count++;
                continue;
            }
             
            // check last bit
            int sum = 0;
            for(int j = 0; j < 17; j++){
                sum += Character.getNumericValue(ID.charAt(j)) * weight[j];
            }
            if(Z2M[sum % modNum] != ID.charAt(17)){
                System.out.println(ID);
                count++;
            }
        }
         
        // no error
        if(count == 0){
            System.out.println("All passed");
        }
          
        in.close();
    }
}