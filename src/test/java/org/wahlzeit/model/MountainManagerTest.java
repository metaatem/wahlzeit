/**
 * MountainManagerTest
 * 
 * 1.0
 * 
 * 19.01.2019
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wahlzeit.model.MountainManager;

public class MountainManagerTest {
	
	private MountainManager mm;
	
	@BeforeEach
	public void init() {
		mm = MountainManager.getInstance();
	}
	
	@Test
	public void testGetInstance() {
		assertNotNull(mm);
	}
	
	@Test
	public void testGetPredefMountainTypes() {
		MountainType mt = mm.getMountainType("Mount Default");
		assertNotNull(mt);
		mt = mm.getMountainType("Mount Everest");
		assertNotNull(mt);
		mt = mm.getMountainType("K2");
		assertNotNull(mt);
		mt = mm.getMountainType("Kangchenjunga");
		assertNotNull(mt);
	}
	
	@Test
	public void testCreateMountain() {
		Mountain mt = mm.createMountain(new MountainType("Test Mountain", 1111));
		assertNotNull(mt);
	}
	
	@Test
	public void testGetMountain() {
		Mountain mt = mm.createMountain(new MountainType("Test Mountain", 1111));
		MountainId mId = mt.getId();
		
		assertNotNull(mm.getMountain(mId));
	}
	
	@Test
	public void testAddMountainType() {
		mm.addMountainType(new MountainType("Test Mountain", 1111));
		assertNotNull(mm.getMountainType("Test Mountain"));
	}
	
	

}
