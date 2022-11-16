import java.util.*;

class pro333
{
	static class Item
	{
		double p;
		double w;
		public Item(double pr,double wt)
		{
			p=pr;
			w=wt;
		}
	}

	static class MyComparator implements Comparator<Item>
	{
		public int compare(Item a,Item b)
		{
			double v1=(a.p/a.w);
			double v2=(b.p/b.w);
			
			if(v1 < v2)
			return 1;
			else
			return -1;
		}
	}
	
	public static double max(Item[] arr,double capacity)
	{
		Arrays.sort(arr,new MyComparator());
		System.out.println("Profit"+"   "+"Weight"+"   ");
		for(Item i:arr)
		{
			System.out.println(i.p+"   "+i.w+"   ");
		}

		double maxProfit=0d;
		for(Item i:arr)
		{
			double curwt=i.w;
			double curpr=i.p;
			if(capacity-curwt >= 0)
			{
				capacity=capacity-curwt;
				maxProfit=maxProfit+curpr;
			}
			else
			{
				double fract=(capacity/curwt);
				capacity=capacity-(curwt*fract);
				maxProfit=maxProfit+(curpr*fract);
				break;
			}
		}
		return maxProfit;
	}
	

		public static void main(String args[])
	{	Scanner sc=new Scanner(System.in);
		double capacity=sc.nextDouble();
		Item[] arr = { new Item(60, 10),
                            new Item(100, 20),
                            new Item(120, 30) };

		Item[] objArr=new Item[3];
		for(int i=0;i<3;i++)
		{
			objArr[i]=new Item(sc.nextDouble(),sc.nextDouble());
		}

		 double maxValue = max(objArr, capacity);
 
        	// Function call
	        System.out.println(maxValue);
	}

}