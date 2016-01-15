/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.parser.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import at.jku.weiner.c.common.common.Model
import at.jku.weiner.c.common.common.TranslationUnit
import at.jku.weiner.c.parser.parser.ExternalDeclaration
import at.jku.weiner.c.parser.parser.Declaration
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers
import at.jku.weiner.c.parser.parser.StorageClassSpecifier
import at.jku.weiner.c.parser.parser.TypeSpecifier
import at.jku.weiner.c.parser.parser.TypeQualifier
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier
import at.jku.weiner.c.parser.parser.InitDeclaratorList
import at.jku.weiner.c.parser.parser.InitDeclarator
import at.jku.weiner.c.parser.parser.DirectDeclarator
import at.jku.weiner.c.parser.parser.Declarator
import at.jku.weiner.c.parser.parser.FunctionDefHead
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers
import at.jku.weiner.c.parser.parser.FunctionDefinition
import at.jku.weiner.c.parser.parser.Statement
import at.jku.weiner.c.parser.parser.DeclaratorSuffix
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix
import at.jku.weiner.c.parser.parser.IdentifierList
import at.jku.weiner.c.parser.parser.ParameterTypeList
import at.jku.weiner.c.parser.parser.ParameterList
import at.jku.weiner.c.parser.parser.ParameterDeclaration
import org.eclipse.xtend.lib.annotations.Accessors
import at.jku.weiner.c.parser.parser.LabeledStatement
import at.jku.weiner.c.parser.parser.CompoundStatement
import at.jku.weiner.c.parser.parser.BodyStatement
import at.jku.weiner.c.parser.parser.ExpressionStatement
import at.jku.weiner.c.parser.parser.SelectionStatement
import at.jku.weiner.c.parser.parser.IterationStatement
import at.jku.weiner.c.parser.parser.JumpStatement
import at.jku.weiner.c.parser.parser.AsmStatement
import at.jku.weiner.c.parser.parser.Expression
import at.jku.weiner.c.parser.parser.AssignmentExpression
import at.jku.weiner.c.parser.parser.AssignmentOperator
import at.jku.weiner.c.parser.parser.ConditionalExpression
import at.jku.weiner.c.parser.parser.LogicalOrExpression
import at.jku.weiner.c.parser.parser.LogicalAndExpression
import at.jku.weiner.c.parser.parser.InclusiveOrExpression
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression
import at.jku.weiner.c.parser.parser.AndExpression
import at.jku.weiner.c.parser.parser.EqualityExpression
import at.jku.weiner.c.parser.parser.RelationalExpression
import at.jku.weiner.c.parser.parser.ShiftExpression
import at.jku.weiner.c.parser.parser.AdditiveExpression
import at.jku.weiner.c.parser.parser.MultiplicativeExpression
import at.jku.weiner.c.parser.parser.CastExpression
import at.jku.weiner.c.parser.parser.UnaryExpression
import at.jku.weiner.c.parser.parser.UnaryOperator
import at.jku.weiner.c.parser.parser.PostfixExpression
import at.jku.weiner.c.parser.parser.PrimaryExpression
import at.jku.weiner.c.common.common.Constant2
import at.jku.weiner.c.parser.parser.ConstantExpression
import at.jku.weiner.c.parser.parser.BlockList
import at.jku.weiner.c.parser.parser.TypeName
import at.jku.weiner.c.parser.parser.SpecifierQualifierList
import at.jku.weiner.c.parser.parser.StructDeclarationList
import at.jku.weiner.c.parser.parser.StructDeclaration
import at.jku.weiner.c.parser.parser.StructDeclarator
import at.jku.weiner.c.parser.parser.StructDeclaratorList
import at.jku.weiner.c.parser.parser.ArgumentExpressionList
import at.jku.weiner.c.parser.parser.Pointer
import at.jku.weiner.c.parser.parser.TypeQualifierList
import at.jku.weiner.c.parser.parser.Initializer
import at.jku.weiner.c.parser.parser.InitializerList
import at.jku.weiner.c.parser.parser.AsmLineWithColon
import at.jku.weiner.c.parser.parser.FunctionSpecifier
import at.jku.weiner.c.parser.parser.EnumSpecifier
import at.jku.weiner.c.parser.parser.EnumeratorList
import at.jku.weiner.c.parser.parser.Enumerator
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixPlusPlus
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixMinusMinus
import at.jku.weiner.c.parser.parser.Parser
import at.jku.weiner.c.parser.parser.AbstractDeclarator
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier
import at.jku.weiner.c.parser.parser.GccAttributeList
import at.jku.weiner.c.parser.parser.GccAttribute
import org.eclipse.emf.common.util.EList
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon
import at.jku.weiner.c.parser.parser.AsmLine
import at.jku.weiner.c.parser.parser.Designation
import at.jku.weiner.c.parser.parser.DesignatorList
import at.jku.weiner.c.parser.parser.Designator
import at.jku.weiner.c.parser.parser.AsmSymbolicName
import at.jku.weiner.c.parser.parser.DirectAbstractDeclarator
import at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix
import at.jku.weiner.c.parser.parser.Init

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ParserGenerator implements IGenerator {
	
	@Accessors String fileName = 'hello_world.cdt.c';
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		val parser = input.allContents.filter(typeof(Parser)).head;
		//val unit = model.units.head;
		val output = outputFor(parser);
		fsa.generateFile(fileName, output);
	}

	def String outputFor(Parser parser) {
		val StringBuffer result = new StringBuffer("");
		for (e : parser.external) {
			result.append(outputFor(e));
		}
		return result.toString();
	}
	
	def String outputFor(ExternalDeclaration dec) '''
		«IF dec.functiondefHead != null»
			«outputFor(dec.functiondefHead)» {
				«outputFor(dec.functionDefinition)»
			}
		«ENDIF»
		«outputFor(dec.declaration)»
		«IF dec.semi != null»
			«dec.semi»
		«ENDIF»
	'''
	
	def String outputFor(FunctionDefHead dec) '''
		«IF dec.funDeclSpecifiers != null»
			«outputFor(dec.funDeclSpecifiers)»
		«ENDIF»
		«outputFor(dec.funDeclarator)»
		«FOR f : dec.funDeclaration»
			«outputFor(f)»
		«ENDFOR»
	'''
	
	def String outputFor(FunctionDeclarationSpecifiers spec) '''
		«FOR s : spec.declarationSpecifier»
			«IF s instanceof StorageClassSpecifier»
			«outputFor(s)»
			«ENDIF»
			«IF s instanceof TypeSpecifier»
			«outputFor(s)»
			«ENDIF»
			«IF s instanceof TypeQualifier»
			«outputFor(s)»
			«ENDIF»
			«IF s instanceof FunctionSpecifier»
			«outputFor(s)»
			«ENDIF»
		«ENDFOR»
	'''
	
	def String outputFor(FunctionDefinition obj) '''
		«outputFor(obj.body)»
	'''
	
	def String outputFor(Declaration dec) '''
		«IF dec != null»
			«outputFor(dec.specifiers)»
			«FOR list : dec.initDeclaratorList»
				«outputFor(list)»
			«ENDFOR»
			«IF dec.semi != null»
				«dec.semi»
			«ENDIF»
		«ENDIF»
	'''
	
	def String outputFor(DeclarationSpecifiers spec) '''
		«FOR s : spec.declarationSpecifier»
			«IF s instanceof StorageClassSpecifier»
			«outputFor(s)»
			«ENDIF»
			«IF s instanceof TypeSpecifier»
			«outputFor(s)»
			«ENDIF»
			«IF s instanceof TypeQualifier»
			«outputFor(s)»
			«ENDIF»
			«IF s instanceof FunctionSpecifier»
			«outputFor(s)»
			«ENDIF»
			«IF s instanceof StructOrUnionSpecifier»
			«outputFor(s)»
			«ENDIF»
		«ENDFOR»
	'''
	
	def String outputFor(StorageClassSpecifier spec) '''
		«spec.name»
	'''
	
	def String outputFor(TypeQualifier spec) '''
		«spec.type»
	'''
	
	def String outputFor(FunctionSpecifier spec) '''
	«IF spec.name != null»«spec.name»«ENDIF»
	«IF spec.gccAttributeSpecifier != null»«outputFor(spec.gccAttributeSpecifier)»«ENDIF»
	'''
	
	def String outputFor(TypeSpecifier spec) '''
		«IF spec.specifier != null»
			«IF spec.specifier instanceof EnumSpecifier»
				«outputFor(spec.specifier as EnumSpecifier)»
			«ENDIF»
			«IF spec.specifier instanceof StructOrUnionSpecifier»
				«outputFor(spec.specifier as StructOrUnionSpecifier)»
			«ENDIF»
		«ENDIF»
		«IF spec.type != null»
			«spec.type.id»
		«ENDIF»
		«IF spec.name != null»
			«spec.name»
		«ENDIF»
		«IF spec.typeOf != null»«spec.typeOf»(
			«IF spec.constExpr != null»«outputForConstantExpression(spec.constExpr as ConstantExpression)»«ENDIF»
			«IF spec.typeName != null»«outputFor(spec.typeName)»«ENDIF»
		)«ENDIF»
	'''
	
	def String outputFor(StructOrUnionSpecifier obj) '''
		«obj.type.name» «IF obj.id != null»«obj.id»«ENDIF»
		«IF obj.braces»{«IF obj.structDeclList != null»«outputFor(obj.structDeclList)»«ENDIF»}«ENDIF»
	'''
	
	def String outputFor(StructDeclarationList obj) '''
		«FOR s: obj.structDeclaration»
			«outputFor(s)»
		«ENDFOR»
	'''
	
	def String outputFor(StructDeclaration obj) '''
		«outputFor(obj.list)»
		«IF obj.structDeclarationList != null»«outputFor(obj.structDeclarationList)»«ENDIF»;
	'''
	
	def String outputFor(StructDeclaratorList obj) '''
		«FOR p : obj.structDeclarator»
			«IF obj.structDeclarator.indexOf(p) > 0», «ENDIF»
			«outputFor(p)»
		«ENDFOR»
	''' 
	
	def String outputFor(StructDeclarator obj) '''
		«IF obj.declarator != null»«outputFor(obj.declarator)»«ENDIF»
		«IF obj.constExpr != null && obj.constExpr.size > 0»:
		«FOR e: obj.constExpr»
			«outputForConstantExpression(e as ConstantExpression)»
		«ENDFOR»
		«ENDIF»
	'''
	
	def String outputFor(EnumSpecifier obj) '''
		enum «IF obj.id != null»«obj.id»«ENDIF»
		«IF obj.enumList != null»
			{
				«outputFor(obj.enumList)»
			}
		«ENDIF»
	'''
	
	def String outputFor(EnumeratorList obj) '''
		«FOR e : obj.enumerator»
			«IF obj.enumerator.indexOf(e) > 0», «ENDIF»
			«outputFor(e)»
		«ENDFOR»
	'''
	
	def String outputFor(Enumerator obj) '''
		«obj.id»
		«IF obj.expr != null»
			=
			«outputForConstantExpression(obj.expr as ConstantExpression)»
		«ENDIF»
	'''
	
	def String outputFor(InitDeclaratorList list) '''
		«FOR initDeclarator : list.initDeclarator»
			«IF list.initDeclarator.indexOf(initDeclarator) > 0», «ENDIF»
			«outputFor(initDeclarator)»
		«ENDFOR»
	'''
	
	def String outputFor(InitDeclarator decl) '''
		«outputFor(decl.declarator)»
		«IF decl.initializer != null»
			= «outputFor(decl.initializer)»
		«ENDIF»
	'''
	
	def String outputFor(Declarator decl) '''
		«IF decl.pointer != null»«outputFor(decl.pointer)»«ENDIF»
		«IF decl.gccDeclExt1 != null»«outputFor(decl.gccDeclExt1)»«ENDIF»
		«outputFor(decl.declarator)»
		«IF decl.gccDeclExt2 != null»«outputFor(decl.gccDeclExt2)»«ENDIF»
	'''
	
	def String outputFor(DirectDeclarator decl) '''
		«IF decl.id != null»
		«decl.id»
		«ELSE»
		(«outputFor(decl.declarator)»)
		«ENDIF»
		«FOR d : decl.declaratorSuffix»
			«outputFor(d)»
		«ENDFOR»
	'''
	
	def String outputFor(DeclaratorSuffix obj) '''
		«IF obj.lastSuffix != null»
			«outputFor(obj.lastSuffix)»
		«ELSE»
			[
«««			«IF obj.typeQualifierList != null»
«««				«outputFor(obj.typeQualifierList)»
«««			«ENDIF»
			«IF obj.expr != null»
				«outputForAssignmentExpression(obj.expr as AssignmentExpression)»
			«ENDIF»
			]
		«ENDIF»
	'''
	
	def String outputFor(DirectDeclaratorLastSuffix obj) '''
		(
		«IF obj.parameterTypeList != null»
			«FOR l : obj.parameterTypeList»
				«outputFor(l)»
			«ENDFOR»
		«ENDIF»
		«IF obj.identifierList != null»
			«outputFor(obj.identifierList)»
		«ENDIF»
		)
	'''
	
	def String outputFor(Pointer obj) '''
		«FOR s: obj.star»«s»«ENDFOR»
		«FOR c: obj.caret»«c»«ENDFOR»
		«FOR t: obj.typeQualifierList»«outputFor(t)»«ENDFOR»
	'''
	
	def String outputFor(TypeQualifierList l) '''
		«FOR t : l.typeQualifier»
			«outputFor(t)»
		«ENDFOR»
	'''
	
	def String outputFor(ParameterTypeList obj) '''
	«IF obj != null»
		«outputFor(obj.list)»
	«ENDIF»
	«IF obj.ellipsis»
		,...
	«ENDIF»
	'''
	
	def String outputFor(ParameterList obj) '''
		«FOR p : obj.parameterDeclaration»
			«IF obj.parameterDeclaration.indexOf(p) > 0», «ENDIF»
			«outputFor(p)»
		«ENDFOR»
	'''
	
	def String outputFor(ParameterDeclaration obj) '''
		«outputFor(obj.declSpecifiers)»
		«IF obj.declarator != null»
			«outputFor(obj.declarator)»
		«ENDIF»
		«IF obj.abstractDeclator != null»
			«outputFor(obj.abstractDeclator)»
		«ENDIF»
	''' 
	
	def String outputFor(IdentifierList obj) '''
		«FOR i : obj.id»
			«IF obj.id.indexOf(i) > 0», «ENDIF»
			«i.id»
		«ENDFOR»
	'''
	
	def String outputFor(Initializer obj) '''
		«IF obj.expr != null»
			«outputForAssignmentExpression(obj.expr as AssignmentExpression)»
		«ENDIF»
		«IF obj.list != null»
			{	«outputFor(obj.list)» }
		«ENDIF»
	'''
	
	def String outputFor(InitializerList obj) '''
		«FOR i : obj.init»
			«IF obj.init.indexOf(i) > 0», «ENDIF»
			«outputFor(i)»
		«ENDFOR»
	'''
	
	def String outputFor(Init obj) '''
		«IF obj.designation != null»«outputFor(obj.designation)»«ENDIF»
		«IF obj.initializer != null»«outputFor(obj.initializer)»«ENDIF»
	'''
	
	def String outputFor(Designation obj)'''
		«outputFor(obj.list)»=
	'''
	
	def String outputFor(DesignatorList obj) '''
		«FOR d : obj.designator»
			«outputFor(d)»
		«ENDFOR»
	'''
	
	def String outputFor(Designator obj) '''
		«IF obj.expr != null»[«outputForConstantExpression(obj.expr as ConstantExpression)»
			«IF obj.to != null»...«outputForConstantExpression(obj.to as ConstantExpression)»«ENDIF»
			]«ENDIF»
		«IF obj.id != null».«obj.id»«ENDIF»
	'''
	
	def String outputFor(EList<GccDeclaratorExtension> obj) {
		val StringBuffer result = new StringBuffer("");
		for (var int i = 0; i < obj.size(); i++) {
			val GccDeclaratorExtension ext = obj.get(i);
			result.append(outputFor(ext));
		}
		return result.toString();
	}
	
	def String outputFor(GccDeclaratorExtension obj) '''
		«IF obj.asm != null»«obj.asm»(«outputFor(obj.string, false)»)«ENDIF»
		«IF obj.gccAttributeSpecifier != null»«outputFor(obj.gccAttributeSpecifier)»«ENDIF»
	'''
	
	def String outputFor(EList<String> obj, boolean addCommas) {
		val StringBuffer result = new StringBuffer("");
		var boolean isFirst = true;
		for (var int i = 0; i < obj.size(); i++) {
			if (!isFirst && addCommas) {
				result.append(",");
			}
			val String str = obj.get(i);
			result.append(str);
			isFirst = false;
		}
		return result.toString();
	}
	
	def String outputFor(GccAttributeSpecifier obj) '''
		«obj.attribute»((«IF obj.list != null»«outputFor(obj.list)»«ENDIF»))
	'''
	
	def String outputFor(GccAttributeList obj) {
		val StringBuffer result = new StringBuffer("");
		var boolean isFirst = true;
		for (var int i = 0; i < obj.gccAttribute.size(); i++) {
			if (!isFirst) {
				result.append(",");
			}
			val GccAttribute attr = obj.gccAttribute.get(i);
			result.append(outputFor(attr));
			
			isFirst = false;
		}	
		return result.toString();
	}
	
	def String outputFor(GccAttribute attr) '''
		«IF attr.id != null»«attr.id»«ENDIF»
		«IF attr.const != null»«attr.const»«ENDIF»
		«IF attr.keyword != null»«attr.keyword»«ENDIF»
		«IF attr.list != null»(«outputFor(attr.list)»)«ENDIF»
	'''
	
	
	def String outputFor(Statement obj) '''
		«IF obj.stmt != null»«outputFor(obj.stmt)»«ENDIF»
		«IF obj instanceof LabeledStatement»«outputForLabeledStatement(obj)»«ENDIF»
		«IF obj instanceof CompoundStatement»«outputForCompoundStatement(obj)»«ENDIF»
		«IF obj instanceof BodyStatement»«outputForBodyStatement(obj)»«ENDIF»
		«IF obj instanceof ExpressionStatement»«outputForExpressionStatement(obj)»«ENDIF»
		«IF obj instanceof SelectionStatement»«outputForSelectionStatement(obj)»«ENDIF»
		«IF obj instanceof IterationStatement»«outputForIterationStatement(obj)»«ENDIF»
		«IF obj instanceof JumpStatement»«outputForJumpStatement(obj)»«ENDIF»
		«IF obj instanceof AsmStatement»«outputForAsmStatement(obj)»«ENDIF»
	'''
	
	def String outputForLabeledStatement(LabeledStatement obj) '''
		«IF obj.id != null»«obj.id»:«outputFor(obj.LStmt)»«ENDIF»
		«IF obj.getCase() != null»case 
			«IF obj.expr != null»«outputForConstantExpression(obj.expr as ConstantExpression)»
			«ELSE»«obj.lower»...«obj.higher»«ENDIF»
			:«outputFor(obj.LStmt)»«ENDIF»
		«IF obj.mydefault»default: «outputFor(obj.LStmt)»«ENDIF»
	'''
	
	def String outputForCompoundStatement(CompoundStatement obj) '''
		{
			«outputFor(obj.body)»
		}
	'''
	
	def String outputForBodyStatement(BodyStatement obj) '''
		«FOR l : obj.blockList»
			«outputFor(l)»
		«ENDFOR»
	'''
	
	def String outputFor(BlockList obj) '''
		«FOR d : obj.declaration»
			«outputFor(d)»
		«ENDFOR»
		«FOR s : obj.statement»
			«outputFor(s)»
		«ENDFOR»
	'''
	
	def String outputForExpressionStatement(ExpressionStatement obj) '''
		«IF obj.expression != null»«outputFor(obj.expression)»«ENDIF»;
	'''
	
	def String outputForSelectionStatement(SelectionStatement obj) '''
		«IF obj.getIf() != null»
			if («outputFor(obj.expr)»)
			«outputFor(obj.ifStatement)»
			«IF obj.getElse() != null»
				else «outputFor(obj.elseStatement)»
			«ENDIF»
		«ENDIF»
		«IF obj.getSwitch() != null»
			switch («outputFor(obj.expr)»)
			«outputFor(obj.switchStatement)»
		«ENDIF»
	'''
	
	def String outputForIterationStatement(IterationStatement obj) '''
		«IF obj.getWhile() != null»
			while («outputFor(obj.expr)»)
			«outputFor(obj.statement)»
		«ENDIF»
		«IF obj.getDo() != null»
			do
				«outputFor(obj.statement)»
			while («outputFor(obj.expr)»);
		«ENDIF»
		«IF obj.getFor() != null»
			for (
				«IF obj.initExpr != null»
					«outputFor(obj.initExpr)»
					;
				«ENDIF»
				«IF obj.initDecl != null»
					«outputFor(obj.initDecl)»
				«ENDIF»
				«IF obj.expr != null»
					«outputFor(obj.expr)»
				«ENDIF»
				;
				«IF obj.incExpr != null»
					«outputFor(obj.incExpr)»
				«ENDIF»
			)
			«outputFor(obj.statement)»
		«ENDIF»
	'''
	
	def String outputForJumpStatement(JumpStatement obj) '''
		«IF obj.continue != null»continue;«ENDIF»
		«IF obj.break != null»break;«ENDIF»
		«IF obj.getReturn() != null»return «IF obj.expr != null»«outputFor(obj.expr)»«ENDIF» ;«ENDIF»
		«IF obj.goto != null»goto «outputForUnaryExpression(obj.expr as UnaryExpression)»;«ENDIF»
	'''
	
	def String outputForAsmStatement(AsmStatement obj) '''
		«obj.asm» 
		«IF obj.volatile != null»
			«obj.volatile» 
		«ENDIF»
		(
			«IF obj.asmLine1 != null»
				«outputFor(obj.asmLine1)»
			«ENDIF»
			«FOR i : 0 ..< obj.asmLines.size()»
				«outputFor(obj.asmLines.get(i))»
			«ENDFOR»
			«IF obj.lastComma»,«ENDIF»
		);
	'''
	
	def String outputFor(AsmLine obj) '''
		«IF obj.sym != null»«outputFor(obj.sym)»«ENDIF»
		«outputForLogicalOrExpression(obj.expr as LogicalOrExpression)»
	'''
	
	def String outputFor(AsmSymbolicName obj) '''
		[«obj.id»]
	'''
	
	def String outputFor(AsmLineWithColon obj) '''
		: «IF obj.asmLine != null»«outputFor(obj.asmLine)»«ENDIF»
	'''
	
	def String outputFor(AsmLineWithoutColon obj) '''
		«FOR i : 0 ..< obj.asmLines.size()»
			«IF i > 0»,«ENDIF»
			«outputFor(obj.asmLines.get(i))»
		«ENDFOR»
	'''
	
	def String outputFor(Expression obj) '''
		«FOR e : obj.exprExpr»
			«IF obj.exprExpr.indexOf(e) > 0», «ENDIF»
			«outputForAssignmentExpression(e as AssignmentExpression)»
		«ENDFOR»
	'''
	
	def String outputForAssignmentExpression(AssignmentExpression obj) '''
		«IF obj.op != null»
			«outputForUnaryExpression(obj.expr as UnaryExpression)»
			«outputFor(obj.op)»
			«IF obj.assignmentExpr != null»
				«outputForAssignmentExpression(obj.assignmentExpr as AssignmentExpression)»
			«ENDIF»
		«ELSE»
			«outputForConditionalExpression(obj.expr as ConditionalExpression)»
		«ENDIF»
	'''
	
	def String outputFor(AssignmentOperator obj) '''
		«obj.op»
	'''
	
	def String outputForConditionalExpression(ConditionalExpression obj) '''
		«outputForLogicalOrExpression(obj.expr as LogicalOrExpression)»
		«IF obj.QExpr != null»
			?«outputFor(obj.QExpr)»:
			«outputForConditionalExpression(obj.CExpr as ConditionalExpression)»
		«ENDIF»
	'''
	
	def String outputForLogicalOrExpression(LogicalOrExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»||«ENDIF»
			«outputForLogicalAndExpression(e as LogicalAndExpression)»
		«ENDFOR»
	'''
	
	def String outputForLogicalAndExpression(LogicalAndExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»&&«ENDIF»
			«outputForInclusiveOrExpression(e as InclusiveOrExpression)»
		«ENDFOR»
	'''
	
	def String outputForInclusiveOrExpression(InclusiveOrExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»|«ENDIF»
			«outputForExclusiveOrExpression(e as ExclusiveOrExpression)»
		«ENDFOR»
	'''
	
	def String outputForExclusiveOrExpression(ExclusiveOrExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»^«ENDIF»
			«outputForAndExpression(e as AndExpression)»
		«ENDFOR»
	'''
	
	def String outputForAndExpression(AndExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»&«ENDIF»
			«outputForEqualityExpression(e as EqualityExpression)»
		«ENDFOR»
	'''
	
	def String outputForEqualityExpression(EqualityExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»«obj.op.get(obj.expr.indexOf(e)-1)»«ENDIF»
			«outputForRelationalExpression(e as RelationalExpression)»
		«ENDFOR»
	'''
	
	def String outputForRelationalExpression(RelationalExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»«obj.op.get(obj.expr.indexOf(e)-1)»«ENDIF»
			«outputForShiftExpression(e as ShiftExpression)»
		«ENDFOR»
	'''
	
	def String outputForShiftExpression(ShiftExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»«obj.op.get(obj.expr.indexOf(e)-1)»«ENDIF»
			«outputForAdditiveExpression(e as AdditiveExpression)»
		«ENDFOR»
	'''
	
	def String outputForAdditiveExpression(AdditiveExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»«obj.op.get(obj.expr.indexOf(e)-1)»«ENDIF»
			«outputForMultiplicativeExpression(e as MultiplicativeExpression)»
		«ENDFOR»
	'''
	
	def String outputForMultiplicativeExpression(MultiplicativeExpression obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»«obj.op.get(obj.expr.indexOf(e)-1)»«ENDIF»
			«outputForCastExpression(e as CastExpression)»
		«ENDFOR»
	'''
	
	def String outputForCastExpression(CastExpression obj) '''
		«IF obj.type != null»
			(«outputFor(obj.type)»)
			«outputForCastExpression(obj.expr as CastExpression)»
		«ELSE»
			«outputForUnaryExpression(obj.expr as UnaryExpression)»
		«ENDIF»
	'''
	
	def String outputFor(TypeName obj) '''
		«outputFor(obj.list)»
		«IF obj.abstractDeclarator != null»
			«outputFor(obj.abstractDeclarator)»
		«ENDIF»
	'''
	
	def String outputFor(SpecifierQualifierList obj) '''
		«FOR x : obj.typeSpecifier»
			«outputFor(x as TypeSpecifier)»
		«ENDFOR»
		«FOR x : obj.typeQualifier»
			«outputFor(x as TypeQualifier)»
		«ENDFOR»
	'''
	
	def String outputFor(AbstractDeclarator obj) '''
		«IF obj.pointer != null»«outputFor(obj.pointer)»«ENDIF»
		«IF obj.directAbstractDeclarator != null»«outputFor(obj.directAbstractDeclarator)»«ENDIF»
		«IF obj.gccDeclExtAbstract != null»«outputFor(obj.gccDeclExtAbstract)»«ENDIF»
	'''
	
	def String outputFor(DirectAbstractDeclarator obj) '''
		«IF obj.declarator != null»(«outputFor(obj.declarator)»)
			«IF obj.gccDeclExt != null»«outputFor(obj.gccDeclExt)»«ENDIF»
		«ENDIF»
		«IF obj.abstractDeclaratorSuffix != null»«outputForAbstractDeclSuff(obj.abstractDeclaratorSuffix)»«ENDIF»
	'''
	
	def String outputForAbstractDeclSuff(EList<AbstractDeclaratorSuffix> obj) {
		val StringBuffer result = new StringBuffer("");
		for (var i = 0; i < obj.size(); i++) {
			result.append(outputFor(obj.get(i)));
		}
		return result.toString();
	}
	
	def String outputFor(AbstractDeclaratorSuffix obj) '''
		«IF obj.parameterTypeList != null»(«outputFor(obj.parameterTypeList)»)«ENDIF»
	'''
		
	def String outputForUnaryExpression(UnaryExpression obj) '''
		«IF obj.plusplus != null»«obj.plusplus»«outputForUnaryExpression(obj.expr as UnaryExpression)»
		«ENDIF»
		«IF obj.minusminus != null»«obj.minusminus»«outputForUnaryExpression(obj.expr as UnaryExpression)»
		«ENDIF»
		«IF obj.sizeOf != null»«obj.sizeOf»
			«IF obj.typeName != null»(«outputFor(obj.typeName)»)
			«ELSE»«outputForUnaryExpression(obj.expr as UnaryExpression)»
			«ENDIF»
		«ENDIF»
		«IF obj.op != null»«outputFor(obj.op)»«outputForCastExpression(obj.expr as CastExpression)»
		«ENDIF»
		«IF obj.expr instanceof PostfixExpression»«outputForPostfixExpression(obj.expr as PostfixExpression)»
		«ENDIF»
		«IF obj.andand != null»«obj.andand»«obj.id»
		«ENDIF»
		«IF obj.alignOf != null»«obj.alignOf»(«outputFor(obj.typeName)»)«ENDIF»
	'''
	
	def String outputFor(UnaryOperator obj) '''
		«obj.op»
	'''
	
	def String outputForPostfixExpression(PostfixExpression obj) '''
		«FOR e : obj.expr»
			«outputForPrimaryExpression(e as PrimaryExpression)»
		«ENDFOR»
		«IF obj.typeName != null»
			«IF obj.ext»__extension__«ENDIF»
			(«outputFor(obj.typeName)»){
			«outputFor(obj.initializerList)»
			«IF obj.comma»,«ENDIF»
			}
		«ENDIF»
		«FOR s : obj.suffix»
			«IF s instanceof PostfixExpressionSuffixArray»
				«outputFor(s as PostfixExpressionSuffixArray)»
			«ENDIF»
			«IF s instanceof PostfixExpressionSuffixArgument»
				«outputFor(s as PostfixExpressionSuffixArgument)»
			«ENDIF»
			«IF s instanceof PostfixExpressionSuffixDot»
				«outputFor(s as PostfixExpressionSuffixDot)»
			«ENDIF»
			«IF s instanceof PostfixExpressionSuffixArrow»
				«outputFor(s as PostfixExpressionSuffixArrow)»
			«ENDIF»
			«IF s instanceof PostfixExpressionSuffixPlusPlus»
				«outputFor(s as PostfixExpressionSuffixPlusPlus)»
			«ENDIF»
			«IF s instanceof PostfixExpressionSuffixMinusMinus»
				«outputFor(s as PostfixExpressionSuffixMinusMinus)»
			«ENDIF»
		«ENDFOR»
	'''
	
	def String outputFor(PostfixExpressionSuffixArray obj) '''
		[«outputFor(obj.arrayExpr)»]
	'''
	
	def String outputFor(PostfixExpressionSuffixArgument obj) '''
		(«outputFor(obj.argumentExpressionList)»)
	'''
	
	def String outputFor(PostfixExpressionSuffixDot obj) '''
		.«obj.id»
	'''
	
	def String outputFor(PostfixExpressionSuffixArrow obj) '''
		->«obj.id»
	'''
	
	def String outputFor(PostfixExpressionSuffixPlusPlus obj) '''
		++
	'''
	
	def String outputFor(PostfixExpressionSuffixMinusMinus obj) '''
		--
	'''
	
	def String outputFor(ArgumentExpressionList obj) '''
		«FOR e : obj.expr»
			«IF obj.expr.indexOf(e) > 0»,«ENDIF»
			«outputForAssignmentExpression(e as AssignmentExpression)»
		«ENDFOR»
	'''
	
	def String outputForPrimaryExpression(PrimaryExpression obj) '''
		«IF obj.id != null»«obj.id»«ENDIF»
		«IF obj.const != null»«outputFor(obj.const)»«ENDIF»
		«IF obj.string != null»«outputForString(obj.string)»«ENDIF»
		«IF obj.expr != null && !obj.builtin_offsetof»(«outputFor(obj.expr)»)«ENDIF»
		«IF obj.builtin_offsetof»__builtin_offsetof(«outputFor(obj.typeName)»,«outputForUnaryExpression(obj.expr as UnaryExpression)»)«ENDIF»
		«IF obj.compoundStmt != null»«IF obj.ext»__extension__«ENDIF»(«outputFor(obj.compoundStmt)»)«ENDIF»
	'''
	
	def String outputForString(EList<String> obj) '''
		«FOR i : 0 ..< obj.size()»
			«obj.get(i)»
		«ENDFOR»
	'''
	
	def String outputFor(Constant2 obj) '''
		«IF obj.hex != null»«obj.hex»«ENDIF»
		«IF obj.oct != null»«obj.oct»«ENDIF»
		«IF obj.dec != null»«obj.dec»«ENDIF»
		«IF obj.ch != null»«obj.ch»«ENDIF»
		«IF obj.str != null»«obj.str»«ENDIF»
		«IF obj.float != null»«obj.float»«ENDIF»
		«IF obj.bin != null»«obj.bin»«ENDIF»
	'''
	
	def String outputForConstantExpression(ConstantExpression obj) '''
		«outputForConditionalExpression(obj.expr as ConditionalExpression)»
	'''
}

