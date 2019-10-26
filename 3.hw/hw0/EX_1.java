public class EX_1
{
	public static void drawTriangle(int N){
		int i = 0;
		String star = "*";
		for (i = 1;i <= N;i++){
			System.out.println(star);
			star = star + "*";
		}
	}
	public static void main(String[] args)
	{
		//1a
		/*int i = 0;
		String star = "*";
		for(i = 1;i < 6;i++)
		{
			System.out.println(star);
			star = star + "*";
		}*/

		//1b
		drawTriangle(10);
	}
}