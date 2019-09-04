public class DoneCommand extends Command{

    int x;

    //constructor
    public DoneCommand(int i){
        x = i;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
        if(x<0 || x>=tasks.size()){
            System.out.println("NO");
        }
        else {
            tasks.markAsDone(x);
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tasks.get(x).toString());
        }
    }
}