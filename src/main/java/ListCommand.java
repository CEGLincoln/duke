public class ListCommand extends Command{

    //constructor
    public ListCommand(){
        //NANI
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
        System.out.println("Here are the tasks in your list:");
        tasks.list();
    }
}