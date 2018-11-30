/**
 * SphericCoordinateTest
 * 
 * 1.0
 * 
 * 15.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




public class SphericCoordinateTest {
	
	private final double _PI = 3.141592653589793;
	private final double _quarter_PI = 0.7853981633974483;
	private final double _nQuarter_PI = -0.7853981633974483;
	private final double _half_PI = 1.5707963267948966;
	private final double _nHalf_PI = -1.5707963267948966;
	private final double _3Quarter_PI = 2.356194490192345;
	private final double _n3Quarter_PI = -2.356194490192345;
	
	private final double _root2 = 1.4142135623730951;
	private final double _root3 = 1.7320508075688772;
	
	private CartesianCoordinate carsq1;
	private CartesianCoordinate carsq2;
	private CartesianCoordinate carsq3;
	private CartesianCoordinate carsq4;
	private CartesianCoordinate carsq5;
	private CartesianCoordinate carsq6;
	private CartesianCoordinate carsq7;
	private CartesianCoordinate carsq8;
	private CartesianCoordinate carsq9;
	private CartesianCoordinate carsq10;
	
	private SphericCoordinate sph1;
	private SphericCoordinate sph2;
	private SphericCoordinate sph3;
	private SphericCoordinate sph4;
	private SphericCoordinate sph5;
	private SphericCoordinate sph6;
	private SphericCoordinate sph7;
	private SphericCoordinate sph8;
	private SphericCoordinate sph9;
	private SphericCoordinate sph10;
	
	private CylindricalCoordinate cyl1;
	private CylindricalCoordinate cyl2;
	private CylindricalCoordinate cyl3;
	private CylindricalCoordinate cyl4;
	private CylindricalCoordinate cyl5;
	private CylindricalCoordinate cyl6;
	private CylindricalCoordinate cyl7;
	private CylindricalCoordinate cyl8;
	private CylindricalCoordinate cyl9;
	private CylindricalCoordinate cyl10;
	
	private Dummy dummy;
	
	private class Dummy {}
	
	@Before
	public void initCoordinate() {
		
		dummy = new Dummy();

		// x,y = 0
		carsq1 = new CartesianCoordinate(0,0,1);
		carsq2 = new CartesianCoordinate(0,0,-1);
		sph1 = new SphericCoordinate(1, 0, 0);
		sph2 = new SphericCoordinate(1, _PI, 0);
		cyl1 = new CylindricalCoordinate(0,0,1);
		cyl2 = new CylindricalCoordinate(0,0,-1);
		
		// y = 0 
		carsq3 = new CartesianCoordinate(1,0,1);
		carsq4 = new CartesianCoordinate(-1,0,-1);
		sph3 = new SphericCoordinate(_root2, _quarter_PI, 0);
		sph4 = new SphericCoordinate(_root2, _3Quarter_PI, _PI);
		cyl3 = new CylindricalCoordinate(1,0,1);
		cyl4 = new CylindricalCoordinate(1, _PI ,-1);
	
		// x = 0
		carsq5 = new CartesianCoordinate(0,1,-1);
		carsq6 = new CartesianCoordinate(0,-1,1);
		sph5 = new SphericCoordinate(_root2, _3Quarter_PI, _half_PI);
		sph6 = new SphericCoordinate(_root2, _quarter_PI, _nHalf_PI);
		cyl5 = new CylindricalCoordinate(1, _half_PI, -1);
		cyl6 = new CylindricalCoordinate(1, _nHalf_PI, 1);
		
		// x,y,z > 0, 1. and 3. quadrant
		carsq7 = new CartesianCoordinate(1,1,1);
		carsq8 = new CartesianCoordinate(-1,-1,-1);
		sph7 = new SphericCoordinate(_root3, 0.9553166181, _quarter_PI);
		sph8 = new SphericCoordinate(_root3, 2.186276035, _n3Quarter_PI);
		cyl7 = new CylindricalCoordinate(_root2, _quarter_PI, 1);
		cyl8 = new CylindricalCoordinate(_root2, _n3Quarter_PI, -1);
		
		// x,y,z > 0, 2. and 4. quadrant 
		carsq9 = new CartesianCoordinate(1,-1,1);
		carsq10 = new CartesianCoordinate(-1,1,-1);
		sph9 = new SphericCoordinate(_root3, 0.9553166181, _nQuarter_PI);
		sph10 = new SphericCoordinate(_root3, 2.186276035, _3Quarter_PI);
		cyl9 = new CylindricalCoordinate(_root2, _nQuarter_PI, 1);
		cyl10 = new CylindricalCoordinate(_root2, _3Quarter_PI, -1);
		
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(cyl1);
		assertEquals(sph1.getRadius(), 1, 0);
		assertEquals(sph1.getTheta(), 0, 0);
		assertEquals(sph1.getPhi(), 0, 0);
	}
	
	@Test
	public void testIsEqual() {
		assertFalse(sph1.isEqual(sph3));
		assertFalse(sph4.isEqual(sph5));
		assertTrue(sph2.isEqual(sph2));
	}
	
	@Test
	public void testEquals() {
		assertFalse(sph1.equals(dummy));
		assertFalse(sph1.equals(sph3));
		assertFalse(sph1.equals(sph2));
		assertTrue(sph1.equals(sph1));
	}
	
	/**
	 * Helper
	 * @MethodType comparison
	 * @param c1
	 * @param c2
	 * @return
	 */
	private void helpAssertCartesian(CartesianCoordinate c1, CartesianCoordinate c2) {
		assertEquals(c1.getX(), c2.getX(), 0.000000001);
		assertEquals(c1.getY(), c2.getY(), 0.000000001);
		assertEquals(c1.getZ(), c2.getZ(), 0.000000001);
		
	}
	
	@Test
	public void testAsCartesianCoordinate() {
		helpAssertCartesian(carsq1, sph1.asCartesianCoordinate());
		helpAssertCartesian(carsq2, sph2.asCartesianCoordinate());
		helpAssertCartesian(carsq3, sph3.asCartesianCoordinate());
		helpAssertCartesian(carsq4, sph4.asCartesianCoordinate());
		helpAssertCartesian(carsq5, sph5.asCartesianCoordinate());
		helpAssertCartesian(carsq6, sph6.asCartesianCoordinate());
		helpAssertCartesian(carsq7, sph7.asCartesianCoordinate());
		helpAssertCartesian(carsq8, sph8.asCartesianCoordinate());
		helpAssertCartesian(carsq9, sph9.asCartesianCoordinate());
		helpAssertCartesian(carsq10, sph10.asCartesianCoordinate());
	}
	

	/**
	 * Helper
	 * @MethodType comparison
	 * @param c1
	 * @param c2
	 * @return
	 */
	private void helpAssertCylindrical(CylindricalCoordinate c1, CylindricalCoordinate c2) {
		assertEquals(c1.getRadius(), c2.getRadius(), 0.000000001);
		assertEquals(c1.getPhi(), c2.getPhi(), 0.000000001);
		assertEquals(c1.getZ(), c2.getZ(), 0.000000001);
	}
	
	@Test
	public void testAsCylindricalCoordinate() {
		helpAssertCylindrical(cyl1, sph1.asCylindricalCoordinate());
		helpAssertCylindrical(cyl2, sph2.asCylindricalCoordinate());
		helpAssertCylindrical(cyl3, sph3.asCylindricalCoordinate());
		helpAssertCylindrical(cyl4, sph4.asCylindricalCoordinate());
		helpAssertCylindrical(cyl5, sph5.asCylindricalCoordinate());
		helpAssertCylindrical(cyl6, sph6.asCylindricalCoordinate());
		helpAssertCylindrical(cyl7, sph7.asCylindricalCoordinate());
		helpAssertCylindrical(cyl8, sph8.asCylindricalCoordinate());
		helpAssertCylindrical(cyl9, sph9.asCylindricalCoordinate());
		helpAssertCylindrical(cyl10, sph10.asCylindricalCoordinate());
	}
	
	
	@Test
	public void testAsSphericCooridnate() {
		assertEquals(sph1, sph1.asSphericCoordinate());
		assertEquals(sph6, sph6.asSphericCoordinate());
		assertEquals(sph9, sph9.asSphericCoordinate());
		
	}
	
	@Test
	public void testGetCartesianDistanceToCartesian() {
		assertEquals(sph1.getCartesianDistance(carsq2), 2.0, 0.000000001);
		assertEquals(sph7.getCartesianDistance(carsq8), 3.464101615, 0.000000001);
		assertEquals(sph3.getCartesianDistance(carsq7), 1.0, 0.000000001);
	}
	
	@Test 
	public void testGetCartesianDistanceToSpheric() {
		assertEquals(sph1.getCartesianDistance(sph2), 2.0, 0.000000001);
		assertEquals(sph7.getCartesianDistance(sph8), 3.464101615, 0.000000001);
		assertEquals(sph3.getCartesianDistance(sph7), 1.0, 0.000000001);
	}
	
	@Test
	public void testGetCartesianDistanceToCylindrical() {
		assertEquals(sph1.getCartesianDistance(cyl2), 2.0, 0.000000001);
		assertEquals(sph7.getCartesianDistance(cyl8), 3.464101615, 0.000000001);
		assertEquals(sph3.getCartesianDistance(cyl7), 1.0, 0.000000001);
	}
	
	@Test
	public void testGetCentralAngle() {
		assertEquals(sph2.getCentralAngle(sph3), _3Quarter_PI, 0.000000001);
		assertEquals(sph3.getCentralAngle(sph4), 0.0, 0.000000001);
		assertEquals(sph5.getCentralAngle(sph6), 0.0, 0.000000001);
		assertEquals(sph5.getCentralAngle(sph8), 1.277953555, 0.000000001);
		assertEquals(sph9.getCentralAngle(sph10), 0.0, 0.0000000001);
		
		// one with cartesian 
		assertEquals(sph5.getCentralAngle(carsq8), 1.277953555, 0.000000001);
		// one with cylindrical
		assertEquals(sph5.getCentralAngle(cyl8), 1.277953555, 0.000000001);
	}
	
}
