public class LinkedListDeque<T> {
	public class IntNode{
		public IntNode prev;
		public T item;
		public IntNode next;

		public IntNode(IntNode p, T i, IntNode n){
			prev = p;
			item = i;
			next = n;
		}
	}
	/*The first item(if it exists)will be sentinel.next*/
	private IntNode sentinel;
	//private IntNode last;
	private int size;
	/*empty list*/
    public LinkedListDeque(){
    	sentinel = new IntNode(null, null, null);
    	IntNode p = sentinel;
    	p.prev = sentinel;
    	p.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x){
    	sentinel = new IntNode(null, null, null);
    	IntNode p = sentinel;
    	p.prev = sentinel;
    	p.next = sentinel;
		sentinel.next = new IntNode(sentinel, x, sentinel);
		sentinel.prev = sentinel.next;
		size = 1;
	}

	public void addFirst(T x){
		sentinel.next = new IntNode(sentinel, x, sentinel.next);
		sentinel.next.next.prev = sentinel.next;
		size += 1;
	}

	public void addLast(T x){
    	sentinel.prev = new IntNode(sentinel.prev, x, sentinel);
    	sentinel.prev.prev.next = sentinel.prev;
    	size += 1;
    }
	public T removeFirst(){
    	if (sentinel.next == sentinel){
    		return null;//TODO:改成null
		}
    	T ans = sentinel.next.item;
    	sentinel.next = sentinel.next.next;
    	sentinel.next.prev = sentinel;
    	return ans;
	}

	public T removeLast(){
		if (sentinel.next == sentinel){
			return null;
		}
		T ans = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		return ans;
	}

	public T get(int index){
    	if (index < 0 || index + 1 > size){
    		return null;
		}
    	int i = 0;
    	IntNode p = sentinel.next;
    	while (i < index){
    		p = p.next;
    		i = i + 1;
		}
    	return p.item;
	}

	public boolean isEmpty(){
		if (sentinel.prev == sentinel){
			return true;
		}
		return false;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		IntNode p = sentinel.next;
		while(p != sentinel){
			System.out.print(p.item + " ");//print不换行
			p = p.next;
		}
		System.out.println("\n");
	}

	public LinkedListDeque(LinkedListDeque other){
		sentinel = new IntNode(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		size = 0;
		for (int i = 0; i < other.size(); i++){
			addLast((T)other.get(i));
		}
	}
	/*for test*/
	/*
	public static void main(String[] args) {
        LinkedListDeque L = new  LinkedListDeque(5);
        L.addFirst(6);
        L.addLast(4);
		LinkedListDeque L1 = new  LinkedListDeque();
		boolean Y = L1.isEmpty();
		boolean Z = L.isEmpty();
		int s = L.size();
		L.printDeque();
	//	L.removeFirst();
	//	L.removeLast();
		int C = L.get(1);
    }*/
}
