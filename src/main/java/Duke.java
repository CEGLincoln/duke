/**
 * @file: Duke.java
 * @author: Lim Li Lincoln
 * 
 * https://nuscs2113-ay1920s1.github.io/website/schedule/week4/project.html
 */
public class Duke{

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * The constructor method for Duke.
     *
     * @param[in] filePath The desired file path to store data.
     */
    public Duke(String filePath){
        ui = new Ui();
        storage = new Storage(filePath);
        try{
            tasks = new TaskList(storage.load());
        }
        catch (DukeException e){
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Run
     *
     * @return Returns void.
     */
    public void run(){
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit){
            try{
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            }
            catch (DukeException e){
                ui.showError(e.getMessage());
            }
            finally{
                ui.showLine();
            }
        }
        try{
            storage.save(tasks.array());
        }
        catch(DukeException e){
            ui.showError("CANNOT SAVE! " + e.getMessage());
        }
    }

    //========== MAIN PROGRAM ==========
    public static void main(String[] args){
        new Duke("tasks.txt").run();
    }
}