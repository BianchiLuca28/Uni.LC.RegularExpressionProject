package it.unicam.cs.lc.regularexpr.custom;

/**
 * This class represents a Transition in the NFA generated from the Thompson Algorithm.
 * So it has of course a starting state, an end state, and a symbol with which the transition is triggered
 *
 * @author Luca Bianchi
 */
public class NFATransition {
    // Starting state of the transition (so of course it should be the same as the state that has this transition in
    // its outgoing transitions)
    private NFAState start;
    // Ending state in which the transition ends
    private NFAState end;
    // Symbol with which the transition is triggered (and is either a symbol of the Alphabet or 'epsilon')
    private String symbol;

    public NFATransition(NFAState start, NFAState end, String symbol) {
        this.start = start;
        this.end = end;
        this.symbol = symbol;
    }

    /**
     * Method used to change the value of the starting state of the transition
     * @param newStart new NFAState where the transition starts from now on
     */
    public void setStart(NFAState newStart) {
        this.start = newStart;
    }

    /**
     * This method returns the ending state of the transition
     * @return ending state of the transition
     */
    public NFAState getEnd() {
        return this.end;
    }

    /**
     * This method returns the symbol with which the transition is triggered
     * @return symbol with which the transition is triggered
     */
    public String getSymbol() {
        return this.symbol;
    }
}
