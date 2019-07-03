/*
  问题描述
　　我们把一个数称为有趣的，当且仅当：
　　1. 它的数字只包含0, 1, 2, 3，且这四个数字都出现过至少一次。
　　2. 所有的0都出现在所有的1之前，而所有的2都出现在所有的3之前。
　　3. 最高位数字不为0。
　　因此，符合我们定义的最小的有趣的数是2013。除此以外，4位的有趣的数还有两个：2031和2301。
　　请计算恰好有n位的有趣的数的个数。由于答案可能非常大，只需要输出答案除以1000000007的余数。
输入格式
　　输入只有一行，包括恰好一个正整数n (4 ≤ n ≤ 1000)。
输出格式
　　输出只有一行，包括恰好n 位的整数中有趣的数的个数除以1000000007的余数。
样例输入
4
样例输出
3
*/
/*
 * n=4 L=3*2^0
 * n=5 L=(4+4*3)*2^1
 * n=6 L=(5+5*4+5*4)*2^2
 * n=7 L=(6+6*5+6*5*4+6*5)*2^3
 * n=8 L=(7+7*6+7*6*5+7*6*5+7*6)*2^4
 * ...
 */
public class a {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		long L=0;//L is final answer
		int m=1;
		
		if(n%2==0)
		{
			for(int a=n-1;a>=n/2+1;a--) 
			{
				m*=a;
				if(a==n-1)
					L+=m;
				else
					L+=2*m;
			}
		}
		else
		{
			for(int a=n-1;a>=(n+1)/2;a--) 
			{
				m*=a;
				if(a==n-1||a==(n+1)/2)
					L+=m;
				else
					L+=2*m;
			}
		}
		
		
		for(int i=n-4;i>0;i--)
		{
			L*=2;
			if(L>1000000007)
				L=L%1000000007;
		}

		
		System.out.println(L);
	}
}


import java.util.Scanner;

/* pu(b,a)  从a个位置选出b个位置放β      由pu(β,n-1)
 * ch(b,2)  从α或β的两种形态中选出某形态的b个数
 * 4 2α1β        pu(1,3)
 * 
 * 5 3α1β  1α    pu(1,4)*ch(1)       
 * 	 2α2β  1β    pu(2,4)*ch(1)
 * 
 * 6 4α1β  2α    pu(1,5)*ch(2)
 * 	 3α2β  1α1β  pu(2,5)*ch(1)*ch(1)
 *   2α3β  2β    pu(2,5)*ch(2)
 *   
 * 7 5α1β  3α    pu(1,6)*ch(3)
 *   4α2β  2α1β  pu(2,6)*ch(2)*ch(1)
 *   3α3β  1α2β  pu(3,6)*ch(1)*ch(2)
 *   2α4β  3β    pu(2,6)*ch(3)
 *  
 * 8 6α1β  4α    pu(1,7)*ch(4)
 *   5α2β  3α1β  pu(2,7)*ch(3)*ch(1)
 *   4α3β  2α2β  pu(3,7)*ch(2)*ch(2)
 *   3α4β  1α3β  pu(3,7)*ch(1)*ch(3)
 *   2α5β  4β    pu(2,7)*ch(4)
 *   
 * 9 7α1β  5α    pu(1,8)*ch(5)
 *   6α2β  4α1β  pu(2,8)*ch(4)*ch(1)
 *   5α3β  3α2β  pu(3,8)*ch(3)*ch(2)
 *   4α4β  2α3β  pu(4,8)*ch(2)*ch(3)
 *   3α5β  1α4β  pu(3,8)*ch(1)*ch(4)
 *   2α6β  5β    pu(2,8)*ch(5)
 *  
 * 10 
 *  
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		long L=0;//L is final answer
		int m=1;
		if(n%2==0)
		{
			L=pu(n/2-1,n-1)*ch(n/2-2)*ch(n/2-2);
		
			for(int i=1;i<=n/2-2;i++)
			{
				L+=(pu(i,n-1)+pu(i+1,n-1))*ch(n-3-i)*ch(i-1);
			}
		}
		else
		{
			for(int i=1;i<=(n-1)/2-1;i++)
			{
				L+=(pu(i,n-1)+pu(i+1,n-1))*ch(n-3-i)*ch(i-1);
			}
		}
	
		L=L%1000000007;
		
		System.out.println(L);
		//System.out.println(pu(2,5)*ch(1)*ch(1));
	}

	public static int pu(int b,int a)
	{
		int aa=1,bb=1,a_b=1;
		for(int i=a;i>0;i--)
		{
			aa*=i;
			
		}
		for(int i=b;i>0;i--)
		{
			bb*=i;
		}
		for(int i=a-b;i>0;i--)
		{
			a_b*=i;
		}
		
		return (aa/(bb*a_b));
	}
	public static int ch(int b)
	{
		return b+1;
	}
}
