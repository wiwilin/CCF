import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		boolean[] b=new boolean[n];
		for(int i=0;i<n;i++)
		{
			ArrayList<Integer> elist=new ArrayList<Integer>();
			ArrayList flist=new ArrayList();
			
			elist.add(System.in.read()-48);
			flist.add((char)System.in.read());
			elist.add(System.in.read()-48);
			flist.add((char)System.in.read());
			elist.add(System.in.read()-48);
			flist.add((char)System.in.read());
			elist.add(System.in.read()-48);
			System.in.read();
			
			while(elist.size()>1)
			{
				for(int j=0;j<flist.size();j++)
				{
					if((char)flist.get(j)=='*')
					{
						elist.set(j,elist.get(j)*elist.get(j+1));
						elist.remove(1+j);
						flist.remove(j);
					}
					if(j<flist.size()&&(char)flist.get(j)=='/')
					{
						elist.set(j,elist.get(j)/elist.get(j+1));
						elist.remove(1+j);
						flist.remove(j);
					}
				}
				for(int j=0;j<flist.size();j++)
				{
					if((char)flist.get(j)=='+')
					{
						elist.set(j,elist.get(j)+elist.get(j+1));
						elist.remove(1+j);
						flist.remove(j);
					}
					if(j<flist.size()&&(char)flist.get(j)=='-')
					{
						elist.set(j,elist.get(j)-elist.get(j+1));
						elist.remove(1+j);
						flist.remove(j);
					}
				}
			 }
				if(elist.get(0)==24)
					b[i]=true;
				else
					b[i]=false;
		}
		
			for(int i=0;i<n;i++)
			{
				if(b[i]==true)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
		}
}
		
	
	
