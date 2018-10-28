package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	private Coordinate coordinate; 
	private Coordinate c1;
	private Coordinate c2;
	private Coordinate c3;
	private Dummy dummy;
	
	private class Dummy {}
	
	@Before
	public void initCoordinate() {
		coordinate = new Coordinate(1,2,3);
		dummy = new Dummy();
		c1 = new Coordinate(1,2,3);
		c2 = new Coordinate(4,5,6);
		c3 = new Coordinate(-4,-5,-6);
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(coordinate);
		assertEquals(coordinate.getX(), 1, 0);
		assertEquals(coordinate.getY(), 2, 0);
		assertEquals(coordinate.getZ(), 3, 0);
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(coordinate.getDistance(c1), 0 , 0);
		assertEquals(coordinate.getDistance(c2), 5.196152422, 0.000000001);
		assertEquals(coordinate.getDistance(c3), 12.4498996, 0.0000001);
	}
	
	@Test
	public void testIsEqual() {
		assertFalse(coordinate.isEqual(c3));
		assertFalse(coordinate.isEqual(c2));
		assertTrue(coordinate.isEqual(c1));
	}
	
	@Test
	public void testEquals() {
		assertFalse(coordinate.equals(dummy));
		assertFalse(coordinate.equals(c3));
		assertFalse(coordinate.equals(c2));
		assertTrue(coordinate.equals(c1));
	}

}
