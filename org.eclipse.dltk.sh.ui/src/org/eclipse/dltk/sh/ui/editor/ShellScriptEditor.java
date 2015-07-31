/*******************************************************************************
 * Copyright (c) 2009 Red Hat Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alexander Kurtakov - initial API and implementation
 *******************************************************************************/
package org.eclipse.dltk.sh.ui.editor;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.sh.core.ShellScriptLanguageToolkit;
import org.eclipse.dltk.sh.ui.Activator;
import org.eclipse.dltk.sh.ui.text.IShellPartitions;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.ui.IEditorInput;

public class ShellScriptEditor extends ScriptEditor {

	public static final String EDITOR_CONTEXT = "#ShellScriptEditorContext";

	public static final String EDITOR_ID = "org.eclipse.dltk.sh.ui.editor";

	@Override
	protected void connectPartitioningToElement(IEditorInput input, IDocument document) {
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension = (IDocumentExtension3) document;
			if (extension.getDocumentPartitioner(IShellPartitions.SHELL_PARTITIONING) == null) {
				ShellDocumentSetupParticipant participant = new ShellDocumentSetupParticipant();
				participant.setup(document);
			}
		}
	}

	@Override
	public String getEditorId() {
		return EDITOR_ID;
	}

	@Override
	public IDLTKLanguageToolkit getLanguageToolkit() {
		return ShellScriptLanguageToolkit.getDefault();
	}

	@Override
	public IPreferenceStore getScriptPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	@Override
	public ScriptTextTools getTextTools() {
		return Activator.getDefault().getTextTools();
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId(EDITOR_CONTEXT);
	}

}
