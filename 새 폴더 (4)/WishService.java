package shopping.service;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishService {
	public List<WishDTO> getWishListProcess(String id); // 로그인한 사용자의 위시리스트 조회
	public void deleteWishProcess(int wishKey); // 위시리스트에서 선택된 상품 삭제
	public void addCartFromWishProcess(int wishKey, String id); // 위시리스트에서 선택된 상품 장바구니로 이동
}
