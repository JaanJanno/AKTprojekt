package gen;

// Generated from /home/jaan/Documents/Java/AKTprojekt/grammar/ASM.g4 by ANTLR 4.x
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ASMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ASMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ASMParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull ASMParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#labelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDeclaration(@NotNull ASMParser.LabelDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#registerValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegisterValue(@NotNull ASMParser.RegisterValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#poinerNum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoinerNum(@NotNull ASMParser.PoinerNumContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull ASMParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull ASMParser.ValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(@NotNull ASMParser.LabelContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#pointerNumPlusReg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerNumPlusReg(@NotNull ASMParser.PointerNumPlusRegContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#registerPointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegisterPointer(@NotNull ASMParser.RegisterPointerContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull ASMParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#specialVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialVal(@NotNull ASMParser.SpecialValContext ctx);
}