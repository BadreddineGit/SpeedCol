package com.ofppt.metier;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ofppt.commun.FactoryInstance;
import com.ofppt.dao.DefaultData;
import com.ofppt.dao.Model;

public class AppTest {

	// Declaration
	private Speed speed;
	private DefaultData data;
	private Order order;

	private int indexCenterObject;

	private Map<String, Collection<Collection<String>>> finaleInfoMethodResult;
	private Map<String, Collection<Collection<Double>>> finaleSpeedSizeResult;
	private Map<String, Boolean> finaleOrderResult;
	private Map<String, Collection<Boolean>> finaleDuplicateNullResult;

	private Collection<Double> size;

	private Collection<String> info;
	private Collection<String> methods;
	private Collection<Collection<String>> all;

	private Collection<Double> speedResult;
	private Collection<Boolean> duplicateNull;

	// Singleton
	private static AppTest instance;

	public synchronized static AppTest getInstance() {
		if (instance == null) {
			instance = new AppTest();
		}
		return instance;
	}

	// Constructor
	private AppTest() {

		speed = FactoryInstance.buildSpeed();
		order = FactoryInstance.buildOrder();
		data = FactoryInstance.buildData();

	}

	/**
	 * create table of random models
	 */
	public void initialize(int nbr) {

		indexCenterObject = (nbr / 2);
		data.createTable(nbr);
	}

	/* ---------------- Collection Info ------------------ */

	public Map<String, Collection<Collection<String>>> infoCollections(Map<String, Collection<Model>> collections) {

		finaleInfoMethodResult = new LinkedHashMap<>();

		Iterator<Entry<String, Collection<Model>>> itr = collections.entrySet().iterator();

		while (itr.hasNext()) {

			info = new ArrayList<>();
			methods = new HashSet<>();
			all = new ArrayList<Collection<String>>();

			Entry<String, Collection<Model>> map = itr.next();
			Collection<Model> collection = map.getValue();

			info.add(collection.getClass().toGenericString());
			info.add(collection.getClass().getInterfaces()[0].getName());
			info.add(collection.getClass().getSuperclass().getName());

			for (Method method : collection.getClass().getDeclaredMethods()) {
				methods.add(method.getName());
			}

			all.add(info);
			all.add(methods);

			finaleInfoMethodResult.put(map.getKey(), all);
		}
		return finaleInfoMethodResult;

	}

	/* ---------------- Maps Info ------------------ */

	public Map<String, Collection<Collection<String>>> infoMaps(Map<String, Map<Integer, Model>> maps) {

		finaleInfoMethodResult = new LinkedHashMap<>();

		Iterator<Entry<String, Map<Integer, Model>>> itr = maps.entrySet().iterator();

		while (itr.hasNext()) {
			info = new ArrayList<>();
			methods = new HashSet<>();
			all = new ArrayList<Collection<String>>();

			Entry<String, Map<Integer, Model>> m = itr.next();
			Map<Integer, Model> map = m.getValue();

			info.add(map.getClass().toGenericString());
			info.add(map.getClass().getInterfaces()[0].getName());
			info.add(map.getClass().getSuperclass().getName());

			for (Method method : map.getClass().getDeclaredMethods()) {
				methods.add(method.getName());
			}

			all.add(info);
			all.add(methods);

			finaleInfoMethodResult.put(m.getKey(), all);
		}
		return finaleInfoMethodResult;
	}
	/* ---------------- Collection Speed ------------------ */

	public Map<String, Collection<Collection<Double>>> speedCollections(Map<String, Collection<Model>> collections) {

		finaleSpeedSizeResult = new LinkedHashMap<>();
		Iterator<Entry<String, Collection<Model>>> itr = collections.entrySet().iterator();

		while (itr.hasNext()) {

			speedResult = new ArrayList<Double>();
			size = new ArrayList<Double>();
			Collection<Collection<Double>> all = new ArrayList<Collection<Double>>();

			Entry<String, Collection<Model>> map = itr.next();
			Collection<Model> collection = map.getValue();

			speedResult.add(speed.insertSpeed(collection, data.getDataCollections(collection, "all")));
			size.add((double) collection.size());
			speedResult.add(speed.findSpeed(collection, DefaultData.centerModel));
			size.add((double) collection.size());
			speedResult.add(speed.removeSpeed(collection, indexCenterObject));
			size.add((double) collection.size());

			all.add(speedResult);
			all.add(size);

			finaleSpeedSizeResult.put(map.getKey(), all);

		}

		return finaleSpeedSizeResult;

	}

	/* ---------------- Map Speed ------------------ */

