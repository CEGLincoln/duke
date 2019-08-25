public class Deadline extends Task {

    protected String time;

    public Deadline(String description, String t) {
        super(description);
        this.time = t;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + time + ")";
    }
}