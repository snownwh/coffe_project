package dto;

public class CoffeeMenuDto {
	private String cName;
	private int _short;
	private int _tall;
	private int _grande;
	
	public CoffeeMenuDto() {
	}
	
	

	public CoffeeMenuDto(String cName, int _short, int _tall, int _grande) {
		super();
		this.cName = cName;
		this._short = _short;
		this._tall = _tall;
		this._grande = _grande;
	}



	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int get_short() {
		return _short;
	}

	public void set_short(int _short) {
		this._short = _short;
	}

	public int get_tall() {
		return _tall;
	}

	public void set_tall(int _tall) {
		this._tall = _tall;
	}

	public int get_grande() {
		return _grande;
	}

	public void set_grande(int _grande) {
		this._grande = _grande;
	}



	@Override
	public String toString() {
		return "CoffeeMenuDto [cName=" + cName + ", _short=" + _short + ", _tall=" + _tall + ", _grande=" + _grande
				+ "]";
	}
	
	
	

	
	
	
	
}
