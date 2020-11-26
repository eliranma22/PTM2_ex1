package Interpeter;

public class Main {

    public static void main(String[] args) throws Exception {



        Parser p = new Parser();
        Lexer l = new Lexer();
        Parser.ParsedDate pd = p.parse("MyCommands", l);
        while(!pd.cmdQ.isEmpty()){
            //TODO
        }

    }
}
