/**
 * MountainTypeTest
 * 
 * 1.0
 * 
 * 19.01.2019
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class MountainTypeTest {
	
	
	private MountainType mt_solo;
	
	private MountainType mt_super;
	
	private MountainType mt_middle_empty;
	
	
	private MountainType mt_sub1;
	private MountainType mt_sub2;
	private MountainType mt_sub3;
	
	
	private MountainType mt_middle_filled;
	
	/**
	 * @Before Doesn't work for some reason in this test.
	 * It worked the whole time, and in other classes as 
	 * CartesianCoordinateTest the @Before works as well, no idea 
	 * why not here. 
	 * That's why I initialize variables in the tests.
	 */
	@BeforeEach
	public void init() {
		// Type without superType or subTypes 
		mt_solo = new MountainType("Solo type", 1234);
		
		// Type with superType and subTypes
		mt_super = new MountainType("Super", 5678);
		mt_sub1 = new MountainType("Sub1", 10);
		mt_sub2 = new MountainType("Sub2", 11);
		mt_sub3 = new MountainType("Sub3", 12);
		mt_middle_empty = new MountainType("Middle empty", 9);
		
		HashSet<MountainType> sub_set = new HashSet<MountainType>();
		sub_set.add(mt_sub1);
		sub_set.add(mt_sub2);
		sub_set.add(mt_sub3);
		
		mt_middle_filled = new MountainType(mt_super, sub_set, "Middle filled", 9999 );
	}
	
	@Test
	public void testGetName() {
		//MountainType mt_super = new MountainType("Super", 5678);
		assertEquals(mt_solo.getName(), "Solo type");
		//assertEquals(mt_middle_filled.getName(), "Middle filled");
	}
	
	@Test
	public void testGetHeight() {
		// Mountai3nType mt_super = new MountainType("Super", 5678);
		assertEquals(mt_solo.getHeight(), 1234);
	}
	
	@Test
	public void testGetSuperType() {
		assertNotNull(mt_middle_filled.getSuperType());
	}
	
	@Test 
	void testSetSuperType() {
		mt_middle_empty.setSuperType(mt_super);
		assertNotNull(mt_middle_empty.getSuperType());
	}
	
	@Test
	public void testGetSubtypeIterator() {
		Iterator<MountainType> iter = mt_middle_filled.getSubTypeIterator();
		assertNotNull(iter);
	}
	
	@Test
	public void testAddSubTypes() {
		mt_middle_empty.addSubType(mt_sub1);
		Iterator<MountainType> iter = mt_middle_empty.getSubTypeIterator();
		assertTrue(iter.hasNext());
	}
	
	@Test
	public void testHasInstance() {
		Mountain m1 = new Mountain(mt_middle_filled);
		Mountain m2 = new Mountain(mt_solo);
		
		assertTrue(mt_middle_filled.hasInstance(m1));
		assertFalse(mt_middle_filled.hasInstance(m2));
	}
	
	@Test
	public void testIsSubtype() {
		assertTrue(mt_sub1.isSubtype());
		assertTrue(mt_sub2.isSubtype());
		assertTrue(mt_sub3.isSubtype());
		assertFalse(mt_solo.isSubtype());
	}
	
	@Test
	public void testCreateInstance() {
		Mountain m1 = mt_middle_filled.createInstance();
		
		assertNotNull(m1);
		assertEquals(m1.getType().getName(), "Middle filled");
		assertEquals(m1.getType().getHeight(), 9999);
	}
}
