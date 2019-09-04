public class ExitCommand extends Command{

    //constructor
    public ExitCommand(){
        //NANI
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
        System.out.println("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit(){
        return true;
    }
}