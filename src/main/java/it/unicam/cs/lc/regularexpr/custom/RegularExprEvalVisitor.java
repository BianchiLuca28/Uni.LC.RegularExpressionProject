package it.unicam.cs.lc.regularexpr.custom;

import it.unicam.cs.lc.regularexpr.generated.RegularExprBaseVisitor;
import it.unicam.cs.lc.regularexpr.generated.RegularExprParser.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This class extends the class RegularExprBaseVisitor, so it is obvious that for this grammar the visit of the
 * Parse Tree to perform the semantic operations uses the Visitor Pattern, because I thought that using a visitor with
 * a LL(1) grammar gives more control on how the visit of the Parse Tree is done.
 * In fact, speaking of a LL(1) grammar this visit is done using a Depth Visit, in which the attributes of the nodes
 * are computed using a Translation Schema.
 *
 * In this class each method is the Override of a method in the base class that represents each production of the grammar.
 *
 * We can divide the visit of the Parse Tree in 2 phases. In the first we build the Thompson Automata, by using a
 * Depth Visit. Which means that are used both Synthesised Attributes and Inherited Attributes.
 * In fact, firstly we go down the parse tree, and when we "go up" we use the Synthesised Attributes, but when we
 * pass from one sibling to the other we pass the Synthesised Attribute using the Inherited Attribute (or better, using
 * the Queue of Inherited Attributes).
 *
 * Once the automata is built and saved inside the 'automata' attribute, we visit the second part of the Parse Tree,
 * in which we first visit the strings, and by going up we compose the single Characters forming the strings.
 * After that, and after the last string is built, by going up the sequence of strings, they are executed in the
 * 'automata' and the result is saved in the Synthesised Attribute of course.
 *
 * In the end, the root state of the parse tree has in the Synthesised Attribute 'accepted' the list of results strings.
 *
 * @author Luca Bianchi
 */
public class RegularExprEvalVisitor extends RegularExprBaseVisitor<ExprSynthesisedAttribute> {

    // Automata saved at the end of the computation of the Thompson algorithm
    private ThompsonNFA automata;

    // This Queue is used to store the inherited attributes while visiting the parse tree (and it is a queue because
    // by reading and popping its elements in a certain order, it is guaranteed that the read inherited attribute is
    // the one needed)
    private Deque<ExprInheritedAttribute> inheritedAttributes;

    public RegularExprEvalVisitor() {
        this.inheritedAttributes = new LinkedList<>();
    }

    /**
     * This method is called when the production initial -> expr1 , stringList is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'accepted' there is the list of strings
     * resulting from the execution of the automata on the given strings
     */
    @Override
    public ExprSynthesisedAttribute visitInitial(InitialContext ctx) {
        // Firstly it visits the left child to build the automata (since it is the root of the subtree that build the automata).
        // And it saves the automata in the private attribute of the class
        this.automata = this.visit(ctx.expr1()).getAutomata();
        // Then visits the right child that parse and executes the strings, returning its results
        return this.visit(ctx.stringList());
    }

    /**
     * This method is called when the production expr1 -> expr2 expr1_sub is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     */
    @Override
    public ExprSynthesisedAttribute visitExpr1_prod(Expr1_prodContext ctx) {
        // Firstly it visits the left child computing the first automata
        ExprSynthesisedAttribute left = this.visit(ctx.expr2());

        // Pass the value to the right child putting it in the queue (so basically it is setting the inherited attribute
        // of the right child to this)
        this.inheritedAttributes.push(new ExprInheritedAttribute(left.getAutomata()));

        // Once the right child has been visited, the Synthesised Attribute of it is available and so it retrieves it
        ExprSynthesisedAttribute toReturn = this.visit(ctx.expr1_sub());

        // Pop the previously pushed inherited attribute
        this.inheritedAttributes.pop();

        return toReturn;
    }

