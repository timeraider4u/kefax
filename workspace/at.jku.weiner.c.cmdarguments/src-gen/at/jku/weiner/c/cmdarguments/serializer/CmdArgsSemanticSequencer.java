/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.cmdarguments.serializer;

import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Model;
import at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.c.cmdarguments.services.CmdArgsGrammarAccess;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class CmdArgsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CmdArgsGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CmdArgsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CmdArgsPackage.ARGUMENT:
				sequence_Argument(context, (Argument) semanticObject); 
				return; 
			case CmdArgsPackage.CMD_LINE:
				sequence_CmdLine(context, (CmdLine) semanticObject); 
				return; 
			case CmdArgsPackage.FUNCTION_MACRO:
				sequence_FunctionMacro(context, (FunctionMacro) semanticObject); 
				return; 
			case CmdArgsPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case CmdArgsPackage.OBJECT_MACRO:
				sequence_ObjectMacro(context, (ObjectMacro) semanticObject); 
				return; 
			case CmdArgsPackage.PATH_CMD:
				sequence_PathCmd(context, (PathCmd) semanticObject); 
				return; 
			case CmdArgsPackage.SIMPLE_MACRO:
				sequence_SimpleMacro(context, (SimpleMacro) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         macro=Macro | 
	 *         (incDir?=IncDir useIncDir=PathCmd) | 
	 *         (incSys?=IncSys useIncDir=PathCmd) | 
	 *         nostdinc?=NoStdInc | 
	 *         include=PathCmd | 
	 *         out=PathCmd | 
	 *         option=Option | 
	 *         in=Option
	 *     )
	 */
	protected void sequence_Argument(EObject context, Argument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (arguments+=Argument arguments+=Argument*)
	 */
	protected void sequence_CmdLine(EObject context, CmdLine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier (params+=Identifier params+=Identifier*)? value=MyCode)
	 */
	protected void sequence_FunctionMacro(EObject context, FunctionMacro semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((lines+=CmdLine lines+=CmdLine*)?)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier value=MyCode)
	 */
	protected void sequence_ObjectMacro(EObject context, ObjectMacro semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CmdArgsPackage.Literals.MACRO__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CmdArgsPackage.Literals.MACRO__NAME));
			if(transientValues.isValueTransient(semanticObject, CmdArgsPackage.Literals.OBJECT_MACRO__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CmdArgsPackage.Literals.OBJECT_MACRO__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getObjectMacroAccess().getNameIdentifierParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getObjectMacroAccess().getValueMyCodeParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     path=Path
	 */
	protected void sequence_PathCmd(EObject context, PathCmd semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CmdArgsPackage.Literals.PATH_CMD__PATH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CmdArgsPackage.Literals.PATH_CMD__PATH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPathCmdAccess().getPathPathParserRuleCall_0(), semanticObject.getPath());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=Identifier
	 */
	protected void sequence_SimpleMacro(EObject context, SimpleMacro semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CmdArgsPackage.Literals.MACRO__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CmdArgsPackage.Literals.MACRO__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleMacroAccess().getNameIdentifierParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
