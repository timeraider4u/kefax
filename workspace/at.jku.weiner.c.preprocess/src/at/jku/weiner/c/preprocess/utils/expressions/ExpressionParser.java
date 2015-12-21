package at.jku.weiner.c.preprocess.utils.expressions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import at.jku.weiner.c.common.common.Expression;

import com.google.inject.Injector;

public class ExpressionParser {

	private final Injector injector;

	private final IResourceFactory resourceFactory;
	private final IResourceValidator validator;

	public ExpressionParser(final Injector commonInjector) {
		this.injector = commonInjector;
		this.resourceFactory = this.injector
				.getInstance(IResourceFactory.class);
		this.validator = this.injector.getInstance(IResourceValidator.class);
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
