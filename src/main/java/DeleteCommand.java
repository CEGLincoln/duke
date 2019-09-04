public class DeleteCommand extends Command{

    int x;

    //constructor
    public DeleteCommand(int i){
        x = i;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
        if(x<0 || x>=tasks.size()){
            System.out.println("NO");
        }
        else {
            System.out.println("Noted. I've removed this task:");
            System.out.println(tasks.get(x).toString());
            tasks.remove(x);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }
}