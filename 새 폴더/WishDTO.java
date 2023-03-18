package shopping.dto;

public class WishDTO {
	
	private int wish_key;
	private String id;
	private int product_key;
	private String product_name;
	private int price;
	private String img_path;
	
	public WishDTO() {
		
	}

	public int getWish_key() {
		return wish_key;
	}

	public void setWish_key(int wish_key) {
		this.wish_key = wish_key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProduct_key() {
		return product_key;
	}

	public void setProduct_key(int product_key) {
		this.product_key = product_key;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	
	
}
