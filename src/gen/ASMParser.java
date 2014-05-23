package gen;

// Generated from /home/jaan/Documents/Java/AKTprojekt/grammar/ASM.g4 by ANTLR 4.x
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ASMParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, Operator=4, RegisterValue=5, RegisterPointer=6, 
		SpecialValue=7, Label=8, LabelDeclaration=9, NumberLiteral=10, Whitespace=11;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'+'", "'['", "Operator", "RegisterValue", "RegisterPointer", 
		"SpecialValue", "Label", "LabelDeclaration", "NumberLiteral", "Whitespace"
	};
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_value = 2, RULE_specialVal = 3, 
		RULE_literal = 4, RULE_register = 5, RULE_label = 6, RULE_labelDeclaration = 7, 
		RULE_pointer = 8;
	public static final String[] ruleNames = {
		"program", "statement", "value", "specialVal", "literal", "register", 
		"label", "labelDeclaration", "pointer"
	};

	@Override
	public String getGrammarFileName() { return "ASM.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ASMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode EOF() { return getToken(ASMParser.EOF, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LabelDeclarationContext> labelDeclaration() {
			return getRuleContexts(LabelDeclarationContext.class);
		}
		public LabelDeclarationContext labelDeclaration(int i) {
			return getRuleContext(LabelDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operator || _la==LabelDeclaration) {
				{
				setState(20);
				switch (_input.LA(1)) {
				case Operator:
					{
					setState(18); statement();
					}
					break;
				case LabelDeclaration:
					{
					setState(19); labelDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25); match(EOF);
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

	public static class StatementContext extends ParserRuleContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode Operator() { return getToken(ASMParser.Operator, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); match(Operator);
			setState(32);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << RegisterValue) | (1L << RegisterPointer) | (1L << SpecialValue) | (1L << Label) | (1L << NumberLiteral))) != 0)) {
				{
				setState(28); value();
				setState(30);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << RegisterValue) | (1L << RegisterPointer) | (1L << SpecialValue) | (1L << Label) | (1L << NumberLiteral))) != 0)) {
					{
					setState(29); value();
					}
				}

				}
			}

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

	public static class ValueContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public SpecialValContext specialVal() {
			return getRuleContext(SpecialValContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_value);
		try {
			setState(39);
			switch (_input.LA(1)) {
			case RegisterValue:
			case RegisterPointer:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); register();
				}
				break;
			case NumberLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(35); literal();
				}
				break;
			case Label:
				enterOuterAlt(_localctx, 3);
				{
				setState(36); label();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(37); pointer();
				}
				break;
			case SpecialValue:
				enterOuterAlt(_localctx, 5);
				{
				setState(38); specialVal();
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

	public static class SpecialValContext extends ParserRuleContext {
		public TerminalNode SpecialValue() { return getToken(ASMParser.SpecialValue, 0); }
		public SpecialValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterSpecialVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitSpecialVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitSpecialVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialValContext specialVal() throws RecognitionException {
		SpecialValContext _localctx = new SpecialValContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_specialVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); match(SpecialValue);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NumberLiteral() { return getToken(ASMParser.NumberLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(NumberLiteral);
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

	public static class RegisterContext extends ParserRuleContext {
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
	 
		public RegisterContext() { }
		public void copyFrom(RegisterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RegisterValueContext extends RegisterContext {
		public TerminalNode RegisterValue() { return getToken(ASMParser.RegisterValue, 0); }
		public RegisterValueContext(RegisterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterRegisterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitRegisterValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitRegisterValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RegisterPointerContext extends RegisterContext {
		public TerminalNode RegisterPointer() { return getToken(ASMParser.RegisterPointer, 0); }
		public RegisterPointerContext(RegisterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterRegisterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitRegisterPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitRegisterPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_register);
		try {
			setState(47);
			switch (_input.LA(1)) {
			case RegisterValue:
				_localctx = new RegisterValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45); match(RegisterValue);
				}
				break;
			case RegisterPointer:
				_localctx = new RegisterPointerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46); match(RegisterPointer);
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode Label() { return getToken(ASMParser.Label, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(Label);
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

	public static class LabelDeclarationContext extends ParserRuleContext {
		public TerminalNode LabelDeclaration() { return getToken(ASMParser.LabelDeclaration, 0); }
		public LabelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterLabelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitLabelDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitLabelDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelDeclarationContext labelDeclaration() throws RecognitionException {
		LabelDeclarationContext _localctx = new LabelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_labelDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(LabelDeclaration);
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

	public static class PointerContext extends ParserRuleContext {
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
	 
		public PointerContext() { }
		public void copyFrom(PointerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PoinerNumContext extends PointerContext {
		public TerminalNode NumberLiteral() { return getToken(ASMParser.NumberLiteral, 0); }
		public PoinerNumContext(PointerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterPoinerNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitPoinerNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitPoinerNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PointerNumPlusRegContext extends PointerContext {
		public TerminalNode NumberLiteral() { return getToken(ASMParser.NumberLiteral, 0); }
		public TerminalNode RegisterValue() { return getToken(ASMParser.RegisterValue, 0); }
		public PointerNumPlusRegContext(PointerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterPointerNumPlusReg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitPointerNumPlusReg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitPointerNumPlusReg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pointer);
		try {
			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new PointerNumPlusRegContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53); match(3);
				setState(54); match(RegisterValue);
				setState(55); match(2);
				setState(56); match(NumberLiteral);
				setState(57); match(1);
				}
				break;

			case 2:
				_localctx = new PoinerNumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58); match(3);
				setState(59); match(NumberLiteral);
				setState(60); match(1);
				}
				break;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\rB\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\3\3\3\3\3\5\3!\n\3\5\3#\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\6\3\6\3\7\3\7\5\7\62\n\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n@\n\n\3\n\2\2\13\2\4\6\b\n\f\16"+
		"\20\22\2\2B\2\30\3\2\2\2\4\35\3\2\2\2\6)\3\2\2\2\b+\3\2\2\2\n-\3\2\2\2"+
		"\f\61\3\2\2\2\16\63\3\2\2\2\20\65\3\2\2\2\22?\3\2\2\2\24\27\5\4\3\2\25"+
		"\27\5\20\t\2\26\24\3\2\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30"+
		"\31\3\2\2\2\31\33\3\2\2\2\32\30\3\2\2\2\33\34\7\2\2\3\34\3\3\2\2\2\35"+
		"\"\7\6\2\2\36 \5\6\4\2\37!\5\6\4\2 \37\3\2\2\2 !\3\2\2\2!#\3\2\2\2\"\36"+
		"\3\2\2\2\"#\3\2\2\2#\5\3\2\2\2$*\5\f\7\2%*\5\n\6\2&*\5\16\b\2\'*\5\22"+
		"\n\2(*\5\b\5\2)$\3\2\2\2)%\3\2\2\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\7\3"+
		"\2\2\2+,\7\t\2\2,\t\3\2\2\2-.\7\f\2\2.\13\3\2\2\2/\62\7\7\2\2\60\62\7"+
		"\b\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\r\3\2\2\2\63\64\7\n\2\2\64\17\3\2"+
		"\2\2\65\66\7\13\2\2\66\21\3\2\2\2\678\7\5\2\289\7\7\2\29:\7\4\2\2:;\7"+
		"\f\2\2;@\7\3\2\2<=\7\5\2\2=>\7\f\2\2>@\7\3\2\2?\67\3\2\2\2?<\3\2\2\2@"+
		"\23\3\2\2\2\t\26\30 \")\61?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}