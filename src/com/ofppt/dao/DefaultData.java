package com.ofppt.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DefaultData {

	private static DefaultData instance;

	public static synchronized DefaultData getInstance() {
		if (instance == null) {
			instance = new DefaultData();
		}
		return instance;
	}

	private DefaultData() {

	}

	public static Model[] modelsTab1;
	public static Model centerModel;

	/* ---------- Create Table of Random Objects ------------ */

	public void createTable(int nbr) {

		modelsTab1 = new Model[nbr];

		int i = 0;

		while (i < nbr) {
			modelsTab1[i] = new Model((int) (100 * Math.random()), (int) (100 * Math.random()),
					(int) (100 * Math.random()));

			if (i == (nbr / 2)) {
				centerModel = modelsTab1[i];
			}

			i++;
		}
	}


	/**
	 * 
	 * @param col
	 * @return
	 */

	public Collection<Model> getDataCollections(Collection<Model> col, String type) {
		Collection<Model> collection = null;
		//int m=0;
		try {
			
			collection = col.getClass().newInstance();
			if (type.equals("all")) {
				for (Model Model : modelsTab1) {
					//m++;
					//System.out.println(Model);
					collection.add(Model);
				}
			} else if (type.equals("some")) {

				for (int i = 0; i < 10; i++) {
					collection.add(modelsTab1[i]);
				}
			}

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	//	System.out.println(m);
		return collection;
	}

	/**
	 * 
	 * @param collection
	 * @return
	 */
	public Collection<Model> addDuplicateDataCollection(Collection<Model> collection) {

		int i = 0;
		while (i < modelsTab1.length && i < 5) {
			collection.add(modelsTab1[i]);
			i++;
		}
		return collection;

	}

	/* ------------------- Maps ------------------ */


	/**
	 * 
	 * @param m
	 * @return
	 */
	public Map<Integer, Model> getDataMaps(Map<Integer, Model> m, String type) {
		Map<Integer, Model> map = null;

		try {
			map = m.getClass().newInstance();
			if (type.equals("all")) {
				int key = 0;

				for (Model model : modelsTab1) {
					map.put(key++, model);
				}
			} else if (type.equals("some")) {
				for (int i = 0; i < 10; i++) {
					map.put(i, modelsTab1[i]);
				}
			}

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return map;

	}

	/**
	 * 
	 * @return
	 */
	public Map<Integer, Model> addDuplicateDataMap(Map<Integer, Model> map) {

		int key = map.size();
		int i = 0;

		while (i < map.size() && i < 5) {
			map.put(key++, modelsTab1[i]);
			i++;
		}

		return map;

	}

}