    /**
     * This method is called when the production expr1_sub -> + expr2 expr1_sub is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     * performing the union of the two automatas
     */
    @Override
    public ExprSynthesisedAttribute visitExpr1_sub_union(Expr1_sub_unionContext ctx) {
        // Firstly it gets the automata built by visiting its left child and extracts the automata
        ExprSynthesisedAttribute rightTree = this.visit(ctx.expr2());
        ThompsonNFA rightAutomata = rightTree.getAutomata();

        // Retrieves the inherited attribute passed from the parent rule that contains the partial automata
        ThompsonNFA leftAutomata = this.inheritedAttributes.peek().getIAutomata();

        // This code sets both initial states as non-initial and both final states as non-final
        leftAutomata.getStartNode().toggleInitial();
        leftAutomata.getEndNode().toggleAccept();
        rightAutomata.getStartNode().toggleInitial();
        rightAutomata.getEndNode().toggleAccept();

        // Creates the new 2 states (one initial and one final) that represents the initial and end state of the
        // resulting automata from the union of the two following Thompson Algorithm
        NFAState newStartNode = new NFAState(true, false);
        NFAState newEndNode = new NFAState(false, true);

        // Adds 2 transitions with epsilon to the 2 previous initial states of the 2 automatas
        newStartNode.addTransition(leftAutomata.getStartNode(), "epsilon");
        newStartNode.addTransition(rightAutomata.getStartNode(), "epsilon");

        // Adds a transition with epsilon on both previous ending states that connects them to the new ending state
        leftAutomata.getEndNode().addTransition(newEndNode, "epsilon");
        rightAutomata.getEndNode().addTransition(newEndNode, "epsilon");

        // Creates the new automata
        ThompsonNFA unionAutomata = new ThompsonNFA(newStartNode, newEndNode);

        // Push the new built automata into the queue, and by then visiting the right child it means that we are putting
        // the new automata into the inherited attribute of the right child (and it will use it)
        this.inheritedAttributes.push(new ExprInheritedAttribute(unionAutomata));

        // Visits the right child and retrieves the automata computed
        ExprSynthesisedAttribute toReturn = this.visit(ctx.expr1_sub());

        // Pop the previously pushed inherited attribute
        this.inheritedAttributes.pop();
        return toReturn;
    }

    /**
     * This method is called when the production expr1_sub -> epsilon is executed
     * (basically it transforms the inherited attribute into synthesised attribute)
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     * (that is the one that is in its inherited attribute)
     */
    @Override
    public ExprSynthesisedAttribute visitExpr1_sub_delete(Expr1_sub_deleteContext ctx) {
        // Retrieves the automata stored in its inherited attribute (that is stored more precisely in the queue)
        ExprInheritedAttribute inheritedAttribute = this.inheritedAttributes.peek();

        // Returns a new Synthesised Attribute that has the automata that was stored in the inherited attribute
        return new ExprSynthesisedAttribute(inheritedAttribute.getIAutomata(), "", null);
    }

    /**
     * This method is called when the production expr2 -> expr3 expr2_sub is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     */
    @Override
    public ExprSynthesisedAttribute visitExpr2_prod(Expr2_prodContext ctx) {
        // Firstly it visits the left child computing the first automata
        ExprSynthesisedAttribute left = this.visit(ctx.expr3());

        // Pass the value to the right child putting it in the queue (so basically it is setting the inherited attribute
        // of the right child to this)
        this.inheritedAttributes.push(new ExprInheritedAttribute(left.getAutomata()));

        // Once the right child has been visited, the Synthesised of it is available and so it retrieves it
        ExprSynthesisedAttribute toReturn = this.visit(ctx.expr2_sub());

        // Pop the previously pushed inherited attribute
        this.inheritedAttributes.pop();

        return toReturn;
    }

