class UnionFind {

    int[] arr;
    int[] size;


    public UnionFind(int n) {
        arr = new int[n+1];
        size = new int[n+1];
        for(int i = 0;i < n+1;i++) {
            arr[i] = i;
            size[i]+=1;
        }
    }

    public int Find(int n) {
        //int m = n;  Later used for path compression
        while(arr[n] != n) {
            n = arr[n];
        }
        //arr[m] = n;  For path compression.
        return n;
    }

    public void Union(int m, int n) {
        if(Find(m) == Find(n)){
            return;
        }
        int pid = Find(m);
        int qid = Find(n);
        if(size[pid] >= size[qid]) {
            size[pid] += size[qid];
            size[qid] = 0;
            arr[qid] = pid;
            return ;
        }
        size[qid]+=size[pid];
        size[pid] = 0;
        arr[pid] = qid;
        return;
    }

    public boolean connected(int m, int n) {
        return Find(m) == Find(n);
    }

    
}