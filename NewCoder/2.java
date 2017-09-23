/* *题目：
 *  数字分类
 * *思路：
 *  对输入的每个整数进行判断和处理
 * *技法：
 *  输入整数
 */

import java.util.Scanner;
 
public class Main {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
         
        int N =  in.nextInt();
          
        int A1 = 0;
        int A2 = 0;
        int A2_cnt = 0;
        int A3 = 0;
        int A4 = 0;
        int A4_cnt = 0;
        int A5_max = 0;
          
        int tmp;
        for(int i = 0; i < N; ++i){
            tmp = in.nextInt();
              
            if(tmp % 10 == 0){
                A1 += tmp;
            }
              
            if(tmp % 5 == 1){
                A2 += Math.pow(-1, A2_cnt) * tmp;
                A2_cnt++;
            }
              
            if(tmp % 5 == 2){
                A3++;
            }
              
            if(tmp % 5 == 3){
                A4 += tmp;
                A4_cnt++;
            }
              
            if(tmp % 5 == 4){
                if(tmp > A5_max){
                    A5_max = tmp;
                }
            }
        }
         
        if(A1 == 0){
            System.out.print("N");
        }else{
            System.out.print(A1);
        }
         
        System.out.print(" ");
         
        if(A2_cnt == 0){
            System.out.print("N");
        }else{
            System.out.print(A2);
        }
         
        System.out.print(" ");
         
        if(A3 == 0){
            System.out.print("N");
        }else{
            System.out.print(A3);
        }
         
        System.out.print(" ");
         
        if(A4_cnt == 0){
            System.out.print("N");
        }else{
            System.out.printf("%.1f", A4/(double)A4_cnt);
        }
         
        System.out.print(" ");
         
        if(A5_max == 0){
            System.out.print("N");
        }else{
            System.out.print(A5_max);
        }
         
        in.close();
    }  
}