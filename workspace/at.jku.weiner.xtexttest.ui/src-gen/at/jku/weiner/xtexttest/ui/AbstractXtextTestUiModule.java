/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.xtexttest.ui;

import at.jku.weiner.xtexttest.ui.contentassist.XtextTestProposalProvider;
import at.jku.weiner.xtexttest.ui.contentassist.antlr.PartialXtextTestContentAssistParser;
import at.jku.weiner.xtexttest.ui.contentassist.antlr.XtextTestParser;
import at.jku.weiner.xtexttest.ui.labeling.XtextTestLabelProvider;
import at.jku.weiner.xtexttest.ui.outline.XtextTestOutlineTreeProvider;
import at.jku.weiner.xtexttest.ui.quickfix.XtextTestQuickfixProvider;
import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialContentAssistParser;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.ui.compare.DefaultViewerCreator;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameSupport;
import org.eclipse.xtext.ui.refactoring.ui.IRenameSupport;
import org.eclipse.xtext.ui.shared.Access;

/**
 * Manual modifications go to {@link XtextTestUiModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractXtextTestUiModule extends DefaultCommonTypesUiModule {

	public AbstractXtextTestUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.LanguageConfig2
	public Provider<IAllContainersState> provideIAllContainersState() {
		return Access.getJavaProjectsState();
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return AntlrProposalConflictHelper.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(at.jku.weiner.xtexttest.parser.antlr.internal.InternalXtextTestLexer.class);
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingTokenDefProvider(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
	}
	
	// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
	public Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return DefaultDependentElementsCalculator.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return BuilderParticipant.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
	public IWorkspaceRoot bindIWorkspaceRootToInstance() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
	public void configureBuilderPreferenceStoreInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("builderPreferenceInitializer")).to(BuilderPreferenceAccess.Initializer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		return ContentFormatterFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsBuilderScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(CurrentDescriptions.ResourceSetAware.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return NatureAddingEditorCallback.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
		return EclipseOutputConfigurationProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsPersisted(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(IBuilderState.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
		return PersistentDataAwareDirtyResource.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return XtextTestLabelProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public void configureResourceUIServiceLabelProvider(Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(at.jku.weiner.xtexttest.ui.labeling.XtextTestDescriptionLabelProvider.class);
	}
	
	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return XtextTestOutlineTreeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return XtextTestOutlineTreeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment
	public Class<? extends IssueResolutionProvider> bindIssueResolutionProvider() {
		return XtextTestQuickfixProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.contentAssist.ContentAssistFragment
	public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
		return XtextTestProposalProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Provider<TemplatesLanguageConfiguration> provideTemplatesLanguageConfiguration() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getTemplatesLanguageConfigurationProvider();
	}
	
	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Provider<LanguageRegistry> provideLanguageRegistry() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getLanguageRegistry();
	}
	
	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	@SingletonBinding(eager=true)
	public Class<? extends LanguageRegistrar> bindLanguageRegistrar() {
		return LanguageRegistrar.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends XtextTemplatePreferencePage> bindXtextTemplatePreferencePage() {
		return AdvancedTemplatesPreferencePage.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends IPartialContentAssistParser> bindIPartialContentAssistParser() {
		return PartialXtextTestContentAssistParser.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
		return DefaultRenameStrategy.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends IReferenceUpdater> bindIReferenceUpdater() {
		return DefaultReferenceUpdater.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public void configureIPreferenceStoreInitializer(Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class).annotatedWith(com.google.inject.name.Names.named("RefactoringPreferences")).to(org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences.Initializer.class);
	}
	
	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends IRenameRefactoringProvider> bindIRenameRefactoringProvider() {
		return DefaultRenameRefactoringProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends IRenameSupport.Factory> bindIRenameSupport$Factory() {
		return DefaultRenameSupport.Factory.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.compare.CompareFragment
	public Class<? extends IViewerCreator> bindIViewerCreator() {
		return DefaultViewerCreator.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return ParserBasedContentAssistContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return XtextTestParser.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestLexer.class));
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestLexer.class);
	}
	
	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends PrefixMatcher> bindPrefixMatcher() {
		return FQNPrefixMatcher.class;
	}
	
}
