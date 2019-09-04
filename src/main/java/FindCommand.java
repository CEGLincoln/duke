public class FindCommand extends Command{

    String str;

    //constructor
    public FindCommand(String s){
        str = s;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
        System.out.println("Here are the matching tasks in your list:");
        tasks.find(str);
    }
}