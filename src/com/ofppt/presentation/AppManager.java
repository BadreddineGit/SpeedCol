package com.ofppt.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import com.ofppt.commun.FactoryInstance;
import com.ofppt.dao.Model;
import com.ofppt.metier.AppTest;

public class AppManager {
	
	private static AppManager instance;
	private AppTest AppTest;

	public static AppManager getInstance() {

		if (instance == null) {
			instance = new AppManager();
		}
		return instance;
	}

	private AppManager() {
		AppTest = FactoryInstance.buildManager();
	}

	// Pick the choosing collection/Maps and call the test methods in the
	// AppTest
	public AdapterModel startTest(int nbrObject, String[] listCollections, String[] listMaps) {

		AppTest.initialize(nbrObject);
		AdapterModel model = new AdapterModel();

		if (listCollections != null && listCollections.length > 0) {

			Map<String, Collection<Model>> collections = getCollections(listCollections);

			model.setFinaleColSpeedSizeResult(AppTest.speedCollections(collections));
			model.setFinaleColInfoMethodResult(AppTest.infoCollections(collections));
			model.setFinaleColOrderResult(AppTest.orderCollections(collections));
			model.setFinaleColDuplicateNullResult(AppTest.duplicateAndNullCollections(collections));

		}
		if (listMaps != null && listMaps.length > 0) {

			Map<String, Map<Integer, Model>> maps = getMaps(listMaps);

			model.setFinaleMapSpeedSizeResult(AppTest.speedMaps(maps));
			model.setFinaleMapInfoMethodResult(AppTest.infoMaps(maps));
			model.setFinaleMapOrderResult(AppTest.orderMaps(maps));
			model.setFinaleMapDuplicateNullResult(AppTest.duplicateAndNullMaps(maps));

		}
		return model;

	}

	public Map<String, Collection<Model>> getCollections(String[] listCollections) {

		Map<String, Collection<Model>> collections = new LinkedHashMap<>();

		for (String colname : listCollections) {

			if (colname.equals("arraylist")) {
				collections.put("Arraylist", new ArrayList<>());

			} else if (colname.equals("linkedlist")) {
				collections.put("Linkedlist", new LinkedList<>());

			} else if (colname.equals("vector")) {
				collections.put("Vector", new Vector<>());

			} else if (colname.equals("hashSet")) {
				collections.put("HashSet", new HashSet<>());

			} else if (colname.equals("linkedhashSet")) {
				collections.put("LinkedhashSet", new LinkedHashSet<>());

			}

			// else if (colname.equals("treeSet")) {
			// collections.put("TreeSet", new TreeSet<>());
			// }

			// collections.put("PriorityQueue", new PriorityQueue<>());
			// sumCol.put("TreeSet", new TreeSet<>()); implements interface
			// comparable
		}
		return collections;

	}

	public Map<String, Map<Integer, Model>> getMaps(String[] listMaps) {

		Map<String, Map<Integer, Model>> maps = new LinkedHashMap<>();

		for (String mapName : listMaps) {

			if (mapName.equals("LinkedHashMap")) {
				maps.put("LinkedHashMap", new LinkedHashMap<>());

			} else if (mapName.equals("hashMap")) {
				maps.put("HashMap", new HashMap<>());

			} else if (mapName.equals("hashTable")) {
				maps.put("HashTable", new Hashtable<>());

			} else if (mapName.equals("treeMap")) {
				maps.put("TreeMap", new TreeMap<>());
			}
		}

		return maps;
	}

}
