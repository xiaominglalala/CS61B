public class ArrayDeque<T>{
	private int size;
	private T[] items;
	private int nextFirst;//addfirst 第一个
	private int nextLast;//addlast 第一个

	public ArrayDeque(){
		items = (T[]) new Object[8];
		size = 0;
		nextFirst = 0;
		nextLast = 1;
	}

	public void resize(int cap){
		//resize后，从0位置开始
		// 所以first是cap-1（最后），last = size
		T[] a = (T[]) new Object[cap];
		int currentFirst = circuleLast(nextFirst);
		for (int i = 0; i < size; i++){
			a[i] = items[currentFirst];
			currentFirst = circuleLast(currentFirst);
		}
		items = a;
		nextFirst = cap - 1;
		nextLast = size;
	}

	public boolean wasteSize(){
		return size < (items.length / 4);
	}

	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		return false;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		for (int i = 0; i < size; i++){
			System.out.print(items[i] + " ");
		}
		System.out.println("\n");
	}
	/*find the new nextFirst*/
	public int circuleFirst(int oldFirst){
		/*len = 5,
		*old = 0 ,next = 4
		*old = 2, next = 1*/
		return (oldFirst - 1 + items.length) % items.length;
	}
	/*find the new nextLast*/
	public int circuleLast(int oldLast){
		/*len = 5,
		*old = 4 ,next = 0
		*old = 2, next = 3*/
		return (oldLast + 1 + items.length) % items.length;
	}

	public void sizeUp(){
		resize(size * 2);
    }
    /*item.length是所有空间大小*/
    public void sizeDown(){
    	resize(items.length / 2);
    }

	public void addFirst(T x){
		if(size == items.length){
			sizeUp();
		}
		items[nextFirst] = x;
		nextFirst = circuleFirst(nextFirst);
		size = size + 1;
	}

	public void addlast (T x){
		if (size == items.length){
			sizeUp();
		}
		items[nextLast] = x;
		nextLast = circuleLast(nextLast);
		size = size + 1;
	}

	public T removeFirst(){
		if (wasteSize()){
			sizeDown();
		}
		//要用nextfirst否则不更新
		nextFirst = circuleLast(nextFirst);
		T toRemove = items[nextFirst];
		items[nextFirst] = null;
		if (size != 0){
			size = size - 1;
		}

		return toRemove;
	}

	public T removeLast(){
		if (wasteSize()){
			sizeDown();
		}
		nextLast = circuleFirst(nextLast);
		T toRemove = items[nextLast];
		items[nextLast] = null;
		if (!isEmpty()){
			size = size - 1;
		}
		return toRemove;
	}
	/*用循环增强鲁棒性*/
	public T get(int index){
    	if(index >= size || index < 0){
    		return null;
		}
    	return items[index];
	}

	public ArrayDeque(ArrayDeque other){
		items = (T[]) new Object[other.size];
		nextFirst = other.nextFirst;
		nextLast = other.nextLast;
		size = other.size;
		System.arraycopy(other.items, 0, items, 0, other.size);
	}
	/*for test*/
	public static void main(String[] args) {
		ArrayDeque L = new ArrayDeque();
		L.addFirst("b");
		L.addFirst("a");
		L.addlast("c");
		L.addlast("d");
		L.removeFirst();
		L.removeLast();
		System.out.println(L.get(1));
		for (int i = 0; i < 10; i++){
			L.addlast(1);
		}
		for (int i = 0; i < 10; i++){
			L.removeFirst();
		}
	}
}
