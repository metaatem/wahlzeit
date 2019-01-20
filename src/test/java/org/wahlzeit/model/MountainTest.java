package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MountainTest {
	
	private Mountain m1, m2;
	private MountainType mt1;
	private MountainId mId;
	
	@BeforeEach
	public void init() {
		mt1 = new MountainType("Test Mt. Type", 1111);
		m1 = new Mountain(mt1);
		
		mId = MountainId.getNextId();
		m2 = new Mountain(mt1, mId);
		
	}
	
	@Test
	public void testSetType() {
		m1.setType(new MountainType("New Mt. Type", 2222));
		assertEquals(m1.getType().getName(), "New Mt. Type");
	}
	
	@Test 
	public void testGetType() {
		assertEquals(m1.getType().getName(), "Test Mt. Type");
	}

	@Test
	public void testSetId() {
		m1.setId(MountainId.getIdFromInt(5));
		assertTrue(m1.getId().isEqual(new MountainId(5)));
	}
	
	@Test
	public void testGetId() {
		assertNotNull(m1.getId());
		assertTrue(m2.getId().isEqual(mId));
	}
}
