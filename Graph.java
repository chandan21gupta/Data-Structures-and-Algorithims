import java.util.*;


class Graph {

  int V;
  Node[] arr;

  Graph(int V){
    this.V = V;
    arr = new Node[this.V];

    for(int i=0;i<this.V;i++){
      arr[i] = new Node(i);
    }
  }


  public void edgeMaker(int src,int dest){
    Node n = arr[src];
    while(n.next!=null){
      n=n.next;
    }
    n.next = new Node(dest);
  }

  public void printGraph(){
    for(int i=0;i<this.V;i++){
      System.out.print(arr[i].data+" ");
      Node n = arr[i].next;
      while(n!=null){
        System.out.print(n.data+" ");
        n=n.next;
      }
      System.out.println();
    }
  }

  class Node{
    int data;
    int color;
    Node next;
    Node(int data){
      this.data = data;
      color = 0;
    }
  }




  public static void main(String[] args){
    int V = 5;
    Graph graph = new Graph(V);
    graph.edgeMaker(0,1);
    graph.edgeMaker(1,0);
    graph.edgeMaker(0,4);
    graph.edgeMaker(4,0);
    graph.edgeMaker(1,2);
    graph.edgeMaker(2,1);
    graph.edgeMaker(1,3);
    graph.edgeMaker(3,1);
    graph.edgeMaker(1,4);
    graph.edgeMaker(4,1);
    graph.edgeMaker(2,3);
    graph.edgeMaker(3,2);
    graph.edgeMaker(3,4);
    graph.edgeMaker(4,3);
    graph.printGraph();
  }
}
