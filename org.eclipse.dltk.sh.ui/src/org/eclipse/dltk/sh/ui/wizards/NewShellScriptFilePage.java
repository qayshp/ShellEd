package org.eclipse.dltk.sh.ui.wizards;

import org.eclipse.dltk.sh.core.ShelledNature;
import org.eclipse.dltk.ui.wizards.NewSourceModulePage;

public class NewShellScriptFilePage extends NewSourceModulePage {

	@Override
	protected String getPageTitle() {
		return "Shell Script";
	}

	@Override
	protected String getPageDescription() {
		return "Create a new Shell Script.";
	}

	@Override
	protected String getRequiredNature() {
		return ShelledNature.SHELLED_NATURE;
	}
}
