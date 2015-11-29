/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Unary Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryOperator()
 * @model
 * @generated
 */
public enum UnaryOperator implements Enumerator
{
  /**
   * The '<em><b>SKW AND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SKW_AND_VALUE
   * @generated
   * @ordered
   */
  SKW_AND(0, "SKW_AND", "SKW_AND"),

  /**
   * The '<em><b>SKW STAR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SKW_STAR_VALUE
   * @generated
   * @ordered
   */
  SKW_STAR(1, "SKW_STAR", "SKW_STAR"),

  /**
   * The '<em><b>SKW PLUS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SKW_PLUS_VALUE
   * @generated
   * @ordered
   */
  SKW_PLUS(2, "SKW_PLUS", "SKW_PLUS"),

  /**
   * The '<em><b>SKW MINUS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SKW_MINUS_VALUE
   * @generated
   * @ordered
   */
  SKW_MINUS(3, "SKW_MINUS", "SKW_MINUS"),

  /**
   * The '<em><b>SKW TILDE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SKW_TILDE_VALUE
   * @generated
   * @ordered
   */
  SKW_TILDE(4, "SKW_TILDE", "SKW_TILDE"),

  /**
   * The '<em><b>SKW NOT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SKW_NOT_VALUE
   * @generated
   * @ordered
   */
  SKW_NOT(5, "SKW_NOT", "SKW_NOT");

  /**
   * The '<em><b>SKW AND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SKW AND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SKW_AND
   * @model
   * @generated
   * @ordered
   */
  public static final int SKW_AND_VALUE = 0;

  /**
   * The '<em><b>SKW STAR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SKW STAR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SKW_STAR
   * @model
   * @generated
   * @ordered
   */
  public static final int SKW_STAR_VALUE = 1;

  /**
   * The '<em><b>SKW PLUS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SKW PLUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SKW_PLUS
   * @model
   * @generated
   * @ordered
   */
  public static final int SKW_PLUS_VALUE = 2;

  /**
   * The '<em><b>SKW MINUS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SKW MINUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SKW_MINUS
   * @model
   * @generated
   * @ordered
   */
  public static final int SKW_MINUS_VALUE = 3;

  /**
   * The '<em><b>SKW TILDE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SKW TILDE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SKW_TILDE
   * @model
   * @generated
   * @ordered
   */
  public static final int SKW_TILDE_VALUE = 4;

  /**
   * The '<em><b>SKW NOT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SKW NOT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SKW_NOT
   * @model
   * @generated
   * @ordered
   */
  public static final int SKW_NOT_VALUE = 5;

  /**
   * An array of all the '<em><b>Unary Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final UnaryOperator[] VALUES_ARRAY =
    new UnaryOperator[]
    {
      SKW_AND,
      SKW_STAR,
      SKW_PLUS,
      SKW_MINUS,
      SKW_TILDE,
      SKW_NOT,
    };

  /**
   * A public read-only list of all the '<em><b>Unary Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<UnaryOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Unary Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static UnaryOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UnaryOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Unary Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static UnaryOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UnaryOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Unary Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static UnaryOperator get(int value)
  {
    switch (value)
    {
      case SKW_AND_VALUE: return SKW_AND;
      case SKW_STAR_VALUE: return SKW_STAR;
      case SKW_PLUS_VALUE: return SKW_PLUS;
      case SKW_MINUS_VALUE: return SKW_MINUS;
      case SKW_TILDE_VALUE: return SKW_TILDE;
      case SKW_NOT_VALUE: return SKW_NOT;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private UnaryOperator(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
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
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //UnaryOperator
