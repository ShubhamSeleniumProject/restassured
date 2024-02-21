package api.utilities;


public interface Endpoints {
	
	String baseURI = "https://www.shoppersstack.com/shopping";
	String shopperLogin ="/users/login";
	
	String viewProduct="/products/alpha";
	
	String wishlistPost="/shoppers/{shopperId}/wishlist";
	String getWishList="/shoppers/{shopperId}/wishlist";
	String deleteWishlist="/shoppers/{shopperId}/wishlist/{pid}";
	
	String postCart="/shoppers/{shopperId}/carts";
	String getCart="/shoppers/{shopperId}/carts";
	String putCart="/shoppers/{shopperId}/carts/{itemId}";
	String deleteCart="/shoppers/{shopperId}/carts/{pid}";
	
	String addAddress="/shoppers/{shopperId}/address";
	String getAddress="/shoppers/{shopperId}/address";
	String getAddressid="/shoppers/{shopperId}/address/{addressId}";
	String putAddress="/shoppers/{shopperId}/address/{addressId}";
	String deleteAddress="/shoppers/{shopperId}/address/{addressId}";
	
	String addOrder="/shoppers/{shopperId}/orders";
	String getOrder="/shoppers/{shopperId}/orders";
	String patchOrder="/shoppers/{shopperId}/orders/{orderId}?status=DELIVERED";
	String getInvoice="/shoppers/{shopperId}/orders/{orderId}/invoice";
	
	String addReview="/reviews?productId={pid}";
	String getReview="/reviews/{pid}";
	String putReview="/reviews/{reviewId}?productId={pid}";
	String deleteReview="/reviews/{reviewId}?productId={pid}";
	
	
	
	
	
	
	

}
