package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CylindricalCoordinateTest {


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
		assertEquals(cyl1.getRadius(), 0, 0);
		assertEquals(cyl1.getPhi(), 0, 0);
		assertEquals(cyl1.getZ(), 1, 0);
	}
	
	@Test
	public void testIsEqual() {
		assertFalse(cyl1.isEqual(cyl3));
		assertFalse(cyl4.isEqual(cyl5));
		assertTrue(cyl2.isEqual(cyl2));
	}
	
	@Test
	public void testEquals() {
		assertFalse(cyl1.equals(dummy));
		assertFalse(cyl1.equals(cyl3));
		assertFalse(cyl1.equals(cyl2));
		assertTrue(cyl1.equals(cyl1));
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
		helpAssertCartesian(carsq1, cyl1.asCartesianCoordinate());
		helpAssertCartesian(carsq2, cyl2.asCartesianCoordinate());
		helpAssertCartesian(carsq3, cyl3.asCartesianCoordinate());
		helpAssertCartesian(carsq4, cyl4.asCartesianCoordinate());
		helpAssertCartesian(carsq5, cyl5.asCartesianCoordinate());
		helpAssertCartesian(carsq6, cyl6.asCartesianCoordinate());
		helpAssertCartesian(carsq7, cyl7.asCartesianCoordinate());
		helpAssertCartesian(carsq8, cyl8.asCartesianCoordinate());
		helpAssertCartesian(carsq9, cyl9.asCartesianCoordinate());
		helpAssertCartesian(carsq10, cyl10.asCartesianCoordinate());
	}
	
	
	@Test
	public void testAsCylindricalCoordinate() {
		assertEquals(cyl1, cyl1.asCylindricalCoordinate());
		assertEquals(cyl6, cyl6.asCylindricalCoordinate());
		assertEquals(cyl9, cyl9.asCylindricalCoordinate());
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
		helpAssertSpheric(sph1, cyl1.asSphericCoordinate());
		helpAssertSpheric(sph2, cyl2.asSphericCoordinate());
		helpAssertSpheric(sph3, cyl3.asSphericCoordinate());
		helpAssertSpheric(sph4, cyl4.asSphericCoordinate());
		helpAssertSpheric(sph5, cyl5.asSphericCoordinate());
		helpAssertSpheric(sph6, cyl6.asSphericCoordinate());
		helpAssertSpheric(sph7, cyl7.asSphericCoordinate());
		helpAssertSpheric(sph8, cyl8.asSphericCoordinate());
		helpAssertSpheric(sph9, cyl9.asSphericCoordinate());
		helpAssertSpheric(sph10, cyl10.asSphericCoordinate());
	}
	
	@Test
	public void testGetCartesianDistanceToCartesian() {
		assertEquals(cyl1.getCartesianDistance(carsq2), 2.0, 0.000000001);
		assertEquals(cyl7.getCartesianDistance(carsq8), 3.464101615, 0.000000001);
		assertEquals(cyl3.getCartesianDistance(carsq7), 1.0, 0.000000001);
	}
	
	@Test 
	public void testGetCartesianDistanceToSpheric() {
		assertEquals(cyl1.getCartesianDistance(sph2), 2.0, 0.000000001);
		assertEquals(cyl7.getCartesianDistance(sph8), 3.464101615, 0.000000001);
		assertEquals(cyl3.getCartesianDistance(sph7), 1.0, 0.000000001);
	}
	
	@Test
	public void testGetCartesianDistanceToCylindrical() {
		assertEquals(cyl1.getCartesianDistance(cyl2), 2.0, 0.000000001);
		assertEquals(cyl7.getCartesianDistance(cyl8), 3.464101615, 0.000000001);
		assertEquals(cyl3.getCartesianDistance(cyl7), 1.0, 0.000000001);
	}
	
	@Test
	public void testGetCentralAngle() {
		assertEquals(cyl2.getCentralAngle(cyl3), _3Quarter_PI, 0.000000001);
		assertEquals(cyl3.getCentralAngle(cyl4), 0.0, 0.000000001);
		assertEquals(cyl5.getCentralAngle(cyl6), 0.0, 0.000000001);
		assertEquals(cyl5.getCentralAngle(cyl8), 1.277953555, 0.000000001);
		assertEquals(cyl9.getCentralAngle(cyl10), 0.0, 0.0000000001);
		
		// one with cartesian 
		assertEquals(cyl5.getCentralAngle(carsq8), 1.277953555, 0.000000001);
		// one with spheric
		assertEquals(cyl5.getCentralAngle(sph8), 1.277953555, 0.000000001);
	}
	

}
