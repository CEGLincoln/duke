import java.util.*;

public class Duke{
    public static void printStr(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        //DECLARE
        String str = "This is the\n"
            + " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n\n"
            + "Hello! What can I do for you?";
        Scanner scanner = new Scanner(System.in);
        Boolean stay = true;
        ArrayList<Task> stuff = new ArrayList<Task>();
        Integer x = 0;

        //START HERE
        printStr(str);
        while(stay){
            //INPUT
            printStr("______________________________");
            str = scanner.nextLine();
            printStr("______________________________");
            String[] part = str.split(" ", 2);
            //OUTPUT
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
                        printStr("OOPS!!! Something went wrong.");
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
                        printStr("OOPS!!! Something went wrong.");
                    }
                    break;
                case "todo":
                    try{
                        stuff.add(new Todo(part[1]));
                        printStr("Got it. I've added this task:");
                        printStr(stuff.get(stuff.size()-1).toString());
                        printStr("Now you have " + stuff.size() + " tasks in the list.");
                    }
                    catch(Exception e){
                        printStr("OOPS!!! Something went wrong.");
                    }
                    break;
                case "deadline":
                    try{
                        String[] art = part[1].split("/", 2);
                        String[] rt = art[1].split(" ", 2);
                        stuff.add(new Deadline(art[0], rt[1]));
                        printStr("Got it. I've added this task:");
                        printStr(stuff.get(stuff.size()-1).toString());
                        printStr("Now you have " + stuff.size() + " tasks in the list.");
                    }
                    catch(Exception e){
                        printStr("OOPS!!! Something went wrong.");
                    }
                    break;
                case "event":
                    try{
                        String[] art = part[1].split("/", 2);
                        String[] rt = art[1].split(" ", 2);
                        stuff.add(new Event(art[0], rt[1]));
                        printStr("Got it. I've added this task:");
                        printStr(stuff.get(stuff.size()-1).toString());
                        printStr("Now you have " + stuff.size() + " tasks in the list.");
                    }
                    catch(Exception e){
                        printStr("OOPS!!! Something went wrong.");
                    }
                    break;
                default:
                    printStr("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
        printStr("Bye. Hope to see you again soon!");
        scanner.close();
    }
}