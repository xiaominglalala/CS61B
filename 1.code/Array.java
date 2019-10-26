/**dis3 2*/
public class Array {
    public static int[] insert(int[]array, int item, int position){
        int[] a = new int[array.length + 1];
        position = Math.min(position, array.length);//增强鲁棒性
        System.arraycopy(array, 0, a, 0, position );
        a[position] = item;
        System.arraycopy(array, position, a, position + 1, array.length - position -1);
        return a;
    }

    public static void reverse(int[] arr){
        int length = arr.length;
        int half_len =length/2;//5/2=2,4/2=2
        int temp;
        for(int i = 0;i < half_len;i++){
            temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = temp;
        }
    }

    /*public static  int[] replicate(int[] arr){
        int length = 0;
        for (int i : arr.length){
            length += Integer.parseInt(arr[i]);
        }
        for (int i :arr.length)
    }*/

    public static int[] replicate(int[] arr) {
         int total = 0;
         for (int item : arr) {
             total += item;
             }
         int[] result = new int[total];
         int i = 0;
         for (int item : arr) {
             for (int counter = 0; counter < item; counter++) {
                 result[i] = item;
                 i++;
                 }
             }
         return result;
         }
    public static void main(String[] args) {
        int[] array ={1,2,3,4,5};
     //   insert(array, 6, 5);
    //   reverse(array);
        replicate(array);
    }
}
