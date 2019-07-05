public class IntList{
	public int first;
	public IntList rest;

	public IntList(int f, IntList r){
		first = f;
		rest = r;
	}
	public int size(){
		if (rest == null){
			return 1;
		}
		else{
			return 1 + this.rest.size();
		}	
	}
	public int iterativeSize(){
	/*	int num = 1;
		while (this.rest != null){
			num ++;
			this = this.rest;
		}*/
		//but why?
		IntList p = this;
		int num = 0;
		while (p != null){
			p = p.rest;
			num ++;
		}
		return num;
	}
	public int get(int i){
		/*int j = 0;
		IntList p = this;
		while(j != i){
			p = p.rest;
			j++;
		}
		return p.first;*/
		//recursion is better
		if (i == 0){
			return first;
		}
		else{
			return rest.get(i - 1);
		}
	}

	public static void main(String[] args) {
		//they all need new
		IntList L = new IntList(5, null);
		L.rest = new IntList(10, null);
		L.rest.rest = new IntList(15,null);

		System.out.println(L.size());
		System.out.println(L.iterativeSize());
		System.out.println(L.get(1));
	}
		
}