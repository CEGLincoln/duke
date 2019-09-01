import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage{

    private ArrayList<Task> stuff;
    
    public Storage(){
        stuff = new ArrayList<Task>();
    }

    public static void write(ArrayList<Task> alt){
        try{
            FileOutputStream fos = new FileOutputStream("duke.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(alt);
            oos.close();
        }
        catch(Exception e){
            System.out.println("Oops! Write to file error.");
        }
    }

    public ArrayList<Task> read(){
        try{
            FileInputStream fis = new FileInputStream("duke.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            stuff = (ArrayList<Task>) ois.readObject(); // WARNING: unchecked cast
            ois.close();
        }
        catch(Exception e){
            //Technically don't even need this
            write(stuff);
        }
        return stuff;
    }
}