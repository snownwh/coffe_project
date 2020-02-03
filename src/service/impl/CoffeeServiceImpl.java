package service.impl;

import java.util.List;

import dao.CoffeeDao;
import dao.impl.CoffeeDaoImpl;
import dto.CoffeeDto;
import dto.CoffeeMenuDto;
import service.CoffeeService;

public class CoffeeServiceImpl implements CoffeeService {
	CoffeeDao cfeDao = new CoffeeDaoImpl();

	@Override
	public List<CoffeeMenuDto> getCoffeeList() {
		return cfeDao.getCoffeeList();
	}

	@Override
	public int coffeePrice(String size, String name) {
		return cfeDao.coffeePrice(size, name);
	}

	@Override
	public boolean orderCoffee(CoffeeDto dto) {
		return cfeDao.orderCoffee(dto);
	}

	@Override
	public List<CoffeeDto> orderBfPayList() {
		return cfeDao.orderBfPayList();
	}

	@Override
	public List<CoffeeDto> totalList() {
		return cfeDao.totalList();
	}

	@Override
	public int sumAll() {
		return cfeDao.sumAll();
	}
	
	
	
	
	
	
	
	

	
}
