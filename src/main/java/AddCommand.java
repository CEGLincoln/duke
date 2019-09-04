public class AddCommand extends Command{

    private Task tsk;

    //constructor
    public AddCommand(Task t){
        tsk = t;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.add(tsk);
        System.out.println("Got it. I've added this task:");
        System.out.println(tsk.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}