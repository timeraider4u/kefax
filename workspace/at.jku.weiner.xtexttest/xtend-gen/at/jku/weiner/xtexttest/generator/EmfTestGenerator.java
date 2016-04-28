package at.jku.weiner.xtexttest.generator;

import at.jku.weiner.xtexttest.xtextTest.After;
import at.jku.weiner.xtexttest.xtextTest.Before;
import at.jku.weiner.xtexttest.xtextTest.CodeCall;
import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.EmfTest;
import at.jku.weiner.xtexttest.xtextTest.Import;
import at.jku.weiner.xtexttest.xtextTest.Inner;
import at.jku.weiner.xtexttest.xtextTest.Model;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class EmfTestGenerator {
  private final static String PKG_PREFIX = "emftests";
  
  private final static int TIMEOUT = 25000;
  
  private URI uri;
  
  private EmfTest test;
  
  private int elementCount;
  
  private Map<String, String> map;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa, final Model model) {
    EmfTest _emfTest = model.getEmfTest();
    this.test = _emfTest;
    URI _uRI = resource.getURI();
    this.uri = _uRI;
    HashMap<String, String> _hashMap = new HashMap<String, String>();
    this.map = _hashMap;
    this.initializeAliases();
    this.elementCount = 0;
    final String outputForJava = this.outputJava();
    final String output = outputForJava.replaceAll("[$][{][{]([^\\}]*)[}][}]", "\" + options.get(\"$1\") + \"");
    String _package = this.test.getPackage();
    String _replace = _package.replace(".", "/");
    String _plus = (_replace + "/");
    String _plus_1 = (_plus + EmfTestGenerator.PKG_PREFIX);
    String _plus_2 = (_plus_1 + "/");
    String _lastSegment = this.uri.lastSegment();
    String _replace_1 = _lastSegment.replace(".xtexttest", "");
    String _plus_3 = (_plus_2 + _replace_1);
    final String fileName = (_plus_3 + ".java");
    fsa.generateFile(fileName, output);
  }
  
  public void initializeAliases() {
    EList<Import> _myimport = this.test.getMyimport();
    boolean _equals = Objects.equal(_myimport, null);
    if (_equals) {
      return;
    }
    for (int i = 0; (i < this.test.getMyimport().size()); i++) {
      {
        EList<Import> _myimport_1 = this.test.getMyimport();
        final Import myImport = _myimport_1.get(i);
        String _alias = myImport.getAlias();
        String _id = myImport.getId();
        this.map.put(_alias, _id);
      }
    }
  }
  
  public String outputJava() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _outputHeader = this.outputHeader();
    _builder.append(_outputHeader, "");
    _builder.newLineIfNotEmpty();
    String _outputClass = this.outputClass();
    _builder.append(_outputClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder.toString();
  }
  
  public CharSequence outputHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this.test.getPackage();
    _builder.append(_package, "");
    _builder.append(".");
    _builder.append(EmfTestGenerator.PKG_PREFIX, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.lang.reflect.InvocationTargetException;");
    _builder.newLine();
    _builder.append("import java.lang.reflect.Method;");
    _builder.newLine();
    _builder.append("import java.nio.file.Files;");
    _builder.newLine();
    _builder.append("import java.nio.file.Path;");
    _builder.newLine();
    _builder.append("import java.nio.file.Paths;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Token;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.common.util.EList;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.common.util.URI;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.Resource;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.ResourceSet;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.util.EDataTypeEList;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.junit.Assert;");
    _builder.newLine();
    _builder.append("import org.junit.After;");
    _builder.newLine();
    _builder.append("import org.junit.Before;");
    _builder.newLine();
    _builder.append("import org.junit.Test;");
    _builder.newLine();
    _builder.append("import org.junit.runner.RunWith;");
    _builder.newLine();
    _builder.newLine();
    Element _root = this.test.getRoot();
    String _iterateImports = this.iterateImports(_root);
    String _replaceAll = _iterateImports.replaceAll("\n+", "\n");
    _builder.append(_replaceAll, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public String iterateImports(final Element element) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(element, null));
      if (_notEquals) {
        {
          String _importing = element.getImporting();
          boolean _notEquals_1 = (!Objects.equal(_importing, null));
          if (_notEquals_1) {
            _builder.append("import ");
            String _importing_1 = element.getImporting();
            String _get = this.map.get(_importing_1);
            _builder.append(_get, "");
            _builder.append(".");
            String _name = element.getName();
            _builder.append(_name, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("import ");
            String _mydefault = this.test.getMydefault();
            _builder.append(_mydefault, "");
            _builder.append(".");
            String _name_1 = element.getName();
            _builder.append(_name_1, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<Inner> _inner = element.getInner();
          for(final Inner inner : _inner) {
            Element _assign = inner.getAssign();
            String _iterateImports = this.iterateImports(_assign);
            _builder.append(_iterateImports, "");
            _builder.newLineIfNotEmpty();
            {
              EList<Element> _assignList = inner.getAssignList();
              for(final Element elem : _assignList) {
                String _iterateImports_1 = this.iterateImports(elem);
                _builder.append(_iterateImports_1, "");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    return _builder.toString();
  }
  
  public String outputClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    {
      CodeCall _paramCall = this.test.getParamCall();
      boolean _notEquals = (!Objects.equal(_paramCall, null));
      if (_notEquals) {
        _builder.append("@RunWith(Parameterized.class)");
        _builder.newLine();
      }
    }
    _builder.append("public class ");
    String _javaClassFileName = this.getJavaClassFileName();
    _builder.append(_javaClassFileName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      CodeCall _paramCall_1 = this.test.getParamCall();
      boolean _notEquals_1 = (!Objects.equal(_paramCall_1, null));
      if (_notEquals_1) {
        _builder.append("\t");
        _builder.append("@Parameters");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static Collection<Object[]> data() = EMFTest.getParameters();");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("private final String pureJavaClassFileName = \"");
    String _javaClassFileName_1 = this.getJavaClassFileName();
    _builder.append(_javaClassFileName_1, "\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private final String sourceFile = \"");
    String _file = this.test.getFile();
    _builder.append(_file, "\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      CodeCall _optionCall = this.test.getOptionCall();
      boolean _notEquals_2 = (!Objects.equal(_optionCall, null));
      if (_notEquals_2) {
        _builder.append("private Map<String,Object> options;");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      CodeCall _paramCall_2 = this.test.getParamCall();
      boolean _notEquals_3 = (!Objects.equal(_paramCall_2, null));
      if (_notEquals_3) {
        _builder.append("\t");
        _builder.append("private final Boolean use;");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _javaClassFileName_2 = this.getJavaClassFileName();
        _builder.append(_javaClassFileName_2, "\t");
        _builder.append("(final Boolean use) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.use = use;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void initialize(){");
    _builder.newLine();
    _builder.append("\t\t");
    {
      CodeCall _optionCall_1 = this.test.getOptionCall();
      boolean _notEquals_4 = (!Objects.equal(_optionCall_1, null));
      if (_notEquals_4) {
        _builder.append("options = ");
        CodeCall _optionCall_2 = this.test.getOptionCall();
        String _myclass = _optionCall_2.getMyclass();
        String _classFor = this.getClassFor(_myclass);
        _builder.append(_classFor, "\t\t");
        _builder.append(".");
        CodeCall _optionCall_3 = this.test.getOptionCall();
        String _method = _optionCall_3.getMethod();
        _builder.append(_method, "\t\t");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("this.pureJavaClassFileName, this.sourceFile);");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      Before _before = this.test.getBefore();
      boolean _notEquals_5 = (!Objects.equal(_before, null));
      if (_notEquals_5) {
        _builder.append("\t\t");
        Before _before_1 = this.test.getBefore();
        CodeCall _codeCall = _before_1.getCodeCall();
        String _myclass_1 = _codeCall.getMyclass();
        _builder.append(_myclass_1, "\t\t");
        _builder.append(".");
        Before _before_2 = this.test.getBefore();
        CodeCall _codeCall_1 = _before_2.getCodeCall();
        String _method_1 = _codeCall_1.getMethod();
        _builder.append(_method_1, "\t\t");
        _builder.append("(");
        Before _before_3 = this.test.getBefore();
        CodeCall _codeCall_2 = _before_3.getCodeCall();
        EList<String> _params = _codeCall_2.getParams();
        String _outputFor = this.outputFor(_params);
        _builder.append(_outputFor, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void cleanUp() {");
    _builder.newLine();
    {
      After _after = this.test.getAfter();
      boolean _notEquals_6 = (!Objects.equal(_after, null));
      if (_notEquals_6) {
        _builder.append("\t\t");
        After _after_1 = this.test.getAfter();
        CodeCall _codeCall_3 = _after_1.getCodeCall();
        String _myclass_2 = _codeCall_3.getMyclass();
        _builder.append(_myclass_2, "\t\t");
        _builder.append(".");
        After _after_2 = this.test.getAfter();
        CodeCall _codeCall_4 = _after_2.getCodeCall();
        String _method_2 = _codeCall_4.getMethod();
        _builder.append(_method_2, "\t\t");
        _builder.append("(");
        After _after_3 = this.test.getAfter();
        CodeCall _codeCall_5 = _after_3.getCodeCall();
        EList<String> _params_1 = _codeCall_5.getParams();
        String _outputFor_1 = this.outputFor(_params_1);
        _builder.append(_outputFor_1, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String getTextFromFile(final String fileName)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throws Exception{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final Path path = Paths.get(fileName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final String content = new String(Files.readAllBytes(path));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return content;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    String _mainJUnitTest = this.mainJUnitTest();
    _builder.append(_mainJUnitTest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  public String getClassFor(final String clazzName) {
    String result = clazzName;
    boolean _contains = clazzName.contains(".");
    boolean _not = (!_contains);
    if (_not) {
      String _package = this.test.getPackage();
      String _plus = (_package + ".");
      String _plus_1 = (_plus + clazzName);
      result = _plus_1;
    }
    return result;
  }
  
  public String mainJUnitTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Test (timeout=");
    {
      int _timeOut = this.test.getTimeOut();
      boolean _greaterThan = (_timeOut > 0);
      if (_greaterThan) {
        int _timeOut_1 = this.test.getTimeOut();
        _builder.append(_timeOut_1, "");
      } else {
        _builder.append(EmfTestGenerator.TIMEOUT, "");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("public void checkParserResult() throws Exception {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final EObject obj = ");
    CodeCall _codeCall = this.test.getCodeCall();
    String _myclass = _codeCall.getMyclass();
    String _classFor = this.getClassFor(_myclass);
    _builder.append(_classFor, "\t");
    _builder.append(".");
    CodeCall _codeCall_1 = this.test.getCodeCall();
    String _method = _codeCall_1.getMethod();
    _builder.append(_method, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.pureJavaClassFileName, this.sourceFile");
    {
      CodeCall _paramCall = this.test.getParamCall();
      boolean _notEquals = (!Objects.equal(_paramCall, null));
      if (_notEquals) {
        _builder.append(", this.use");
      } else {
        _builder.append(", true");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Assert.assertNotNull(obj);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Assert.assertTrue(obj instanceof ");
    Element _root = this.test.getRoot();
    String _name = _root.getName();
    _builder.append(_name, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("final ");
    Element _root_1 = this.test.getRoot();
    String _name_1 = _root_1.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" ");
    Element _root_2 = this.test.getRoot();
    String _varName = this.varName(_root_2);
    _builder.append(_varName, "\t");
    _builder.append("  =  (");
    Element _root_3 = this.test.getRoot();
    String _name_2 = _root_3.getName();
    _builder.append(_name_2, "\t");
    _builder.append(")obj;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Element _root_4 = this.test.getRoot();
    String _generateForElement = this.generateForElement(_root_4);
    _builder.append(_generateForElement, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  public String outputFor(final EList<String> list) {
    final StringBuffer result = new StringBuffer("");
    boolean isFirst = true;
    for (int i = 0; (i < list.size()); i++) {
      {
        if ((!isFirst)) {
          result.append(",");
        }
        final String entry = list.get(i);
        result.append(entry);
        isFirst = false;
      }
    }
    return result.toString();
  }
  
  public String getJavaClassFileName() {
    String _lastSegment = this.uri.lastSegment();
    return _lastSegment.replace(".xtexttest", "");
  }
  
  public String getFileExtension() {
    final String fileNameForDataFile = this.test.getFile();
    final int index = fileNameForDataFile.indexOf(".");
    final String result = fileNameForDataFile.substring((index + 1));
    return result;
  }
  
  public String generateForElement(final Element element) {
    StringConcatenation _builder = new StringConcatenation();
    final String varName = this.varName(element);
    _builder.newLineIfNotEmpty();
    _builder.append("Assert.assertNotNull(");
    _builder.append(varName, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<Inner> _inner = element.getInner();
      for(final Inner inner : _inner) {
        String _parameter = inner.getParameter();
        final String paramName = this.firstCharToUpperCase(_parameter);
        _builder.newLineIfNotEmpty();
        {
          Element _assign = inner.getAssign();
          boolean _notEquals = (!Objects.equal(_assign, null));
          if (_notEquals) {
            Element _assign_1 = inner.getAssign();
            CharSequence _generateForInnerAssign = this.generateForInnerAssign(varName, paramName, _assign_1);
            _builder.append(_generateForInnerAssign, "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _and = false;
          EList<Element> _assignList = inner.getAssignList();
          boolean _notEquals_1 = (!Objects.equal(_assignList, null));
          if (!_notEquals_1) {
            _and = false;
          } else {
            EList<Element> _assignList_1 = inner.getAssignList();
            boolean _isEmpty = _assignList_1.isEmpty();
            boolean _not = (!_isEmpty);
            _and = _not;
          }
          if (_and) {
            EList<Element> _assignList_2 = inner.getAssignList();
            CharSequence _generateForListAssign = this.generateForListAssign(varName, paramName, _assignList_2);
            _builder.append(_generateForListAssign, "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _and_1 = false;
          String _assignAsData = inner.getAssignAsData();
          boolean _notEquals_2 = (!Objects.equal(_assignAsData, null));
          if (!_notEquals_2) {
            _and_1 = false;
          } else {
            String _assignAsData_1 = inner.getAssignAsData();
            boolean _isEmpty_1 = _assignAsData_1.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            _and_1 = _not_1;
          }
          if (_and_1) {
            String _assignAsData_2 = inner.getAssignAsData();
            CharSequence _generateForDataListAssign = this.generateForDataListAssign(varName, paramName, _assignAsData_2);
            _builder.append(_generateForDataListAssign, "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          String _value = inner.getValue();
          boolean _notEquals_3 = (!Objects.equal(_value, null));
          if (_notEquals_3) {
            String _value_1 = inner.getValue();
            CharSequence _generateForValueAssign = this.generateForValueAssign(varName, paramName, _value_1);
            _builder.append(_generateForValueAssign, "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          String _assignAsBool = inner.getAssignAsBool();
          boolean _notEquals_4 = (!Objects.equal(_assignAsBool, null));
          if (_notEquals_4) {
            String _assignAsBool_1 = inner.getAssignAsBool();
            CharSequence _generateForBoolAssign = this.generateForBoolAssign(varName, paramName, _assignAsBool_1);
            _builder.append(_generateForBoolAssign, "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isIsNull = inner.isIsNull();
          if (_isIsNull) {
            _builder.append("Assert.assertNull(");
            _builder.append(varName, "");
            _builder.append(".get");
            _builder.append(paramName, "");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isIsNotNull = inner.isIsNotNull();
          if (_isIsNotNull) {
            _builder.append("Assert.assertNotNull(");
            _builder.append(varName, "");
            _builder.append(".get");
            _builder.append(paramName, "");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isIsEmpty = inner.isIsEmpty();
          if (_isIsEmpty) {
            _builder.append("Assert.assertTrue(");
            _builder.append(varName, "");
            _builder.append(".get");
            _builder.append(paramName, "");
            _builder.append("().isEmpty());");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public CharSequence generateForInnerAssign(final String varName, final String paramName, final Element innerElem) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//");
    int _plusPlus = this.elementCount++;
    _builder.append(_plusPlus, "");
    _builder.newLineIfNotEmpty();
    String _name = innerElem.getName();
    final String type = this.firstCharToUpperCase(_name);
    _builder.newLineIfNotEmpty();
    _builder.append("final ");
    _builder.append(type, "");
    _builder.append(" ");
    String _varName = this.varName(innerElem);
    _builder.append(_varName, "");
    _builder.append(" = (");
    _builder.append(type, "");
    _builder.append(")");
    _builder.append(varName, "");
    _builder.append(".get");
    _builder.append(paramName, "");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    String _generateForElement = this.generateForElement(innerElem);
    _builder.append(_generateForElement, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateForListAssign(final String varName, final String paramName, final EList<Element> assignList) {
    StringConcatenation _builder = new StringConcatenation();
    final String listName = this.getListName(paramName);
    _builder.newLineIfNotEmpty();
    _builder.append("final EList<? extends EObject> ");
    _builder.append(listName, "");
    _builder.append(" = ");
    _builder.append(varName, "");
    _builder.append(".get");
    _builder.append(paramName, "");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("Assert.assertNotNull(");
    _builder.append(listName, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("Assert.assertEquals(");
    int _size = assignList.size();
    _builder.append(_size, "");
    _builder.append(", ");
    _builder.append(listName, "");
    _builder.append(".size());");
    _builder.newLineIfNotEmpty();
    {
      int _size_1 = assignList.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_1, true);
      for(final Integer i : _doubleDotLessThan) {
        final Element elem = assignList.get((i).intValue());
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        int _plusPlus = this.elementCount++;
        _builder.append(_plusPlus, "");
        _builder.newLineIfNotEmpty();
        final String type = elem.getName();
        _builder.newLineIfNotEmpty();
        _builder.append("final ");
        _builder.append(type, "");
        _builder.append(" ");
        String _varName = this.varName(elem);
        _builder.append(_varName, "");
        _builder.append(" = (");
        _builder.append(type, "");
        _builder.append(")");
        _builder.append(listName, "");
        _builder.append(".get(");
        _builder.append(i, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        String _generateForElement = this.generateForElement(elem);
        _builder.append(_generateForElement, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String getListName(final String paramName) {
    return (((paramName + "_") + Integer.valueOf(this.elementCount)) + "_list");
  }
  
  public CharSequence generateForDataListAssign(final String varName, final String paramName, final String assignAsData) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Assert.assertEquals(\"");
    _builder.append(assignAsData, "");
    _builder.append("\", ");
    _builder.append(varName, "");
    _builder.append(".get");
    _builder.append(paramName, "");
    _builder.append("().toString());");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateForValueAssign(final String varName, final String paramName, final String value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Assert.assertEquals(\"");
    _builder.append(value, "");
    _builder.append("\", ");
    _builder.append(varName, "");
    _builder.append(".get");
    _builder.append(paramName, "");
    _builder.append("());");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateForBoolAssign(final String varName, final String paramName, final String string3) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _equals = "true".equals(string3);
      if (_equals) {
        _builder.append("Assert.assertTrue(");
        _builder.append(varName, "");
        _builder.append(".is");
        _builder.append(paramName, "");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("Assert.assertFalse(");
        _builder.append(varName, "");
        _builder.append(".is");
        _builder.append(paramName, "");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String varName(final Element element) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = element.getName();
    _builder.append(_name, "");
    _builder.append("_");
    _builder.append(this.elementCount, "");
    _builder.append("_Var");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String firstCharToUpperCase(final String text) {
    String _substring = text.substring(0, 1);
    final String first = _substring.toUpperCase();
    final String tail = text.substring(1);
    return (first + tail);
  }
}
