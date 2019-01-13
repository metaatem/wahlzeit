package org.wahlzeit.utils;

import java.lang.annotation.Repeatable;

@Repeatable(DesignPatterns.class)
public @interface DesignPattern {
	String name();
	String[] participants();
}
