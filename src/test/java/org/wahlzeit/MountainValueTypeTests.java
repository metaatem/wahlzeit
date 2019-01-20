/**
 * MountainManager
 * 
 * 1.0
 * 
 * 19.01.2019
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.wahlzeit.model.MountainTypeTest;
import org.wahlzeit.model.MountainManagerTest;
import org.wahlzeit.model.MountainTest;



@RunWith(JUnitPlatform.class)
@SelectClasses({ MountainTypeTest.class, MountainManagerTest.class, MountainTest.class})
class MountainValueTypeTests {
}
