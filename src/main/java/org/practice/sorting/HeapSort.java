package org.practice.sorting;



public class HeapSort {

    private static HeapSort heapSort;

    private HeapSort(){

    }
    private static HeapSort getInstance(){
        if(heapSort == null){
            return new HeapSort();
        }
        else{
            return heapSort;
        }
    }
    public static void sort(int[] arr){
        getInstance().sort1(arr);
    }

    public void sort1(int[] arr){
        int n = arr.length - 1;
        for(int i = n/2; i >=0; i--){
            downHeapify(arr,i,n);
        }

        for(int i = n; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            downHeapify(arr,0,i-1);
        }

    }

    private void downHeapify(int[] arr, int parent, int lastIndex){

        while(true){
            int left = (parent *2) + 1;
            int right = left +1;

            if(left > lastIndex) break;

            int maxIndex;

            if(right > lastIndex || arr[left] > arr[right]){
                maxIndex = left;
            }
            else {
                maxIndex = right;
            }

            if(arr[maxIndex] > arr[parent]){
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[parent];
                arr[parent] = temp;
                parent = maxIndex;
            }

            else {
                break;
            }

        }
    }
}
