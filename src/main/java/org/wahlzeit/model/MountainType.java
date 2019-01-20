/**
 * MountainType
 * 
 * 1.0
 * 
 * 19.01.2019
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.utils.MetaatemClassesUtil;



public class MountainType {
	
	protected MountainType superType = null;
	protected Set<MountainType> subTypes = new HashSet<MountainType>();
	
	private String name; 
	private int height;
	
	public MountainType(String name, int height) {
		this.name = name;
		this.height = height;
	}
	
	public MountainType(MountainType superType, String name, int height) {
		this.superType = superType;
		this.name = name;
		this.height = height;
	}
	
	public MountainType(MountainType superType, HashSet<MountainType> subTypes,
				String name, int height) {
		
		this.superType = superType;
		for( MountainType st : subTypes) {
			st.setSuperType(this);
		}
		this.subTypes = subTypes;
		this.name = name;
		this.height = height;
	}
	
	
	public void setSuperType(MountainType superType) {
		this.superType = superType;
	}
	
	public MountainType getSuperType() {
		return superType;
	}
	
	
	public void addSubType(MountainType mt) {
		MetaatemClassesUtil.assertNotNull(mt);
		
		mt.setSuperType(this);
		subTypes.add(mt);
	}
	
	public Iterator<MountainType> getSubTypeIterator(){
		return subTypes.iterator();
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public boolean hasInstance(Mountain mountain) {
		MetaatemClassesUtil.assertNotNull(mountain);
		
		if(mountain.getType() == this) {
			return true;
		}
		
		for(MountainType type : subTypes) {
			if(type.hasInstance(mountain)) {
				return true;
			}
		}
		
		return false;
	}
	

	public boolean isSubtype() {
		return (superType != null);
	}
	
	public Mountain createInstance() {
		return new Mountain(this, MountainId.getNextId());
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
