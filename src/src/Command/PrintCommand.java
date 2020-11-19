package Command;

public class PrintCommand extends CommandBase {
    @Override
    public void execute(String[] args) throws Exception {
        for(int i=1;i<args.length;i++)
            System.out.print(args[i]+ " ");
        System.out.println("");
    }

    @Override
    public void testArgs(String[] args) throws Exception {
        //TODO
    }
}
