package org.practice.hashMaps;

import java.util.ArrayList;
import java.util.List;

public class Map <Key,Value>{

    private static class Node<Key,Value> {
        Key key;
        Value value;

        Node<Key,Value> next;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public List<Node<Key,Value>> bucket;

    private static final int INITIAL_BUCKET_SIZE = 2;

    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private int bucketSize;
    private double loadFactor;
    private int size;
    public Map(){
        this.bucketSize = INITIAL_BUCKET_SIZE;
        this.loadFactor = DEFAULT_LOAD_FACTOR;

        this.bucket = new ArrayList<>(bucketSize);

        for(int i = 0; i < bucketSize; i++){
            bucket.add(null);
        }
    }





    private int getHashIndex(Key key){
        return (key.hashCode()) % bucketSize;
    }
    public void insert(Key key, Value value){

        int index = getHashIndex(key);

        Node<Key,Value> root = bucket.get(index), temp = root;;

        while(temp != null){
            if(temp.key.equals(key)){
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        Node<Key,Value> curr = new Node<>(key,value);

        curr.next = root;

        bucket.set(index,curr);

        size++;

        rehashIfNeedBe();
    }

    private void rehashIfNeedBe() {
        double currentLF = ((double)this.size)/this.bucketSize;
        System.out.println(currentLF);
        if(currentLF > this.loadFactor){
            this.bucketSize *= 2;
            List<Node<Key,Value>> oldBucket = this.bucket;
            this.bucket = new ArrayList<>(this.bucketSize);
            for(int i = 0; i < this.bucketSize; i++){
                this.bucket.add(null);
            }

            this.size = 0;

            for(Node<Key,Value> head : oldBucket){
                while(head != null){
                    this.insert(head.key, head.value);
                    head = head.next;
                }
            }
        }
    }

    public Value get(Key key){

        int index = getHashIndex(key);

        Node<Key,Value> root = bucket.get(index), temp = root;

        while(temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public int size(){
        return this.size;
    }

    public boolean delete(Key key){

        int index = getHashIndex(key);

        Node<Key,Value> root = bucket.get(index), temp = root, prev = null;

        while(temp != null){

            if(prev != null && temp.key.equals(key)){
                prev.next = temp.next;
                return true;
            }
            else if(temp.key.equals(key)){
                bucket.set(index, temp.next);
                return true;
            }

            prev = temp;
            temp = temp.next;
        }

        size--;
        return false;

    }



//    public boolean delete(Key key){
//        int hc = key.hashCode();
//        int index = hc % bucketSize;
//
//        Node<Key,Value> root = bucket.get(index), temp = root;
//        if(root == null) return false;
//
//        if(root.key.equals(key)){
//            bucket.set(index,root.next);
//            size--;
//            return true;
//        }
//
//        while(temp.next != null){
//            if(temp.next.key.equals(key)){
//                temp.next = temp.next.next;
//                size--;
//                return true;
//            }
//            temp = temp.next;
//        }
//        return false;
//
//    }



//    public void insert(Key key, Value value){
//        int hc = key.hashCode();
//        int index = hc % bucketSize;
//
//        Node<Key,Value> root = bucket.get(index);
//
//        Node<Key,Value> curr = new Node<>(key,value) , temp = root;
//
//        if(root == null){
//            root = curr;
//            bucket.add(index,root);
//            size++;
//        }
//        else{
//            boolean isUpdated = false;
//            while(temp.next != null){
//                if(temp.key.equals(key)){
//                    temp.value = value;
//                    isUpdated = true;
//                }
//                temp = temp.next;
//            }
//            if(!isUpdated){
//                if(temp.key.equals(key)){
//                    temp.value = value;
//                    isUpdated = true;
//                }
//                else{
//                    temp.next = curr;
//                }
//                size++;
//            }
//        }
//
//
//    }

}
