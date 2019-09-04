import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage{

    private String filePath;
    
    //constructor
    public Storage(String fp){
        filePath = fp;
    }

    public void save(ArrayList<Task> tasks) throws DukeException{
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tasks);
            oos.close();
        }
        catch(Exception e){
            throw new DukeException(e.getMessage());
        }
    }

    public ArrayList<Task> load() throws DukeException{
        ArrayList<Task> tasks = new ArrayList<Task>();
        try{
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tasks = (ArrayList<Task>) ois.readObject(); // WARNING: unchecked cast
            ois.close();
        }
        catch(Exception e){
            throw new DukeException(e.getMessage());
        }
        return tasks;
    }
}