    /**
     * This method is called when the production expr2_sub -> expr3 expr2_sub is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     * performing the concatenation of the two automatas
     */
    @Override
    public ExprSynthesisedAttribute visitExpr2_sub_concat(Expr2_sub_concatContext ctx) {
        // Firstly it gets the automata built by visiting its left child and extracts the automata
        ExprSynthesisedAttribute rightTree = this.visit(ctx.expr3());
        ThompsonNFA rightAutomata = rightTree.getAutomata();

        // Retrieves the inherited attribute passed from the parent rule that contains the partial automata
        ThompsonNFA leftAutomata = this.inheritedAttributes.peek().getIAutomata();

        // Here we make the ending node of the left automata no more final
        leftAutomata.getEndNode().toggleAccept();
        // And here we make the starting node of the right automata no more initial
        rightAutomata.getStartNode().toggleInitial();

        /*
            For each of the transition of the starting node of the right automata, we set the start of these
            transitions to the end state of the left automata, and then attach them to this last one
         */
        for (NFATransition transition : rightAutomata.getStartNode().getOutgoingTransitions()) {
            transition.setStart(leftAutomata.getEndNode());
            leftAutomata.getEndNode().addTransition(transition);
        }

        // Creates the new automata
        ThompsonNFA concatAutomata = new ThompsonNFA(leftAutomata.getStartNode(), rightAutomata.getEndNode());

        // Push the new built automata into the queue, and by then visiting the right child it means that we are putting
        // the new automata into the inherited attribute of the right child (and it will use it)
        this.inheritedAttributes.push(new ExprInheritedAttribute(concatAutomata));

        // Visits the right child and retrieves the automata computed
        ExprSynthesisedAttribute toReturn = this.visit(ctx.expr2_sub());

        // Pop the previously pushed inherited attribute
        this.inheritedAttributes.pop();
        return toReturn;
    }

    /**
     * This method is called when the production expr2_sub -> epsilon is executed
     * (basically it transforms the inherited attribute into synthesised attribute)
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     * (that is the one that is in its inherited attribute)
     */
    @Override
    public ExprSynthesisedAttribute visitExpr2_sub_delete(Expr2_sub_deleteContext ctx) {
        // Retrieves the automata stored in its inherited attribute (that is stored more precisely in the queue)
        ExprInheritedAttribute inheritedAttribute = this.inheritedAttributes.peek();

        // Returns a new Synthesised Attribute that has the automata that was stored in the inherited attribute
        return new ExprSynthesisedAttribute(inheritedAttribute.getIAutomata(), "", null);
    }

    /**
     * This method is called when the production expr3 -> fact expr3_sub is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     */
    @Override
    public ExprSynthesisedAttribute visitExpr3_prod(Expr3_prodContext ctx) {
        // Firstly it visits the left child computing the first automata
        ExprSynthesisedAttribute left = this.visit(ctx.fact());

        // Pass the value to the right child putting it in the queue (so basically it is setting the inherited attribute
        // of the right child to this)
        this.inheritedAttributes.push(new ExprInheritedAttribute(left.getAutomata()));

        // Once the right child has been visited, the Synthesised of it is available and so it retrieves it
        ExprSynthesisedAttribute toReturn = this.visit(ctx.expr3_sub());

        // Pop the previously pushed inherited attribute
        this.inheritedAttributes.pop();

        return toReturn;
    }

