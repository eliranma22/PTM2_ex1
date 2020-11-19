package Interpeter;

import Command.*;
import Expression.Number;
import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Parser {

    public static class ParsedDate{
        public Queue<Command> cmdQ = new LinkedList<>();
        public Queue<String[]> argsQ = new LinkedList();
        public List<String> errors = new LinkedList<>();
    }

    public ParsedDate parse(String fileName, Lexer lexer) throws IOException {

        int lineIndex = 0;
        BufferedReader fileInput = new BufferedReader(new FileReader(new File(fileName)));
        ParsedDate parsedData = new ParsedDate();

        String line;
        Command cmd;
        String cmdName;
        String args[];

        while((line = fileInput.readLine()) != null){
            lineIndex++;
            if(line.trim().length() == 0)
                continue;
            try {
                List<String> tokens = lexer.lexer(line);
                cmdName = tokens.get(0);
                if (!Utilities.isCommandExist(cmdName)) {
                    parsedData.errors.add(lineIndex + ": Command is not valid.");
                    continue;
                }

                cmd = Utilities.getCommand(cmdName);
                args = tokens.toArray(new String[0]);
                cmd.testArgs(args);

                if(cmd.getClass().getName().intern() != VarDeclerationCommand.class.getName().intern()) {
                    for(int i=1;i<tokens.size();i++) {
                        String varName = tokens.get(i);
                        if (Utilities.isSymbolExist(varName))
                            parsedData.errors.add(lineIndex + ": "+varName+" already declared.");
                        else
                            Utilities.setSymbol(varName, null);
                    }
                }

                parsedData.argsQ.add(args);
                parsedData.cmdQ.add(cmd);

                if(cmdName.startsWith("return"))
                    break;


            }catch (Exception e){
                parsedData.errors.add(lineIndex+" : "+e.getMessage());
                continue;
            }

        }

        if((line == null || !line.startsWith("return")) && parsedData.errors.isEmpty())
            parsedData.errors.add("Program must contain a return statement.");

        fileInput.close();
        return parsedData;
    }

}
