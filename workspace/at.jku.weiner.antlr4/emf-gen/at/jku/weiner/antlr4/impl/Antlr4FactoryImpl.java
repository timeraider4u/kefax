/**
 */
package at.jku.weiner.antlr4.impl;

import at.jku.weiner.antlr4.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Antlr4FactoryImpl extends EFactoryImpl implements Antlr4Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Antlr4Factory init() {
		try {
			Antlr4Factory theAntlr4Factory = (Antlr4Factory)EPackage.Registry.INSTANCE.getEFactory(Antlr4Package.eNS_URI);
			if (theAntlr4Factory != null) {
				return theAntlr4Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Antlr4FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Antlr4FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Antlr4Package.GRAMMAR: return createGrammar();
			case Antlr4Package.PARSER_RULE_SPEC: return createParserRuleSpec();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grammar createGrammar() {
		GrammarImpl grammar = new GrammarImpl();
		return grammar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParserRuleSpec createParserRuleSpec() {
		ParserRuleSpecImpl parserRuleSpec = new ParserRuleSpecImpl();
		return parserRuleSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Antlr4Package getAntlr4Package() {
		return (Antlr4Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Antlr4Package getPackage() {
		return Antlr4Package.eINSTANCE;
	}

} //Antlr4FactoryImpl
