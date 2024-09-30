import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ErrorStack<Item> {
    private Node first;
    private int n;


    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    //Pop function may not be necessary
    public Item pop(){
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public String toString() {
        if (isEmpty()) {
            return "No errors found.";
        }

        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null) {
            sb.append(current.item).append("\n");
            current = current.next;
        }

        return sb.toString();
    }


}
