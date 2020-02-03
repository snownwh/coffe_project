package main;

import db.DBConnection;
import dto.CoffeeMenuDto;
import singleton.Singleton;
import view.CoffeeMenuView;
import view.CoffeeOrderHistoryView;
import view.CoffeeOrderMenu;
import view.LoginView;

public class MainClass {
	public static void main(String[] args) {
		DBConnection.initConnection();
		
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
//		s.cfeCtrl.getCoffeeList();
//		new CoffeeOrderMenu();
//		new CoffeeOrderHistoryView();
	}
}
