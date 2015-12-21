package at.jku.weiner.c.preprocess.utils.expressions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import at.jku.weiner.c.common.CommonRuntimeModule;
import at.jku.weiner.c.common.CommonStandaloneSetup;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.parser.antlr.CommonParser;
import at.jku.weiner.c.common.ui.internal.CommonActivator;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ExpressionParser {

	IResourceServiceProvider.Registry reg;

	private final ResourceSet set;
	private final Injector injector;

	private final ResourceSet set2;

	private final IResourceFactory resourceFactory;
	private final IResourceValidator validator;

	public ExpressionParser(final ResourceSet set) {
		this.set2 = set;

		// TODO: only do when we are executing tests,
		// but not when in Eclipse environment
		final CommonStandaloneSetup setup = new CommonStandaloneSetup();
		final Injector injector = setup.createInjectorAndDoEMFRegistration();
		this.set = injector.getInstance(ResourceSet.class);
		this.reg = IResourceServiceProvider.Registry.INSTANCE;
		this.resourceFactory = injector.getInstance(IResourceFactory.class);
		this.validator = injector.getInstance(IResourceValidator.class);
		// this.set = set;

		// final URI uri = URI
		// .createURI("http://www.jku.at/weiner/c/common/Common");
		// final IResourceServiceProvider provider = this.reg
		// .getResourceServiceProvider(uri);
		// this.set = provider.get(ResourceSet.class);
		// final CommonActivator activator = CommonActivator.getInstance();
		// this.injector = activator
		// .getInjector(CommonActivator.AT_JKU_WEINER_C_COMMON_COMMON);
		// final XtextResourceSetProvider provider = this.injector
		// .getInstance(XtextResourceSetProvider.class);
		// final XtextResourceSet resourceSet = (XtextResourceSet) provider
		// .get();
		// this.set =
		this.injector = null;
	}

	public Expression getExpression(final String text) throws IOException {
		final URI uri = URI.createURI("__newURI.cdt.common");
		final Resource res = this.resourceFactory.createResource(uri);
		final InputStream in = new ByteArrayInputStream(text.getBytes("UTF-8"));
		// validate the resource
		final List<Issue> issues = this.validator.validate(res, CheckMode.ALL,
				CancelIndicator.NullImpl);
		if (!issues.isEmpty()) {
			throw new RuntimeException("Error during parsing: '"
					+ issues.toString() + "'");
		}

		res.load(in, null);

		final EList<EObject> list = res.getContents();
		final EObject object = list.get(0);
		final Expression expr = (Expression) object;
		return expr;
	}

}
