package it.unicam.cs.lc.regularexpr.custom;

import java.util.List;

/**
 * These are the Synthesised Attributes needed for this grammar.
 * In fact, here is needed a ThompsonNFA to build the automata during the visit of the subtree that has 'expr1' has the
 * root (this is also used with the Inherited attribute), there is a stringToAccept to build the string to pass in
 * the built automata once it's done, and there is a List of Strings that contains the results of the executed strings
 *
 * @author Luca Bianchi
 */
public class ExprSynthesisedAttribute {

    // This attribute is used during the building of the Thompson Automata to make the automata "go up" the tree
    private ThompsonNFA automata;
    // String built going up the tree, and that will be passed to the automata to be executed and get a result
    private String stringToAccept;
    // List of strings that contains the results of the execution of the automata on the strings passed
    private List<String> accepted;

    public ExprSynthesisedAttribute(ThompsonNFA automata, String stringToAccept, List<String> accepted) {
        super();
        this.automata = automata;
        this.stringToAccept = stringToAccept;
        this.accepted = accepted;
    }

    /**
     * Returns the attribute named 'automata' that is instance of ThompsonNFA
     * @return the attribute named 'automata' that is instance of ThompsonNFA
     */
    public ThompsonNFA getAutomata() {
        return this.automata;
    }

    /**
     * Returns the string attribute that will be passed to the automata to be computed
     * @return the string attribute that will be passed to the automata to be computed
     */
    public String getStringToAccept() {
        return this.stringToAccept;
    }

    /**
     * Returns the results (the attribute named 'accepted') computed executing the automata on the strings
     * @return the results (the attribute named 'accepted') computed executing the automata on the strings
     */
    public List<String> getAccepted() {
        return this.accepted;
    }
}
