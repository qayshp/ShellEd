/*******************************************************************************
 * Copyright (c) 2011 Mat Booth and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Mat Booth
 *******************************************************************************/
package org.eclipse.dltk.sh.ui.text.tests;

import org.eclipse.dltk.sh.ui.text.AssignmentDetector;
import org.eclipse.dltk.sh.ui.text.AssignmentRule;
import org.eclipse.dltk.sh.ui.text.IShellPartitions;
import org.eclipse.jface.text.rules.Token;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the assignment rule that detects variable assignments.
 */
public class AssignmentRuleTest {

	// Mock objects
	private MockScanner fScanner;

	// Objects under test
	private static AssignmentRule fRule = new AssignmentRule(new AssignmentDetector(),
			Token.UNDEFINED, new Token(IShellPartitions.PARAM_CONTENT_TYPE));

	/**
	 * Match simple variable assignments.
	 */
	@Test
	public void testAssignmentMatch() {
		fScanner = new MockScanner("VAR=assignment");
		Assert.assertFalse(fRule.evaluate(fScanner).isUndefined());
		Assert.assertEquals("VAR", fScanner.getBuffer().substring(0, fScanner.getOffset()));
	}

	/**
	 * Match assignments to shell array variable indexes.
	 */
	@Test
	public void testArrayIndexAssignmentMatch() {
		fScanner = new MockScanner("VAR[2]=assignment");
		Assert.assertFalse(fRule.evaluate(fScanner).isUndefined());
		Assert.assertEquals("VAR[2]", fScanner.getBuffer().substring(0, fScanner.getOffset()));
	}

	/**
	 * The equals MUST immediately follow the var-name, otherwise don't match.
	 */
	@Test
	public void testNonAssignmentMatch() {
		fScanner = new MockScanner("VAR = assignment");
		Assert.assertTrue(fRule.evaluate(fScanner).isUndefined());
		Assert.assertEquals("", fScanner.getBuffer().substring(0, fScanner.getOffset()));
	}
}
