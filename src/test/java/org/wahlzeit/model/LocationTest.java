package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	
	private Location location;
	private Location tl1;
	private Location tl2;
	private Location tl3;
	private Dummy dummy;
	
	private class Dummy {}
	
	@Before
	public void initLocation() {
		location = new Location(new Coordinate(1,2,3));
		dummy = new Dummy();
		tl1 = new Location(new Coordinate(1,2,3));
		tl2 = new Location(new Coordinate(4,5,6));
		tl3 = new Location(new Coordinate(-4,-5,-6));
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(location);
		assertEquals(location.coordinate.getX(), 1, 0);
		assertEquals(location.coordinate.getY(), 2, 0);
		assertEquals(location.coordinate.getZ(), 3, 0);
	}
	
	@Test 
	public void testGetDistance() {
		Coordinate this_coordinate = location.coordinate;
		assertEquals(this_coordinate.getDistance(tl1.coordinate), 0 , 0);
		assertEquals(this_coordinate.getDistance(tl2.coordinate), 5.196152422, 0.000000001);
		assertEquals(this_coordinate.getDistance(tl3.coordinate), 12.4498996, 0.0000001);
	}
	
	@Test 
	public void testIsEqual() {
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
