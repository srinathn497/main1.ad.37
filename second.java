package main;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Srinath
 *
 */
public class second {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sb2;
		
		
		
		String methodName = "main()";
		System.out.println("Method Invoked:" + methodName);
		System.out.println("Please enter a numbers ");
		Scanner sc = new Scanner(System.in);
		try
		{
		int inputNumber1=sc.nextInt();
		
		sb2= modifyNumber(inputNumber1);
		System.out.println("Difference btw two consecutive numbers and \n making units digit remains same \t"+""+sb2);
		}
		 catch (InputMismatchException e) 
			{
				// JDK 1.7 Version Updation
				System.err.println("Exception Caught\t" + e);
				e.printStackTrace();
			
			}
			finally {
				sc.close();
			}
		}

	
	//********************************************
	
	protected static int modifyNumber(int n)
	{
		String methodName = "modifyNumber()";
		System.out.println("Method Invoked:" + methodName);
		 int inputNumber;
		  int k;
		  String str1;
		  
		  List l = new ArrayList();
		  List m = new ArrayList();
		  //List<int> al=new ArrayList<int>();
		  int[] a = new int[5];
		  int[] b = new int[5];
		  int i=0,j=0,z=0;
		  
		  StringBuffer sb = new StringBuffer("");
		  try
		  {
	
		inputNumber=n;
	
		str1=String.valueOf(inputNumber);
		
		
			for( i=0;i<str1.length();i++)
			{
			char  ch ;
		    ch=str1.charAt(i);
		   
		    
		
		    l.add((int)ch);
		    
		   
		    }
			z=l.size()-1;

	for(j=0;j<str1.length()-1;j++)
	{
		//b[j]=Math.abs(a[j]-a[j+1]);
		int r = (int)l.get(j);
        int s=(int)l.get(j+1);
		m.add(Math.abs(r-s));
	
		//b[j]=Math.abs((l.get(j))-(l.get(j+1)));
		//System.out.println("Convert"+m.get(j));
		
		sb.append(m.get(j));
		
			
	}
	int c=Integer.parseInt(l.get(z).toString());
	int y=Character.getNumericValue(c);

	
	sb.append(y);
	String s1=sb.toString();
	n=Integer.parseInt(s1) ;
	//System.out.println("Difference btw two consecutive numbers and \n making units digit remains same from method \t"+""+sb);
	
		  }
		  catch (InputMismatchException e) 
			{
				// JDK 1.7 Version Updation
				System.err.println("Exception Caught\t" + e);
				fail();
			
			}
		  return n;
	}
	
	

	
	

}
