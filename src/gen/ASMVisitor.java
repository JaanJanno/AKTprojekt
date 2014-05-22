package gen;

// Generated from C:/Users/Juhan/Documents/GitHub/AKTprojekt/grammar\ASM.g4 by ANTLR 4.x
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
	 * Visit a parse tree produced by {@link ASMParser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(@NotNull ASMParser.PointerContext ctx);

	/**
	 * Visit a parse tree produced by {@link ASMParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(@NotNull ASMParser.LabelContext ctx);
}