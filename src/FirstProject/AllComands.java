package FirstProject;

public class AllComands {
    private CommandContainer commandContainer;
    public AllComands(CommandContainer commandContainer){
        this.commandContainer = commandContainer;
        addCommands();
    }
    private void addCommands(){
        this.commandContainer.add(new Command(0,"help"));
        this.commandContainer.add(new Command(1,"crack"));
        this.commandContainer.add(new Command(2,"WhiteList"));
        this.commandContainer.add(new Command(3,"BlackList"));
        this.commandContainer.add(new Command(4,"status"));
    }
}
