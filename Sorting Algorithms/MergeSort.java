class MergeSort {

	static void mergesort(int[] arr,int low,int high) {
		if(low>=high){
			return;
		}
		int mid = (low+high)/2;
		mergesort(arr,low,mid);
		mergesort(arr,mid+1,high);
		merge(arr,low,mid,high);
	}

	static void merge(int[] arr,int low,int mid,int high) {
		int[] left =  new int[mid-low+1];
		int[] right = new int[high-mid];
		//int[] sorted = new int[arr.length];
		for(int i=0;i<left.length;i++){
			left[i] = arr[low+i];
		}
		for(int j=0;j<right.length;j++){
			right[j] = arr[mid+1+j];
		}
		int i = 0;int j = 0;int k=low;
		while(i<left.length && j<right.length){
			if(left[i]<=right[j]){
				arr[k] = left[i];
				i++;
				k++;
			}
			else{
				arr[k] = right[j];
				j++;
				k++;
			}
		}

		while(i<left.length){
			arr[k] = left[i];
			k++;
			i++;
		}
		while(j<right.length){
			arr[k] = right[j];
			k++;
			j++;
		}

	}

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1,0};
		mergesort(arr,0,5);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}