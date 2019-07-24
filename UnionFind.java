import java.io.*;
// class QuickFind {
// 	int n;
// 	int[] sets;

// 	public QuickFind(int n) {
// 		this.n = n;
// 		sets = new int[n];
// 		for(int i=0;i<n;i++){
// 			sets[i] = i;
// 		}
// 	}

// 	public boolean slowconnected(int p, int q){
// 		return sets[p] == sets[q];
// 	}

// 	public int quickfind(int p){
// 		return sets[p];
// 	}

// 	public void slowunion(int p,int q) {
// 		if(slowconnected(p,q)){
// 			return;
// 		}

// 		int pid = quickfind(p);
// 		int qid = quickfind(q);

// 		for(int i=0;i<n;i++){
// 			if(sets[i] == pid){
// 				sets[i] = qid;
// 			}
// 		}
// 	}

// 	public void print_set(){
// 		for(int i=0;i<this.n;i++){
// 			System.out.print(sets[i]+" ");
// 		}
// 	}

// }



class UnionFind {
	
	int[] id;
	int[] size;

	public UnionFind(int n){
		id = new int[n+1];
		size = new int[n+1];
		for(int i=1;i<n+1;i++){
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
		for(int i=1;i<id.length;i++){
			System.out.print(id[i] + " ");
		}
	}




	public static void main(String[] args) throws java.io.IOException {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
		UnionFind q = new UnionFind(n);
		int q1 = Integer.parseInt(buffer.readLine());
		for(int i=0;i<q1;i++){
			String s1 = buffer.readLine();
			String[] s = s1.split(" ");
			if(s[0].equals("1")){
				q.quickunion(Integer.parseInt(s[1]),Integer.parseInt(s[2]));
			}
			else{
				if(q.quickconnected(Integer.parseInt(s[1]),Integer.parseInt(s[2]))){
					System.out.println("YES");
				}
				else{
					System.out.println("NO");
				}
			}
		}
	}
}