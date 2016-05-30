package at.jku.weiner.antlr4.utils.tests;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.antlr4.utils.GeneratorUtils;
import at.jku.weiner.log.MyLog;

public class GeneratorUtilsRunAntlr4Tool {
	
	private static final String PKG_NAME = "generated";
	private static final String MY_FILENAME = "My4.g4";
	private static final String TEST_PROJECT_NAME = "MyAntlr4ToolProject";
	private IProgressMonitor monitor;
	private IProject myTestProject;
	private InputStream in;
	private IFile file;
	private IFolder genFolder;
	
	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.monitor = new NullProgressMonitor();
		this.myTestProject = GeneratorUtils.reCreateProject(
				GeneratorUtilsRunAntlr4Tool.TEST_PROJECT_NAME, this.monitor);
		final StringBuffer buffer = new StringBuffer("grammar My4;\n");
		buffer.append("antlr4: helloWorld+;\n");
		buffer.append("helloWorld: 'Hello' ID;\n");
		buffer.append("ID: [a-zA-Z]+;\n");
		buffer.append("WS: [ \\t\\r\\n]+ -> skip;\n");
		buffer.append("\n");
		final String string = buffer.toString();
		this.in = GeneratorUtils.convertStringToStream(string);
		this.file = this.myTestProject
				.getFile(GeneratorUtilsRunAntlr4Tool.MY_FILENAME);
		this.file.create(this.in, true, this.monitor);
		this.genFolder = this.myTestProject
				.getFolder(GeneratorUtilsRunAntlr4Tool.PKG_NAME);
		this.genFolder.create(true, true, this.monitor);
	}
	
	@Test
	public void testRunAntlr4Tool1() throws Exception {
		// prepare test
		final String fileName = GeneratorUtils
				.getAbsoluteFileNameFor(this.file);
		Assert.assertNotNull(fileName);
		final String genFolderName = GeneratorUtils
				.getAbsoluteFileNameFor(this.genFolder);
		Assert.assertNotNull(genFolderName);
		// run test
		final int result = GeneratorUtils.runAntlr4Tool(
				GeneratorUtilsRunAntlr4Tool.PKG_NAME, fileName, genFolderName);
		Assert.assertEquals(0, result);
		this.myTestProject.refreshLocal(IResource.DEPTH_INFINITE, this.monitor);
		Assert.assertTrue(this.genFolder.exists());
		final IResource[] members = this.genFolder.members();
		Assert.assertNotNull(members);
		Assert.assertEquals(8, this.genFolder.members().length);

		final IFile lexerJava = this.genFolder.getFile("My4Lexer.java");
		Assert.assertTrue(lexerJava.exists());
		final IFile parserJava = this.genFolder.getFile("My4Parser.java");
		Assert.assertTrue(parserJava.exists());
		final IFile lexerTokens = this.genFolder.getFile("My4Lexer.tokens");
		Assert.assertTrue(lexerTokens.exists());
		final IFile parserTokens = this.genFolder.getFile("My4.tokens");
		Assert.assertTrue(parserTokens.exists());
		final IFile listener1 = this.genFolder.getFile("My4Listener.java");
		Assert.assertTrue(listener1.exists());
		final IFile listener2 = this.genFolder.getFile("My4BaseListener.java");
		Assert.assertTrue(listener2.exists());
		final IFile visitor1 = this.genFolder.getFile("My4Visitor.java");
		Assert.assertTrue(visitor1.exists());
		final IFile visitor2 = this.genFolder.getFile("My4BaseVisitor.java");
		Assert.assertTrue(visitor2.exists());
	}

}
