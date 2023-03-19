package shopping.service;

import java.util.List;

import shopping.dto.WishDTO;

public interface WishService {
    // 유저가 찜한 상품 목록을 조회하는 기능
    List<WishDTO> getWishListByUserId(int userId);

    // 유저가 찜한 상품을 카트에 추가하는 기능
    void addProductToCart(int userId, int productId);

    // 유저가 찜한 상품을 찜 목록에서 삭제하는 기능
    void deleteProductFromWishList(int userId, int productId);
}