	public Map<String, Collection<Collection<Double>>> speedMaps(Map<String, Map<Integer, Model>> maps) {

		finaleSpeedSizeResult = new LinkedHashMap<>();
		Iterator<Entry<String, Map<Integer, Model>>> itr = maps.entrySet().iterator();

		while (itr.hasNext()) {

			speedResult = new ArrayList<Double>();
			size = new ArrayList<Double>();
			Collection<Collection<Double>> all = new ArrayList<Collection<Double>>();

			Entry<String, Map<Integer, Model>> m = itr.next();
			Map<Integer, Model> map = m.getValue();

			speedResult.add(speed.insertSpeed(map, data.getDataMaps(map, "all")));
			size.add((double) map.size());
			speedResult.add(speed.findSpeed(map, DefaultData.centerModel));
			size.add((double) map.size());
			speedResult.add(speed.removeSpeed(map, indexCenterObject));
			size.add((double) map.size());

			all.add(speedResult);
			all.add(size);

			finaleSpeedSizeResult.put(m.getKey(), all);
		}

		return finaleSpeedSizeResult;

	}

	/* ---------------- Collection Order ------------------ */

	public Map<String, Boolean> orderCollections(Map<String, Collection<Model>> collections) {

		finaleOrderResult = new LinkedHashMap<>();
		Iterator<Entry<String, Collection<Model>>> itr = collections.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<String, Collection<Model>> map = itr.next();

			Collection<Model> c = map.getValue();
			c.clear();
			speed.insertSpeed(c, data.getDataCollections(c, "some"));

			finaleOrderResult.put(map.getKey(), order.verifieOrderCollection(map.getValue(), DefaultData.modelsTab1));

		}
		return finaleOrderResult;

	}

	/* ---------------- Map Order ------------------ */

	public Map<String, Boolean> orderMaps(Map<String, Map<Integer, Model>> maps) {

		finaleOrderResult = new LinkedHashMap<>();
		Iterator<Entry<String, Map<Integer, Model>>> itr = maps.entrySet().iterator();

		while (itr.hasNext()) {

			Entry<String, Map<Integer, Model>> map = itr.next();

			Map<Integer, Model> m = map.getValue();
			m.clear();
			speed.insertSpeed(m, data.getDataMaps(m, "all"));

			finaleOrderResult.put(map.getKey(), order.verifieOrderMap(map.getValue(), DefaultData.modelsTab1));
		}
		return finaleOrderResult;
	}

	/* ---------------- Collection Douplicate ------------------ */

	public Map<String, Collection<Boolean>> duplicateAndNullCollections(Map<String, Collection<Model>> collections) {

		finaleDuplicateNullResult = new LinkedHashMap<>();
		Iterator<Entry<String, Collection<Model>>> itr = collections.entrySet().iterator();

		while (itr.hasNext()) {

			duplicateNull = new ArrayList<Boolean>();
			boolean acceptDuplicate;
			boolean acceptNull;

			Entry<String, Collection<Model>> map = itr.next();
			Collection<Model> collection = map.getValue();
			int initialSize = collection.size();

			// add duplicate data
			collection.addAll(data.addDuplicateDataCollection(collection));

			if (initialSize != collection.size()) {
				acceptDuplicate = true;
			} else {
				acceptDuplicate = false;
			}

			try {
				collection.add(null);
				acceptNull = true;

			} catch (Exception e) {
				acceptNull = false;
			}

			duplicateNull.add(acceptDuplicate);
			duplicateNull.add(acceptNull);
			finaleDuplicateNullResult.put(map.getKey(), duplicateNull);

		}
		return finaleDuplicateNullResult;
	}

	/* ---------------- Maps Double ------------------ */

	public Map<String, Collection<Boolean>> duplicateAndNullMaps(Map<String, Map<Integer, Model>> maps) {

		finaleDuplicateNullResult = new LinkedHashMap<>();
		Iterator<Entry<String, Map<Integer, Model>>> itr = maps.entrySet().iterator();

		while (itr.hasNext()) {
			duplicateNull = new ArrayList<Boolean>();
			boolean acceptDuplicate;
			boolean acceptNull;

			Entry<String, Map<Integer, Model>> m = itr.next();
			Map<Integer, Model> map = m.getValue();
			int initialSize = map.size();

			map.putAll(data.addDuplicateDataMap(map));

			if (initialSize != map.size()) {
				acceptDuplicate = true;
			} else {
				acceptDuplicate = false;
			}

			try {
				map.put(map.size() + 1, null);
				acceptNull = true;
			} catch (Exception e) {
				acceptNull = false;
			}
			
			duplicateNull.add(acceptDuplicate);
			duplicateNull.add(acceptNull);

			finaleDuplicateNullResult.put(m.getKey(), duplicateNull);

		}

		return finaleDuplicateNullResult;

	}

}
