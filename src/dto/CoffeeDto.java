package dto;

public class CoffeeDto {
	private int sequence;
	private String id;
	private String coffeeName;
	private int price;
	private String date;
	private String size;
	private String cyrup; 
	private String cream;
	private String addShot;
	private int amount;
	private int total_price;
	
	public CoffeeDto() {
	}
	
	
	
	public CoffeeDto(String coffeeName, String date, String size, int amount, int total_price) {
		super();
		this.coffeeName = coffeeName;
		this.date = date;
		this.size = size;
		this.amount = amount;
		this.total_price = total_price;
	}



	public CoffeeDto(String coffeeName, String size, String cyrup, String cream, String addShot, int amount,
			int total_price) {
		super();
		this.coffeeName = coffeeName;
		this.size = size;
		this.cyrup = cyrup;
		this.cream = cream;
		this.addShot = addShot;
		this.amount = amount;
		this.total_price = total_price;
	}

	public CoffeeDto(int sequence, String id, String coffeeName, int price, String date, String size, String cyrup,
			String cream, String addShot, int amount, int total_price) {
		super();
		this.sequence = sequence;
		this.id = id;
		this.coffeeName = coffeeName;
		this.price = price;
		this.date = date;
		this.size = size;
		this.cyrup = cyrup;
		this.cream = cream;
		this.addShot = addShot;
		this.amount = amount;
		this.total_price = total_price;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCyrup() {
		return cyrup;
	}

	public void setCyrup(String cyrup) {
		this.cyrup = cyrup;
	}

	public String getCream() {
		return cream;
	}

	public void setCream(String cream) {
		this.cream = cream;
	}

	public String getAddShot() {
		return addShot;
	}

	public void setAddShot(String addShot) {
		this.addShot = addShot;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "CoffeeDto [sequence=" + sequence + ", id=" + id + ", coffeeName=" + coffeeName + ", price=" + price
				+ ", date=" + date + ", size=" + size + ", cyrup=" + cyrup + ", cream=" + cream + ", addShot=" + addShot
				+ ", amount=" + amount + ", total_price=" + total_price + "]";
	}

	

	
	
}
