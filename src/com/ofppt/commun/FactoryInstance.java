package com.ofppt.commun;

import com.ofppt.dao.DefaultData;
import com.ofppt.metier.AppTest;
import com.ofppt.metier.Order;
import com.ofppt.metier.Speed;
import com.ofppt.presentation.AppManager;

public class FactoryInstance {

	public static AppTest buildManager() {
		return AppTest.getInstance();
	}

	public static Speed buildSpeed() {
		return Speed.getInstance();
	}

	public static DefaultData buildData() {
		return DefaultData.getInstance();
	}

	public static AppManager buildMenu() {
		return AppManager.getInstance();
	}

	public static Order buildOrder() {
		return Order.getInstance();
	}

}
