package Command;

import Interpeter.Utilities;
import Expression.Number;

public class VarDecelerationCommand extends CommandBase {

    public VarDecelerationCommand(){
        this.numOfArgs = 2;
    }

    @Override
    public void execute(String[] args) throws Exception {
        this.testArgs(args);
        for(int i=1;i<args.length;i++)
            Utilities.setSymbol(args[i], new Number(0));
    }

    @Override
    public void testArgs(String[] args) throws Exception {
        if(args.length < this.numOfArgs)
            throw new Exception("Var Deceleration Command is expecting at least "+this.numOfArgs+" Args, but "+args.length+" were given.");
        String varType = args[0];

        if(!Utilities.varTypes.contains(varType))
            throw new Exception("Var type "+varType+" is not supported");


    }
}
