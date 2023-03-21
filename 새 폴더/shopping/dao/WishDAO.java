package shopping.dao;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishDAO {
	
	// 유저가 상품을 찜하는 기능
	public void insertWish(String id, int pr_key);

	// 유저가 찜한 상품 목록을 조회하는 기능
	public List<WishDTO> selectWishListByMemberId(String id);

	// 유저가 찜한 상품을 카트에 추가하는 기능
	public void insertCartByWishKey(int wish_key);

	// 유저가 찜한 상품을 찜 목록에서 삭제하는 기능
	public void deleteWishByWishKey(int wish_key);

}