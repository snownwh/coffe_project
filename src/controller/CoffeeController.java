package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dto.CoffeeDto;
import dto.CoffeeMenuDto;
import service.CoffeeService;
import service.impl.CoffeeServiceImpl;
import singleton.Singleton;
import view.CoffeeMenuView;
import view.CoffeeOrderHistoryView;
import view.CoffeeOrderMenu;
import view.TotalOrder;

public class CoffeeController {
	CoffeeService cfeServ = new CoffeeServiceImpl();
	
	public void OrderMenu() {
		new CoffeeOrderMenu();
	}
	
	public void getCoffeeList() {
		List<CoffeeMenuDto> list = cfeServ.getCoffeeList(); 
		new CoffeeMenuView(list);
	}
	
	public int coffeeCost(String size, String name) {
		int cost = cfeServ.coffeePrice(size, name);
		return cost;
	}
	
	public void OrderAf(CoffeeDto dto) {
		boolean b = cfeServ.orderCoffee(dto);
		if(b) {
			// list <- 일회성
			JOptionPane.showMessageDialog(null, "주문완료");
			
			List<CoffeeDto> list = cfeServ.orderBfPayList();
			new CoffeeOrderHistoryView(list);
		}
		else {
			JOptionPane.showMessageDialog(null, "주문실패");
		}
		
		Object obj = new Object();
		
	}
	
	
	
	
	public void totalList() {
		// list <- DB
		List<CoffeeDto> list = cfeServ.totalList();
		new TotalOrder(list);
		
		
	}
	
	public int _sumAll() {
		int sumAll = cfeServ.sumAll();
		return sumAll;
	}
	
	
}
