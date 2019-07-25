import java.util.*;
class Edge {
    int dest;
    int weight;

    Edge(int dest,int weight) {
        //this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    LinkedList<Edge> arr[];
    int V;

    Graph(int V) {
        arr = new LinkedList[V];
        this.V = V;
        for(int i=0;i<V;i++) {
            arr[i] = new LinkedList<>();
        }
    }

    void addedge(int src,int dest,int weight) {
        Edge edge = new Edge(dest,weight);
        arr[src].add(edge);
    }

    void display() {
        for(int i=0;i<this.V;i++) {
            System.out.print(i+" ");
            for(Edge e : arr[i]) {
                System.out.print(e.dest+"->"+e.weight+" ");
            }
            System.out.println();
        }
    }

    int[] bellman_ford() {
        int count = 0;
        int[] distances = new int[V];
        distances[0] = 0;
        for(int i=1;i<V;i++) {
            distances[i] = Integer.MAX_VALUE-100;
        }

        int flag = 2;
        while(flag == 2) {
            flag = 1;
            count++;
            for(int i=0;i<V;i++) {
                for(Edge e : arr[i]) {
                    //System.out.print(i+"->"+distances[i]+" ");
                    int d = distances[i] + e.weight;
                    //System.out.println(e.weight+" "+d);
                    if(distances[e.dest]>d) {
                        distances[e.dest] = d;
                        flag = 2;
                    }
                }
            }
            
        }
        // for(int i=0;i<V;i++) {
        //     System.out.print(distances[i]+" ");
        // }
        System.out.println(count); //Number of iterations
        
        return distances;
    }

    int[] dijkstra(int s) {
        int[] distances = new int[V];
        int[] visited = new int[V];
        for(int i=0;i<V;i++) {
            if(i != s) {
                distances[i] = Integer.MAX_VALUE-1000;
            }
        }
        int min_index = s;
        while(min_index != -1){
            visited[min_index] = 1;
            for(Edge e : arr[min_index]) {
                int d = distances[min_index] + e.weight;
                if(d<distances[e.dest]) {
                    distances[e.dest] = d;
                } 
            }
            min_index = minimim_weight(visited,distances);
        }
        return distances;
    }


    int minimim_weight(int[] visited,int[] distances) {
        int min_index = -1;
        int[] temp = new int[distances.length];
        for(int i=0;i<distances.length;i++) {
            temp[i] = distances[i];
        }
        for(int i=0;i<distances.length;i++) {
            if(visited[i] != 1) {
                for(int j=0;j<distances.length;j++) {
                    if(distances[j] == temp[i]) {
                        return j;
                    }
                }
            }
        }
        return min_index;
    }



}
class weightedgraph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addedge(0, 1, 3);
        g.addedge(1, 0, 3);
        g.addedge(0, 3, 1);
        g.addedge(3, 0, 1);
        g.addedge(1, 2, 1);
        g.addedge(2, 1, 1);
        g.addedge(1, 3, 7);
        g.addedge(3, 1, 7);
        g.addedge(1, 4, 5);
        g.addedge(4, 1, 5);
        g.addedge(2, 4, 7);
        g.addedge(4, 2, 7);
        g.addedge(3, 4, 2);
        g.addedge(4, 3, 2);
        //g.display();
        int[] arr = g.dijkstra(3);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}