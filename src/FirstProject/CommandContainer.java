package FirstProject;

import java.util.ArrayList;

public class CommandContainer {
    private ArrayList<Command> Container = new ArrayList<Command>();
    private int top = 0;
    private boolean IsAllowed;
    public CommandContainer(){
    }
    public void add(Command command){
        this.Container.add(command);
    }
    public int findCommand(String that){
        for (int i = 0; i < this.Container.size(); i++)
            if(this.Container.get(i).getCommand().equalsIgnoreCase(that))
                return i;
        return -1;
    }
    public String GetAllCommands(){
        String all = "";
        all += "List of all commands: \n";
        for(Command c : this.Container) all += c + "\n";
        return all;
    }

}
