package com.ofppt.metier;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.ofppt.dao.Model;

public class Order {

	private static Order instance;

	public static synchronized Order getInstance() {
		if (instance == null) {
			instance = new Order();
		}
		return instance;
	}

	private Order() {

	}

	public boolean verifieOrderCollection(Collection<Model> collection, Model[] models) {

		boolean order = true;
		Iterator<Model> itr = collection.iterator();
		int i = 0;
		while (itr.hasNext()) {
			if (!models[i].equals(itr.next())) {
				order = false;
				break;
			}
			i++;
		}
		return order;

	}

	public boolean verifieOrderMap(Map<Integer, Model> map, Model[] models) {

		boolean order = true;
		Iterator<Entry<Integer, Model>> itr = map.entrySet().iterator();
		int i = 0;
		while (itr.hasNext()) {
			if (!models[i].equals(itr.next().getValue())) {
				order = false;
				break;
			}
			i++;

		}
		return order;
	}

}
