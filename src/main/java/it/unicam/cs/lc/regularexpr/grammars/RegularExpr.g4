/**
 * This is a non-ambiguous grammar to write a regular expression based on a alphabet composed of a-z , A-Z and 0, 1, 2, ... 9.
 * This grammar also follows precedence and associativity rules. After the regular expression some strings must be found
 * (at least one) that then will be executed by the NFA.
 *
 * This grammar is LL(1), this means that it can be parsed using a Top-Down Parser.
 *
 * The semantic is specified in the other Java files, but the main goal is to create the NFA based on the given regular
 * expression using the Thompson Algorithm. The final output is a sequence of strings of OK or KO, which are the
 * results of the strings executed on the automata.
 *
 * To do this it uses both Synthesised Attributes and Inherited Attributes to create the automata and only Synthesised
 * Attributes to parse the strings after the regular expression.
 * More specifically, for semantic a Translation Schema is used, and a pattern visitor is used to navigate the parsing tree.
 * (for more check the custom code for the semantic).
 *
 * @author Luca Bianchi
*/

grammar RegularExpr;

@header {
    package it.unicam.cs.lc.regularexpr.generated;
}

init
:
    expr1 ',' stringList EOF # initial
;

expr1
:
	expr2 expr1_sub # expr1_prod
;

expr1_sub
:
    '+' expr2 expr1_sub # expr1_sub_union
    | # expr1_sub_delete
;

expr2
:
	expr3 expr2_sub # expr2_prod
;

expr2_sub
:
    expr3 expr2_sub # expr2_sub_concat
    | # expr2_sub_delete
;

expr3
:
    fact expr3_sub # expr3_prod
;

expr3_sub
:
    '*' # expr3_sub_kleene
    | # expr3_sub_delete
;

fact
:
	CHAR # factChar
	| EPSILON # factEpsilon
	| '(' expr1 ')' # factExpr1
;

stringList
:
    string stringList_sub # stringList_prod
;

stringList_sub
:
    ',' stringList # stringList_sub_otherString
    | # stringList_sub_delete
;

string
:
    CHAR string # string_prod
    | # string_delete
;

// This is any character of the Alphabet
CHAR
:
    [a-zA-Z0-9]
;

// Specific token that represents the Epsilon of the regular expressions
EPSILON
:
    'epsilon'
;

WS
:
	[ \t\r\n]+ -> skip
; // toss out whitespace