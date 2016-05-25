// Generated from Antlr4.g4 by ANTLR 4.4
package at.jku.weiner.antlr4;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import at.jku.weiner.antlr4.Antlr4Parser.HelloWorldContext;

/**
 * This class provides an empty implementation of {@link Antlr4Listener},
 * which can be extended to create a listener which only needs to handle a
 * subset
 * of the available methods.
 */
public class Antlr4MyListener extends Antlr4BaseListener {
	private final StringBuffer	buffer;
	
	public Antlr4MyListener() {
		this.buffer = new StringBuffer();
		this.buffer.append("\n");
	}
	
	@Override
	public String toString() {
		final String result = this.buffer.toString();
		return result;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAntlr4(@NotNull final Antlr4Parser.Antlr4Context ctx) {
		this.buffer.append("rule antlr4!\n");
		final List<HelloWorldContext> list = ctx.helloWorld();
		this.buffer.append("list='" + list + "'\n");
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterHelloWorld(
			@NotNull final Antlr4Parser.HelloWorldContext ctx) {
		
		this.buffer.append("rule helloWorld!\n");
		// this.buffer.append("text='" + ctx.getText() + "'\n");
		final TerminalNode id = ctx.ID();
		this.buffer.append("id='" + id + "'\n");
	}
	
}
