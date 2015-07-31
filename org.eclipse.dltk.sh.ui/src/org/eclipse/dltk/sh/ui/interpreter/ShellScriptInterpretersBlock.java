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
package org.eclipse.dltk.sh.ui.interpreter;

import org.eclipse.dltk.core.environment.IEnvironment;
import org.eclipse.dltk.internal.debug.ui.interpreters.AddScriptInterpreterDialog;
import org.eclipse.dltk.internal.debug.ui.interpreters.InterpretersBlock;
import org.eclipse.dltk.launching.IInterpreterInstall;
import org.eclipse.dltk.launching.ScriptRuntime;
import org.eclipse.dltk.sh.core.ShelledNature;

public class ShellScriptInterpretersBlock extends InterpretersBlock {
	@Override
	protected AddScriptInterpreterDialog createInterpreterDialog(IEnvironment environment,
			IInterpreterInstall standin) {
		AddShellScriptInterpreterDialog dialog = new AddShellScriptInterpreterDialog(this, getShell(),
				ScriptRuntime.getInterpreterInstallTypes(getCurrentNature()), standin);
		dialog.setEnvironment(environment);
		return dialog;
	}

	@Override
	protected String getCurrentNature() {
		return ShelledNature.SHELLED_NATURE;
	}

}
