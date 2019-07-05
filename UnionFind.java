class QuickFind {
	int n;
	int[] sets;

	public QuickFind(int n) {
		this.n = n;
		sets = new int[n];
		for(int i=0;i<n;i++){
			sets[i] = i;
		}
	}

	public boolean slowconnected(int p, int q){
		return sets[p] == sets[q];
	}

	public int quickfind(int p){
		return sets[p];
	}

	public void slowunion(int p,int q) {
		if(slowconnected(p,q)){
			return;
		}

		int pid = quickfind(p);
		int qid = quickfind(q);

		for(int i=0;i<n;i++){
			if(sets[i] == pid){
				sets[i] = qid;
			}
		}
	}

	public void print_set(){
		for(int i=0;i<this.n;i++){
			System.out.print(sets[i]+" ");
		}
	}

}

class QuickUnion {
	
	int[] id;
	int[] size;

	public QuickUnion(int n){
		id = new int[n];
		size = new int[n];
		for(int i=0;i<n;i++){
			id[i] = i;
			size[i] = 1;
		}
	}

	public boolean quickconnected(int p, int q){
		return slowfind(p) == slowfind(q);
	}

	public int slowfind(int p) {
		int i = p;
		while(id[i] != i){
			i = id[i];
		}
		return i;
	}

	public void quickunion(int p, int q) {
		if(quickconnected(p,q)){
			return;
		}

		if(size[p]<size[q]){
			int x = slowfind(p);
			id[x] = slowfind(q);
			size[q]+=size[p];
			size[p] = size[q];
		}
		else{
			int x = slowfind(q);
			id[x] = slowfind(p);
			size[p]+=size[q];
			size[q] = size[p];
		}
	}

	public void print_id() {
		for(int i=0;i<id.length;i++){
			System.out.print(id[i] + " ");
		}
	}


}

class UnionFind {

	public static void main(String[] args) {
		
		QuickUnion q = new QuickUnion(10);

		q.quickunion(4,3);
		q.quickunion(3,8);
		q.quickunion(6,5);
		q.quickunion(9,4);
		q.quickunion(2,1);
		q.quickunion(5,0);
		q.quickunion(7,2);
		q.quickunion(6,1);
		q.quickunion(7,3);
		//q.quickunion()
		q.print_id();
	}
}