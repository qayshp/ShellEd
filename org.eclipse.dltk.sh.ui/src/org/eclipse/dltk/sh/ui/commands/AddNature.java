/*******************************************************************************
 * Copyright (c) 2010 Mat Booth and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.dltk.sh.ui.commands;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.sh.core.ShelledNature;

/**
 * Implementation of the project handler that adds the ShellEd nature to a
 * project.
 */
public class AddNature extends AbstractProjectHandler {

	@Override
	protected void fettleProject(IProject project) {
		try {
			// Get the project description
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();

			// Add the nature to the list
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = ShelledNature.SHELLED_NATURE;

			// Set the project description
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
