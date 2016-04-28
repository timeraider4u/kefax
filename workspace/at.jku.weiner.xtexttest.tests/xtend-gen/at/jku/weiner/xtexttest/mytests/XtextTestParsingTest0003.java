/**
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.xtexttest.mytests;

import at.jku.weiner.xtexttest.generator.XtextTestGenerator;
import at.jku.weiner.xtexttest.tests.XtextTestInjectorProvider;
import at.jku.weiner.xtexttest.xtextTest.Model;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XtextTestInjectorProvider.class)
@SuppressWarnings("all")
public class XtextTestParsingTest0003 {
  @Inject
  private ParseHelper<Model> parseHelper;
  
  @Inject
  private XtextTestGenerator generator;
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Inject
  private IResourceValidator validator;
  
  @Inject
  private JavaIoFileSystemAccess fileAccessSystem;
  
  private int wordCount = 0;
  
  public String getTextFromFile(final String fileName) throws Exception {
    final Path path = Paths.get(fileName);
    byte[] _readAllBytes = Files.readAllBytes(path);
    final String content = new String(_readAllBytes);
    return content;
  }
  
  @Test
  public void loadModel() {
    try {
      final String file = "res/Test0003_Semicolons.xtexttest";
      final String input = this.getTextFromFile(file);
      final Model result = this.parseHelper.parse(input);
      Assert.assertNotNull(result);
      final ResourceSet set = this.resourceSetProvider.get();
      final URI uri = URI.createURI(file);
      final Resource resource = set.getResource(uri, true);
      final List<Issue> list = this.validator.validate(resource, 
        CheckMode.ALL, CancelIndicator.NullImpl);
      boolean _isEmpty = list.isEmpty();
      Assert.assertTrue(_isEmpty);
      this.fileAccessSystem.setOutputPath("bin");
      this.generator.setFileName("Test0003_Semicolons.java");
      this.generator.doGenerate(resource, this.fileAccessSystem);
      final String actual = this.getTextFromFile("bin/at/jku/weiner/c/preprocess/xtexttests/Test0003_Semicolons.java");
      Assert.assertNotNull(actual);
      final String expect = this.getTextFromFile("expected/Test0003_Semicolons.java");
      Assert.assertEquals(expect, actual);
      final Pattern pattern = Pattern.compile("RULE_MYCODE");
      final Matcher matcher = pattern.matcher(actual);
      while (matcher.find()) {
        this.wordCount++;
      }
      Assert.assertEquals(10, this.wordCount);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
