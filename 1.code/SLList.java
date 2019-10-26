public class SLList{
	public class IntNode{
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}

	//it should be private
	private IntNode first;
	private int size;
	//empty list
	public SLList(){
		first = null;
		size = 0;
	}
	//instantiation
	public SLList(int x){
		first = new IntNode (x, null);
		size = 1;
	}

	public void addFirst(int x){
		first = new IntNode (x, first);
		size += 1;
		//just like Intlist:L = new IntList (x, null);
	}

	public int getFirst(){

		return first.item;
	}

	public void addLast(int x){
		/* Your Code Here! */
		size += 1;
		IntNode p =first;
		if (p == null){
			p = new IntNode(x, null);
			return ;
		}
		if (p.next == null){
			p.next = new IntNode(x, null);
		}
		else{
			p = p.next;
		}

	}
	/** Returns the number of items in the list using recursion. */
	//private static  int size(IntNode p) {
		/* Your Code Here! */
	//	if (p.next == null){
	//		return 1;
	//	}
	//	else{
	//		return 1 + size(p.next);
	//	}
	//}
	/*	public int size(){
            return size(first);
        }*/
	public int size(){
		return size;
	}

	/**dis3 1.1*/
	public void insert(int item, int position){
		if(position == 0){
			addFirst(item);
		}
		else{
			IntNode p = first;
			for (int i = 0; i < position -1; i++){
			p = p.next;
			}
			//IntNode prev = p;
			IntNode save = p.next;
			p.next = new IntNode(item,save);
		}

	}
	/**dis3 1.2*/
	public void reverse() {
		 if (first == null || first.next == null) {
			 return;
			 }
		 IntNode save;
		 IntNode target;
		 target = first.next;
		 first.next = null;
		 while (target != null){
		 	save = target.next;
		 	target.next = first;
		 	first = target;
		 	target =save;
		 }
	}
	public void reverseRecur() {
		 first = reverseHelper(first);
		 }

		 private IntNode reverseHelper(IntNode lst) {
		 if (lst == null || lst.next == null) {
			 return lst;
			 } else {
			 IntNode endOfReversed = lst.next;
			 IntNode reversed = reverseHelper(lst.next);
			 endOfReversed.next = lst;
			 lst.next = null;
			 return reversed;
			 }
		 }
	public static void main(String[] args) {
		SLList L = new SLList(15);
		L.addFirst(10);
		L.addFirst(5);
		L.addFirst(30);
		L.insert(20, 2);
		//L.reverse();
		L.reverseRecur();
	}

}