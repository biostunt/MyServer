package FirstProject;

public class Command {
    private int id;
    private String command;
    public Command(int id, String command){
        this.id = id;
        this.command = command;
    }

    public int getId() {
        return this.id;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return ""+ this.id + ": " + this.command;
    }
}
