public class Todo extends Task {

    //protected String time;

    public Todo(String description/*, String t*/) {
        super(description);
        //this.time = t;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}