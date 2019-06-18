import java.io.*;
class Heap {

  public static void Heapify(int[] arr,int index) {
    int m = 2*index+1;
    int n = 2*index+2;
    int smallest = index;

    if(m<arr.length && arr[m]<arr[smallest]) {
      smallest = m;
    }
    else{
      return;
    }

    if(n<arr.length && arr[n]<arr[smallest]) {
      smallest = n;
    }

    if(smallest!=index) {
      int temp = arr[smallest];
      arr[smallest] = arr[index];
      arr[index] = temp;
      if(smallest<arr.length){
        Heapify(arr,smallest);
      }
  }
  return;
}

  public static void Build_Heap(int[] arr,int n) {
    for(int i=n/2;i>=0;i--) {
      Heapify(arr,i);
    }
  }


  public static void main(String[] args) throws java.io.IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(buffer.readLine());
    int[] arr = new int[n];
    for(int i=0;i<n;i++) {
      arr[i] = Integer.parseInt(buffer.readLine());
    }
    Build_Heap(arr,n);
    for(int i=0;i<n;i++) {
      System.out.print(arr[i]+" ");
    }
  }
}
