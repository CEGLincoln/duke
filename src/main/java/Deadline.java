import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{

    //WARNING: serialVersionUID
    protected LocalDateTime ldt;
    protected DateTimeFormatter formatter;

    //constructor
    public Deadline(String description, String t) throws DukeException{
        super(description);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try{
            ldt = LocalDateTime.parse(t,formatter);
        }
        catch(Exception e){
            System.out.println("WRONG FORMAT: yyyy-MM-dd HH:mm");
            throw new DukeException(e.getMessage());
        }
    }

    @Override
    public String toString(){
        String fdt = ldt.format(formatter);
        return "[D]" + super.toString() + " (by: " + fdt + ")";
    }
}