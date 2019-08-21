import java.util.*;

public class Duke{
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
        //SHOW
        System.out.println(str);
        //UH OH
        while(stay){
            str = scanner.nextLine();
            switch(str){
                case "bye":
                    stay = false;
                    break;
                default:
                    System.out.println(str);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
        scanner.close();
    }
}