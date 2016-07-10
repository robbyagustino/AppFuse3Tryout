import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;


public class MyTest {
	public static void main (String[] args) throws ParseException { 
		long a;
		
//		 Comparator naturalOrder = new Comparator() { 
//		 public int compare(Integer first, Integer second) { 
//			 return first < second ? -1 : (first == second ? 0 : 1); 
//		 }
//
//		@Override
//		public int compare(Object o1, Object o2) {
//			// TODO Auto-generated method stub
//			return 0;
//		} 
//		 }; 
//		 int result = naturalOrder.compare(new Integer(42), new Integer(42)); 
//		 System.out.println(result);
		
//		int k=3;
//		int sa[] = {1, 2, 3, 3, 1, 3, 1};
//		System.out.println(solution3(k, sa));
		
//		String inputStr = "01-OCTOBER-2014";
//		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//		Date inputDate = dateFormat.parse(inputStr);
//		System.out.println(inputDate);
		
//		System.out.println(modifyDate());
//		System.out.println(count(5));
		
		printTriangle(8);
//		bitwiseNegate();
		
//		int A[] = {-1, 3, -4, 5, 1, -6, 2, 1};
//		System.out.println(solutionEqui(A));
	} 
	
	public static void printTriangle(int length){
		StringBuilder sb = new StringBuilder("*");
		for (int j = 0; j < length; j++) {
			sb.insert(0, " ");
		}
		for (int i = 0; i < length; i++) {			
			System.out.println(sb);
			sb.append("**");
			sb.replace(0, 1, "");
		}
	}
	
	public static void bitwiseNegate(){
		int a1 = 1;
		int a2 = ~a1;
		
		System.out.println(a2);
	}
	
	public static int count(int N){
		double a =  java.lang.Math.pow(11,N);
		String line = a+"";
		
		int count = line.length() - line.replace("1", "").length();
		System.out.println(line);
		System.out.println(line.length());
		System.out.println(line.replace("1", ""));
		System.out.println(line.replace("1", "").length());
		return count;
	}
	
	 public int solutionCount1(int N) {
	        // write your code in Java SE 8
	        
	        //Initialize
	        int total1 = 0;
	        double powerResult = java.lang.Math.pow(11,N);
	        
	        //Loop and count character 1
	        String s = powerResult+"";
	        for( int i=0; i<s.length(); i++ ) {
	            if( s.charAt(i) == '1' ) {
	                total1++;
	            } 
	        }
	        //Return the result
	        return total1;
	    }
	
	public static int modifyDate() throws ParseException{
		String year = "2014";
		String mon1 = "APRIL";
		String mon2 = "MAY";
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String inputStr1 = "01-"+mon1+"-"+year;
		String inputStr2 = "01-"+mon2+"-"+year;
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date inputDate1 = dateFormat.parse(inputStr1);
		Date inputDate2 = dateFormat.parse(inputStr2);
		
		Calendar c = Calendar.getInstance();
		c.setTime(inputDate2);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		inputDate2 = c.getTime();
		
		System.out.println(inputDate1);
		System.out.println(inputDate2);
		
		System.out.println(getMonthsCount(inputDate1, inputDate2));
		int ct = getMonthsCount(inputDate1, inputDate2);
		Calendar c1 = Calendar.getInstance();
		c1.setTime(inputDate1);
		int minus =0;
		
		int j=0 ;
		
		//for(int j=0 ; j<ct;j++){
		do{
			
			Date date3 = c1.getTime();
			System.out.println(date3);
			
			System.out.println(c1.get(Calendar.DAY_OF_WEEK));
			if(c1.get(Calendar.DAY_OF_WEEK) != 1){
				minus=minus+1;
			}
			c1.add(Calendar.MONTH, 1);
			j=j+1;
		}while(j<ct);
		System.out.println("minus:"+ minus);
		
		return ( countWeeksBetween(inputDate1, inputDate2));
	}
	
	public static int getMonthsCount(Date startDate, Date endDate){
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(startDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		return diffMonth;
	}
	
	
	public static int countWeeksBetween(Date startDate, Date endDate) {

		//Reverse if negative
	    if (endDate.before(startDate)) {
	        return -countWeeksBetween(endDate, startDate);
	    }
	    //Reset time
	    startDate = resetTime(startDate);
	    endDate = resetTime(endDate);
	    //Set calendar for counting
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(startDate);	    
	    int weekday = cal.get(Calendar.DAY_OF_WEEK);
	    int days = Calendar.SUNDAY - weekday;
	    if (days < 0)   {
	        days += 7;
	    }
	    cal.add(Calendar.DAY_OF_YEAR, days);
	    //Counting the weeks difference
	    int weeks = 0;
	    while (cal.getTime().before(endDate)) {
	        cal.add(Calendar.WEEK_OF_YEAR, 1);
	        weeks++;
	    }
	    return weeks;
	}
	
	public static Date resetTime (Date d) {
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(d);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	
	
	public static int solutionEqui(int[] A) {
        // write your code in Java SE 8
        long sum = 0, leftsum = 0;
        int i, l = A.length;
        for (i = 0; i < l; i++) {
            sum += A[i];
        }
        for (i = 0; i < l; i++) {
            sum -= A[i];
            if (leftsum == sum) {
                return i;
            }
            leftsum += A[i];
        }
        return -1;
    }
	
	public static int solution3(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 1;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (count[A[i]] >= 0) {
            	System.out.println("1");
                int tmp = count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
                count[A[i]] = tmp + 1;
            } else {
            	System.out.println("2");
                count[A[i]] = 1;
            }
        }
        return A[index];
    }
}


class SuperDuper { 
private void aMethod() { } 
} 
class Sub extends SuperDuper { 
protected void aMethod() { } 
} 