    /**
     * This method is called when the production expr3_sub -> * is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     * (more precisely is the automata built by applying the Thompson Algorithm in case of the Kleene operator)
     */
    @Override
    public ExprSynthesisedAttribute visitExpr3_sub_kleene(Expr3_sub_kleeneContext ctx) {
        // Retrieves the inherited attribute passed from the parent rule that contains the partial automata
        ThompsonNFA inheritedAutomata = this.inheritedAttributes.peek().getIAutomata();

        // Here the initial and final states of the automata are no longer that
        inheritedAutomata.getStartNode().toggleInitial();
        inheritedAutomata.getEndNode().toggleAccept();

        // Creates a new initial and a new final state for the new automata, connecting them with a transition with epsilon
        NFAState newStartNode = new NFAState(true, false);
        NFAState newEndNode = new NFAState(false, true);
        newStartNode.addTransition(newEndNode, "epsilon");

        // Connects the new initial node with the previous starting node adding a transition with epsilon
        newStartNode.addTransition(inheritedAutomata.getStartNode(), "epsilon");
        // Connects the previous ending node with the new final node adding a transition with epsilon
        inheritedAutomata.getEndNode().addTransition(newEndNode, "epsilon");

        // Loop between the previous ending node and the previous starting node by adding a transition with epsilon
        inheritedAutomata.getEndNode().addTransition(inheritedAutomata.getStartNode(), "epsilon");

        // Creates the new automata
        ThompsonNFA automataToReturn = new ThompsonNFA(newStartNode, newEndNode);

        // Returns a new Synthesised Attribute containing the computed automata
        return new ExprSynthesisedAttribute(automataToReturn, "", null);
    }

    /**
     * This method is called when the production expr3_sub -> epsilon is executed
     * (basically it transforms the inherited attribute into synthesised attribute)
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata built by the visit
     * (that is the one that is in its inherited attribute)
     */
    @Override
    public ExprSynthesisedAttribute visitExpr3_sub_delete(Expr3_sub_deleteContext ctx) {
        // Retrieves the automata stored in its inherited attribute (that is stored more precisely in the queue)
        ExprInheritedAttribute inheritedAttribute = this.inheritedAttributes.peek();

        // Returns a new Synthesised Attribute that has the automata that was stored in the inherited attribute
        return new ExprSynthesisedAttribute(inheritedAttribute.getIAutomata(), "", null);
    }

    /**
     * This method is called when the production fact -> CHAR is executed
     * Returns a new Synthesised Attribute that has as the automata the simple automata composed by two new states (one
     * initial and the other final) connected by a transition that as a symbol has the lexeme of the child node CHAR
     * @param ctx the parse tree
     * @return a new Synthesised Attribute that has as the automata the simple automata composed by two new states (one
     * initial and the other final) connected by a transition that as a symbol has the lexeme of the child node CHAR
     */
    @Override
    public ExprSynthesisedAttribute visitFactChar(FactCharContext ctx) {
        // Creates two new states (one initial and the other final)
        NFAState start = new NFAState(true, false);
        NFAState end = new NFAState(false, true);

        // Connects them adding a transition that as a symbol has the lexeme of the child node CHAR
        start.addTransition(end, ctx.CHAR().getText());

        // Creates the new automata
        ThompsonNFA automataToReturn = new ThompsonNFA(start, end);

        // Returns a new Synthesised Attribute that has the automata built
        return new ExprSynthesisedAttribute(automataToReturn, "", null);
    }

    /**
     * This method is called when the production fact -> EPSILON is executed
     * Returns a new Synthesised Attribute that has as the automata the simple automata composed by two new states (one
     * initial and the other final) connected by an epsilon transition
     * @param ctx the parse tree
     * @return a new Synthesised Attribute that has as the automata the simple automata composed by two new states (one
     * initial and the other final) connected by an epsilon transition
     */
    @Override
    public ExprSynthesisedAttribute visitFactEpsilon(FactEpsilonContext ctx) {
        // Creates two new states (one initial and the other final)
        NFAState start = new NFAState(true, false);
        NFAState end = new NFAState(false, true);

        // Connects them adding an epsilon transition
        start.addTransition(end, ctx.EPSILON().getText());

        // Creates the new automata
        ThompsonNFA automataToReturn = new ThompsonNFA(start, end);

        // Returns a new Synthesised Attribute that has the automata built
        return new ExprSynthesisedAttribute(automataToReturn, "", null);
    }

    /**
     * This method is called when the production fact -> ( expr1 ) is executed
     * @param ctx the parse tree
     * @return the Synthesised Attribute computed by the visit. In the attribute 'automata' there is the automata computed in
     * the expression in the braces
     */
    @Override
    public ExprSynthesisedAttribute visitFactExpr1(FactExpr1Context ctx) {
        // Visits the expression in braces and returns the synthesised attribute
        return this.visit(ctx.expr1());
    }

