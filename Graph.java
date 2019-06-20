import java.util.*;


class Graph {

  int V;
  LinkedList<Integer> arr[];


  Graph(int V) {
    this.V = V;
    arr = new LinkedList[V];

    for(int i=0;i<V;i++){
      arr[i] = new LinkedList<>();
    }
  }

  public void edgeMaker(int src,int dest){
    arr[src].add(dest);
    //arr[dest].add(src); For undirected graphs
  }

  public void printGraph(){
    for(int i=0;i<V;i++){
      System.out.print(i+" ");
      for(Integer Node : arr[i]){
        System.out.print(Node+" ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args){
    int V = 5;
    Graph graph = new Graph(V);
    graph.edgeMaker(0,1);
    graph.edgeMaker(0,4);
    graph.edgeMaker(1,2);
    graph.edgeMaker(1,3);
    graph.edgeMaker(1,4);
    graph.edgeMaker(2,3);
    graph.edgeMaker(3,4);
    graph.printGraph();
  }
}
