package service;

import java.util.List;

import dto.CoffeeDto;
import dto.CoffeeMenuDto;

public interface CoffeeService {
	
	public List<CoffeeMenuDto> getCoffeeList();
	
	public int coffeePrice(String size, String name);
	
	public boolean orderCoffee(CoffeeDto dto);
	
	public List<CoffeeDto> orderBfPayList();
	
	public List<CoffeeDto> totalList();
	
	public int sumAll();
}
