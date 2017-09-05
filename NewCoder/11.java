import java.util.Scanner;
import java.util.List;
import java.util.ArrayList; 
import java.util.Collections;

public class Hello {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int L = in.nextInt();
		int H = in.nextInt();
		
		int M = 0;
		
		List<Student> list = new ArrayList<Student>(N);  
		
		int id, D, C;
		id = D = C = 0;
		for(int i = 0; i < N; ++i){
			id = in.nextInt();
			D = in.nextInt();
			C = in.nextInt();
			
			if(D >= L && C >= L){
				list.add(new Student(id,D,C,H));
				M++;
			}
				 
		}
		
		// sort
		Collections.sort(list);
		
		System.out.println(M);
		// traversal
		for(int i = 0; i < list.size(); i++) {    
		     System.out.println(list.get(i));
		}  
		
		in.close();
	}
}

class Student implements Comparable<Student>{
	public int ID;
	public int DScore;
	public int CScore;
	public int total;
	public int level;
	
	public Student(int id, int D, int C, int H){
		ID = id;
		DScore = D;
		CScore = C;
		total = DScore + CScore;
		
		if(DScore>= H && CScore >= H){
			level = 1;
		}else if(DScore>= H && CScore < H){
			level = 2;
		}else if(DScore < H && DScore >= CScore){
			level = 3;
		}else{
			level = 4;
		}
		
	}
	
	public String toString(){
		return ""+ID+" "+DScore+" "+CScore; 
	}
	
	public int compareTo(Student t){
		int res = 1;
		
		if(level < t.level){
			res = -1;
		}else if(level == t.level){
			if(total > t.total){
				res = -1;
			}else if(total == t.total){
				if(DScore > t.DScore){
					res = -1;
				}else if(DScore == t.DScore){
					if(ID < t.ID){
						res = -1;
					}
				}
			}
		}
		
		return res;
	}
}