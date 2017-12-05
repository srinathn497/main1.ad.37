package main;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class First {

	
		static int []outArray= new int[50];
		static int []outArray3= new int[50];
		static int f=0;
		static int j=0;
		static SortedSet<Integer> hs = new TreeSet<Integer>();
		

		public static void main(String[] args)
		{
			 String methodName="main()";
			 System.out.println("Inside the method  "+methodName);
			 int y=0;
			 
			 int z=1;
			 
			 
			System.out.println("Please enter  numbers which are integers and when finish press 0 and enter. ");
			Scanner sc = new Scanner(System.in);
			try
			{
				while(z!=0)
				{
			y=sc.nextInt();
			if(y!=0)
			{
			
			outArray[j]=y;
			j++;
			
			}
			else
			{
				z=0;
				
			}
			
				}
				//System.out.println("array"+outArray);
				
				
				int sr=getSecondSmallest(outArray);
				System.out.println("Second Smallest Element"+sr);
			
			}
			catch(Exception e)
			{
				System.err.println("Exception Caught\t" + e);
				//e.printStackTrace();
				//fail();
			}
			 
		}
		
		public static int getSecondSmallest(int[] outArray2)
		{
			String methodName="getSecondSmallest()";
			 System.out.println("Inside the method  "+methodName);
			for(int l=0;l<j;l++)
			{
				 //System.out.println(" Elements in array"+l+outArray2[l]);
				 hs.add(outArray2[l]);
				
				
			}
			try
			{
			@SuppressWarnings("rawtypes")
			Iterator itr = hs.iterator();
			

				for(int i=0;i<j;i++)
			        {
					outArray3[i]=(int) itr.next();
			            
			            //System.out.println("Sorted Elements"+outArray3[i]);
			        }
			
			}
			catch(Exception e)
			{
				System.err.println("Exception Caught\t" + e);
				//e.printStackTrace();
				//fail();
			}
			
			  int ss=outArray3[1];
			//System.out.println("Second Smallest Element"+ss);
				 
			  return ss;
			
		}
		
		
		//******************************************
		
		public static int getSecondSmallest2(int[] outArray2)
		{
			String methodName="getSecondSmallest()";
			 System.out.println("Inside the method  "+methodName);
			for(int l=0;l<outArray2.length;l++)
			{
				 //System.out.println(" Elements in array"+l+outArray2[l]);
				 hs.add(outArray2[l]);
				
				
			}
			try
			{
			@SuppressWarnings("rawtypes")
			Iterator itr = hs.iterator();
			

				for(int i=0;i<outArray2.length;i++)
			        {
					outArray3[i]=(int) itr.next();
			            
			            //System.out.println("Sorted Elements"+outArray3[i]);
			        }
			
			}
			catch(Exception e)
			{
				System.err.println("Exception Caught\t" + e);
				//e.printStackTrace();
				//fail();
			}
			
			  int ss=outArray3[1];
			//System.out.println("Second Smallest Element"+ss);
				 
			  return ss;
			

	
	
}
}

