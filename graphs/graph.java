import java.util.*;
class matrix {

    int[][] arr;

    matrix(int n) {
       arr = new int[n][n];
    }
    void connection(int src,int dest) {
        arr[src][dest] = 1;
    }
    void display(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.println();
    }
}

class list {
    
    LinkedList<Integer> arr[];

    list(int n) {
        arr = new LinkedList[n];
        for(int i=0;i<n;i++) {
            arr[i] = new LinkedList<Integer>();
        }
    }

    void connection(int src,int dest) {
        arr[src].add(dest);
    }

    void display(int v) {
        for(int i=0;i<v;i++) {
            System.out.print(i+" ");
            for(Integer p : arr[i]) {
                System.out.print(p+" ");
            }
            System.out.println();
        }
    }

    void bfs(int n,int s) {
        int[] visited = new int[n];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = 1;
        queue.add(s);

        while(queue.size() > 0) {
            int node = queue.poll();
            System.out.print(node+" ");

            for(Integer p : arr[node]) {
                if(visited[p]==0) {
                    queue.add(p);
                    visited[p] = 1;
                }
            }
        }
    }

    void dfs_visit(int n) {
        int[] visited = new int[n];
        for(int i=0;i<n;i++) {
            if(visited[i] == 0){
                System.out.print(i+" ");
                visited[i] = 1;
                dfs(i,visited);
            }
        }
    }

    void dfs(int s,int[] visited) {
        for(Integer p : arr[s]) {
            if(visited[p] == 0) {
                visited[p] = 1;
                System.out.print(p+" ");
                dfs(p,visited);
            }
        }
    }

}

class graph {

    public static void main(String[] args) {
        int n = 5;

        list m = new list(n);

        m.connection(0,1);
        m.connection(1,0);
        m.connection(0,2);
        m.connection(2,0);
        m.connection(1,3);
        m.connection(3,1);
        m.connection(1,4);
        m.connection(4,1);

        m.dfs_visit(n);
    }
}