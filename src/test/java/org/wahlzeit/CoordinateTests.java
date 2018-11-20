/**
 * CoordinateTests
 * 
 * 1.0
 * 
 * 15.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.wahlzeit.model.CylindricalCoordinateTest;
import org.wahlzeit.model.SphericCoordinateTest;
import org.wahlzeit.model.CartesianCoordinateTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ CartesianCoordinateTest.class, SphericCoordinateTest.class, CylindricalCoordinateTest.class})
class CoordinateTests {
}
