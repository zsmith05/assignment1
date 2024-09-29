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
    /*public Item pop(){
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }*/

    public static void main(String[] args){
        ErrorStack<String> errorStack = new ErrorStack<>();

        try{
            File logentry = new File("log-data.csv");
            Scanner scanner = new Scanner(logentry);

            while(scanner.hasNextLine()){
                String log = scanner.nextLine();
                // Check if the log line contains "ERROR"
                if(log.contains("ERROR")){
                    errorStack.push(log);
                }
            }
            scanner.close();
        }

        catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
