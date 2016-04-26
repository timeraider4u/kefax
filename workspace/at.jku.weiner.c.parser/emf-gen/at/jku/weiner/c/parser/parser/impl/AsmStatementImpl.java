/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asm Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getVolatile <em>Volatile</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getAsmLine1 <em>Asm Line1</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getAsmLines <em>Asm Lines</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#isLastComma <em>Last Comma</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getGoto <em>Goto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AsmStatementImpl extends StatementImpl implements AsmStatement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsmStatementImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ParserPackage.Literals.ASM_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAsm()
	{
		return (String)eGet(ParserPackage.Literals.ASM_STATEMENT__ASM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsm(String newAsm)
	{
		eSet(ParserPackage.Literals.ASM_STATEMENT__ASM, newAsm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVolatile()
	{
		return (String)eGet(ParserPackage.Literals.ASM_STATEMENT__VOLATILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolatile(String newVolatile)
	{
		eSet(ParserPackage.Literals.ASM_STATEMENT__VOLATILE, newVolatile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsmLine getAsmLine1()
	{
		return (AsmLine)eGet(ParserPackage.Literals.ASM_STATEMENT__ASM_LINE1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsmLine1(AsmLine newAsmLine1)
	{
		eSet(ParserPackage.Literals.ASM_STATEMENT__ASM_LINE1, newAsmLine1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AsmLineWithColon> getAsmLines()
	{
		return (EList<AsmLineWithColon>)eGet(ParserPackage.Literals.ASM_STATEMENT__ASM_LINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLastComma()
	{
		return (Boolean)eGet(ParserPackage.Literals.ASM_STATEMENT__LAST_COMMA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastComma(boolean newLastComma)
	{
		eSet(ParserPackage.Literals.ASM_STATEMENT__LAST_COMMA, newLastComma);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoto()
	{
		return (String)eGet(ParserPackage.Literals.ASM_STATEMENT__GOTO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoto(String newGoto)
	{
		eSet(ParserPackage.Literals.ASM_STATEMENT__GOTO, newGoto);
	}

} //AsmStatementImpl
