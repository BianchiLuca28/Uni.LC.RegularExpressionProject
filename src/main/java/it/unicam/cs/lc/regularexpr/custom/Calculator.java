package it.unicam.cs.lc.regularexpr.custom;

import it.unicam.cs.lc.regularexpr.generated.RegularExprLexer;
import it.unicam.cs.lc.regularexpr.generated.RegularExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

/**
 * This class is the main class, and in fact inside the main method we can find the part where the input is read,
 * the part where we declare the Lexer, whose output is then passed to the Parser, that once visited the
 * root of the Parsing Tree, starts to calculate the semantic of the expression.
 *
 * Lastly, once the visit is completed it gets the output on the Synthesised Attributed of the root.
 * Which is a List of Strings, so in the auxiliary method it prints all of them as a sequence of strings.
 *
 * @author Luca Bianchi
 */
public class Calculator {
    public static void main(String[] args) throws Exception {
        CharStream input;
        String inputFile = null;
        if (args.length > 0)
            // This is the case in which a file path is passed, in which we can find the input to the grammar
            inputFile = args[0];
        if (inputFile != null)
            // In case there is a path passed, it gets its content
            input = CharStreams.fromFileName(inputFile);
        else
            // Otherwise it just gets the input from the console
            input = CharStreams.fromStream(System.in);
        // Declare the Lexer passing in input the string passed in input (from file or console)
        RegularExprLexer lexer = new RegularExprLexer(input);
        // Gets the tokens recognized from the Lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Initialize a new Parser passing in the sequence of recognized tokens
        RegularExprParser parser = new RegularExprParser(tokens);

        // Starts the visit of the parse tree starting from the root node/symbol
        ParseTree tree = parser.init(); // parse
        // Initialize a new Visitor (which is the custom Visitor that extends the base visitor)
        RegularExprEvalVisitor eval = new RegularExprEvalVisitor();

        // Once evaluated the whole tree it gets the Synthesised Attributes of the root
        ExprSynthesisedAttribute a = eval.visit(tree);
        // Output the sequence of strings computed
        printResults(a.getAccepted());
    }

    /**
     * Auxiliary method that prints the results
     * @param results list of strings of results to print
     */
    private static void printResults(List<String> results) {
        for (String result : results.subList(0, results.size() - 1)) {
            System.out.print(result + ", ");
        }

        // The last one is printed without "comma"
        System.out.print(results.get(results.size() - 1));
    }
}
