/* *题目：
 *  人口普查
 * *思路：
 *  先实现人的比较器，对未出生的，超过200的人在输入时判断排除，其余记为有效的。在有效的里面寻找最年轻的和最年老的
 * *技法：
 *  class比较器的实现，compareTo()方法的设计，字符串split()，寻找并记录最大最小
 */


import java.util.*;

public class Hello{ 
	
	public static void main(String[] args) {
		final String today = "2014/9/6";
		final Age todayPerson = Age.newPerson(today);
		final String twoHundred = "1814/9/6";
		final Age oldPerson = Age.newPerson(twoHundred);

		int count = 0;
		
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        // store oldest and youngest person
        Age older = Age.newPerson(today);
        Age newer = Age.newPerson("1814/9/6");
        
        int i = 0;
        String name;
        String birthday;
        while(i < N){
        	name = in.next();
        	birthday = in.next();
        	Age tmp = Age.newPerson(birthday);
        	
        	i++;
        	
        	// > 200
        	/*if(tmp.isTooOld(todayPerson)){
        		continue;
        	}*/
        	if(tmp.compareTo(oldPerson) > 0){
        		continue;
        	}
        	
        	// not born yet
        	if(tmp.compareTo(todayPerson) < 0){
        		continue;
        	}
        	
        	// valid
        	count++;
        	
        	// younger
        	if(tmp.compareTo(newer) <= 0){
        		newer = tmp;
        		newer.name = name;
        	}
        	
        	// older
        	if(tmp.compareTo(older) >= 0){
        		older = tmp;
        		older.name = name;
        	}
        }
        
        // print
		System.out.println(count + " " + older.name + " " + newer.name);

	}
}

class Age implements Comparable<Age>{
    int year;
    int month;
    int day;
    String name;
    
    public Age(int y, int m, int d){
    	year = y;
    	month = m;
    	day = d;
    	name = null;
    }
    
    // create a person
    public static Age newPerson(String time){
    	String [] ymd = time.split("/");
    	return new Age(Integer.parseInt(ymd[0]),Integer.parseInt(ymd[1]),Integer.parseInt(ymd[2]));
    }
    
    // compare if older or younger
    public int compareTo(Age tmp){
    	int res = -1;
    	if(year < tmp.year){
    		res = 1;
    	}else if(year == tmp.year && month < tmp.month){
    		res = 1;
    	}else if(year == tmp.year && month == tmp.month && day < tmp.day){
    		res = 1;
    	}else if(year == tmp.year && month == tmp.month && day == tmp.day){ // ==
    		res = 0;
    	}
    	return res;
    }
    
    // check if exceeding 200
    boolean isTooOld(Age tmp){
    	boolean res = false;
    	if(tmp.year - year > 200){
    		res = true;
    	}else if(tmp.year - year == 200 && tmp.month > month){
    		res = true;
    	}else if(tmp.year - year == 200 && tmp.month == month && tmp.day > day){
    		res = true;
    	}
    	
    	return res;
    }    
}
