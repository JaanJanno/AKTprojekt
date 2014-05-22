package gen;

// Generated from C:/Users/Juhan/Documents/GitHub/AKTprojekt/grammar\ASM.g4 by ANTLR 4.x
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ASMParser}.
 */
public interface ASMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ASMParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull ASMParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull ASMParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull ASMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull ASMParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ASMParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ASMParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#pointer}.
	 * @param ctx the parse tree
	 */
	void enterPointer(@NotNull ASMParser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#pointer}.
	 * @param ctx the parse tree
	 */
	void exitPointer(@NotNull ASMParser.PointerContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(@NotNull ASMParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(@NotNull ASMParser.LabelContext ctx);
}