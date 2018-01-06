/* *题目：
 *  对称矩阵
 * *思路：
 *  输入一个N维矩阵，判断是否对称
 */

import java.util.Scanner;
 
public class Main{
    public static void main(String argv[]){
        Scanner numIn = new Scanner(System.in);
         
        while(numIn.hasNext()){
            int N = numIn.nextInt();
            int arr[][] = new int[N][N];
             
            for(int i = 0; i < N; ++i){
                for(int j = 0; j < N; ++j){
                    arr[i][j] = numIn.nextInt();
                }
            }
             
            isD(arr, N);
             
        }
    }
     
    public static void isD(int a[][], int n){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                if(a[i][j] != a[j][i]){
                    System.out.println("No!");
                    return ;
                }
            }
        }
         
        System.out.println("Yes!");
    }
}