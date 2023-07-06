package it.unicam.cs.lc.regularexpr.custom;

/**
 * Inherited attribute for the grammar, the value of a left operand that is transferred
 * from a left sibling to a right sibling in order to compute at the end the combination of
 * the two automatas following the Thompson Algorithm
 *
 * @author Luca Bianchi
 */
public class ExprInheritedAttribute {

    // The only Inherited attribute needed for this grammar is only this of type ThompsonNFA
    private ThompsonNFA i_automata;

    public ExprInheritedAttribute(ThompsonNFA automata) {
        this.i_automata = automata;
    }

    /**
     * Returns the automata stored in the ExprInheritedAttribute
     * @return the automata stored in the ExprInheritedAttribute
     */
    public ThompsonNFA getIAutomata() {
        return this.i_automata;
    }
}
