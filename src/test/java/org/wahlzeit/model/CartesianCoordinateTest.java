/**
 * CartesianCoordinateTest
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



public class CartesianCoordinateTest {
	
	
	private final double _PI = 3.141592653589793;
	private final double _quarter_PI = 0.7853981633974483;
	private final double _nQuarter_PI = -0.7853981633974483;
	private final double _half_PI = 1.5707963267948966;
	private final double _nHalf_PI = -1.5707963267948966;
	private final double _3Quarter_PI = 2.356194490192345;
	private final double _n3Quarter_PI = -2.356194490192345;
	
	private final double _root2 = 1.4142135623730951;
	private final double _root3 = 1.7320508075688772;
	
	private CartesianCoordinate coordinate; 
	private CartesianCoordinate dCar1;
	private CartesianCoordinate dCar2;
	private CartesianCoordinate dCar3;
	
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
		
		coordinate = new CartesianCoordinate(1,2,3);
		dCar1 = new CartesianCoordinate(1,2,3);
		dCar2 = new CartesianCoordinate(4,5,6);
		dCar3 = new CartesianCoordinate(-4,-5,-6);
		
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
		assertNotNull(coordinate);
		assertEquals(coordinate.getX(), 1, 0);
		assertEquals(coordinate.getY(), 2, 0);
		assertEquals(coordinate.getZ(), 3, 0);
	}
	
	@Test
	public void testIsEqual() {
		assertFalse(coordinate.isEqual(dCar3));
		assertFalse(coordinate.isEqual(dCar2));
		assertTrue(coordinate.isEqual(dCar1));
	}
	
	@Test
	public void testEquals() {
		assertFalse(coordinate.equals(dummy));
		assertFalse(coordinate.equals(dCar3));
		assertFalse(coordinate.equals(dCar2));
		assertTrue(coordinate.equals(dCar1));
	}
	
	
	@Test
	public void testAsCartesianCoordinate() {
		assertEquals(carsq1, carsq1.asCartesianCoordinate());
		assertEquals(carsq4, carsq4.asCartesianCoordinate());
		assertEquals(carsq7, carsq7.asCartesianCoordinate());
	}
	
	@Test
	public void testGetCartesianDistanceToCartesian() {
		assertEquals(coordinate.getCartesianDistance(dCar1), 0 , 0);
		assertEquals(coordinate.getCartesianDistance(dCar2), 5.196152422, 0.000000001);
		assertEquals(coordinate.getCartesianDistance(dCar3), 12.4498996, 0.0000001);
		
		assertEquals(carsq1.getCartesianDistance(carsq2), 2.0, 0.000000001);
		assertEquals(carsq7.getCartesianDistance(carsq8), 3.464101615, 0.000000001);
		assertEquals(carsq3.getCartesianDistance(carsq7), 1.0, 0.000000001);
	}
	
	@Test 
	public void testGetCartesianDistanceToSpheric() {
		assertEquals(carsq1.getCartesianDistance(sph2), 2.0, 0.000000001);
		assertEquals(carsq7.getCartesianDistance(sph8), 3.464101615, 0.000000001);
		assertEquals(carsq3.getCartesianDistance(sph7), 1.0, 0.000000001);
	}
	
	@Test
	public void testGetCartesianDistanceToCylindrical() {
		assertEquals(carsq1.getCartesianDistance(cyl2), 2.0, 0.000000001);
		assertEquals(carsq7.getCartesianDistance(cyl8), 3.464101615, 0.000000001);
		assertEquals(carsq3.getCartesianDistance(cyl7), 1.0, 0.000000001);
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
		assertEquals(c1.getZ(), c2.getZ(), 0.000000001);
		assertEquals(c1.getPhi(), c2.getPhi(), 0.000000001);
	}
	
	@Test
	public void testAsCylindricalCoordinate() {
		helpAssertCylindrical(cyl1, carsq1.asCylindricalCoordinate());
		helpAssertCylindrical(cyl2, carsq2.asCylindricalCoordinate());
		helpAssertCylindrical(cyl3, carsq3.asCylindricalCoordinate());
		helpAssertCylindrical(cyl4, carsq4.asCylindricalCoordinate());
		helpAssertCylindrical(cyl5, carsq5.asCylindricalCoordinate());
		helpAssertCylindrical(cyl6, carsq6.asCylindricalCoordinate());
		helpAssertCylindrical(cyl7, carsq7.asCylindricalCoordinate());
		helpAssertCylindrical(cyl8, carsq8.asCylindricalCoordinate());
		helpAssertCylindrical(cyl9, carsq9.asCylindricalCoordinate());
		helpAssertCylindrical(cyl10, carsq10.asCylindricalCoordinate());
	}
	
	/**
	 * Helper
	 * @MethodType comparison
	 * @param c1
	 * @param c2
	 * @return
	 */
	private void helpAssertSpheric(SphericCoordinate c1, SphericCoordinate c2) {
		assertEquals(c1.getRadius(), c2.getRadius(), 0.000000001);
		assertEquals(c1.getTheta(), c2.getTheta(), 0.000000001);
		assertEquals(c1.getPhi(), c2.getPhi(), 0.000000001);
	}
	
	@Test
	public void testAsSphericCooridnate() {
		helpAssertSpheric(sph1, carsq1.asSphericCoordinate());
		helpAssertSpheric(sph2, carsq2.asSphericCoordinate());
		helpAssertSpheric(sph3, carsq3.asSphericCoordinate());
		helpAssertSpheric(sph4, carsq4.asSphericCoordinate());
		helpAssertSpheric(sph5, carsq5.asSphericCoordinate());
		helpAssertSpheric(sph6, carsq6.asSphericCoordinate());
		helpAssertSpheric(sph7, carsq7.asSphericCoordinate());
		helpAssertSpheric(sph8, carsq8.asSphericCoordinate());
		helpAssertSpheric(sph9, carsq9.asSphericCoordinate());
		helpAssertSpheric(sph10, carsq10.asSphericCoordinate());
	}
	
	@Test
	public void testGetCentralAngle() {
		assertEquals(carsq2.getCentralAngle(carsq3), _3Quarter_PI, 0.000000001);
		assertEquals(carsq3.getCentralAngle(carsq4), 0.0, 0.000000001);
		assertEquals(carsq5.getCentralAngle(carsq6), 0.0, 0.000000001);
		assertEquals(carsq5.getCentralAngle(carsq8), 1.277953555, 0.000000001);
		assertEquals(carsq9.getCentralAngle(carsq10), 0.0, 0.0000000001);
		
		// one with cylindrical rest is actually test in cylindrical
		assertEquals(carsq5.getCentralAngle(cyl8), 1.277953555, 0.000000001);
		// one with spheric
		assertEquals(carsq2.getCentralAngle(sph3), _3Quarter_PI, 0.000000001);
	}
	
	


}
