package it.unicam.cs.lc.regularexpr.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Thompson NFA in the algorithm.
 * As such it has only one initial state and one ending state.
 *
 * The most important method is the accept method, that given a string it returns the result
 *
 * @author Luca Bianchi
 */
public class ThompsonNFA {
    // Initial state
    private NFAState startState;
    // Ending state
    private NFAState endState;

    public ThompsonNFA(NFAState startState, NFAState endState) {
        this.startState = startState;
        this.endState = endState;
    }

    /**
     * Returns the Initial NFAState
     * @return the Initial NFAState
     */
    public NFAState getStartNode() {
        return this.startState;
    }

    /**
     * Returns the Final NFAState
     * @return the Final NFAState
     */
    public NFAState getEndNode() {
        return this.endState;
    }

    /**
     * This method returns true if the given string is accepted, false otherwise
     * @param stringToAccept String that on which the automata is executed
     * @return true if the given string is accepted, false otherwise
     */
    public boolean accept(String stringToAccept) {
        // Firstly it initialize a new List of States that is the one returned from the epsilon closure applied to the
        // only initial state and also represents the currents states in which the automata is (being non-deterministic)
        List<NFAState> currentStates = this.epsilonClosure(startState);

        // For each character of the list
        for (String character : stringToAccept.split("")) {
            // This is the list of the new states that are reached reading the single characters of the string
            // that will "trigger" the transitions based on the symbols of the transitions and the character read
            // (Note that since this is an NFA the reached states are note only one, but several of them)
            List<NFAState> reachedStates = new ArrayList<>();

            // Then cycle for each of the current states in which the automata currently is
            for (NFAState state : currentStates) {
                // Adds to the reached states all the states that are reachable from the current state checking which
                // of its transitions can trigger given the read character (and of course, this time as well is a set
                // of states since it's an NFA)
                reachedStates.addAll(move(state, character));
            }

            // If from the current states of the automata there are no states that are reachable reading
            // the current character, it means that the automata is blocked and can't move anymore, so it returns
            // false since the given string is not accepted
            if (reachedStates.isEmpty())
                return false;
            else
                // Otherwise it keeps going, changing the current states of the automata with the ones reached and
                // reads the next character of the string
                currentStates = reachedStates;
        }

        // Once the whole string has been read (and arriving here it means that the automata didn't block),
        // it checks if in the current states there is at least one that is final. If there is, it returns true
        // because it means that the given string is accepted by the NFA
        for (NFAState state : currentStates) {
            if (state.getAccept()) return true;
        }

        // If there isn't a single state that is final, it returns false, since the automata didn't accept the string
        return false;
    }

    /**
     * This auxiliary method computes the epsilon closure of the given state
     * @param stateToClose state that needs to be closed
     * @return List of states that are reachable with epsilon transition from the given state
     */
    private List<NFAState> epsilonClosure(NFAState stateToClose) {
        // List of states that will be returned at the end
        List<NFAState> setToReturn = new ArrayList<>();
        // List of states where all states are added at each step and then is emptied to restart with the next step
        List<NFAState> newStatesToAdd = new ArrayList<>();

        // Firstly adds to the set of states to return the given state, since in the definition of epsilon closure
        // the given state is also part of the result
        setToReturn.add(stateToClose);

        // Since it's an incremental function, it keeps to add states to the ones to return until re-applying the
        // function on the reached states, no more can be added, so it exits
        while (true) {
            // Clean the new states to add to the set of states to return
            newStatesToAdd = new ArrayList<>();
            // For each of the current states reached using an epsilon transition
            for (NFAState state : setToReturn) {
                // For each transition of the current state
                for (NFATransition transition : state.getOutgoingTransitions()) {
                    // Checks if the symbol of the transition is epsilon AND if the end state of the transition
                    // isn't already in the set of states to return. If it's true, it adds the end state of the transition
                    // to the states to add to the set of states to return computed so far
                    if (transition.getSymbol().equals("epsilon") && !setToReturn.contains(transition.getEnd())) {
                        newStatesToAdd.add(transition.getEnd());
                    }
                }
            }
            // If no more states are reached using epsilon transitions starting from the current states reached in this
            // step are found, it returns the list of states (that in case it exits right away it only contains
            // the first given state)
            if(newStatesToAdd.isEmpty()) {
                return setToReturn;
            } else {
                // Otherwise it keeps going, adding the new reached states to the set to return and starting again
                // looking for epsilon transition
                setToReturn.addAll(newStatesToAdd);
            }
        }
    }

    /**
     * This auxiliary method returns the list of states reached from the given state using the transitions that has
     * the symbol as the given character read from the string
     * @param startState starting state from which check the transitions with the given symbol
     * @param symbol character read from the string to accept used to look for the triggered transitions
     * @return list of end states reached from the starting state using the transitions that has the same symbol as
     * the given character
     */
    private List<NFAState> move(NFAState startState, String symbol) {
        // If the given character is empty, it means that the string given at the start is empty, and to return the
        // reachable states it first transforms the symbol to 'epsilon' to help the execution of the equals found later
        if (symbol.isEmpty()) symbol = "epsilon";

        // List of states to return reached using the given symbol from the starting state
        List<NFAState> outgoingStates = new ArrayList<>();

        // For each of the transition of the given starting state
        for (NFATransition transition : startState.getOutgoingTransitions()) {
            // If the transition has the same symbol as the one given, it adds to the set of states to return
            // all the states returned from the epsilon closure applied to the end state of the transition
            if (transition.getSymbol().equals(symbol)) outgoingStates.addAll(epsilonClosure(transition.getEnd()));
        }

        return outgoingStates;
    }
}
