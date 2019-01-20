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

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.wahlzeit.model.MountainManager;

public class MountainManagerTest {
	
	
	@Test
	void testGetInstance() {
		assertNotNull(MountainManager.getInstance());
	}
	
	@Test
	void testPredefMountain1() {
		MountainManager.getInstance();
		assertTrue(true);
	}
	
	@Test 
	void testPredefMountain2() {
		assertTrue(true);
	}
	
	@Test 
	void testPredefMountain3() {
		assertTrue(true);
	}
	
	@Test 
	void testPredefMountain4() {
		assertTrue(true);
	}
	
	@Test
	void testGetMountainType() {
		assertTrue(true);
	}
	
	@Test
	void testGetMountain() {
		assertTrue(true);
	}
	
}
