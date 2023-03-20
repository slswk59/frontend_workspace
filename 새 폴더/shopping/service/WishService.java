package shopping.service;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishService {

    // 해당 회원의 찜 목록 조회
    public List<WishDTO> getWishListByMemberId(String memberId);

    // 찜한 상품을 카트에 추가
    public boolean addCartByWishKey(int wishKey);

    // 찜한 상품 삭제
    public boolean deleteWishByWishKey(int wishKey);

}
