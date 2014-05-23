package gen;

// Generated from /home/jaan/Documents/Java/AKTprojekt/grammar/ASM.g4 by ANTLR 4.x
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
	 * Enter a parse tree produced by {@link ASMParser#registerValue}.
	 * @param ctx the parse tree
	 */
	void enterRegisterValue(@NotNull ASMParser.RegisterValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#registerValue}.
	 * @param ctx the parse tree
	 */
	void exitRegisterValue(@NotNull ASMParser.RegisterValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#poinerNum}.
	 * @param ctx the parse tree
	 */
	void enterPoinerNum(@NotNull ASMParser.PoinerNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#poinerNum}.
	 * @param ctx the parse tree
	 */
	void exitPoinerNum(@NotNull ASMParser.PoinerNumContext ctx);

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
	 * Enter a parse tree produced by {@link ASMParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(@NotNull ASMParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(@NotNull ASMParser.LabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#pointerNumPlusReg}.
	 * @param ctx the parse tree
	 */
	void enterPointerNumPlusReg(@NotNull ASMParser.PointerNumPlusRegContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#pointerNumPlusReg}.
	 * @param ctx the parse tree
	 */
	void exitPointerNumPlusReg(@NotNull ASMParser.PointerNumPlusRegContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#registerPointer}.
	 * @param ctx the parse tree
	 */
	void enterRegisterPointer(@NotNull ASMParser.RegisterPointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#registerPointer}.
	 * @param ctx the parse tree
	 */
	void exitRegisterPointer(@NotNull ASMParser.RegisterPointerContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASMParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull ASMParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull ASMParser.LiteralContext ctx);
}