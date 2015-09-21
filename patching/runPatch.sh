#!/bin/bash

######### EMF-GEN ####################
#MY="Composite Condition Conjunction Disjunction Group LiteralCondition NamedArgument Negation Parameter ParameterReference RuleCall"
MY="CompositeCondition Condition Conjunction Disjunction Group LiteralCondition NamedArgument Negation Parameter ParameterReference RuleCall"
cd ~/workspace/workspace-xtext/xtext-timeraider/
for FILE in ${MY}; do
	git checkout HEAD "plugins/org.eclipse.xtext/emf-gen/org/eclipse/xtext/${FILE}.java"
	git checkout HEAD "plugins/org.eclipse.xtext/emf-gen/org/eclipse/xtext/impl/${FILE}Impl.java"
done
patch --forward "plugins/org.eclipse.xtext/emf-gen/org/eclipse/xtext/XtextFactory.java" ../patches/XtextFactory.patch
patch --forward "plugins/org.eclipse.xtext/emf-gen/org/eclipse/xtext/impl/XtextFactoryImpl.java" ../patches/XtextFactoryImpl.patch

########## ... ################
patch --forward "plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/AbstractXtextProposalProvider.java" ../patches/AbstractXtextProposalProvider.java.patch
git checkout HEAD plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/PartialXtextContentAssistParser.java
patch --forward "plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/XtextParser.java" ../patches/XtextParser.java.patch
patch --forward "plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtextLexer.java" ../patches/InternalXtextLexer.java.0.patch
patch --forward "plugins/org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtextParser.java" ../patches/InternalXtextParser.java.0.patch
patch --forward "plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextLexer.java" ../patches/InternalXtextLexer.java.1.patch
patch --forward "plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextParser.java" ../patches/InternalXtextParser.java.1.patch

patch --forward "plugins/org.eclipse.xtext.generator/xtend-gen/org/eclipse/xtext/generator/adapter/FragmentAdapter.java" ../patches/FragmentAdapter.patch
patch --forward "plugins/org.eclipse.xtext.generator/xtend-gen/org/eclipse/xtext/generator/adapter/StringConcatOutputImpl.java" ../patches/StringConcatOutputImpl.patch

find . -name "*.rej" -exec rm -rf {} \;
find . -name "*.orig" -exec rm -rf {} \;

MY="build/BuildContext.java build/BuildRequest.java build/IncrementalBuilder.java build/Indexer.java generator/FileSystemAccessQueue.java \
generator/FileSystemAccessRequest.java generator/IShouldGenerate.java generator/URIBasedFileSystemAccess.java \
resource/ForwardingEObjectDescription.java resource/IResourceDescriptionsProvider.java \
resource/containers/ProjectDescriptionBasedContainerManager.java \
resource/impl/ChunkedResourceDescriptions.java resource/impl/ProjectDescription.java \
service/LanguageSpecific.java"
for FILE in ${MY}; do
	git checkout HEAD "plugins/org.eclipse.xtext/xtend-gen/org/eclipse/xtext/${FILE}"
done

git status
