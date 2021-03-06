package org.eclipse.modisco.cdt.discoverer.tests.basic.emftests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collection;

import org.antlr.runtime.Token;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.EObject;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import at.jku.weiner.c.common.common.Model;
import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.common.common.TranslationUnit;

@SuppressWarnings("unused")
@RunWith(Parameterized.class)
public class Test0004_Emftest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { true }, { false } });
	};
	
	private final String pureJavaClassFileName = "Test0004_Emftest";
	private final String sourceFile = "res/TestDiscoverer0004.c";
	private Map<String,Object> options;
	private final Boolean use;
	
	public Test0004_Emftest(final Boolean use) {
		this.use = use;
	}
	
	@Before
	public void initialize(){
		options = org.eclipse.modisco.cdt.discoverer.tests.basic.EMFTest.getOptions(
			this.pureJavaClassFileName, this.sourceFile);
		at.jku.weiner.xtexttest.demo.Demo.beforeDemo(demo);
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.xtexttest.demo.Demo.afterDemo(demo,demo);
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
				
	@Test (timeout=25000)
	public void checkParserResult() throws Exception {
		final EObject obj = org.eclipse.modisco.cdt.discoverer.tests.basic.EMFTest.emfTest(
			this.pureJavaClassFileName, this.sourceFile, this.use
		);
		Assert.assertNotNull(obj);
		Assert.assertTrue(obj instanceof Model);
		final Model Model_0_Var
		  =  (Model)obj;
		Assert.assertNotNull(Model_0_Var
		);
		final EList<? extends EObject> Units_0_list = Model_0_Var
		.getUnits();
		Assert.assertNotNull(Units_0_list);
		Assert.assertEquals(2, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		//1
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
		//2
		final Parser Parser_3_Var
		 = (Parser)TranslationUnit_1_Var
		.getParser();
		Assert.assertNotNull(Parser_3_Var
		);
		Assert.assertEquals("" + options.get("path") + "/" + options.get("sourceFile") + "/Empty.c", TranslationUnit_1_Var
		.getPath());
		//3
		final TranslationUnit TranslationUnit_4_Var
		 = (TranslationUnit)Units_0_list.get(1);
		Assert.assertNotNull(TranslationUnit_4_Var
		);
	}
	
	
}


