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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\r\u00aa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5c\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7y\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0086\n\b\3\t\3\t\7\t\u008a\n\t\f\t"+
		"\16\t\u008d\13\t\3\t\3\t\3\n\3\n\7\n\u0093\n\n\f\n\16\n\u0096\13\n\3\n"+
		"\3\n\3\13\3\13\7\13\u009c\n\13\f\13\16\13\u009f\13\13\3\13\5\13\u00a2"+
		"\n\13\3\f\6\f\u00a5\n\f\r\f\16\f\u00a6\3\f\3\f\4\u008b\u0094\2\r\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\4\4\2CEZ\\\6\2\13\f"+
		"\17\17\"\"..\u00cb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\tb\3\2\2\2\13d"+
		"\3\2\2\2\rx\3\2\2\2\17\u0085\3\2\2\2\21\u0087\3\2\2\2\23\u0090\3\2\2\2"+
		"\25\u00a1\3\2\2\2\27\u00a4\3\2\2\2\31\32\7_\2\2\32\4\3\2\2\2\33\34\7-"+
		"\2\2\34\6\3\2\2\2\35\36\7]\2\2\36\b\3\2\2\2\37 \7O\2\2 !\7Q\2\2!c\7X\2"+
		"\2\"#\7C\2\2#$\7F\2\2$c\7F\2\2%&\7U\2\2&\'\7W\2\2\'c\7D\2\2()\7O\2\2)"+
		"*\7W\2\2*c\7N\2\2+,\7F\2\2,-\7K\2\2-c\7X\2\2./\7O\2\2/\60\7Q\2\2\60c\7"+
		"F\2\2\61\62\7C\2\2\62\63\7P\2\2\63c\7F\2\2\64\65\7Q\2\2\65c\7T\2\2\66"+
		"\67\7Z\2\2\678\7Q\2\28c\7T\2\29:\7K\2\2:;\7H\2\2;c\7G\2\2<=\7K\2\2=>\7"+
		"H\2\2>c\7P\2\2?@\7K\2\2@A\7H\2\2Ac\7I\2\2BC\7K\2\2CD\7H\2\2Dc\7N\2\2E"+
		"F\7K\2\2FG\7H\2\2GH\7I\2\2Hc\7G\2\2IJ\7K\2\2JK\7H\2\2KL\7N\2\2Lc\7G\2"+
		"\2MN\7R\2\2NO\7W\2\2OP\7U\2\2Pc\7J\2\2QR\7P\2\2RS\7Q\2\2Sc\7V\2\2TU\7"+
		"U\2\2UV\7J\2\2Vc\7T\2\2WX\7U\2\2XY\7J\2\2Yc\7N\2\2Z[\7R\2\2[\\\7Q\2\2"+
		"\\c\7R\2\2]^\7U\2\2^c\7F\2\2_`\7F\2\2`a\7C\2\2ac\7V\2\2b\37\3\2\2\2b\""+
		"\3\2\2\2b%\3\2\2\2b(\3\2\2\2b+\3\2\2\2b.\3\2\2\2b\61\3\2\2\2b\64\3\2\2"+
		"\2b\66\3\2\2\2b9\3\2\2\2b<\3\2\2\2b?\3\2\2\2bB\3\2\2\2bE\3\2\2\2bI\3\2"+
		"\2\2bM\3\2\2\2bQ\3\2\2\2bT\3\2\2\2bW\3\2\2\2bZ\3\2\2\2b]\3\2\2\2b_\3\2"+
		"\2\2c\n\3\2\2\2de\t\2\2\2e\f\3\2\2\2fg\7]\2\2gh\7C\2\2hy\7_\2\2ij\7]\2"+
		"\2jk\7D\2\2ky\7_\2\2lm\7]\2\2mn\7E\2\2ny\7_\2\2op\7]\2\2pq\7Z\2\2qy\7"+
		"_\2\2rs\7]\2\2st\7[\2\2ty\7_\2\2uv\7]\2\2vw\7\\\2\2wy\7_\2\2xf\3\2\2\2"+
		"xi\3\2\2\2xl\3\2\2\2xo\3\2\2\2xr\3\2\2\2xu\3\2\2\2y\16\3\2\2\2z{\7U\2"+
		"\2{\u0086\7R\2\2|}\7R\2\2}\u0086\7E\2\2~\177\7R\2\2\177\u0080\7G\2\2\u0080"+
		"\u0081\7G\2\2\u0081\u0086\7M\2\2\u0082\u0083\7R\2\2\u0083\u0084\7Q\2\2"+
		"\u0084\u0086\7R\2\2\u0085z\3\2\2\2\u0085|\3\2\2\2\u0085~\3\2\2\2\u0085"+
		"\u0082\3\2\2\2\u0086\20\3\2\2\2\u0087\u008b\7<\2\2\u0088\u008a\13\2\2"+
		"\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u008c\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7<\2\2\u008f"+
		"\22\3\2\2\2\u0090\u0094\7a\2\2\u0091\u0093\13\2\2\2\u0092\u0091\3\2\2"+
		"\2\u0093\u0096\3\2\2\2\u0094\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7a\2\2\u0098\24\3\2\2\2\u0099"+
		"\u009d\4\63;\2\u009a\u009c\4\62;\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a2\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u00a0\u00a2\7\62\2\2\u00a1\u0099\3\2\2\2\u00a1\u00a0\3"+
		"\2\2\2\u00a2\26\3\2\2\2\u00a3\u00a5\t\3\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00a9\b\f\2\2\u00a9\30\3\2\2\2\13\2bx\u0085\u008b\u0094\u009d"+
		"\u00a1\u00a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}