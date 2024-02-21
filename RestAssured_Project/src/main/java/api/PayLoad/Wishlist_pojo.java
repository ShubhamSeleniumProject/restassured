package api.PayLoad;



public class Wishlist_pojo {
	String productId;
	int quantity;
	
 
	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Wishlist_pojo(String productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	
	
	
	

}
