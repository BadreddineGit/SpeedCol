package com.ofppt.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AdapterModel {

	private Map<String, Collection<Collection<String>>> finaleColInfoMethodResult;
	private Map<String, Collection<Collection<Double>>> finaleColSpeedSizeResult;
	private Map<String, Boolean> finaleColOrderResult;
	private Map<String, Collection<Boolean>> finaleColDuplicateNullResult;

	private Map<String, Collection<Collection<String>>> finaleMapInfoMethodResult;
	private Map<String, Collection<Collection<Double>>> finaleMapSpeedSizeResult;
	private Map<String, Boolean> finaleMapOrderResult;
	private Map<String, Collection<Boolean>> finaleMapDuplicateNullResult;

	// Getters

	// Collections
	public Collection<String> getColInfoResult() {

		Collection<String> info = new ArrayList<String>();
		Iterator<Entry<String, Collection<Collection<String>>>> itr = finaleColInfoMethodResult.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<String, Collection<Collection<String>>> m = itr.next();

			info.add(m.getKey());

			Iterator<Collection<String>> itrCol = m.getValue().iterator();

			for (String s : itrCol.next()) {
				info.add(s);
			}
		}
		return info;

	}

	public Map<String, Collection<String>> getColMethodResult() {

		Map<String, Collection<String>> Methods = new LinkedHashMap<String, Collection<String>>();
		Iterator<Entry<String, Collection<Collection<String>>>> itr = finaleColInfoMethodResult.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<String, Collection<Collection<String>>> m = itr.next();

			int i = 0;
			for (Collection<String> col : m.getValue()) {

				// Get the second collection (Methods) of the map
				if (i == 1) {
					Methods.put(m.getKey(), col);
					i = 0;
				}
				i++;
			}
		}
		return Methods;
	}

	public Collection<String> getFinaleColSpeedSizeResult() {

		Collection<String> SpeedSize = new ArrayList<String>();
		Iterator<Entry<String, Collection<Collection<Double>>>> itr = finaleColSpeedSizeResult.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Collection<Collection<Double>>> m = itr.next();

			SpeedSize.add(m.getKey());

			for (Collection<Double> col : m.getValue()) {
				for (Double d : col) {
					SpeedSize.add(String.valueOf(d));
				}
			}
		}
		return SpeedSize;
	}

	public Collection<String> getFinaleColOrderResult() {
		Collection<String> order = new ArrayList<String>();
		Iterator<Entry<String, Boolean>> itr = finaleColOrderResult.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Boolean> m = itr.next();

			order.add(m.getKey());
			order.add(String.valueOf(m.getValue()));
		}
		return order;
	}

	public Collection<String> getFinaleColDuplicateNullResult() {
		Collection<String> DuplicatNull = new ArrayList<String>();
		Iterator<Entry<String, Collection<Boolean>>> itr = finaleColDuplicateNullResult.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Collection<Boolean>> m = itr.next();

			DuplicatNull.add(m.getKey());

			for (Boolean b : m.getValue()) {
				DuplicatNull.add(String.valueOf(b));
			}
		}
		return DuplicatNull;
	}

	// Maps
	public Collection<String> getMapInfoResult() {

		Collection<String> info = new ArrayList<String>();
		Iterator<Entry<String, Collection<Collection<String>>>> itr = finaleMapInfoMethodResult.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Collection<Collection<String>>> m = itr.next();

			info.add(m.getKey());

			Iterator<Collection<String>> itrCol = m.getValue().iterator();

			for (String s : itrCol.next()) {
				info.add(s);
			}
		}
		return info;
	}
	

	public Map<String, Collection<String>> getMapMethodResult() {

		Map<String, Collection<String>> Methods = new LinkedHashMap<String, Collection<String>>();
		Iterator<Entry<String, Collection<Collection<String>>>> itr = finaleMapInfoMethodResult.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<String, Collection<Collection<String>>> m = itr.next();

			int i = 0;
			for (Collection<String> col : m.getValue()) {

				// Get the second collection (Methods) of the map
				if (i == 1) {
					Methods.put(m.getKey(), col);
					i = 0;
				}
				i++;
			}
		}
		return Methods;
	}

	public Collection<String> getFinaleMapSpeedSizeResult() {
		Collection<String> SpeedSize = new ArrayList<String>();
		Iterator<Entry<String, Collection<Collection<Double>>>> itr = finaleMapSpeedSizeResult.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Collection<Collection<Double>>> m = itr.next();

			SpeedSize.add(m.getKey());

			for (Collection<Double> col : m.getValue()) {
				for (Double d : col) {
					SpeedSize.add(String.valueOf(d));
				}
			}
		}
		return SpeedSize;
	}

	public Collection<String> getFinaleMapOrderResult() {
		Collection<String> order = new ArrayList<String>();
		Iterator<Entry<String, Boolean>> itr = finaleMapOrderResult.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Boolean> m = itr.next();

			order.add(m.getKey());
			order.add(String.valueOf(m.getValue()));
		}
		return order;
	}

	public Collection<String> getFinaleMapDuplicateNullResult() {
		Collection<String> DuplicatNull = new ArrayList<String>();
		Iterator<Entry<String, Collection<Boolean>>> itr = finaleMapDuplicateNullResult.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Collection<Boolean>> m = itr.next();

			DuplicatNull.add(m.getKey());

			for (Boolean b : m.getValue()) {
				DuplicatNull.add(String.valueOf(b));
			}
		}
		return DuplicatNull;
	}

	// Setters

	public void setFinaleColInfoMethodResult(Map<String, Collection<Collection<String>>> finaleColInfoMethodResult) {
		this.finaleColInfoMethodResult = finaleColInfoMethodResult;
	}

	public void setFinaleColSpeedSizeResult(Map<String, Collection<Collection<Double>>> finaleColSpeedSizeResult) {
		this.finaleColSpeedSizeResult = finaleColSpeedSizeResult;
	}

	public void setFinaleColOrderResult(Map<String, Boolean> finaleColOrderResult) {
		this.finaleColOrderResult = finaleColOrderResult;
	}

	public void setFinaleColDuplicateNullResult(Map<String, Collection<Boolean>> finaleColDuplicateNullResult) {
		this.finaleColDuplicateNullResult = finaleColDuplicateNullResult;
	}

	public void setFinaleMapInfoMethodResult(Map<String, Collection<Collection<String>>> finaleMapInfoMethodResult) {
		this.finaleMapInfoMethodResult = finaleMapInfoMethodResult;
	}

	public void setFinaleMapSpeedSizeResult(Map<String, Collection<Collection<Double>>> finaleMapSpeedSizeResult) {
		this.finaleMapSpeedSizeResult = finaleMapSpeedSizeResult;
	}

	public void setFinaleMapOrderResult(Map<String, Boolean> finaleMapOrderResult) {
		this.finaleMapOrderResult = finaleMapOrderResult;
	}

	public void setFinaleMapDuplicateNullResult(Map<String, Collection<Boolean>> finaleMapDuplicateNullResult) {
		this.finaleMapDuplicateNullResult = finaleMapDuplicateNullResult;
	}

}
