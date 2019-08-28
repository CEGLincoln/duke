import java.io.*;
import java.util.*;

public class Duke{

    private static String str = "This is the\n"
        + " ____        _        \n"
        + "|  _ \\ _   _| | _____ \n"
        + "| | | | | | | |/ / _ \\\n"
        + "| |_| | |_| |   <  __/\n"
        + "|____/ \\__,_|_|\\_\\___|\n\n"
        + "Hello! What can I do for you?";
    private static Scanner scanner = new Scanner(System.in);
    private static Boolean stay = true;
    private static ArrayList<Task> stuff = new ArrayList<Task>();
    private static Integer x = 0;

    public static void write(){
        try{
            FileOutputStream fos = new FileOutputStream("t.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(stuff);
            oos.close();
        }
        catch(Exception e){
            System.out.println("Oops! Write to file error.");
        }
    }

    public static void read(){
        try{
            FileInputStream fis = new FileInputStream("t.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            stuff = (ArrayList<Task>) ois.readObject();
            ois.close();
        }
        catch(Exception e){
            System.out.println("Oops! Read from file error.");
        }
    }

    public static void printStr(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        read();
        printStr(str);
        while(stay){
            printStr("______________________________");
            str = scanner.nextLine();
            printStr("______________________________");
            String[] part = str.split(" ", 2);
            switch(part[0]){
                case "help":
                    printStr("Here is the command list:");
                    printStr("help \t\t\t\t shows the command list");
                    printStr("echo <msg> \t\t\t echos the message");
                    printStr("bye \t\t\t\t terminates the program");
                    printStr("list \t\t\t\t shows the list");
                    printStr("done <id> \t\t\t mark as done");
                    printStr("todo <task> \t\t\t add a todo");
                    printStr("deadline <task> /by <time> \t add a deadline");
                    printStr("event <task> /at <time> \t add an event");
                    break;
                case "echo":
                    try{
                        printStr(part[1]);
                    }
                    catch(Exception e){
                        printStr("OOPS!!! The description of an echo cannot be empty.");
                    }
                    break;
                case "bye":
                    stay = false;
                    break;
                case "list":
                    printStr("Here are the tasks in your list:");
                    x = 0;
                    for(Task t : stuff){
                        x++;
                        printStr(x + "." + t.toString());
                    }
                    break;
                case "done":
                    try{
                        x = Integer.parseInt(part[1]) - 1;
                        stuff.get(x).markAsDone();
                        printStr("Nice! I've marked this task as done:");
                        printStr(stuff.get(x).toString());
                    }
                    catch(Exception e){
                        printStr("OOPS!!! The id of a done must be between 1 and " + (stuff.size()-1) + ".");
                    }
                    break;
                case "todo":
                    try{
                        Todo t = new Todo(part[1]);
                        stuff.add(t);
                        printStr("Got it. I've added this task:");
                        printStr(t.toString());
                        printStr("Now you have " + stuff.size() + " tasks in the list.");
                    }
                    catch(Exception e){
                        printStr("OOPS!!! The description of a todo cannot be empty.");
                    }
                    break;
                case "deadline":
                    try{
                        String[] art = part[1].split("/", 2);
                        String[] rt = art[1].split(" ", 2);
                        Deadline d = new Deadline(art[0], rt[1]);
                        stuff.add(d);
                        printStr("Got it. I've added this task:");
                        printStr(d.toString());
                        printStr("Now you have " + stuff.size() + " tasks in the list.");
                    }
                    catch(Exception e){
                        printStr("OOPS!!! The description of a deadline cannot be empty.");
                    }
                    break;
                case "event":
                    try{
                        String[] art = part[1].split("/", 2);
                        String[] rt = art[1].split(" ", 2);
                        Event e = new Event(art[0], rt[1]);
                        stuff.add(e);
                        printStr("Got it. I've added this task:");
                        printStr(e.toString());
                        printStr("Now you have " + stuff.size() + " tasks in the list.");
                    }
                    catch(Exception e){
                        printStr("OOPS!!! The description of an event cannot be empty.");
                    }
                    break;
                default:
                    printStr("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
        write();
        scanner.close();
        printStr("Bye. Hope to see you again soon!");
    }
}