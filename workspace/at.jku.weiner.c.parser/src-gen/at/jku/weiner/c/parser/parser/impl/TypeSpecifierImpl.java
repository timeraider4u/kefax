/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclarationSpecifier;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getExtType <em>Ext Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getSpecifier <em>Specifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getType <em>Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getTypeOf <em>Type Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getConstExpr <em>Const Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#isBuiltinChooseExpr <em>Builtin Choose Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getExpr1 <em>Expr1</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getExpr2 <em>Expr2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeSpecifierImpl extends MinimalEObjectImpl.Container implements TypeSpecifier
{
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
   * The default value of the '{@link #getExtType() <em>Ext Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtType()
   * @generated
   * @ordered
   */
  protected static final String EXT_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtType() <em>Ext Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtType()
   * @generated
   * @ordered
   */
  protected String extType = EXT_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSpecifier() <em>Specifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecifier()
   * @generated
   * @ordered
   */
  protected DeclarationSpecifier specifier;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypedefName type;

  /**
   * The default value of the '{@link #getTypeOf() <em>Type Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeOf()
   * @generated
   * @ordered
   */
  protected static final String TYPE_OF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeOf() <em>Type Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeOf()
   * @generated
   * @ordered
   */
  protected String typeOf = TYPE_OF_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected TypeName typeName;

  /**
   * The cached value of the '{@link #getConstExpr() <em>Const Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstExpr()
   * @generated
   * @ordered
   */
  protected Expression constExpr;

  /**
   * The default value of the '{@link #isBuiltinChooseExpr() <em>Builtin Choose Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBuiltinChooseExpr()
   * @generated
   * @ordered
   */
  protected static final boolean BUILTIN_CHOOSE_EXPR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBuiltinChooseExpr() <em>Builtin Choose Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBuiltinChooseExpr()
   * @generated
   * @ordered
   */
  protected boolean builtinChooseExpr = BUILTIN_CHOOSE_EXPR_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpr1() <em>Expr1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr1()
   * @generated
   * @ordered
   */
  protected Expression expr1;

  /**
   * The cached value of the '{@link #getExpr2() <em>Expr2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr2()
   * @generated
   * @ordered
   */
  protected Expression expr2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeSpecifierImpl()
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
    return ParserPackage.Literals.TYPE_SPECIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtType()
  {
    return extType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtType(String newExtType)
  {
    String oldExtType = extType;
    extType = newExtType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__EXT_TYPE, oldExtType, extType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarationSpecifier getSpecifier()
  {
    return specifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecifier(DeclarationSpecifier newSpecifier, NotificationChain msgs)
  {
    DeclarationSpecifier oldSpecifier = specifier;
    specifier = newSpecifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__SPECIFIER, oldSpecifier, newSpecifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecifier(DeclarationSpecifier newSpecifier)
  {
    if (newSpecifier != specifier)
    {
      NotificationChain msgs = null;
      if (specifier != null)
        msgs = ((InternalEObject)specifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__SPECIFIER, null, msgs);
      if (newSpecifier != null)
        msgs = ((InternalEObject)newSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__SPECIFIER, null, msgs);
      msgs = basicSetSpecifier(newSpecifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__SPECIFIER, newSpecifier, newSpecifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedefName getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypedefName newType, NotificationChain msgs)
  {
    TypedefName oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypedefName newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeOf()
  {
    return typeOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeOf(String newTypeOf)
  {
    String oldTypeOf = typeOf;
    typeOf = newTypeOf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__TYPE_OF, oldTypeOf, typeOf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeName getTypeName()
  {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeName(TypeName newTypeName, NotificationChain msgs)
  {
    TypeName oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__TYPE_NAME, oldTypeName, newTypeName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName(TypeName newTypeName)
  {
    if (newTypeName != typeName)
    {
      NotificationChain msgs = null;
      if (typeName != null)
        msgs = ((InternalEObject)typeName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__TYPE_NAME, null, msgs);
      if (newTypeName != null)
        msgs = ((InternalEObject)newTypeName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__TYPE_NAME, null, msgs);
      msgs = basicSetTypeName(newTypeName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__TYPE_NAME, newTypeName, newTypeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getConstExpr()
  {
    return constExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstExpr(Expression newConstExpr, NotificationChain msgs)
  {
    Expression oldConstExpr = constExpr;
    constExpr = newConstExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__CONST_EXPR, oldConstExpr, newConstExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstExpr(Expression newConstExpr)
  {
    if (newConstExpr != constExpr)
    {
      NotificationChain msgs = null;
      if (constExpr != null)
        msgs = ((InternalEObject)constExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__CONST_EXPR, null, msgs);
      if (newConstExpr != null)
        msgs = ((InternalEObject)newConstExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__CONST_EXPR, null, msgs);
      msgs = basicSetConstExpr(newConstExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__CONST_EXPR, newConstExpr, newConstExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBuiltinChooseExpr()
  {
    return builtinChooseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBuiltinChooseExpr(boolean newBuiltinChooseExpr)
  {
    boolean oldBuiltinChooseExpr = builtinChooseExpr;
    builtinChooseExpr = newBuiltinChooseExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__BUILTIN_CHOOSE_EXPR, oldBuiltinChooseExpr, builtinChooseExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpr1()
  {
    return expr1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr1(Expression newExpr1, NotificationChain msgs)
  {
    Expression oldExpr1 = expr1;
    expr1 = newExpr1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__EXPR1, oldExpr1, newExpr1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr1(Expression newExpr1)
  {
    if (newExpr1 != expr1)
    {
      NotificationChain msgs = null;
      if (expr1 != null)
        msgs = ((InternalEObject)expr1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__EXPR1, null, msgs);
      if (newExpr1 != null)
        msgs = ((InternalEObject)newExpr1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__EXPR1, null, msgs);
      msgs = basicSetExpr1(newExpr1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__EXPR1, newExpr1, newExpr1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpr2()
  {
    return expr2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr2(Expression newExpr2, NotificationChain msgs)
  {
    Expression oldExpr2 = expr2;
    expr2 = newExpr2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__EXPR2, oldExpr2, newExpr2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr2(Expression newExpr2)
  {
    if (newExpr2 != expr2)
    {
      NotificationChain msgs = null;
      if (expr2 != null)
        msgs = ((InternalEObject)expr2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__EXPR2, null, msgs);
      if (newExpr2 != null)
        msgs = ((InternalEObject)newExpr2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__EXPR2, null, msgs);
      msgs = basicSetExpr2(newExpr2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__EXPR2, newExpr2, newExpr2));
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
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        return basicSetSpecifier(null, msgs);
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        return basicSetType(null, msgs);
      case ParserPackage.TYPE_SPECIFIER__TYPE_NAME:
        return basicSetTypeName(null, msgs);
      case ParserPackage.TYPE_SPECIFIER__CONST_EXPR:
        return basicSetConstExpr(null, msgs);
      case ParserPackage.TYPE_SPECIFIER__EXPR1:
        return basicSetExpr1(null, msgs);
      case ParserPackage.TYPE_SPECIFIER__EXPR2:
        return basicSetExpr2(null, msgs);
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        return getName();
      case ParserPackage.TYPE_SPECIFIER__EXT_TYPE:
        return getExtType();
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        return getSpecifier();
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        return getType();
      case ParserPackage.TYPE_SPECIFIER__TYPE_OF:
        return getTypeOf();
      case ParserPackage.TYPE_SPECIFIER__TYPE_NAME:
        return getTypeName();
      case ParserPackage.TYPE_SPECIFIER__CONST_EXPR:
        return getConstExpr();
      case ParserPackage.TYPE_SPECIFIER__BUILTIN_CHOOSE_EXPR:
        return isBuiltinChooseExpr();
      case ParserPackage.TYPE_SPECIFIER__EXPR1:
        return getExpr1();
      case ParserPackage.TYPE_SPECIFIER__EXPR2:
        return getExpr2();
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        setName((String)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__EXT_TYPE:
        setExtType((String)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        setSpecifier((DeclarationSpecifier)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        setType((TypedefName)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE_OF:
        setTypeOf((String)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE_NAME:
        setTypeName((TypeName)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__CONST_EXPR:
        setConstExpr((Expression)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__BUILTIN_CHOOSE_EXPR:
        setBuiltinChooseExpr((Boolean)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__EXPR1:
        setExpr1((Expression)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__EXPR2:
        setExpr2((Expression)newValue);
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ParserPackage.TYPE_SPECIFIER__EXT_TYPE:
        setExtType(EXT_TYPE_EDEFAULT);
        return;
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        setSpecifier((DeclarationSpecifier)null);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        setType((TypedefName)null);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE_OF:
        setTypeOf(TYPE_OF_EDEFAULT);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE_NAME:
        setTypeName((TypeName)null);
        return;
      case ParserPackage.TYPE_SPECIFIER__CONST_EXPR:
        setConstExpr((Expression)null);
        return;
      case ParserPackage.TYPE_SPECIFIER__BUILTIN_CHOOSE_EXPR:
        setBuiltinChooseExpr(BUILTIN_CHOOSE_EXPR_EDEFAULT);
        return;
      case ParserPackage.TYPE_SPECIFIER__EXPR1:
        setExpr1((Expression)null);
        return;
      case ParserPackage.TYPE_SPECIFIER__EXPR2:
        setExpr2((Expression)null);
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ParserPackage.TYPE_SPECIFIER__EXT_TYPE:
        return EXT_TYPE_EDEFAULT == null ? extType != null : !EXT_TYPE_EDEFAULT.equals(extType);
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        return specifier != null;
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        return type != null;
      case ParserPackage.TYPE_SPECIFIER__TYPE_OF:
        return TYPE_OF_EDEFAULT == null ? typeOf != null : !TYPE_OF_EDEFAULT.equals(typeOf);
      case ParserPackage.TYPE_SPECIFIER__TYPE_NAME:
        return typeName != null;
      case ParserPackage.TYPE_SPECIFIER__CONST_EXPR:
        return constExpr != null;
      case ParserPackage.TYPE_SPECIFIER__BUILTIN_CHOOSE_EXPR:
        return builtinChooseExpr != BUILTIN_CHOOSE_EXPR_EDEFAULT;
      case ParserPackage.TYPE_SPECIFIER__EXPR1:
        return expr1 != null;
      case ParserPackage.TYPE_SPECIFIER__EXPR2:
        return expr2 != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", extType: ");
    result.append(extType);
    result.append(", typeOf: ");
    result.append(typeOf);
    result.append(", builtinChooseExpr: ");
    result.append(builtinChooseExpr);
    result.append(')');
    return result.toString();
  }

} //TypeSpecifierImpl
