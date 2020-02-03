package singleton;

import controller.MemberController;
import dto.CoffeeDto;

import java.util.ArrayList;
import java.util.List;

import controller.CoffeeController;

public class Singleton {
	private static Singleton s = null;
	
	public MemberController memCtrl = null;
	public CoffeeController cfeCtrl = null;
	public List<CoffeeDto> cfelist = null;
	
	
	private String loginID;
	
	public Singleton() {
		memCtrl = new MemberController();
		cfeCtrl = new CoffeeController();
		cfelist = new ArrayList<CoffeeDto>();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
	
}
