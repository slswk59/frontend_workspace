package shopping.dao;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishDAO {
	
	public List<WishDTO> selectWishList(String id);
	
	public int deleteWish(int wish_key);
	
	public int insertWish(WishDTO wishDto);
	
	public int insertCart(WishDTO wishDto);
	
	public int moveCart(int wish_key, String id);
	
	public int deleteWishByIdAndProductKey(String id, int product_key);
}