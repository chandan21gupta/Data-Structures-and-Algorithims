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
}
class weightedgraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addedge(0, 1, 10);
        g.addedge(2, 1, 1);
        g.addedge(3, 2, -2);
        g.addedge(4, 3, -1);
        g.addedge(5, 4, 1);
        g.addedge(0, 5, 8);
        g.addedge(1, 3, 2);
        g.addedge(4, 1, -4);

        //g.display();
        int[] arr = g.bellman_ford();
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}