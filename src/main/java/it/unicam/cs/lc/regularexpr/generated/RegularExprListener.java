// Generated from C:/Users/Utente/IdeaProjects/RegularExpressionProject/src/main/java/it/unicam/cs/lc/regularexpr/grammars\RegularExpr.g4 by ANTLR 4.12.0

    package it.unicam.cs.lc.regularexpr.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RegularExprParser}.
 */
public interface RegularExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code initial}
	 * labeled alternative in {@link RegularExprParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInitial(RegularExprParser.InitialContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initial}
	 * labeled alternative in {@link RegularExprParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInitial(RegularExprParser.InitialContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_prod}
	 * labeled alternative in {@link RegularExprParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_prod(RegularExprParser.Expr1_prodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_prod}
	 * labeled alternative in {@link RegularExprParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_prod(RegularExprParser.Expr1_prodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_sub_union}
	 * labeled alternative in {@link RegularExprParser#expr1_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_sub_union(RegularExprParser.Expr1_sub_unionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_sub_union}
	 * labeled alternative in {@link RegularExprParser#expr1_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_sub_union(RegularExprParser.Expr1_sub_unionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr1_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr1_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr1_sub_delete(RegularExprParser.Expr1_sub_deleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr1_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr1_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr1_sub_delete(RegularExprParser.Expr1_sub_deleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr2_prod}
	 * labeled alternative in {@link RegularExprParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr2_prod(RegularExprParser.Expr2_prodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr2_prod}
	 * labeled alternative in {@link RegularExprParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr2_prod(RegularExprParser.Expr2_prodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr2_sub_concat}
	 * labeled alternative in {@link RegularExprParser#expr2_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr2_sub_concat(RegularExprParser.Expr2_sub_concatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr2_sub_concat}
	 * labeled alternative in {@link RegularExprParser#expr2_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr2_sub_concat(RegularExprParser.Expr2_sub_concatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr2_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr2_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr2_sub_delete(RegularExprParser.Expr2_sub_deleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr2_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr2_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr2_sub_delete(RegularExprParser.Expr2_sub_deleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr3_prod}
	 * labeled alternative in {@link RegularExprParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterExpr3_prod(RegularExprParser.Expr3_prodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr3_prod}
	 * labeled alternative in {@link RegularExprParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitExpr3_prod(RegularExprParser.Expr3_prodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr3_sub_kleene}
	 * labeled alternative in {@link RegularExprParser#expr3_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr3_sub_kleene(RegularExprParser.Expr3_sub_kleeneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr3_sub_kleene}
	 * labeled alternative in {@link RegularExprParser#expr3_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr3_sub_kleene(RegularExprParser.Expr3_sub_kleeneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr3_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr3_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr3_sub_delete(RegularExprParser.Expr3_sub_deleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr3_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr3_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr3_sub_delete(RegularExprParser.Expr3_sub_deleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factChar}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFactChar(RegularExprParser.FactCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factChar}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFactChar(RegularExprParser.FactCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factEpsilon}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFactEpsilon(RegularExprParser.FactEpsilonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factEpsilon}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFactEpsilon(RegularExprParser.FactEpsilonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factExpr1}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFactExpr1(RegularExprParser.FactExpr1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code factExpr1}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFactExpr1(RegularExprParser.FactExpr1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code stringList_prod}
	 * labeled alternative in {@link RegularExprParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList_prod(RegularExprParser.StringList_prodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringList_prod}
	 * labeled alternative in {@link RegularExprParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList_prod(RegularExprParser.StringList_prodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringList_sub_otherString}
	 * labeled alternative in {@link RegularExprParser#stringList_sub}.
	 * @param ctx the parse tree
	 */
	void enterStringList_sub_otherString(RegularExprParser.StringList_sub_otherStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringList_sub_otherString}
	 * labeled alternative in {@link RegularExprParser#stringList_sub}.
	 * @param ctx the parse tree
	 */
	void exitStringList_sub_otherString(RegularExprParser.StringList_sub_otherStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringList_sub_delete}
	 * labeled alternative in {@link RegularExprParser#stringList_sub}.
	 * @param ctx the parse tree
	 */
	void enterStringList_sub_delete(RegularExprParser.StringList_sub_deleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringList_sub_delete}
	 * labeled alternative in {@link RegularExprParser#stringList_sub}.
	 * @param ctx the parse tree
	 */
	void exitStringList_sub_delete(RegularExprParser.StringList_sub_deleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string_prod}
	 * labeled alternative in {@link RegularExprParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString_prod(RegularExprParser.String_prodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string_prod}
	 * labeled alternative in {@link RegularExprParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString_prod(RegularExprParser.String_prodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string_delete}
	 * labeled alternative in {@link RegularExprParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString_delete(RegularExprParser.String_deleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string_delete}
	 * labeled alternative in {@link RegularExprParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString_delete(RegularExprParser.String_deleteContext ctx);
}