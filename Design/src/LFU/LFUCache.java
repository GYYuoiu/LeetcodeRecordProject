package LFU;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    int minFreq, capacity;
    Map<Integer, Node> keyTable;
    Map<Integer, DoubleLinkedList> freqTable;

    LFUCache(int capacity){
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }
    public int get(int k){
        if(capacity == 0)  return -1;
        // 如果不存在，返回-1
        if(!keyTable.containsKey(k))  return -1;
        // 得到目标节点 curNode 及其出现频率 f
        Node curNode = keyTable.get(k);
        int f = curNode.freq;
        int val = curNode.value;
        // 得到curNode所在的双向链表 oldList
        DoubleLinkedList oldList = freqTable.get(f);
        // 将 curNode 从 oldList 中删除
        oldList.remove(curNode);
        // 如果oldList没有节点了，将其从freqTable中删除，并更新整个freqTable的最小频率minFreq
        if(oldList.size == 0){
            freqTable.remove(f);
            if(minFreq == f)  minFreq ++;
        }
        // 将 curNode 添加进新的双向链表 newList
        curNode = new Node(k, val, f + 1);
        keyTable.put(k, curNode);
        DoubleLinkedList newList = freqTable.getOrDefault(f + 1, new DoubleLinkedList());
        newList.addFirst(curNode);
        freqTable.put(f + 1, newList);
        // 返回curNode的值
        return curNode.value;
    }

    public void put(int k, int val){
        if(capacity == 0)  return;
        if(keyTable.containsKey(k)){
            Node curNode = keyTable.get(k);
            int f = curNode.freq;
            DoubleLinkedList oldList = freqTable.get(f);
            oldList.remove(curNode);
            if(oldList.size == 0){
                freqTable.remove(f);
                if(minFreq == f)  minFreq ++;
            }
            curNode = new Node(k, val, f + 1);
            keyTable.put(k, curNode);
            DoubleLinkedList newList = freqTable.getOrDefault(f + 1, new DoubleLinkedList());
            newList.addFirst(curNode);
            freqTable.put(f + 1, newList);
        }else{
            // 不存在 当前k表示的Node
            // 判断容量是否已满
            if(keyTable.size() == capacity){
                // 删除 最小频率链表的最旧节点
                DoubleLinkedList deleteList = freqTable.get(minFreq);
                Node deleteNode = deleteList.getTail();
                keyTable.remove(deleteNode.key);
                deleteList.remove(deleteNode);
                // 如果最小频率链表没值了，将其也删除
                if(deleteList.size == 0){
                    freqTable.remove(minFreq);
                }
            }
            Node curNode =  new Node(k, val, 1);
            keyTable.put(k, curNode);
            DoubleLinkedList curList = freqTable.getOrDefault(1, new DoubleLinkedList());
            curList.addFirst(curNode);
            freqTable.put(1, curList);
            minFreq = 1;
        }
    }
}
