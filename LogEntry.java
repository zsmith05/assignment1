import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;


public class LogEntry<item> {

    private Node first, last;

    private class Node {
        String item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void enqueue(String item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
    }
    public String dequeue()
    {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null) {
            sb.append(current.item).append(" ");
            System.out.println();
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        File logentry = new File("log-data.csv");
        LogEntry<String> logs = new LogEntry<String>();

        Scanner reader = new Scanner(logentry);
        while(reader.hasNextLine()){
            String log = reader.nextLine();
            logs.enqueue(log);


        }

        while(!logs.isEmpty()){
            logs.dequeue();
            if()
        }

        System.out.println(logs);

    }



}
