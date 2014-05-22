// Generated from C:/Users/Juhan/Documents/GitHub/AKTprojekt/grammar\ASM.g4 by ANTLR 4.x
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
		SpecialValue=7, Label=8, NumberLiteral=9, Whitespace=10;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'+'", "'['", "Operator", "RegisterValue", "RegisterPointer", 
		"SpecialValue", "Label", "NumberLiteral", "Whitespace"
	};
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_value = 2, RULE_label = 3, 
		RULE_pointer = 4;
	public static final String[] ruleNames = {
		"program", "statement", "value", "label", "pointer"
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
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(12);
			switch (_input.LA(1)) {
			case Operator:
				{
				setState(10); statement();
				}
				break;
			case Label:
				{
				setState(11); label();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operator || _la==Label) {
				{
				setState(16);
				switch (_input.LA(1)) {
				case Operator:
					{
					setState(14); statement();
					}
					break;
				case Label:
					{
					setState(15); label();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(21); match(EOF);
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
			setState(23); match(Operator);
			setState(28);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << RegisterValue) | (1L << RegisterPointer) | (1L << NumberLiteral))) != 0)) {
				{
				setState(24); value();
				setState(26);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << RegisterValue) | (1L << RegisterPointer) | (1L << NumberLiteral))) != 0)) {
					{
					setState(25); value();
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
		public TerminalNode NumberLiteral() { return getToken(ASMParser.NumberLiteral, 0); }
		public TerminalNode RegisterValue() { return getToken(ASMParser.RegisterValue, 0); }
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TerminalNode RegisterPointer() { return getToken(ASMParser.RegisterPointer, 0); }
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
			setState(34);
			switch (_input.LA(1)) {
			case RegisterValue:
				enterOuterAlt(_localctx, 1);
				{
				setState(30); match(RegisterValue);
				}
				break;
			case RegisterPointer:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); match(RegisterPointer);
				}
				break;
			case NumberLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(32); match(NumberLiteral);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(33); pointer();
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
		enterRule(_localctx, 6, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(Label);
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
		public TerminalNode NumberLiteral() { return getToken(ASMParser.NumberLiteral, 0); }
		public TerminalNode RegisterValue() { return getToken(ASMParser.RegisterValue, 0); }
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMListener ) ((ASMListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASMVisitor ) return ((ASMVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pointer);
		try {
			setState(46);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); match(3);
				setState(39); match(RegisterValue);
				setState(40); match(2);
				setState(41); match(NumberLiteral);
				setState(42); match(1);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); match(3);
				setState(44); match(NumberLiteral);
				setState(45); match(1);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f\63\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\5\2\17\n\2\3\2\3\2\7\2\23\n\2\f\2"+
		"\16\2\26\13\2\3\2\3\2\3\3\3\3\3\3\5\3\35\n\3\5\3\37\n\3\3\4\3\4\3\4\3"+
		"\4\5\4%\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\61\n\6\3\6\2\2"+
		"\7\2\4\6\b\n\2\2\66\2\16\3\2\2\2\4\31\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n"+
		"\60\3\2\2\2\f\17\5\4\3\2\r\17\5\b\5\2\16\f\3\2\2\2\16\r\3\2\2\2\17\24"+
		"\3\2\2\2\20\23\5\4\3\2\21\23\5\b\5\2\22\20\3\2\2\2\22\21\3\2\2\2\23\26"+
		"\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\27\3\2\2\2\26\24\3\2\2\2\27\30"+
		"\7\2\2\3\30\3\3\2\2\2\31\36\7\6\2\2\32\34\5\6\4\2\33\35\5\6\4\2\34\33"+
		"\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\32\3\2\2\2\36\37\3\2\2\2\37\5"+
		"\3\2\2\2 %\7\7\2\2!%\7\b\2\2\"%\7\13\2\2#%\5\n\6\2$ \3\2\2\2$!\3\2\2\2"+
		"$\"\3\2\2\2$#\3\2\2\2%\7\3\2\2\2&\'\7\n\2\2\'\t\3\2\2\2()\7\5\2\2)*\7"+
		"\7\2\2*+\7\4\2\2+,\7\13\2\2,\61\7\3\2\2-.\7\5\2\2./\7\13\2\2/\61\7\3\2"+
		"\2\60(\3\2\2\2\60-\3\2\2\2\61\13\3\2\2\2\t\16\22\24\34\36$\60";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}