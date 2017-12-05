/**
 * 
 */
package main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Srinath
 *
 */
public class Third {

	/**
	 * @param args
	 */
	static int s;
	static int i=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		boolean d=false;
		// TODO Auto-generated method stub
		String methodName="main";
        System.out.println("Inside the method  "+methodName);
        Map<Integer,Integer> map2=new HashMap<Integer,Integer>();
        Map<Integer,String> map3=new HashMap<Integer,String>();
        Scanner sc = new Scanner(System.in);
        try{
        while(!d)
        {
		System.out.println("Please enter Marks of students and press 0 and enter when finished ");
		i++;
		
		s = sc.nextInt();
		  if (s==0)
		            {
		            	d = true;
		            	break;
		            }
                map2.put(i, s);
		       
		
        }

        Map<Integer,String> map1= getEligible(map2);
		System.out.println("Students who win the Medals with their I.D "+map1);
        }
        catch (InputMismatchException e) 
		{
			
			System.err.println("Exception Caught\t" + e);
			e.printStackTrace();
		
		}
		finally {
			sc.close();
		}
	}

	public static Map<Integer, String> getEligible(Map<Integer, Integer> map4) 
	{
		
		String methodName="getEligible";
        System.out.println("Inside the method  "+methodName);
        

		Map<Integer,String> map3=new HashMap<Integer,String>();
		
		s=map4.get(2);
		
		
		for (Integer key : map4.keySet()) {
		  
		s=map4.get(key);
		if(s >= 90)
        {
			
			map3.put(key, "Gold");
        }
        else if(s>=80 & s <=90)
        {
        	map3.put(key, "Silver");
        	
        }
        else if(s>=70 & s <=80)
        {
        	map3.put(key, "Bronze");
        }
        else if(s<70)
        {
        	//nothng
        }
		
		}
		return map3;
	}
	
	////////////////////
	
	
	
	
	
	
	
	

}

