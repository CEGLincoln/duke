import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    private static final long serialVersionUID = 1L;
    protected LocalDateTime ldt;

    public Deadline(String description, String t) throws DukeException{
        super(description);
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

        return "[D]" + super.toString() + " (by: " + fdt + ")";
    }
}