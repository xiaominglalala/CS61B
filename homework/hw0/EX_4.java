public class EX_4 {
  public static void windowPosSum(int[] a, int n) {
    int len = a.length;
    for(int i = 0;i < len;i++)
      if (a[i] <= 0 )
        {
          continue;
        }
      else
        {
          for(int j = i+1;j <= i + n;j++)
          {
            if (j >= len)
             { 
               break;
             }
            else
            {
              a[i] += a[j];
            }
          }        
        }  
  }
  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}

/*
1.break是整个循环的终止，continue是循环当前轮次后面的跳过
2.不加大括号容易报错，至少在网页版本上是这样的
3.EX_4后面要有空格
*/