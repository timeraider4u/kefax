package at.jku.weiner.c.modisco.discoverer.tests.emftests;

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

@SuppressWarnings("unused")
@RunWith(Parameterized.class)
public class Test0001_Empty {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { true }, { false } });
	};
	
	private final String pureJavaClassFileName = "Test0001_Empty";
	private final String sourceFile = "res/Test0001_Empty";
	private final Boolean use;
	
	public Test0001_Empty(final Boolean use) {
		this.use = use;
	}
	
	@Before
	public void initialize(){
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0001_before();
	}
	
	@After
	public void cleanUp() {
		at.jku.weiner.c.modisco.discoverer.tests.EMFTest.test0001_after();
	}
	
	private String getTextFromFile(final String fileName)
	throws Exception{
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}
	
				
	@Test (timeout=45000)
	public void checkParserResult() throws Exception {
		final EObject obj = at.jku.weiner.c.modisco.discoverer.tests.EMFTest.emfTest(
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
		Assert.assertEquals(1, Units_0_list.size());
		//0
		final TranslationUnit TranslationUnit_1_Var
		 = (TranslationUnit)Units_0_list.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var
		);
		Assert.assertEquals("platform:/plugin/at.jku.weiner.c.preprocess/res/predefined/gcc_4.9.3_default.h", TranslationUnit_1_Var
		.getPath());
		//1
		final Preprocess Preprocess_2_Var
		 = (Preprocess)TranslationUnit_1_Var
		.getPreprocess();
		Assert.assertNotNull(Preprocess_2_Var
		);
	}
	
	
}


