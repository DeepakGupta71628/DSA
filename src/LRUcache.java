import java.util.HashMap;
import java.util.Map;

public class LRUcache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;


        Node(int key,int value){
            this.key=key;
            this.value=value;
        }

    }



    Map<Integer,Node> hashMap;
    Node tail =new Node(0,0);
    Node head=new Node(0,0);
    int capacity=0;

    LRUcache(int capacity){
        this.capacity=capacity;
    }

    LRUcache(){
        hashMap=new HashMap<Integer,Node>();
        tail.next=head;
        head.prev=tail;
    }

    public Integer get(int key){
        if(!hashMap.containsKey(key)) return -1;

        Node node =hashMap.get(key);
        remove(node);
        addToTail(node);

        return node.value;
    }

    public void put(int key, int value){
        if(hashMap.containsKey(key)){
            Node node=hashMap.get(key);
            node.value=value;
            remove(node);
            addToTail(node);
            return;
        }

        Node node=new Node(key,value);
        addToTail(node);
        capacity++;
        if(hashMap.size()>capacity){
            remove(head.next);
            capacity--;
            hashMap.remove(node.key);
        }
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToTail(Node node){
        tail.prev.next=node;
        node.next=tail;
        node.prev=tail.prev;
        tail.prev=node;

    }


}
