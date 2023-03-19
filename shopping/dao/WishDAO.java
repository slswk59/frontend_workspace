package shopping.dao;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishDAO {
    
    // 유저가 찜한 상품 목록을 조회하는 기능
    List<WishDTO> selectWishListByUserId(int userId);
    
    // 유저가 찜한 상품을 카트에 추가하는 기능
    int insertCartByUserIdAndProductId(int userId, int productId);
    
    // 유저가 찜한 상품을 찜 목록에서 삭제하는 기능
    int deleteWishByUserIdAndProductId(int userId, int productId);
    
}