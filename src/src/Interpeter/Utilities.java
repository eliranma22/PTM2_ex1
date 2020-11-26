package Interpeter;

import Command.Command;
import Expression.Expression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Utilities {

    private static Map<String, Expression> symbolTable = new HashMap<>();
    private static Map<String, Command> commandTable = new HashMap<>();
    public static Set<String> varTypes = new HashSet<>();

    public static Expression getSymbolValue(String symbol){
        return symbolTable.getOrDefault(symbol, null);
    }

    public static boolean isSymbolExist(String symbol){
        return symbolTable.containsKey(symbol);
    }

    public static void setSymbol(String symbol, Expression value){
        symbolTable.put(symbol, value);
    }

    public static Command getCommand(String name){
        return commandTable.getOrDefault(name, null);
    }

    public static void setCommand(String name, Command cmd){
        commandTable.put(name, cmd);
    }

    public static boolean isCommandExist(String name){
        return commandTable.containsKey(name);
    }
}
