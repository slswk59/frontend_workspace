package shopping.service;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishService {

	    // 찜 목록에 상품 추가 기능
		public void addProductToWishList(String Id, int pr_Key);
		
		// 찜 목록 조회 기능
		public List<WishDTO> getWishList(String Id);
		
		// 찜 목록에서 상품 삭제 기능
		public void deleteProductFromWishList(int wish_Key);
		
		// 카트에 상품 추가 기능
		public void addProductToCart(int wish_Key);

}
