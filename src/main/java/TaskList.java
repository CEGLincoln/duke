import java.util.ArrayList;

public class TaskList{

    private ArrayList<Task> tasks;
    private int x;

    //constructor1
    public TaskList(ArrayList<Task> alt){
        tasks = alt;
    }

    //constructor2
    public TaskList(){
        tasks = new ArrayList<Task>();
    }

    public void add(Task t){
        tasks.add(t);
    }

    public ArrayList<Task> array(){
        return tasks;
    }

    public void find(String s){
        x = 0;
        for(Task t : tasks){
            if(t.toString().contains(s)){
                x++;
                System.out.println(x + "." + t.toString());
            }
        }
    }

    public Task get(int x){
        return tasks.get(x);
    }

    public void list(){
        x = 0;
        for(Task t : tasks){
            x++;
            System.out.println(x + "." + t.toString());
        }
    }

    public void markAsDone(int x){
        tasks.get(x).markAsDone();
    }

    public void remove(int x){
        tasks.remove(x);
    }

    public int size(){
        return tasks.size();
    }
}