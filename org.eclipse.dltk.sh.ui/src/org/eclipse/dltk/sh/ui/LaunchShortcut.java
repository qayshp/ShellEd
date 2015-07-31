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
package org.eclipse.dltk.sh.ui;

import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.dltk.internal.debug.ui.launcher.AbstractScriptLaunchShortcut;
import org.eclipse.dltk.sh.core.ShelledNature;

public class LaunchShortcut extends AbstractScriptLaunchShortcut {

	@Override
	protected ILaunchConfigurationType getConfigurationType() {
		return getLaunchManager().getLaunchConfigurationType("org.eclipse.dltk.sh.ui.launchConfigurationType1");
	}

	@Override
	protected String getNatureId() {
		return ShelledNature.SHELLED_NATURE;
	}

}
