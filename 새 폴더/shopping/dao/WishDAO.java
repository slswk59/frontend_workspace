package shopping.dao;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishDAO {
    // 해당 회원의 찜 목록 조회
    public List<WishDTO> selectWishListByMemberId(String memberId);

    // 찜한 상품을 카트에 추가
    public int insertCartByWishKey(int wishKey);

    // 찜한 상품 삭제
    public int deleteWishByWishKey(int wishKey);
}
