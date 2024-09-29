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

    public boolean contains(String log, String keyword) {
        return log.contains(keyword);
    }

    public static void main(String[] args) throws FileNotFoundException {
        int error = 0;
        int warn = 0;
        int info = 0;
        int mem = 0;
        File logentry = new File("log-data.csv");
        LogEntry<String> logs = new LogEntry<String>();
        ErrorStack<String> errorStack = new ErrorStack<>();

        Scanner reader = new Scanner(logentry);
        while(reader.hasNextLine()){
            String log = reader.nextLine();
            logs.enqueue(log);

        }
        while(!logs.isEmpty()){
            String currentLog = logs.dequeue();
            if(logs.contains(currentLog, "ERROR")){
                errorStack.push(currentLog);
            }

            if (logs.contains(currentLog, "ERROR")) {
                error++;
            } else if (logs.contains(currentLog, "WARN")) {
                warn++;
            } else if (logs.contains(currentLog, "INFO")) {
                info++;
            }

            if((logs.contains(currentLog, "WARN")) && (logs.contains(currentLog, "Memory")) ){
                mem++;

            }

        }


        System.out.println("There were: " + error + " ERROR log level entries.");
        System.out.println("There were: " + warn + " WARN log level entries" );
        System.out.println("There were: " + info + " INFO log level entries");
        System.out.println("There were: " + mem + " WARN Memory log level entries");





    }



}
