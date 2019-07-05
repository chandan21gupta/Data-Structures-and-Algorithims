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

	public boolean connected(int p, int q){
		return sets[p] == sets[q];
	}

	public int find(int p){
		return sets[p];
	}

	public void union(int p,int q) {
		if(connected(p,q)){
			return;
		}

		int pid = sets[p];
		int qid = sets[q];

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


class UnionFind {

	public static void main(String[] args) {
		QuickFind q = new QuickFind(10);
		q.union(4,3);
		q.union(3,8);
		q.union(6,5);
		q.union(9,4);
		q.union(2,1);
		//q/connected(8,9);
		//q.connected(5,0);
		q.union(5,0);
		q.union(7,2);
		q.union(6,1);

		q.print_set();


	}
}