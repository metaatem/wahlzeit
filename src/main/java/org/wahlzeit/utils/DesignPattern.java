/**
 * DesignPattern
 * 
 * 1.0
 * 
 * 13.01.2019
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.utils;

import java.lang.annotation.Repeatable;

@Repeatable(DesignPatterns.class)
public @interface DesignPattern {
	String name();
	String[] participants();
}
