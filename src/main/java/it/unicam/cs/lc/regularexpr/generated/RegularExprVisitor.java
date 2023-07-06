// Generated from C:/Users/Utente/IdeaProjects/RegularExpressionProject/src/main/java/it/unicam/cs/lc/regularexpr/grammars\RegularExpr.g4 by ANTLR 4.12.0

    package it.unicam.cs.lc.regularexpr.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegularExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegularExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code initial}
	 * labeled alternative in {@link RegularExprParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial(RegularExprParser.InitialContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_prod}
	 * labeled alternative in {@link RegularExprParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_prod(RegularExprParser.Expr1_prodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_sub_union}
	 * labeled alternative in {@link RegularExprParser#expr1_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_sub_union(RegularExprParser.Expr1_sub_unionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr1_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr1_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1_sub_delete(RegularExprParser.Expr1_sub_deleteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr2_prod}
	 * labeled alternative in {@link RegularExprParser#expr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr2_prod(RegularExprParser.Expr2_prodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr2_sub_concat}
	 * labeled alternative in {@link RegularExprParser#expr2_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr2_sub_concat(RegularExprParser.Expr2_sub_concatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr2_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr2_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr2_sub_delete(RegularExprParser.Expr2_sub_deleteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr3_prod}
	 * labeled alternative in {@link RegularExprParser#expr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr3_prod(RegularExprParser.Expr3_prodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr3_sub_kleene}
	 * labeled alternative in {@link RegularExprParser#expr3_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr3_sub_kleene(RegularExprParser.Expr3_sub_kleeneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr3_sub_delete}
	 * labeled alternative in {@link RegularExprParser#expr3_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr3_sub_delete(RegularExprParser.Expr3_sub_deleteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factChar}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactChar(RegularExprParser.FactCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factEpsilon}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactEpsilon(RegularExprParser.FactEpsilonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factExpr1}
	 * labeled alternative in {@link RegularExprParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactExpr1(RegularExprParser.FactExpr1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code stringList_prod}
	 * labeled alternative in {@link RegularExprParser#stringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList_prod(RegularExprParser.StringList_prodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringList_sub_otherString}
	 * labeled alternative in {@link RegularExprParser#stringList_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList_sub_otherString(RegularExprParser.StringList_sub_otherStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringList_sub_delete}
	 * labeled alternative in {@link RegularExprParser#stringList_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList_sub_delete(RegularExprParser.StringList_sub_deleteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_prod}
	 * labeled alternative in {@link RegularExprParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_prod(RegularExprParser.String_prodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_delete}
	 * labeled alternative in {@link RegularExprParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_delete(RegularExprParser.String_deleteContext ctx);
}