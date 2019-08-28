import java.time.*;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    //protected String time;
    protected LocalDateTime ldt;

    public Event(String description, String t) throws DukeException{
        super(description);
        //this.time = t;
        try{
            ldt = LocalDateTime.parse(t);
        }
        catch(Exception e){
            System.out.println("WRONG FORMAT. YYYY-MM-DDTHH:MM:SS");
            throw new DukeException("CRY");
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fdt = ldt.format(formatter);
        
        return "[E]" + super.toString() + " (at: " + fdt + ")";
    }
}