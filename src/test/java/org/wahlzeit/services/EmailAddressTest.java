/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


//import junit.framework.TestCase;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest {

	private EmailAddress dem1;
	private EmailAddress dem2;
	private EmailAddress dem3;
	private EmailAddress dem4;
	
	@Before
	public void setUp() {
		dem1 = new EmailAddress("dummy.eins@dummy.de");
		dem2 = new EmailAddress("dummy.zwei@dummy.de");
		dem3 = new EmailAddress("");
		dem4 = EmailAddress.doGetFromString("");
	}
	
	@AfterEach
	public void tearDown() {
		EmailAddress.instances.remove("");
	}
	
	
	/**
	 *
	 */
	@Test
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	@Test
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}
	
	/**
	 * Test for asInternetAddress() 
	 */
	@Test
	public void testEmailAsInternetAddress() {
		assertNotNull(dem1.asInternetAddress());
		assertNotNull(dem2.asInternetAddress());
		assertNull(dem3.asInternetAddress());
	}
	
	/**
	 * 
	 */
	@Test
	public void testIsEqual() {
		assertTrue(dem1.isEqual(dem1));
		assertFalse(dem1.isEqual(dem2));
	}
	
	/**
	 *
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(dem4.isEmpty());
		assertFalse(dem3.isEmpty());
	}
	
	/**
	 * 
	 */
	@Test
	public void testIsValid() {
		assertTrue(dem1.isValid());
		assertTrue(dem2.isValid());
		assertTrue(dem3.isValid());
		assertFalse(dem4.isValid());
	}

}

