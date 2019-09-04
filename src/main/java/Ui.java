import java.util.Scanner;

public class Ui{

    private Scanner scanner;
    
    //constructor
    public Ui(){
        scanner = new Scanner(System.in);
    }

    public String readCommand(){
        return scanner.nextLine();
    }

    public void showError(String s){
        System.out.println(s);
    }

    public void showLine(){
        System.out.println("____________________________________________________________");
    }

    public void showLoadingError(){
        System.out.println("Loading Error");
    }

    public void showWelcome(){
        showLine();
        System.out.println("Hello! I'm Duke.");
        System.out.println("What can I do for you?");
        showLine();
    }
}