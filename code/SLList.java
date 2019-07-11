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
	public static void main(String[] args) {
		/*SLList L = new SLList(15);
		L.addFirst(10);
		L.addFirst(5);
		int x = L.getFirst();
		System.out.println(x);*/
		//empty list
		SLList x =new SLList();
		x.addLast(5);
		System.out.println(x.size());
	}


}