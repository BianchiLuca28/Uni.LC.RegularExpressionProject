// Generated from C:/Users/Utente/IdeaProjects/RegularExpressionProject/src/main/java/it/unicam/cs/lc/regularexpr/grammars\RegularExpr.g4 by ANTLR 4.12.0

    package it.unicam.cs.lc.regularexpr.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RegularExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CHAR=6, EPSILON=7, WS=8;
	public static final int
		RULE_init = 0, RULE_expr1 = 1, RULE_expr1_sub = 2, RULE_expr2 = 3, RULE_expr2_sub = 4, 
		RULE_expr3 = 5, RULE_expr3_sub = 6, RULE_fact = 7, RULE_stringList = 8, 
		RULE_stringList_sub = 9, RULE_string = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "expr1", "expr1_sub", "expr2", "expr2_sub", "expr3", "expr3_sub", 
			"fact", "stringList", "stringList_sub", "string"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'+'", "'*'", "'('", "')'", null, "'epsilon'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "CHAR", "EPSILON", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RegularExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RegularExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitContext extends ParserRuleContext {
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
	 
		public InitContext() { }
		public void copyFrom(InitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InitialContext extends InitContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public StringListContext stringList() {
			return getRuleContext(StringListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RegularExprParser.EOF, 0); }
		public InitialContext(InitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterInitial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitInitial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitInitial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			_localctx = new InitialContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			expr1();
			setState(23);
			match(T__0);
			setState(24);
			stringList();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr1Context extends ParserRuleContext {
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
	 
		public Expr1Context() { }
		public void copyFrom(Expr1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr1_prodContext extends Expr1Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr1_subContext expr1_sub() {
			return getRuleContext(Expr1_subContext.class,0);
		}
		public Expr1_prodContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr1_prod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr1_prod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr1_prod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		Expr1Context _localctx = new Expr1Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr1);
		try {
			_localctx = new Expr1_prodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			expr2();
			setState(28);
			expr1_sub();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr1_subContext extends ParserRuleContext {
		public Expr1_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1_sub; }
	 
		public Expr1_subContext() { }
		public void copyFrom(Expr1_subContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr1_sub_deleteContext extends Expr1_subContext {
		public Expr1_sub_deleteContext(Expr1_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr1_sub_delete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr1_sub_delete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr1_sub_delete(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr1_sub_unionContext extends Expr1_subContext {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr1_subContext expr1_sub() {
			return getRuleContext(Expr1_subContext.class,0);
		}
		public Expr1_sub_unionContext(Expr1_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr1_sub_union(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr1_sub_union(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr1_sub_union(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr1_subContext expr1_sub() throws RecognitionException {
		Expr1_subContext _localctx = new Expr1_subContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr1_sub);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				_localctx = new Expr1_sub_unionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(T__1);
				setState(31);
				expr2();
				setState(32);
				expr1_sub();
				}
				break;
			case T__0:
			case T__4:
				_localctx = new Expr1_sub_deleteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr2Context extends ParserRuleContext {
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
	 
		public Expr2Context() { }
		public void copyFrom(Expr2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr2_prodContext extends Expr2Context {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr2_subContext expr2_sub() {
			return getRuleContext(Expr2_subContext.class,0);
		}
		public Expr2_prodContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr2_prod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr2_prod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr2_prod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		Expr2Context _localctx = new Expr2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr2);
		try {
			_localctx = new Expr2_prodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			expr3();
			setState(38);
			expr2_sub();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr2_subContext extends ParserRuleContext {
		public Expr2_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2_sub; }
	 
		public Expr2_subContext() { }
		public void copyFrom(Expr2_subContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr2_sub_concatContext extends Expr2_subContext {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr2_subContext expr2_sub() {
			return getRuleContext(Expr2_subContext.class,0);
		}
		public Expr2_sub_concatContext(Expr2_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr2_sub_concat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr2_sub_concat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr2_sub_concat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr2_sub_deleteContext extends Expr2_subContext {
		public Expr2_sub_deleteContext(Expr2_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr2_sub_delete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr2_sub_delete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr2_sub_delete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr2_subContext expr2_sub() throws RecognitionException {
		Expr2_subContext _localctx = new Expr2_subContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr2_sub);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case CHAR:
			case EPSILON:
				_localctx = new Expr2_sub_concatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				expr3();
				setState(41);
				expr2_sub();
				}
				break;
			case T__0:
			case T__1:
			case T__4:
				_localctx = new Expr2_sub_deleteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr3Context extends ParserRuleContext {
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
	 
		public Expr3Context() { }
		public void copyFrom(Expr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr3_prodContext extends Expr3Context {
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public Expr3_subContext expr3_sub() {
			return getRuleContext(Expr3_subContext.class,0);
		}
		public Expr3_prodContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr3_prod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr3_prod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr3_prod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr3);
		try {
			_localctx = new Expr3_prodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			fact();
			setState(47);
			expr3_sub();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr3_subContext extends ParserRuleContext {
		public Expr3_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3_sub; }
	 
		public Expr3_subContext() { }
		public void copyFrom(Expr3_subContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr3_sub_kleeneContext extends Expr3_subContext {
		public Expr3_sub_kleeneContext(Expr3_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr3_sub_kleene(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr3_sub_kleene(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr3_sub_kleene(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr3_sub_deleteContext extends Expr3_subContext {
		public Expr3_sub_deleteContext(Expr3_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterExpr3_sub_delete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitExpr3_sub_delete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitExpr3_sub_delete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr3_subContext expr3_sub() throws RecognitionException {
		Expr3_subContext _localctx = new Expr3_subContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr3_sub);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new Expr3_sub_kleeneContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__2);
				}
				break;
			case T__0:
			case T__1:
			case T__3:
			case T__4:
			case CHAR:
			case EPSILON:
				_localctx = new Expr3_sub_deleteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactContext extends ParserRuleContext {
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
	 
		public FactContext() { }
		public void copyFrom(FactContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactCharContext extends FactContext {
		public TerminalNode CHAR() { return getToken(RegularExprParser.CHAR, 0); }
		public FactCharContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterFactChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitFactChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitFactChar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactExpr1Context extends FactContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public FactExpr1Context(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterFactExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitFactExpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitFactExpr1(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactEpsilonContext extends FactContext {
		public TerminalNode EPSILON() { return getToken(RegularExprParser.EPSILON, 0); }
		public FactEpsilonContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterFactEpsilon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitFactEpsilon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitFactEpsilon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fact);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR:
				_localctx = new FactCharContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(CHAR);
				}
				break;
			case EPSILON:
				_localctx = new FactEpsilonContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(EPSILON);
				}
				break;
			case T__3:
				_localctx = new FactExpr1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(T__3);
				setState(56);
				expr1();
				setState(57);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringListContext extends ParserRuleContext {
		public StringListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringList; }
	 
		public StringListContext() { }
		public void copyFrom(StringListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringList_prodContext extends StringListContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringList_subContext stringList_sub() {
			return getRuleContext(StringList_subContext.class,0);
		}
		public StringList_prodContext(StringListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterStringList_prod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitStringList_prod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitStringList_prod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringListContext stringList() throws RecognitionException {
		StringListContext _localctx = new StringListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stringList);
		try {
			_localctx = new StringList_prodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			string();
			setState(62);
			stringList_sub();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringList_subContext extends ParserRuleContext {
		public StringList_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringList_sub; }
	 
		public StringList_subContext() { }
		public void copyFrom(StringList_subContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringList_sub_otherStringContext extends StringList_subContext {
		public StringListContext stringList() {
			return getRuleContext(StringListContext.class,0);
		}
		public StringList_sub_otherStringContext(StringList_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterStringList_sub_otherString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitStringList_sub_otherString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitStringList_sub_otherString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringList_sub_deleteContext extends StringList_subContext {
		public StringList_sub_deleteContext(StringList_subContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterStringList_sub_delete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitStringList_sub_delete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitStringList_sub_delete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringList_subContext stringList_sub() throws RecognitionException {
		StringList_subContext _localctx = new StringList_subContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stringList_sub);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new StringList_sub_otherStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(T__0);
				setState(65);
				stringList();
				}
				break;
			case EOF:
				_localctx = new StringList_sub_deleteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class String_deleteContext extends StringContext {
		public String_deleteContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterString_delete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitString_delete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitString_delete(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class String_prodContext extends StringContext {
		public TerminalNode CHAR() { return getToken(RegularExprParser.CHAR, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public String_prodContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).enterString_prod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegularExprListener ) ((RegularExprListener)listener).exitString_prod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExprVisitor ) return ((RegularExprVisitor<? extends T>)visitor).visitString_prod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_string);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR:
				_localctx = new String_prodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(CHAR);
				setState(70);
				string();
				}
				break;
			case EOF:
			case T__0:
				_localctx = new String_deleteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\bK\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002$\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004-\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0003\u00064\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007<\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\tD\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0003\nI\b\n\u0001\n\u0000\u0000\u000b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000F\u0000\u0016\u0001"+
		"\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0004#\u0001\u0000"+
		"\u0000\u0000\u0006%\u0001\u0000\u0000\u0000\b,\u0001\u0000\u0000\u0000"+
		"\n.\u0001\u0000\u0000\u0000\f3\u0001\u0000\u0000\u0000\u000e;\u0001\u0000"+
		"\u0000\u0000\u0010=\u0001\u0000\u0000\u0000\u0012C\u0001\u0000\u0000\u0000"+
		"\u0014H\u0001\u0000\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017"+
		"\u0018\u0005\u0001\u0000\u0000\u0018\u0019\u0003\u0010\b\u0000\u0019\u001a"+
		"\u0005\u0000\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0003\u0006\u0003\u0000\u001c\u001d\u0003\u0004\u0002\u0000\u001d\u0003"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0002\u0000\u0000\u001f \u0003"+
		"\u0006\u0003\u0000 !\u0003\u0004\u0002\u0000!$\u0001\u0000\u0000\u0000"+
		"\"$\u0001\u0000\u0000\u0000#\u001e\u0001\u0000\u0000\u0000#\"\u0001\u0000"+
		"\u0000\u0000$\u0005\u0001\u0000\u0000\u0000%&\u0003\n\u0005\u0000&\'\u0003"+
		"\b\u0004\u0000\'\u0007\u0001\u0000\u0000\u0000()\u0003\n\u0005\u0000)"+
		"*\u0003\b\u0004\u0000*-\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000"+
		",(\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\t\u0001\u0000\u0000"+
		"\u0000./\u0003\u000e\u0007\u0000/0\u0003\f\u0006\u00000\u000b\u0001\u0000"+
		"\u0000\u000014\u0005\u0003\u0000\u000024\u0001\u0000\u0000\u000031\u0001"+
		"\u0000\u0000\u000032\u0001\u0000\u0000\u00004\r\u0001\u0000\u0000\u0000"+
		"5<\u0005\u0006\u0000\u00006<\u0005\u0007\u0000\u000078\u0005\u0004\u0000"+
		"\u000089\u0003\u0002\u0001\u00009:\u0005\u0005\u0000\u0000:<\u0001\u0000"+
		"\u0000\u0000;5\u0001\u0000\u0000\u0000;6\u0001\u0000\u0000\u0000;7\u0001"+
		"\u0000\u0000\u0000<\u000f\u0001\u0000\u0000\u0000=>\u0003\u0014\n\u0000"+
		">?\u0003\u0012\t\u0000?\u0011\u0001\u0000\u0000\u0000@A\u0005\u0001\u0000"+
		"\u0000AD\u0003\u0010\b\u0000BD\u0001\u0000\u0000\u0000C@\u0001\u0000\u0000"+
		"\u0000CB\u0001\u0000\u0000\u0000D\u0013\u0001\u0000\u0000\u0000EF\u0005"+
		"\u0006\u0000\u0000FI\u0003\u0014\n\u0000GI\u0001\u0000\u0000\u0000HE\u0001"+
		"\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000I\u0015\u0001\u0000\u0000"+
		"\u0000\u0006#,3;CH";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}