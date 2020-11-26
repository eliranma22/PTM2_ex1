package Interpeter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lexer {

    public List<String> lexer(String line){

        List<String> tokens = new LinkedList<>();
        Scanner in = new Scanner(line);

        while(in.hasNext())
            tokens.add(in.next());

        in.close();
        return tokens;
    }

}
