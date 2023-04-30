package org.practice.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    private static class HeapNode<T>{
        T value;
        int priority;

        public HeapNode(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    ", priority=" + priority +
                    '}';
        }
    }

    private List<HeapNode<T>> heap;



    private int getParentIndex(int i){
        return (i - 1)/2;
    }

    private int getLeftChildIndex(int i){
        return ((2*i) + 1);
    }

    private int getRightChildIndex(int i){
        return ((2*i) + 2);
    }

    private int getIndexOfLastElement(){
        return this.size() - 1;
    }

    private int getPriority(int index){
        return this.heap.get(index).priority;
    }
    private void  swap(int index1, int index2){
        HeapNode<T> temp = this.heap.get(index2);
        this.heap.set(index2,this.heap.get(index1));
        this.heap.set(index1,temp);
    }

    public void add(T value,int priority){
        this.heap.add(new HeapNode<>(value,priority));

        int iCurr = this.getIndexOfLastElement();

        while(iCurr > 0){
            int iParent = this.getParentIndex(iCurr);

            if( this.getPriority(iParent) > this.getPriority(iCurr)){
                this.swap(iCurr,iParent);
                iCurr = iParent;
            }
            else{
                break;
            }
        }

    }

    public T removeMin(){
        T minValue = this.getMin();

        this.swap(this.getIndexOfLastElement(),0);

        this.heap.remove(getIndexOfLastElement());

        int iCurr = 0;

        while(true){
            int left = this.getLeftChildIndex(iCurr);
            int right = this.getRightChildIndex(iCurr);

            if(left >= this.size() && right >= this.size()){
                break;
            }

            int lowestIndex;

            if(right >= this.size()){
                lowestIndex = left;
            }
            else if(this.getPriority(left) < this.getPriority(right)){
                lowestIndex = left;
            }
            else {
                lowestIndex = right;
            }

            if(this.getPriority(lowestIndex) >= this.getPriority(iCurr)){
                break;
            }
            else{
                this.swap(lowestIndex,iCurr);
                iCurr = lowestIndex;
            }
        }

        return minValue;
    }



    public T getMin(){
        if(this.isEmpty()) return null;
        return this.heap.get(0).value;
    }

    public int size(){
        return this.heap.size();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public void print(){
        System.out.println(this.heap);
    }
}
