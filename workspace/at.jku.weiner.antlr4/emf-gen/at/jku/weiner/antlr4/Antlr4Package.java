/**
 */
package at.jku.weiner.antlr4;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.jku.weiner.antlr4.Antlr4Factory
 * @model kind="package"
 * @generated
 */
public interface Antlr4Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "antlr4";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.jku.at/weiner/antlr4";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "antlr4";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Antlr4Package eINSTANCE = at.jku.weiner.antlr4.impl.Antlr4PackageImpl.init();

	/**
	 * The meta object id for the '{@link at.jku.weiner.antlr4.impl.GrammarImpl <em>Grammar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.antlr4.impl.GrammarImpl
	 * @see at.jku.weiner.antlr4.impl.Antlr4PackageImpl#getGrammar()
	 * @generated
	 */
	int GRAMMAR = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__RULES = 1;

	/**
	 * The number of structural features of the '<em>Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.jku.weiner.antlr4.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.antlr4.impl.RuleImpl
	 * @see at.jku.weiner.antlr4.impl.Antlr4PackageImpl#getRule()
	 * @generated
	 */
	int RULE = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link at.jku.weiner.antlr4.impl.ParserRuleSpecImpl <em>Parser Rule Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.antlr4.impl.ParserRuleSpecImpl
	 * @see at.jku.weiner.antlr4.impl.Antlr4PackageImpl#getParserRuleSpec()
	 * @generated
	 */
	int PARSER_RULE_SPEC = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSER_RULE_SPEC__IDENTIFIER = RULE__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Parser Rule Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSER_RULE_SPEC_FEATURE_COUNT = RULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parser Rule Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSER_RULE_SPEC_OPERATION_COUNT = RULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link at.jku.weiner.antlr4.Grammar <em>Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar</em>'.
	 * @see at.jku.weiner.antlr4.Grammar
	 * @generated
	 */
	EClass getGrammar();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.antlr4.Grammar#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see at.jku.weiner.antlr4.Grammar#getIdentifier()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link at.jku.weiner.antlr4.Grammar#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see at.jku.weiner.antlr4.Grammar#getRules()
	 * @see #getGrammar()
	 * @generated
	 */
	EReference getGrammar_Rules();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.antlr4.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see at.jku.weiner.antlr4.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.antlr4.Rule#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see at.jku.weiner.antlr4.Rule#getIdentifier()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Identifier();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.antlr4.ParserRuleSpec <em>Parser Rule Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parser Rule Spec</em>'.
	 * @see at.jku.weiner.antlr4.ParserRuleSpec
	 * @generated
	 */
	EClass getParserRuleSpec();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Antlr4Factory getAntlr4Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.jku.weiner.antlr4.impl.GrammarImpl <em>Grammar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.antlr4.impl.GrammarImpl
		 * @see at.jku.weiner.antlr4.impl.Antlr4PackageImpl#getGrammar()
		 * @generated
		 */
		EClass GRAMMAR = eINSTANCE.getGrammar();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR__IDENTIFIER = eINSTANCE.getGrammar_Identifier();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR__RULES = eINSTANCE.getGrammar_Rules();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.antlr4.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.antlr4.impl.RuleImpl
		 * @see at.jku.weiner.antlr4.impl.Antlr4PackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__IDENTIFIER = eINSTANCE.getRule_Identifier();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.antlr4.impl.ParserRuleSpecImpl <em>Parser Rule Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.antlr4.impl.ParserRuleSpecImpl
		 * @see at.jku.weiner.antlr4.impl.Antlr4PackageImpl#getParserRuleSpec()
		 * @generated
		 */
		EClass PARSER_RULE_SPEC = eINSTANCE.getParserRuleSpec();

	}

} //Antlr4Package
