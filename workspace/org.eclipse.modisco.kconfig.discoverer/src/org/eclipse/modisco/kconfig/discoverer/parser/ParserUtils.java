package org.eclipse.modisco.kconfig.discoverer.parser;

import java.util.Stack;

import org.eclipse.modisco.kconfig.BooleanExpr;
import org.eclipse.modisco.kconfig.BooleanExprType;
import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.ConfigType;
import org.eclipse.modisco.kconfig.Default;
import org.eclipse.modisco.kconfig.Depend;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.KconfigFactory;
import org.eclipse.modisco.kconfig.LiteralExpr;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.Option;
import org.eclipse.modisco.kconfig.Prompt;
import org.eclipse.modisco.kconfig.Range;
import org.eclipse.modisco.kconfig.Select;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.TristateExpr;
import org.eclipse.modisco.kconfig.TristateValue;

public final class ParserUtils {

	private final KconfigFactory factory;
	private final Model model;
	private final TranslationUnit unit;
	private final Stack<Config> scope;
	private Config currentScope;

	public ParserUtils(final KconfigFactory factory, final Model model,
			final TranslationUnit unit) {
		this.factory = factory;
		this.model = model;
		this.unit = unit;
		this.currentScope = null;
		this.scope = new Stack<Config>();
	}

	public void openScope(final Config newScope) {
		if (this.currentScope != null) {
			this.scope.push(this.currentScope);
			// clone scope
			// TODO: clone scope!
		}
		this.currentScope = newScope;
	}

	public void closeScope() {
		if (this.scope.isEmpty()) {
			this.currentScope = null;
		} else {
			this.currentScope = this.scope.pop();
		}
	}

	public Config createConfig(final String name) {
		final Config config = this.factory.createConfig();
		config.setName(name);
		config.setDescription("");
		this.model.getConfigs().add(config);
		return config;
	}

	public Config lookUpConfig(final String name) {
		Config config = null;
		// ... search in context
		for (final Config temp : this.model.getConfigs()) {
			if (name.equals(temp.getName())) {
				return temp;
			}
		}
		// create
		if (config == null) {
			config = this.createConfig(name);
		}
		return config;
	}

	public Config insertConfig(final String name) {
		final Config config = this.lookUpConfig(name);
		this.unit.getConfigs().add(config);
		this.openScope(config);

		return config;
	}

	public Expr createConfigExpr(final boolean neg, final String name) {
		final ConfigExpr myexpr = this.factory.createConfigExpr();
		myexpr.setNegated(neg);
		this.setConfigOwner(myexpr);
		final Config refConfig = this.lookUpConfig(name);
		myexpr.setRefOnConfig(refConfig);
		return myexpr;
	}

	public void addDependsToUtils(final Expr depends) {
		final Depend mydepends = this.factory.createDepend();
		mydepends.setExpression(depends);
		this.setConfigOwner(depends);
		this.currentScope.getDepends().add(mydepends);
	}

	public void setDescription(final String string) {
		this.currentScope.setDescription(string);
	}

	public void addExprPrompt(final Expr expr) {
		final Prompt prompt = this.factory.createPrompt();
		prompt.setExpression(expr);
		this.setConfigOwner(expr);
		this.currentScope.setPrompt(prompt);
	}

	public Expr createLitExpr(final String myString) {
		final LiteralExpr expr = this.factory.createLiteralExpr();
		expr.setValue(myString);
		this.setConfigOwner(expr);
		return expr;
	}

	public Default addDefaultExpr(final Expr expr) {
		final Default myDefault = this.factory.createDefault();
		myDefault.setExpression(expr);
		this.setConfigOwner(expr);
		this.currentScope.getDefaults().add(myDefault);
		return myDefault;
	}

	public void addDefaultIfExpr(final Default myDefault, final Expr ifExpr) {
		this.setConfigOwner(ifExpr);
		myDefault.setIfExpr(ifExpr);
	}

	private void setConfigOwner(final Expr expr) {
		expr.setOwner(this.currentScope);
	}

	public Expr createTristateExpr(final TristateValue value) {
		final TristateExpr expr = this.factory.createTristateExpr();
		expr.setValue(value);
		this.setConfigOwner(expr);
		return expr;
	}

	public Select addSelectExpr(final Expr expr) {
		final Select mySelect = this.factory.createSelect();
		mySelect.setExpression(expr);
		this.setConfigOwner(expr);
		this.currentScope.getSelects().add(mySelect);
		return mySelect;
	}

	public void addSelectIfExpr(final Select mySelect, final Expr ifExpr) {

		this.setConfigOwner(ifExpr);
		mySelect.setIfExpr(ifExpr);
	}

	public Range createRange() {
		final Range range = this.factory.createRange();
		this.currentScope.getRanges().add(range);
		return range;
	}

	public void setLowerRangeExpr(final Range range, final String value) {
		final LiteralExpr expr = this.factory.createLiteralExpr();
		expr.setOwner(this.currentScope);
		range.setLowerExpr(expr);
		expr.setValue(value);
	}

	public void setUpperRangeExpr(final Range range, final String value) {
		final LiteralExpr expr = this.factory.createLiteralExpr();
		expr.setOwner(this.currentScope);
		range.setUpperExpr(expr);
		expr.setValue(value);
	}

	public void addRangeIfExpr(final Range myRange, final Expr ifExpr) {
		this.setConfigOwner(ifExpr);
		myRange.setIfExpr(ifExpr);
	}

	public Option createOption() {
		final Option option = this.factory.createOption();
		this.currentScope.getOptions().add(option);
		return option;
	}

	public void setOptionValue(final Option option, final String value) {
		option.setName("env");
		option.setValue(value);
	}

	public Expr createBooleanExpr(final Expr leftExpr,
			final BooleanExprType type) {
		final BooleanExpr expr = this.factory.createBooleanExpr();
		expr.setType(type);
		this.setConfigOwner(leftExpr);
		this.setConfigOwner(expr);
		expr.setLeft(leftExpr);
		return expr;
	}

	public void setRightExpr(final Expr expr, final Expr rightExpr) {
		final BooleanExpr boolExpr = (BooleanExpr) expr;
		this.setConfigOwner(rightExpr);
		boolExpr.setRight(rightExpr);
	}

	public void addSourceUnit(final String fileName) {
		final TranslationUnit unit = UnitHelper.lookUpTranslationUnit(
				this.factory, this.model, fileName, false);
		// UnitHelper.insertUnit(this.model, unit);
		this.unit.getSources().add(unit);
	}

	public void setType(final ConfigType type) {
		this.currentScope.setType(type);
	}
}
