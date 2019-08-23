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
        int x = 0;

        //START HERE
        printStr(str);
        while(stay){
            str = scanner.nextLine();
            String[] part = str.split(" ", 2);
            switch(part[0]){
                case "bye":
                    stay = false;
                    break;
                case "done":
                    x = Integer.parseInt(part[1]) - 1;
                    stuff.get(x).markAsDone();
                    printStr("Nice! I've marked this task as done:");
                    printStr("[" + stuff.get(x).getStatusIcon() + "] " + stuff.get(x).getDescription());
                    break;
                case "list":
                    printStr("Here are the tasks in your list:");
                    x = 0;
                    for(Task t : stuff){
                        x++;
                        printStr(x + ".[" + t.getStatusIcon() + "] " + t.getDescription());
                    }
                    break;
                default:
                    stuff.add(new Task(str));
                    printStr("added: " + str);
            }
        }
        printStr("Bye. Hope to see you again soon!");
        scanner.close();
    }
}