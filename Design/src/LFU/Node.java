package LFU;

public class Node {
    int key, value, freq;
    Node next, prev;

    Node(){
        this(-1, -1, 0);
    }

    Node(int k, int v, int f){
        this.key = k;
        this.value = v;
        this.freq = f;
    }
}
