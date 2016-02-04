/**
 */
package at.jku.weiner.kefax.dotconfig.dotconfig.util;

import at.jku.weiner.kefax.dotconfig.dotconfig.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage
 * @generated
 */
public class DotconfigAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DotconfigPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DotconfigAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = DotconfigPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DotconfigSwitch<Adapter> modelSwitch =
    new DotconfigSwitch<Adapter>()
    {
      @Override
      public Adapter caseDotConfigModel(DotConfigModel object)
      {
        return createDotConfigModelAdapter();
      }
      @Override
      public Adapter caseConfig(Config object)
      {
        return createConfigAdapter();
      }
      @Override
      public Adapter caseConfigString(ConfigString object)
      {
        return createConfigStringAdapter();
      }
      @Override
      public Adapter caseConfigLogic(ConfigLogic object)
      {
        return createConfigLogicAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.kefax.dotconfig.dotconfig.DotConfigModel <em>Dot Config Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotConfigModel
   * @generated
   */
  public Adapter createDotConfigModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.kefax.dotconfig.dotconfig.Config <em>Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.Config
   * @generated
   */
  public Adapter createConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.kefax.dotconfig.dotconfig.ConfigString <em>Config String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.ConfigString
   * @generated
   */
  public Adapter createConfigStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.kefax.dotconfig.dotconfig.ConfigLogic <em>Config Logic</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.ConfigLogic
   * @generated
   */
  public Adapter createConfigLogicAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //DotconfigAdapterFactory
