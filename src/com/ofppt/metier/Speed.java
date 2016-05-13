package com.ofppt.metier;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.ofppt.dao.Model;

public class Speed {

	private static Speed instance;

	public static synchronized Speed getInstance() {
		if (instance == null) {
			instance = new Speed();
		}
		return instance;
	}

	private Speed() {

	}

	public double difference(double start, double end) {
		return (end - start) / 1e6;
	}

	/* ----------------- Insert ----------------- */

	public double insertSpeed(Collection<Model> collection, Collection<Model> colToAdd) {

		double start = System.nanoTime();
		collection.addAll(colToAdd);
		double end = System.nanoTime();

		return difference(start, end);
	}

	public double insertSpeed(Map<Integer, Model> map, Map<Integer, Model> mapToAdd) {

		double start = System.nanoTime();
		map.putAll(mapToAdd);
		double end = System.nanoTime();

		return difference(start, end);

	}

	/* ----------------- Remove ----------------- */

	public double removeSpeed(Collection<Model> collection, int position) {

		int i = 0;
		double start = 0;
		double end = 0;

		Iterator<Model> itr = collection.iterator();

		while (itr.hasNext()) {
			itr.next();
			if (i == position) {
				start = System.nanoTime();
				itr.remove();
				end = System.nanoTime();
			}
			i++;
		}

		return difference(start, end);

	}

	public double removeSpeed(Map<Integer, Model> map, int position) {

		double start = 0;
		double end = 0;
		int i = 0;

		Iterator<Entry<Integer, Model>> itr = map.entrySet().iterator();

		while (itr.hasNext()) {
			itr.next();
			if (i == position) {
				start = System.nanoTime();
				itr.remove();
				end = System.nanoTime();
			}
			i++;
		}

		return difference(start, end);

	}

	/* ----------------- Find ----------------- */

	public double findSpeed(Collection<Model> collection, Model model) {

		double diff = 0;

		double start = System.nanoTime();
		if (collection.contains(model)) {
			double end = System.nanoTime();
			diff = difference(start, end);
		} else {
			System.out.println("Model not found");
		}

		return diff;
	}

	public double findSpeed(Map<Integer, Model> map, Model model) {

		double diff = 0;

		double start = System.nanoTime();
		if (map.containsValue(model)) {
			double end = System.nanoTime();
			diff = difference(start, end);
		} else {
			System.out.println("Model not found");
		}

		return diff;

	}

}
