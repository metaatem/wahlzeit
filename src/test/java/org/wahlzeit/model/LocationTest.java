/**
 * LocationTest
 * 
 * 1.0
 * 
 * 28.10.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;

public class LocationTest {
	
	private Location location;
	private Location tl1;
	private Location tl2;
	private Location tl3;
	private Dummy dummy;
	
	private class Dummy {}
	
	@Before
	public void initLocation() 
			throws InvalidCoordinateValueException, InvalidCoordinateException,
				UnknownCoordinateTypeException {
		location = new Location(CartesianCoordinate.getInstance(1,2,3));
		dummy = new Dummy();
		tl1 = new Location(CartesianCoordinate.getInstance(1,2,3));
		tl2 = new Location(CartesianCoordinate.getInstance(4,5,6));
		tl3 = new Location(CartesianCoordinate.getInstance(-4,-5,-6));
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(location);
		assertEquals(location.coordinate.getX(), 1, 0);
		assertEquals(location.coordinate.getY(), 2, 0);
		assertEquals(location.coordinate.getZ(), 3, 0);
	}
	
	@Test 
	public void testIsEqual() throws CoordinateException {
		assertFalse(location.isEqual(tl2));
		assertFalse(location.isEqual(tl3));
		assertTrue(location.isEqual(tl1));
	}

	@Test
	public void testEquals() {
		assertFalse(location.equals(dummy));
		assertFalse(location.equals(tl2));
		assertFalse(location.equals(tl3));
		assertTrue(location.equals(tl1));
	}

}
