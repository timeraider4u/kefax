/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.ArgumentExpressionList;
import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.PostfixExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getArrayExpr <em>Array Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getArgumentExpressionList <em>Argument Expression List</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getDot <em>Dot</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getArrow <em>Arrow</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getMinusminus <em>Minusminus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PostfixExpressionImpl extends ExpressionImpl implements PostfixExpression
{
  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> expr;

  /**
   * The cached value of the '{@link #getArrayExpr() <em>Array Expr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayExpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> arrayExpr;

  /**
   * The cached value of the '{@link #getArgumentExpressionList() <em>Argument Expression List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgumentExpressionList()
   * @generated
   * @ordered
   */
  protected EList<ArgumentExpressionList> argumentExpressionList;

  /**
   * The cached value of the '{@link #getDot() <em>Dot</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDot()
   * @generated
   * @ordered
   */
  protected EList<String> dot;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected EList<String> id;

  /**
   * The cached value of the '{@link #getArrow() <em>Arrow</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrow()
   * @generated
   * @ordered
   */
  protected EList<String> arrow;

  /**
   * The cached value of the '{@link #getPlusplus() <em>Plusplus</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlusplus()
   * @generated
   * @ordered
   */
  protected EList<String> plusplus;

  /**
   * The cached value of the '{@link #getMinusminus() <em>Minusminus</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinusminus()
   * @generated
   * @ordered
   */
  protected EList<String> minusminus;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostfixExpressionImpl()
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
    return CPackage.Literals.POSTFIX_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getExpr()
  {
    if (expr == null)
    {
      expr = new EObjectContainmentEList<Expression>(Expression.class, this, CPackage.POSTFIX_EXPRESSION__EXPR);
    }
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArrayExpr()
  {
    if (arrayExpr == null)
    {
      arrayExpr = new EObjectContainmentEList<Expression>(Expression.class, this, CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR);
    }
    return arrayExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ArgumentExpressionList> getArgumentExpressionList()
  {
    if (argumentExpressionList == null)
    {
      argumentExpressionList = new EObjectContainmentEList<ArgumentExpressionList>(ArgumentExpressionList.class, this, CPackage.POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST);
    }
    return argumentExpressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDot()
  {
    if (dot == null)
    {
      dot = new EDataTypeEList<String>(String.class, this, CPackage.POSTFIX_EXPRESSION__DOT);
    }
    return dot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getId()
  {
    if (id == null)
    {
      id = new EDataTypeEList<String>(String.class, this, CPackage.POSTFIX_EXPRESSION__ID);
    }
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getArrow()
  {
    if (arrow == null)
    {
      arrow = new EDataTypeEList<String>(String.class, this, CPackage.POSTFIX_EXPRESSION__ARROW);
    }
    return arrow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getPlusplus()
  {
    if (plusplus == null)
    {
      plusplus = new EDataTypeEList<String>(String.class, this, CPackage.POSTFIX_EXPRESSION__PLUSPLUS);
    }
    return plusplus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMinusminus()
  {
    if (minusminus == null)
    {
      minusminus = new EDataTypeEList<String>(String.class, this, CPackage.POSTFIX_EXPRESSION__MINUSMINUS);
    }
    return minusminus;
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
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        return ((InternalEList<?>)getExpr()).basicRemove(otherEnd, msgs);
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        return ((InternalEList<?>)getArrayExpr()).basicRemove(otherEnd, msgs);
      case CPackage.POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST:
        return ((InternalEList<?>)getArgumentExpressionList()).basicRemove(otherEnd, msgs);
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
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        return getExpr();
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        return getArrayExpr();
      case CPackage.POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST:
        return getArgumentExpressionList();
      case CPackage.POSTFIX_EXPRESSION__DOT:
        return getDot();
      case CPackage.POSTFIX_EXPRESSION__ID:
        return getId();
      case CPackage.POSTFIX_EXPRESSION__ARROW:
        return getArrow();
      case CPackage.POSTFIX_EXPRESSION__PLUSPLUS:
        return getPlusplus();
      case CPackage.POSTFIX_EXPRESSION__MINUSMINUS:
        return getMinusminus();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        getExpr().clear();
        getExpr().addAll((Collection<? extends Expression>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        getArrayExpr().clear();
        getArrayExpr().addAll((Collection<? extends Expression>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST:
        getArgumentExpressionList().clear();
        getArgumentExpressionList().addAll((Collection<? extends ArgumentExpressionList>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__DOT:
        getDot().clear();
        getDot().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__ID:
        getId().clear();
        getId().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__ARROW:
        getArrow().clear();
        getArrow().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__PLUSPLUS:
        getPlusplus().clear();
        getPlusplus().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__MINUSMINUS:
        getMinusminus().clear();
        getMinusminus().addAll((Collection<? extends String>)newValue);
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
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        getExpr().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        getArrayExpr().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST:
        getArgumentExpressionList().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__DOT:
        getDot().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__ID:
        getId().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__ARROW:
        getArrow().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__PLUSPLUS:
        getPlusplus().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__MINUSMINUS:
        getMinusminus().clear();
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
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        return expr != null && !expr.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        return arrayExpr != null && !arrayExpr.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST:
        return argumentExpressionList != null && !argumentExpressionList.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__DOT:
        return dot != null && !dot.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__ID:
        return id != null && !id.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__ARROW:
        return arrow != null && !arrow.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__PLUSPLUS:
        return plusplus != null && !plusplus.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__MINUSMINUS:
        return minusminus != null && !minusminus.isEmpty();
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
    result.append(" (dot: ");
    result.append(dot);
    result.append(", id: ");
    result.append(id);
    result.append(", arrow: ");
    result.append(arrow);
    result.append(", plusplus: ");
    result.append(plusplus);
    result.append(", minusminus: ");
    result.append(minusminus);
    result.append(')');
    return result.toString();
  }

} //PostfixExpressionImpl
