/**
 * Copyright (c) 2010 Mia-Software.
 *    All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *   
 *   	   Nicolas Guyomar (Mia-Software) - initial API and implementation
 */
package org.eclipse.modisco.kconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigType;
import org.eclipse.modisco.kconfig.Default;
import org.eclipse.modisco.kconfig.Depend;
import org.eclipse.modisco.kconfig.KconfigPackage;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.Option;
import org.eclipse.modisco.kconfig.Prompt;
import org.eclipse.modisco.kconfig.Range;
import org.eclipse.modisco.kconfig.Select;
import org.eclipse.modisco.kconfig.TranslationUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getHelpText <em>Help Text</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getDefinedIn <em>Defined In</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getPrompt <em>Prompt</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getDefaults <em>Defaults</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getSelects <em>Selects</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getRanges <em>Ranges</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigImpl#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigImpl extends MinimalEObjectImpl.Container implements Config {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigType TYPE_EDEFAULT = ConfigType.TRISTATE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ConfigType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHelpText() <em>Help Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpText()
	 * @generated
	 * @ordered
	 */
	protected static final String HELP_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHelpText() <em>Help Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpText()
	 * @generated
	 * @ordered
	 */
	protected String helpText = HELP_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDepends() <em>Depends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected EList<Depend> depends;

	/**
	 * The cached value of the '{@link #getDefinedIn() <em>Defined In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinedIn()
	 * @generated
	 * @ordered
	 */
	protected TranslationUnit definedIn;

	/**
	 * The cached value of the '{@link #getPrompt() <em>Prompt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrompt()
	 * @generated
	 * @ordered
	 */
	protected Prompt prompt;

	/**
	 * The cached value of the '{@link #getDefaults() <em>Defaults</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaults()
	 * @generated
	 * @ordered
	 */
	protected EList<Default> defaults;

	/**
	 * The cached value of the '{@link #getSelects() <em>Selects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelects()
	 * @generated
	 * @ordered
	 */
	protected EList<Select> selects;

	/**
	 * The cached value of the '{@link #getRanges() <em>Ranges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<Range> ranges;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> options;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KconfigPackage.Literals.CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ConfigType newType) {
		ConfigType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHelpText() {
		return helpText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelpText(String newHelpText) {
		String oldHelpText = helpText;
		helpText = newHelpText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__HELP_TEXT, oldHelpText, helpText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Depend> getDepends() {
		if (depends == null) {
			depends = new EObjectContainmentWithInverseEList<Depend>(Depend.class, this, KconfigPackage.CONFIG__DEPENDS, KconfigPackage.DEPEND__OWNER);
		}
		return depends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getOwner() {
		if (eContainerFeatureID() != KconfigPackage.CONFIG__OWNER) return null;
		return (Model)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Model newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, KconfigPackage.CONFIG__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Model newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != KconfigPackage.CONFIG__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, KconfigPackage.MODEL__CONFIGS, Model.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationUnit getDefinedIn() {
		if (definedIn != null && definedIn.eIsProxy()) {
			InternalEObject oldDefinedIn = (InternalEObject)definedIn;
			definedIn = (TranslationUnit)eResolveProxy(oldDefinedIn);
			if (definedIn != oldDefinedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.CONFIG__DEFINED_IN, oldDefinedIn, definedIn));
			}
		}
		return definedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationUnit basicGetDefinedIn() {
		return definedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinedIn(TranslationUnit newDefinedIn, NotificationChain msgs) {
		TranslationUnit oldDefinedIn = definedIn;
		definedIn = newDefinedIn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__DEFINED_IN, oldDefinedIn, newDefinedIn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinedIn(TranslationUnit newDefinedIn) {
		if (newDefinedIn != definedIn) {
			NotificationChain msgs = null;
			if (definedIn != null)
				msgs = ((InternalEObject)definedIn).eInverseRemove(this, KconfigPackage.TRANSLATION_UNIT__CONFIGS, TranslationUnit.class, msgs);
			if (newDefinedIn != null)
				msgs = ((InternalEObject)newDefinedIn).eInverseAdd(this, KconfigPackage.TRANSLATION_UNIT__CONFIGS, TranslationUnit.class, msgs);
			msgs = basicSetDefinedIn(newDefinedIn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__DEFINED_IN, newDefinedIn, newDefinedIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Prompt getPrompt() {
		return prompt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrompt(Prompt newPrompt, NotificationChain msgs) {
		Prompt oldPrompt = prompt;
		prompt = newPrompt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__PROMPT, oldPrompt, newPrompt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrompt(Prompt newPrompt) {
		if (newPrompt != prompt) {
			NotificationChain msgs = null;
			if (prompt != null)
				msgs = ((InternalEObject)prompt).eInverseRemove(this, KconfigPackage.PROMPT__OWNER, Prompt.class, msgs);
			if (newPrompt != null)
				msgs = ((InternalEObject)newPrompt).eInverseAdd(this, KconfigPackage.PROMPT__OWNER, Prompt.class, msgs);
			msgs = basicSetPrompt(newPrompt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG__PROMPT, newPrompt, newPrompt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Default> getDefaults() {
		if (defaults == null) {
			defaults = new EObjectContainmentWithInverseEList<Default>(Default.class, this, KconfigPackage.CONFIG__DEFAULTS, KconfigPackage.DEFAULT__OWNER);
		}
		return defaults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Select> getSelects() {
		if (selects == null) {
			selects = new EObjectContainmentWithInverseEList<Select>(Select.class, this, KconfigPackage.CONFIG__SELECTS, KconfigPackage.SELECT__OWNER);
		}
		return selects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Range> getRanges() {
		if (ranges == null) {
			ranges = new EObjectContainmentWithInverseEList<Range>(Range.class, this, KconfigPackage.CONFIG__RANGES, KconfigPackage.RANGE__OWNER);
		}
		return ranges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOptions() {
		if (options == null) {
			options = new EObjectContainmentWithInverseEList<Option>(Option.class, this, KconfigPackage.CONFIG__OPTIONS, KconfigPackage.OPTION__OWNER);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KconfigPackage.CONFIG__DEPENDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDepends()).basicAdd(otherEnd, msgs);
			case KconfigPackage.CONFIG__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Model)otherEnd, msgs);
			case KconfigPackage.CONFIG__DEFINED_IN:
				if (definedIn != null)
					msgs = ((InternalEObject)definedIn).eInverseRemove(this, KconfigPackage.TRANSLATION_UNIT__CONFIGS, TranslationUnit.class, msgs);
				return basicSetDefinedIn((TranslationUnit)otherEnd, msgs);
			case KconfigPackage.CONFIG__PROMPT:
				if (prompt != null)
					msgs = ((InternalEObject)prompt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KconfigPackage.CONFIG__PROMPT, null, msgs);
				return basicSetPrompt((Prompt)otherEnd, msgs);
			case KconfigPackage.CONFIG__DEFAULTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefaults()).basicAdd(otherEnd, msgs);
			case KconfigPackage.CONFIG__SELECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSelects()).basicAdd(otherEnd, msgs);
			case KconfigPackage.CONFIG__RANGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRanges()).basicAdd(otherEnd, msgs);
			case KconfigPackage.CONFIG__OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOptions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KconfigPackage.CONFIG__DEPENDS:
				return ((InternalEList<?>)getDepends()).basicRemove(otherEnd, msgs);
			case KconfigPackage.CONFIG__OWNER:
				return basicSetOwner(null, msgs);
			case KconfigPackage.CONFIG__DEFINED_IN:
				return basicSetDefinedIn(null, msgs);
			case KconfigPackage.CONFIG__PROMPT:
				return basicSetPrompt(null, msgs);
			case KconfigPackage.CONFIG__DEFAULTS:
				return ((InternalEList<?>)getDefaults()).basicRemove(otherEnd, msgs);
			case KconfigPackage.CONFIG__SELECTS:
				return ((InternalEList<?>)getSelects()).basicRemove(otherEnd, msgs);
			case KconfigPackage.CONFIG__RANGES:
				return ((InternalEList<?>)getRanges()).basicRemove(otherEnd, msgs);
			case KconfigPackage.CONFIG__OPTIONS:
				return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case KconfigPackage.CONFIG__OWNER:
				return eInternalContainer().eInverseRemove(this, KconfigPackage.MODEL__CONFIGS, Model.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KconfigPackage.CONFIG__NAME:
				return getName();
			case KconfigPackage.CONFIG__TYPE:
				return getType();
			case KconfigPackage.CONFIG__HELP_TEXT:
				return getHelpText();
			case KconfigPackage.CONFIG__DESCRIPTION:
				return getDescription();
			case KconfigPackage.CONFIG__DEPENDS:
				return getDepends();
			case KconfigPackage.CONFIG__OWNER:
				return getOwner();
			case KconfigPackage.CONFIG__DEFINED_IN:
				if (resolve) return getDefinedIn();
				return basicGetDefinedIn();
			case KconfigPackage.CONFIG__PROMPT:
				return getPrompt();
			case KconfigPackage.CONFIG__DEFAULTS:
				return getDefaults();
			case KconfigPackage.CONFIG__SELECTS:
				return getSelects();
			case KconfigPackage.CONFIG__RANGES:
				return getRanges();
			case KconfigPackage.CONFIG__OPTIONS:
				return getOptions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KconfigPackage.CONFIG__NAME:
				setName((String)newValue);
				return;
			case KconfigPackage.CONFIG__TYPE:
				setType((ConfigType)newValue);
				return;
			case KconfigPackage.CONFIG__HELP_TEXT:
				setHelpText((String)newValue);
				return;
			case KconfigPackage.CONFIG__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case KconfigPackage.CONFIG__DEPENDS:
				getDepends().clear();
				getDepends().addAll((Collection<? extends Depend>)newValue);
				return;
			case KconfigPackage.CONFIG__OWNER:
				setOwner((Model)newValue);
				return;
			case KconfigPackage.CONFIG__DEFINED_IN:
				setDefinedIn((TranslationUnit)newValue);
				return;
			case KconfigPackage.CONFIG__PROMPT:
				setPrompt((Prompt)newValue);
				return;
			case KconfigPackage.CONFIG__DEFAULTS:
				getDefaults().clear();
				getDefaults().addAll((Collection<? extends Default>)newValue);
				return;
			case KconfigPackage.CONFIG__SELECTS:
				getSelects().clear();
				getSelects().addAll((Collection<? extends Select>)newValue);
				return;
			case KconfigPackage.CONFIG__RANGES:
				getRanges().clear();
				getRanges().addAll((Collection<? extends Range>)newValue);
				return;
			case KconfigPackage.CONFIG__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends Option>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case KconfigPackage.CONFIG__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KconfigPackage.CONFIG__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case KconfigPackage.CONFIG__HELP_TEXT:
				setHelpText(HELP_TEXT_EDEFAULT);
				return;
			case KconfigPackage.CONFIG__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case KconfigPackage.CONFIG__DEPENDS:
				getDepends().clear();
				return;
			case KconfigPackage.CONFIG__OWNER:
				setOwner((Model)null);
				return;
			case KconfigPackage.CONFIG__DEFINED_IN:
				setDefinedIn((TranslationUnit)null);
				return;
			case KconfigPackage.CONFIG__PROMPT:
				setPrompt((Prompt)null);
				return;
			case KconfigPackage.CONFIG__DEFAULTS:
				getDefaults().clear();
				return;
			case KconfigPackage.CONFIG__SELECTS:
				getSelects().clear();
				return;
			case KconfigPackage.CONFIG__RANGES:
				getRanges().clear();
				return;
			case KconfigPackage.CONFIG__OPTIONS:
				getOptions().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KconfigPackage.CONFIG__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KconfigPackage.CONFIG__TYPE:
				return type != TYPE_EDEFAULT;
			case KconfigPackage.CONFIG__HELP_TEXT:
				return HELP_TEXT_EDEFAULT == null ? helpText != null : !HELP_TEXT_EDEFAULT.equals(helpText);
			case KconfigPackage.CONFIG__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case KconfigPackage.CONFIG__DEPENDS:
				return depends != null && !depends.isEmpty();
			case KconfigPackage.CONFIG__OWNER:
				return getOwner() != null;
			case KconfigPackage.CONFIG__DEFINED_IN:
				return definedIn != null;
			case KconfigPackage.CONFIG__PROMPT:
				return prompt != null;
			case KconfigPackage.CONFIG__DEFAULTS:
				return defaults != null && !defaults.isEmpty();
			case KconfigPackage.CONFIG__SELECTS:
				return selects != null && !selects.isEmpty();
			case KconfigPackage.CONFIG__RANGES:
				return ranges != null && !ranges.isEmpty();
			case KconfigPackage.CONFIG__OPTIONS:
				return options != null && !options.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(", helpText: "); //$NON-NLS-1$
		result.append(helpText);
		result.append(", description: "); //$NON-NLS-1$
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ConfigImpl
