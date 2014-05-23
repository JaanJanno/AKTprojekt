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
		SpecialValue=7, Label=8, LabelDeclaration=9, NumberLiteral=10, Whitespace=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'+'", "'['", "Operator", "RegisterValue", "RegisterPointer", "SpecialValue", 
		"Label", "LabelDeclaration", "NumberLiteral", "Whitespace"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "Operator", "RegisterValue", "RegisterPointer", 
		"SpecialValue", "Label", "LabelDeclaration", "NumberLiteral", "Whitespace"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\r\u00ab\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5d\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7z\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0087\n\b\3\t\3\t\7\t\u008b\n\t"+
		"\f\t\16\t\u008e\13\t\3\t\3\t\3\n\3\n\7\n\u0094\n\n\f\n\16\n\u0097\13\n"+
		"\3\n\3\n\3\13\3\13\7\13\u009d\n\13\f\13\16\13\u00a0\13\13\3\13\5\13\u00a3"+
		"\n\13\3\f\6\f\u00a6\n\f\r\f\16\f\u00a7\3\f\3\f\4\u008c\u0095\2\r\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\4\4\2CEZ\\\6\2\13\f"+
		"\17\17\"\"..\u00cc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\tc\3\2\2\2\13e"+
		"\3\2\2\2\ry\3\2\2\2\17\u0086\3\2\2\2\21\u0088\3\2\2\2\23\u0091\3\2\2\2"+
		"\25\u00a2\3\2\2\2\27\u00a5\3\2\2\2\31\32\7_\2\2\32\4\3\2\2\2\33\34\7-"+
		"\2\2\34\6\3\2\2\2\35\36\7]\2\2\36\b\3\2\2\2\37 \7O\2\2 !\7Q\2\2!d\7X\2"+
		"\2\"#\7C\2\2#$\7F\2\2$d\7F\2\2%&\7U\2\2&\'\7W\2\2\'d\7D\2\2()\7O\2\2)"+
		"*\7W\2\2*d\7N\2\2+,\7F\2\2,-\7K\2\2-d\7X\2\2./\7O\2\2/\60\7Q\2\2\60d\7"+
		"F\2\2\61\62\7C\2\2\62\63\7P\2\2\63d\7F\2\2\64\65\7Q\2\2\65d\7T\2\2\66"+
		"\67\7Z\2\2\678\7Q\2\28d\7T\2\29:\7K\2\2:;\7H\2\2;d\7G\2\2<=\7K\2\2=>\7"+
		"H\2\2>d\7P\2\2?@\7K\2\2@A\7H\2\2Ad\7I\2\2BC\7K\2\2CD\7H\2\2Dd\7N\2\2E"+
		"F\7K\2\2FG\7H\2\2GH\7I\2\2Hd\7G\2\2IJ\7K\2\2JK\7H\2\2KL\7N\2\2Ld\7G\2"+
		"\2MN\7R\2\2NO\7W\2\2OP\7U\2\2Pd\7J\2\2QR\7P\2\2RS\7Q\2\2Sd\7V\2\2TU\7"+
		"U\2\2UV\7J\2\2Vd\7T\2\2WX\7U\2\2XY\7J\2\2Yd\7N\2\2Z[\7G\2\2[\\\7R\2\2"+
		"\\]\7Q\2\2]d\7R\2\2^_\7U\2\2_d\7F\2\2`a\7F\2\2ab\7C\2\2bd\7V\2\2c\37\3"+
		"\2\2\2c\"\3\2\2\2c%\3\2\2\2c(\3\2\2\2c+\3\2\2\2c.\3\2\2\2c\61\3\2\2\2"+
		"c\64\3\2\2\2c\66\3\2\2\2c9\3\2\2\2c<\3\2\2\2c?\3\2\2\2cB\3\2\2\2cE\3\2"+
		"\2\2cI\3\2\2\2cM\3\2\2\2cQ\3\2\2\2cT\3\2\2\2cW\3\2\2\2cZ\3\2\2\2c^\3\2"+
		"\2\2c`\3\2\2\2d\n\3\2\2\2ef\t\2\2\2f\f\3\2\2\2gh\7]\2\2hi\7C\2\2iz\7_"+
		"\2\2jk\7]\2\2kl\7D\2\2lz\7_\2\2mn\7]\2\2no\7E\2\2oz\7_\2\2pq\7]\2\2qr"+
		"\7Z\2\2rz\7_\2\2st\7]\2\2tu\7[\2\2uz\7_\2\2vw\7]\2\2wx\7\\\2\2xz\7_\2"+
		"\2yg\3\2\2\2yj\3\2\2\2ym\3\2\2\2yp\3\2\2\2ys\3\2\2\2yv\3\2\2\2z\16\3\2"+
		"\2\2{|\7U\2\2|\u0087\7R\2\2}~\7R\2\2~\u0087\7E\2\2\177\u0080\7R\2\2\u0080"+
		"\u0081\7G\2\2\u0081\u0082\7G\2\2\u0082\u0087\7M\2\2\u0083\u0084\7R\2\2"+
		"\u0084\u0085\7Q\2\2\u0085\u0087\7R\2\2\u0086{\3\2\2\2\u0086}\3\2\2\2\u0086"+
		"\177\3\2\2\2\u0086\u0083\3\2\2\2\u0087\20\3\2\2\2\u0088\u008c\7<\2\2\u0089"+
		"\u008b\13\2\2\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008d\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0090\7<\2\2\u0090\22\3\2\2\2\u0091\u0095\7a\2\2\u0092\u0094\13\2\2\2"+
		"\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0096\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7a\2\2\u0099"+
		"\24\3\2\2\2\u009a\u009e\4\63;\2\u009b\u009d\4\62;\2\u009c\u009b\3\2\2"+
		"\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a3"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\7\62\2\2\u00a2\u009a\3\2\2\2"+
		"\u00a2\u00a1\3\2\2\2\u00a3\26\3\2\2\2\u00a4\u00a6\t\3\2\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\b\f\2\2\u00aa\30\3\2\2\2\13\2cy\u0086\u008c"+
		"\u0095\u009e\u00a2\u00a7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}