package shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shopping.dto.WishDTO;

@Mapper
public interface WishDAO {
    // 유저가 찜한 상품 목록을 조회하는 기능
    public List<WishDTO> selectWishListByMemberId(String memberId);

    // 찜 목록에 있는 상품을 장바구니에 담는 기능
    public boolean insertCartByWishKey(int wishKey);

    // 찜 목록에서 상품을 삭제하는 기능
    public boolean deleteWishByWishKey(int wishKey);
}
