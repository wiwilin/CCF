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
				if(L>1000000007)
					L=L%1000000007;
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
				if(L>1000000007)
					L=L%1000000007;
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
