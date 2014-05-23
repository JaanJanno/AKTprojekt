package gen;

// Generated from /home/jaan/Documents/Java/AKTprojekt/grammar/ASM.g4 by ANTLR 4.x
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ASMLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, Operator=4, RegisterValue=5, RegisterPointer=6, 
		SpecialValue=7, Label=8, NumberLiteral=9, Whitespace=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'+'", "'['", "Operator", "RegisterValue", "RegisterPointer", "SpecialValue", 
		"Label", "NumberLiteral", "Whitespace"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "Operator", "RegisterValue", "RegisterPointer", 
		"SpecialValue", "Label", "NumberLiteral", "Whitespace"
	};


	public ASMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ASM.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f\u009f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5a\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7w\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u0084\n\b\3\t\3\t\7\t\u0088\n\t\f\t\16\t\u008b"+
		"\13\t\3\t\3\t\3\n\3\n\7\n\u0091\n\n\f\n\16\n\u0094\13\n\3\n\5\n\u0097"+
		"\n\n\3\13\6\13\u009a\n\13\r\13\16\13\u009b\3\13\3\13\2\2\f\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\4\4\2CEZ\\\6\2\13\f\17\17\"\"."+
		".\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3"+
		"\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t`\3\2\2\2\13b\3\2\2\2\rv\3\2\2\2\17"+
		"\u0083\3\2\2\2\21\u0085\3\2\2\2\23\u0096\3\2\2\2\25\u0099\3\2\2\2\27\30"+
		"\7_\2\2\30\4\3\2\2\2\31\32\7-\2\2\32\6\3\2\2\2\33\34\7]\2\2\34\b\3\2\2"+
		"\2\35\36\7O\2\2\36\37\7Q\2\2\37a\7X\2\2 !\7C\2\2!\"\7F\2\2\"a\7F\2\2#"+
		"$\7U\2\2$%\7W\2\2%a\7D\2\2&\'\7O\2\2\'(\7W\2\2(a\7N\2\2)*\7F\2\2*+\7K"+
		"\2\2+a\7X\2\2,-\7O\2\2-.\7Q\2\2.a\7F\2\2/\60\7C\2\2\60\61\7P\2\2\61a\7"+
		"F\2\2\62\63\7Q\2\2\63a\7T\2\2\64\65\7Z\2\2\65\66\7Q\2\2\66a\7T\2\2\67"+
		"8\7K\2\289\7H\2\29a\7G\2\2:;\7K\2\2;<\7H\2\2<a\7P\2\2=>\7K\2\2>?\7H\2"+
		"\2?a\7I\2\2@A\7K\2\2AB\7H\2\2Ba\7N\2\2CD\7K\2\2DE\7H\2\2EF\7I\2\2Fa\7"+
		"G\2\2GH\7K\2\2HI\7H\2\2IJ\7N\2\2Ja\7G\2\2KL\7R\2\2LM\7W\2\2MN\7U\2\2N"+
		"a\7J\2\2OP\7P\2\2PQ\7Q\2\2Qa\7V\2\2RS\7U\2\2ST\7J\2\2Ta\7T\2\2UV\7U\2"+
		"\2VW\7J\2\2Wa\7N\2\2XY\7R\2\2YZ\7Q\2\2Za\7R\2\2[\\\7U\2\2\\a\7F\2\2]^"+
		"\7F\2\2^_\7C\2\2_a\7V\2\2`\35\3\2\2\2` \3\2\2\2`#\3\2\2\2`&\3\2\2\2`)"+
		"\3\2\2\2`,\3\2\2\2`/\3\2\2\2`\62\3\2\2\2`\64\3\2\2\2`\67\3\2\2\2`:\3\2"+
		"\2\2`=\3\2\2\2`@\3\2\2\2`C\3\2\2\2`G\3\2\2\2`K\3\2\2\2`O\3\2\2\2`R\3\2"+
		"\2\2`U\3\2\2\2`X\3\2\2\2`[\3\2\2\2`]\3\2\2\2a\n\3\2\2\2bc\t\2\2\2c\f\3"+
		"\2\2\2de\7]\2\2ef\7C\2\2fw\7_\2\2gh\7]\2\2hi\7D\2\2iw\7_\2\2jk\7]\2\2"+
		"kl\7E\2\2lw\7_\2\2mn\7]\2\2no\7Z\2\2ow\7_\2\2pq\7]\2\2qr\7[\2\2rw\7_\2"+
		"\2st\7]\2\2tu\7\\\2\2uw\7_\2\2vd\3\2\2\2vg\3\2\2\2vj\3\2\2\2vm\3\2\2\2"+
		"vp\3\2\2\2vs\3\2\2\2w\16\3\2\2\2xy\7U\2\2y\u0084\7R\2\2z{\7R\2\2{\u0084"+
		"\7E\2\2|}\7R\2\2}~\7G\2\2~\177\7G\2\2\177\u0084\7M\2\2\u0080\u0081\7R"+
		"\2\2\u0081\u0082\7Q\2\2\u0082\u0084\7R\2\2\u0083x\3\2\2\2\u0083z\3\2\2"+
		"\2\u0083|\3\2\2\2\u0083\u0080\3\2\2\2\u0084\20\3\2\2\2\u0085\u0089\7<"+
		"\2\2\u0086\u0088\13\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008c\u008d\7<\2\2\u008d\22\3\2\2\2\u008e\u0092\4\63;\2\u008f\u0091"+
		"\4\62;\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0097\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\7\62"+
		"\2\2\u0096\u008e\3\2\2\2\u0096\u0095\3\2\2\2\u0097\24\3\2\2\2\u0098\u009a"+
		"\t\3\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\13\2\2\u009e\26\3\2\2"+
		"\2\n\2`v\u0083\u0089\u0092\u0096\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}