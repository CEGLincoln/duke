import java.io.Serializable;

public class Task implements Serializable{

    //WARNING: serialVersionUID
    protected String description;
    protected boolean isDone;

    //constructor
    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public String getDescription(){
        return this.description;
    }

    public String getStatusIcon(){
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }
}