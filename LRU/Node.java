package LRU;

public class Node {
    int key;
    int value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}