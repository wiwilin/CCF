public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int R=scan.nextInt();
		int C=scan.nextInt();
		int map[][]=new int[R][C];
		int Ti=0,Tj=0,Si=0,Sj=0;

		
		for(int i=0;i<R;i++)
		{
			String str=scan.next();
			for(int j=0;j<C;j++)
			{
				char c=str.charAt(j);
			
				if(c=='T')
				{	 Ti=i;
					 Tj=j;
					 map[i][j]=15;
				}
				else if(c=='S')
				{	Si=i;
					Sj=j;
					map[i][j]=15;
				}
				if(c=='+')
					map[i][j]=15;
				else if(c=='|')
					map[i][j]=12;
				else if(c=='.')
					map[i][j]=4;
				else if(c=='-')
					map[i][j]=3;
				else if(c=='#')
					map[i][j]=0;
			}
		}
		map=Sto(map,Si,Sj,R,C);
		
		map=toT(map,Ti,Tj,R,C);
		

		
		if((map[Ti][Tj]&32)==0)
			System.out.println("I'm stuck!");
		else {
		int count=0;
		for(int i=0;i<R;i++)
		{
			
			for(int j=0;j<C;j++)
			{
				if(map[i][j]>=32&&map[i][j]<48)
					count++;
			}
			
		}
		System.out.print(count);
		}
		
	}
	
	public static int[][] Sto(int map[][],int i,int j,int R,int C) {
		if((map[i][j]&32)==32||map[i][j]==0)
			return map;
		else
			map[i][j]+=32;
		if(i>0&&(map[i][j]&8)==8)
			Sto(map,i-1,j,R,C);
		if(i<R-1&&(map[i][j]&4)==4)
			Sto(map,i+1,j,R,C);
		if(j>0&&(map[i][j]&2)==2)
			Sto(map,i,j-1,R,C);
		if(j<C-1&&(map[i][j]&1)==1)
			Sto(map,i,j+1,R,C);
		return map;
	}
	public static int[][] toT(int map[][],int i,int j,int R,int C) {
		if((map[i][j]&16)==16||map[i][j]==0)
			return map;
		else
			map[i][j]+=16;
		if(i<R-1&&(map[i+1][j]&8)==8)
			toT(map,i+1,j,R,C);
		if(i>0&&(map[i-1][j]&4)==4)
			toT(map,i-1,j,R,C);
		if(j<C-1&&(map[i][j+1]&2)==2)
			toT(map,i,j+1,R,C);
		if(j>0&&(map[i][j-1]&1)==1)
			toT(map,i,j-1,R,C);
		return map;
	}
}
