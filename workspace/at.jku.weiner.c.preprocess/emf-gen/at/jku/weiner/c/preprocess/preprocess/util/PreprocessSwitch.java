/**
 */
package at.jku.weiner.c.preprocess.preprocess.util;

import at.jku.weiner.c.preprocess.preprocess.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage
 * @generated
 */
public class PreprocessSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PreprocessPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreprocessSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = PreprocessPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case PreprocessPackage.GROUP_OPT:
			{
				GroupOpt groupOpt = (GroupOpt)theEObject;
				T result = caseGroupOpt(groupOpt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.SOURCE_CODE_LINE:
			{
				SourceCodeLine sourceCodeLine = (SourceCodeLine)theEObject;
				T result = caseSourceCodeLine(sourceCodeLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.INCLUDE_DIRECTIVE:
			{
				IncludeDirective includeDirective = (IncludeDirective)theEObject;
				T result = caseIncludeDirective(includeDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.DEFINE_DIRECTIVE:
			{
				DefineDirective defineDirective = (DefineDirective)theEObject;
				T result = caseDefineDirective(defineDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.IDENTIFIER_LIST:
			{
				IdentifierList identifierList = (IdentifierList)theEObject;
				T result = caseIdentifierList(identifierList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.ERROR_DIRECTIVE:
			{
				ErrorDirective errorDirective = (ErrorDirective)theEObject;
				T result = caseErrorDirective(errorDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.WARNING_DIRECTIVE:
			{
				WarningDirective warningDirective = (WarningDirective)theEObject;
				T result = caseWarningDirective(warningDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.UN_DEFINE_DIRECTIVE:
			{
				UnDefineDirective unDefineDirective = (UnDefineDirective)theEObject;
				T result = caseUnDefineDirective(unDefineDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.CONDITIONAL_DIRECTIVE:
			{
				ConditionalDirective conditionalDirective = (ConditionalDirective)theEObject;
				T result = caseConditionalDirective(conditionalDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.IF_CONDITIONAL:
			{
				IfConditional ifConditional = (IfConditional)theEObject;
				T result = caseIfConditional(ifConditional);
				if (result == null) result = caseIfAbstractConditional(ifConditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.IF_DEF_CONDITIONAL:
			{
				IfDefConditional ifDefConditional = (IfDefConditional)theEObject;
				T result = caseIfDefConditional(ifDefConditional);
				if (result == null) result = caseIfAbstractConditional(ifDefConditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.IF_NOT_DEF_CONDITIONAL:
			{
				IfNotDefConditional ifNotDefConditional = (IfNotDefConditional)theEObject;
				T result = caseIfNotDefConditional(ifNotDefConditional);
				if (result == null) result = caseIfAbstractConditional(ifNotDefConditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.EL_IF_CONDITIONAL:
			{
				ElIfConditional elIfConditional = (ElIfConditional)theEObject;
				T result = caseElIfConditional(elIfConditional);
				if (result == null) result = caseIfAbstractConditional(elIfConditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.ELSE_CONDITIONAL:
			{
				ElseConditional elseConditional = (ElseConditional)theEObject;
				T result = caseElseConditional(elseConditional);
				if (result == null) result = caseIfAbstractConditional(elseConditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.PRAGMA_DIRECTIVE:
			{
				PragmaDirective pragmaDirective = (PragmaDirective)theEObject;
				T result = casePragmaDirective(pragmaDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.NULL_DIRECTIVE:
			{
				NullDirective nullDirective = (NullDirective)theEObject;
				T result = caseNullDirective(nullDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.PREPROCESS:
			{
				Preprocess preprocess = (Preprocess)theEObject;
				T result = casePreprocess(preprocess);
				if (result == null) result = caseCommon_Preprocess(preprocess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.GROUP_OPT2:
			{
				GroupOpt2 groupOpt2 = (GroupOpt2)theEObject;
				T result = caseGroupOpt2(groupOpt2);
				if (result == null) result = caseGroupOpt(groupOpt2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.PREPROCESSOR_DIRECTIVES:
			{
				PreprocessorDirectives preprocessorDirectives = (PreprocessorDirectives)theEObject;
				T result = casePreprocessorDirectives(preprocessorDirectives);
				if (result == null) result = caseSourceCodeLine(preprocessorDirectives);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.DEFINE_OBJECT_MACRO:
			{
				DefineObjectMacro defineObjectMacro = (DefineObjectMacro)theEObject;
				T result = caseDefineObjectMacro(defineObjectMacro);
				if (result == null) result = caseDefineDirective(defineObjectMacro);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.DEFINE_FUNCTION_LIKE_MACRO:
			{
				DefineFunctionLikeMacro defineFunctionLikeMacro = (DefineFunctionLikeMacro)theEObject;
				T result = caseDefineFunctionLikeMacro(defineFunctionLikeMacro);
				if (result == null) result = caseDefineDirective(defineFunctionLikeMacro);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.NEW_LINE_LINE:
			{
				NewLineLine newLineLine = (NewLineLine)theEObject;
				T result = caseNewLineLine(newLineLine);
				if (result == null) result = caseSourceCodeLine(newLineLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.CODE:
			{
				Code code = (Code)theEObject;
				T result = caseCode(code);
				if (result == null) result = caseSourceCodeLine(code);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.PRIMARY_EXPRESSION:
			{
				PrimaryExpression primaryExpression = (PrimaryExpression)theEObject;
				T result = casePrimaryExpression(primaryExpression);
				if (result == null) result = caseExpression(primaryExpression);
				if (result == null) result = caseCommon_Expression(primaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL:
			{
				IfAbstractConditional ifAbstractConditional = (IfAbstractConditional)theEObject;
				T result = caseIfAbstractConditional(ifAbstractConditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.EXPRESSION:
			{
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseCommon_Expression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PreprocessPackage.LINE_DIRECTIVE:
			{
				LineDirective lineDirective = (LineDirective)theEObject;
				T result = caseLineDirective(lineDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group Opt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group Opt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupOpt(GroupOpt object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Code Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Code Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceCodeLine(SourceCodeLine object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Include Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Include Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncludeDirective(IncludeDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Define Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Define Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefineDirective(DefineDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierList(IdentifierList object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorDirective(ErrorDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Warning Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Warning Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWarningDirective(WarningDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Un Define Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Un Define Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnDefineDirective(UnDefineDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalDirective(ConditionalDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfConditional(IfConditional object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Def Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Def Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfDefConditional(IfDefConditional object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Not Def Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Not Def Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfNotDefConditional(IfNotDefConditional object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>El If Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>El If Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElIfConditional(ElIfConditional object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Else Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Else Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElseConditional(ElseConditional object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pragma Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pragma Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePragmaDirective(PragmaDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullDirective(NullDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preprocess</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preprocess</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreprocess(Preprocess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group Opt2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group Opt2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupOpt2(GroupOpt2 object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preprocessor Directives</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preprocessor Directives</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreprocessorDirectives(PreprocessorDirectives object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Define Object Macro</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Define Object Macro</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefineObjectMacro(DefineObjectMacro object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Define Function Like Macro</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Define Function Like Macro</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefineFunctionLikeMacro(DefineFunctionLikeMacro object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Line Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Line Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewLineLine(NewLineLine object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCode(Code object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimaryExpression(PrimaryExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Abstract Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Abstract Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfAbstractConditional(IfAbstractConditional object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineDirective(LineDirective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preprocess</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preprocess</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommon_Preprocess(at.jku.weiner.c.common.common.Preprocess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommon_Expression(at.jku.weiner.c.common.common.Expression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //PreprocessSwitch
