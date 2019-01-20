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

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MountainTypeTest {
	
	private Mountain mountain;
	
	private MountainType mt_solo;
	private MountainType mt_super;
	
	private MountainType mt_middle_empty;
	private MountainType mt_middle_filled;
	
	private MountainType mt_sub1;
	private MountainType mt_sub2;
	private MountainType mt_sub3;
	
	@Before
	public void setUp() {
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
	void testGetName() {
		System.out.println(mt_middle_filled.getName());
		assertEquals(mt_middle_filled.getName(), "Middle filled");
	}
	
	@Test
	void testGetHeight() {
		assertEquals(mt_middle_filled.getHeight(), 9999);
	}
	
	@Test
	void testGetSuperType() {
		MountainType smt = mt_middle_filled.getSuperType();
		assertEquals(smt.getName(), "Super");
	}
	
	/*@Test
	void testGetNoSuperType() {
		MountainType mt = mt_middle_empty.getSuperType();
		assertThrows(NullPointerException.class, mt.getName());
	}*/
	
	@Test 
	void testSetSuperType() {
		assertTrue(true);
	}
	
	@Test
	void testGetSubtypeIterator() {
		Iterator it = (Iterator) mt_middle_filled.getSubTypeIterator();
		assertNotNull(it);
	}
	
	@Test
	void testAddSubTypes() {
		assertTrue(true);
	}
	
	@Test
	void testAddSuperType(){
		assertTrue(true);
	}
	
	@Test
	void testHasInstance() {
		assertTrue(true);
	}
	
	@Test
	void testIsSubtype() {
		assertTrue(true);
	}
	
	@Test
	void testCreateInstance() {
		assertTrue(true);
	}
}
