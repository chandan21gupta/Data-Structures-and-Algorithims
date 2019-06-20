import java.util.*;


class Graph {

  int V;
  Node[] arr;

  class Node{
    int data;
    int color;
    Node next;
    Node(int data){
      this.data = data;
      color = 0;
    }
  }


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


  public void BFS(int s){
    Queue<Node> q = new LinkedList<>();
    q.add(arr[s]);
    arr[s].color = 1;
    while(q.size()>0){
      Node n = q.remove();
      System.out.print(n.data+" ");
      Node temp = n.next;
      while(temp!=null){
        if(arr[temp.data].color == 0){
          arr[temp.data].color = 1;
          q.add(arr[temp.data]);
        }
        temp = temp.next;
      }
    }

  }


  public void DFS(int v){
    dfs(arr[v]);
  }


  public void dfs(Node s){
    System.out.print(s.data+" ");
    arr[s.data].color = 1;
    Node n = s.next;
    while(n!=null){
      if(arr[n.data].color == 0){
        arr[n.data].color = 1;
        dfs(arr[n.data]);
      }
      n=n.next;
    }
  }


  public static void main(String[] args){
    int V = 4;
    Graph graph = new Graph(V);
    graph.edgeMaker(0,1);
    graph.edgeMaker(0,2);
    graph.edgeMaker(1,2);
    graph.edgeMaker(2,0);
    graph.edgeMaker(2,3);
    graph.edgeMaker(3,3);
    //graph.printGraph();
    graph.DFS(2);
  }
}
