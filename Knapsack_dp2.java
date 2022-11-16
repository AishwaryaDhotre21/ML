class Knapsack_dp2
{
	static int max(int a,int b)
	{
		return(a>b)?a:b;
	}
	static int knapsack(int W,int[] wt,int val[],int n)
	{
		int i,w;
		int v[][]=new int[n+1][W+1];
		for(i=0;i<=n;i++)
		{
			for(w=0;w<=W;w++)
			{
				if(i==0 || w==0)
				v[i][w]=0;
				else if(wt[i-1]<=w)
				v[i][w]=max(v[i-1][w],v[i-1][w-wt[i-1]]+val[i-1]);
				else
				v[i][w]=v[i-1][w];
			}
		}
		return v[n][W];
	}
	public static void main(String args[])
	{
		int val[]={60,100,120}	;
		int wt[]={10,20,30};
		int W=50;
		int n=val.length;
		int vl=knapsack(W,wt,val,n);
		System.out.println(vl);
	}
}