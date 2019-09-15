public class Parser{

    //constructor
    public Parser(){
        //NANI
    }

    /**
     * A huge switch case based on fullCommand
     *
     * @param[in] fullCommand The command from user in all of its glory.
     * @return Returns a command class based on the input.
     */
    public static Command parse(String fullCommand) throws DukeException{
        String[] part = fullCommand.split(" ", 2);
        switch(part[0]){
            case "help":
                System.out.println("YES");
                break;
            case "echo":
                if(part.length == 2){
                    System.out.println(part[1]);
                }
                else{
                    System.out.println("Something went wrong.");
                }
                break;
            case "bye":
                return new ExitCommand();
                //break;
            case "list":
                return new ListCommand();
                //break;
            case "done":
                if(part.length == 2){
                    try{
                        return new DoneCommand(Integer.parseInt(part[1]) - 1);
                    }
                    catch(Exception e){
                        //do nothing, error will be printed
                    }
                }
                throw new DukeException("NO");
            case "todo":
                if(part.length == 2){
                    return new AddCommand(new Todo(part[1]));
                }
                throw new DukeException("NO");
            case "deadline":
                if(part.length == 2){
                    String[] art = part[1].split(" /by ",2);
                    if(art.length == 2){
                        try{
                            return new AddCommand(new Deadline(art[0], art[1]));
                        }
                        catch(DukeException e){
                            throw e;
                        }
                    }
                }
                throw new DukeException("NO");
            case "event":
                if(part.length == 2){
                    String[] art = part[1].split(" /at ",2);
                    if(art.length == 2){
                        try{
                            return new AddCommand(new Event(art[0], art[1]));
                        }
                        catch(DukeException e){
                            throw e;
                        }
                    }
                }
                throw new DukeException("NO");
            case "delete":
                if(part.length == 2){
                    try{
                        return new DeleteCommand(Integer.parseInt(part[1]) - 1);
                    }
                    catch(Exception e){
                        //do nothing, error will be printed
                    }
                }
                throw new DukeException("NO");
            case "find":
                if(part.length == 2){
                    return new FindCommand(part[1]);
                }
                throw new DukeException("NO");
            default:
                throw new DukeException("NO");
        }
        //Should not reach this point
        return new Command();
    }
}