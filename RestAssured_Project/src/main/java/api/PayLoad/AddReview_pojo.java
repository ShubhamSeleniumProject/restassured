package api.PayLoad;

public class AddReview_pojo {
	
	String dateTime;
	String description;
	String heading;
	String rating;
	String shopperId;
	String shopperName;
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getShopperId() {
		return shopperId;
	}
	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}
	public String getShopperName() {
		return shopperName;
	}
	public void setShopperName(String shopperName) {
		this.shopperName = shopperName;
	}
	public AddReview_pojo(String dateTime, String description, String heading, String rating, String shopperId,
			String shopperName) {
		super();
		this.dateTime = dateTime;
		this.description = description;
		this.heading = heading;
		this.rating = rating;
		this.shopperId = shopperId;
		this.shopperName = shopperName;
	}
	
	

}
