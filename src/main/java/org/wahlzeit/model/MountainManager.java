/**
 * MountainManager
 * 
 * 1.0
 * 
 * 19.01.2019
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MountainManager extends ObjectManager{
	
	/**
	 *
	 */
	protected static final MountainManager instance = new MountainManager();

	private static final Logger log = Logger.getLogger(MountainManager.class.getName());
	
	/**
	 * In-memory cache for Mountain-Instances
	 */
	protected Map<MountainId, Mountain> mountainCache = new HashMap<MountainId, Mountain>();
	
	/**
	 * In-memory cache for MountainType-Instances
	 */
	protected Map<String, MountainType> mountainTypeCache = new HashMap<String, MountainType>();
	
	
	public MountainManager() {
		this.mountainTypeCache.put("Mount Default", new MountainType("Mount Default", 4711));
		this.mountainTypeCache.put("Mount Everest", new MountainType("Mount Everest", 8848));
		this.mountainTypeCache.put("K2", new MountainType("K2", 8611));
		this.mountainTypeCache.put("Kangchenjunga", new MountainType("Kangchenjunga", 8586));
	}
	
	
	public static MountainManager getInstance() {
		return instance;
	}
	
	public Mountain createMountain(MountainType mt) {
		
		MountainType query = getMountainType(mt.toString());
		
		if(query == null) {
			mountainTypeCache.put(mt.toString(), mt);
			query = mt;
		}
		
		Mountain result = query.createInstance();
		mountainCache.put(result.getId(), result);
		
		return result;
	}
	
	
	
	public Mountain getMountain(MountainId mountainId) {
		return mountainCache.get(mountainId);
	}
	
	public void addMountainType(MountainType mt) {
		mountainTypeCache.put(mt.getName(), mt);
	}
	
	public MountainType getMountainType(String mountainTypeName) {
		return mountainTypeCache.get(mountainTypeName);
	}
}
