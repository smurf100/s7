package series;

public class prime{


		public prime(int n)
		{

			for(int i=2;i<=n;i++)
			{ 
                                                             int flag=1;
			for(int j=2;j<i;j++)
			if(i%j==0)
			{
			flag=0;
			 break;
			}
	if(flag==1) System.out.println(""+i+" ");
				}
		}

}

