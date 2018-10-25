package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	
	private Location location;

	@Before
	public void initLocation() {
		location = new Location(new Coordinate(1,2,3));
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(location);
		assertEquals(location.coordinate.getX(), 1, 0);
		assertEquals(location.coordinate.getY(), 2, 0);
		assertEquals(location.coordinate.getZ(), 3, 0);
	}

}
