/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.Parser;
import at.jku.weiner.c.common.common.Preprocess;
import at.jku.weiner.c.common.common.TranslationUnit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.TranslationUnitImpl#getPreprocess <em>Preprocess</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.TranslationUnitImpl#getParser <em>Parser</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TranslationUnitImpl extends MinimalEObjectImpl.Container implements TranslationUnit
{
	/**
	 * The cached value of the '{@link #getPreprocess() <em>Preprocess</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreprocess()
	 * @generated
	 * @ordered
	 */
	protected Preprocess preprocess;

	/**
	 * The cached value of the '{@link #getParser() <em>Parser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParser()
	 * @generated
	 * @ordered
	 */
	protected Parser parser;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TranslationUnitImpl()
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
		return CommonPackage.Literals.TRANSLATION_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preprocess getPreprocess()
	{
		return preprocess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreprocess(Preprocess newPreprocess, NotificationChain msgs)
	{
		Preprocess oldPreprocess = preprocess;
		preprocess = newPreprocess;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.TRANSLATION_UNIT__PREPROCESS, oldPreprocess, newPreprocess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreprocess(Preprocess newPreprocess)
	{
		if (newPreprocess != preprocess)
		{
			NotificationChain msgs = null;
			if (preprocess != null)
				msgs = ((InternalEObject)preprocess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.TRANSLATION_UNIT__PREPROCESS, null, msgs);
			if (newPreprocess != null)
				msgs = ((InternalEObject)newPreprocess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.TRANSLATION_UNIT__PREPROCESS, null, msgs);
			msgs = basicSetPreprocess(newPreprocess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.TRANSLATION_UNIT__PREPROCESS, newPreprocess, newPreprocess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parser getParser()
	{
		return parser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParser(Parser newParser, NotificationChain msgs)
	{
		Parser oldParser = parser;
		parser = newParser;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.TRANSLATION_UNIT__PARSER, oldParser, newParser);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParser(Parser newParser)
	{
		if (newParser != parser)
		{
			NotificationChain msgs = null;
			if (parser != null)
				msgs = ((InternalEObject)parser).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.TRANSLATION_UNIT__PARSER, null, msgs);
			if (newParser != null)
				msgs = ((InternalEObject)newParser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.TRANSLATION_UNIT__PARSER, null, msgs);
			msgs = basicSetParser(newParser, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.TRANSLATION_UNIT__PARSER, newParser, newParser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case CommonPackage.TRANSLATION_UNIT__PREPROCESS:
				return basicSetPreprocess(null, msgs);
			case CommonPackage.TRANSLATION_UNIT__PARSER:
				return basicSetParser(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case CommonPackage.TRANSLATION_UNIT__PREPROCESS:
				return getPreprocess();
			case CommonPackage.TRANSLATION_UNIT__PARSER:
				return getParser();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case CommonPackage.TRANSLATION_UNIT__PREPROCESS:
				setPreprocess((Preprocess)newValue);
				return;
			case CommonPackage.TRANSLATION_UNIT__PARSER:
				setParser((Parser)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case CommonPackage.TRANSLATION_UNIT__PREPROCESS:
				setPreprocess((Preprocess)null);
				return;
			case CommonPackage.TRANSLATION_UNIT__PARSER:
				setParser((Parser)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case CommonPackage.TRANSLATION_UNIT__PREPROCESS:
				return preprocess != null;
			case CommonPackage.TRANSLATION_UNIT__PARSER:
				return parser != null;
		}
		return super.eIsSet(featureID);
	}

} //TranslationUnitImpl
