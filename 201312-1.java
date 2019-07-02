/*
问题描述
　　给定n个正整数，找出它们中出现次数最多的数。如果这样的数有多个，请输出其中最小的一个。
输入格式
　　输入的第一行只有一个正整数n(1 ≤ n ≤ 1000)，表示数字的个数。
　　输入的第二行有n个整数s1, s2, …, sn (1 ≤ si ≤ 10000, 1 ≤ i ≤ n)。相邻的数用空格分隔。
输出格式
　　输出这n个次数中出现次数最多的数。如果这样的数有多个，输出其中最小的一个。
样例输入
6
10 1 10 20 30 20
样例输出
10
*/
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int a[]=new int[10000];
		int m;
		for(int i=0;i<10000;i++)
		{
			a[i]=0;
		}
		for(int i=1;i<=n;i++)
		{
			m=scan.nextInt();
			a[m]++;
		}
		int max=0,out=0;
	
		for(int i=9999;i>=0;i--)
		{
			if(a[i]>=max)
				{
					max=a[i];
					out=i;
				}
		}
		System.out.print(out);
	
	}
}
