public class Event extends Task {

    protected String time;

    public Event(String description, String t) {
        super(description);
        this.time = t;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + time + ")";
    }
}