    /**
     * This method is called when the production stringList -> string stringList_sub is executed
     * @param ctx the parse tree
     * @return the ExprSynthesisedAttribute containing the list of strings containing the results of the
     * executions of the strings on the automata
     */
    @Override
    public ExprSynthesisedAttribute visitStringList_prod(StringList_prodContext ctx) {
        // Visits the left child of the node
        ExprSynthesisedAttribute leftString = this.visit(ctx.string());

        // Visits the right child of the node
        ExprSynthesisedAttribute rightSubList = this.visit(ctx.stringList_sub());

        // This string is OK if the automata accepted the computed string, otherwise it is KO
        String accepted = this.automata.accept(leftString.getStringToAccept()) ? "OK" : "KO";

        // Gets the list of strings of results computed so far from the right child and adds in the first position the
        // new computed result (with the string of the left child)
        List<String> listAcceptedResults = rightSubList.getAccepted();
        listAcceptedResults.add(0, accepted);

        // Returns a new Synthesised Attribute with the concatenated result in the first position
        return new ExprSynthesisedAttribute(
                null,
                "",
                listAcceptedResults
        );
    }

    /**
     * This method is called when the production stringList_sub -> , stringList_sub is executed.
     * In fact, as the name suggests, it just means that there is another string to compute, so it goes in depth visiting the right child
     * @param ctx the parse tree
     * @return the ExprSynthesisedAttribute containing the list of strings containing the results of the executions
     * of the strings on the automata computed so far
     */
    @Override
    public ExprSynthesisedAttribute visitStringList_sub_otherString(StringList_sub_otherStringContext ctx) {
        // Once it has visited the right child, it makes the Synthesised Attribute "go up" in the tree
        ExprSynthesisedAttribute subList = this.visit(ctx.stringList());
        return new ExprSynthesisedAttribute(
                null,
                "",
                subList.getAccepted()
        );
    }

    /**
     * This method is called when the production stringList_sub -> epsilon is executed.
     * Arrived here it means that the sequence of string to compute is terminated, so it goes back up to compute them
     * @param ctx the parse tree
     * @return a new ExprSynthesisedAttribute with an empty list of strings of computed results
     */
    @Override
    public ExprSynthesisedAttribute visitStringList_sub_delete(StringList_sub_deleteContext ctx) {
        // Returns a new empty list of results
        return new ExprSynthesisedAttribute(
                null,
                "",
                new ArrayList<>()
        );
    }

    /**
     * This method is called when the production string -> CHAR string is executed.
     * It means that the string has a character and possibly even more, so it goes in depth
     * @param ctx the parse tree
     * @return the string to accept computed so far, concatenating the lexeme of the new CHAR as its first character
     */
    @Override
    public ExprSynthesisedAttribute visitString_prod(String_prodContext ctx) {
        // Visits the substring on the right child
        ExprSynthesisedAttribute subString = this.visit(ctx.string());

        // Returns a new ExprSynthesisedAttribute where the string to accept is the one computed so far concatenated after
        // the new CHAR (since we are going up)
        return new ExprSynthesisedAttribute(
                null,
                ctx.CHAR().getText() + subString.getStringToAccept(),
                null
        );
    }

    /**
     * This method is called when the production string -> epsilon is executed.
     * It means that the sequence of characters of the string is terminated, so it goes back up by returning a new empty string
     * (to concatenate characters to the top)
     * @param ctx the parse tree
     * @return a new ExprSynthesisedAttribute with an empty string to accept
     */
    @Override
    public ExprSynthesisedAttribute visitString_delete(String_deleteContext ctx) {
        // Returns a new empty string to accept (so that it can be passed to the top)
        return new ExprSynthesisedAttribute(null, "", null);
    }
}
