public class EX_2 {
   public static int max(int[] m) {
       int len = m.length;
       int max_m = m[0];
       for (int i = 0; i < len; i++)
       {
          if (m[i] > max_m)
             max_m = m[i];
       }
      System.out.println(max_m);
       return 0;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6}; 
      max(numbers);
   }
}