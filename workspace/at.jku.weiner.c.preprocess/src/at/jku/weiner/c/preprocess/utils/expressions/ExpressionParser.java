package at.jku.weiner.c.preprocess.utils.expressions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import at.jku.weiner.c.common.common.Expression;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ExpressionParser {

	@Inject
	private Provider<XtextResourceSet> provider;

	public Expression getExpression(final String text) throws IOException {
		final ResourceSet set = this.provider.get();
		final URI uri = URI.createURI("__newURI.cdt.common");
		final Resource res = set.createResource(uri);
		final InputStream in = new ByteArrayInputStream(text.getBytes("UTF-8"));
		res.load(in, null);
		final EList<EObject> list = res.getContents();
		final EObject object = list.get(0);
		final Expression expr = (Expression) object;
		return expr;
	}

}
