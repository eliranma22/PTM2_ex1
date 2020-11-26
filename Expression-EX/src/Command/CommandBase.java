package Command;

public abstract class CommandBase implements Command{

    protected int numOfArgs;

    @Override
    public abstract void execute(String[] args) throws Exception;

    @Override
    public void testArgs(String[] args) throws Exception{
        if(args.length != this.numOfArgs)
            throw new Exception(this.getClass().getName() + " requires "+this.numOfArgs+" arguments but "+args.length+" were given.");
    }

}
