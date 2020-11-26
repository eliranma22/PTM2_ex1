package Command;

public interface Command {

    public void execute(String[] arg) throws Exception;
    public void testArgs(String[] args) throws Exception;

}
