/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asm Line With Colon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithColonImpl#getAsmLine <em>Asm Line</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AsmLineWithColonImpl extends PersistentEObjectImpl implements AsmLineWithColon
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsmLineWithColonImpl()
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
		return ParserPackage.Literals.ASM_LINE_WITH_COLON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsmLineWithoutColon getAsmLine()
	{
		return (AsmLineWithoutColon)eGet(ParserPackage.Literals.ASM_LINE_WITH_COLON__ASM_LINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsmLine(AsmLineWithoutColon newAsmLine)
	{
		eSet(ParserPackage.Literals.ASM_LINE_WITH_COLON__ASM_LINE, newAsmLine);
	}

} //AsmLineWithColonImpl
