package shopping.service;

import java.util.List;

import cart.service.cartService;
import shopping.dao.WishDAO;
import shopping.dto.CartDTO;
import shopping.dto.WishDTO;

public class WishServiceImp implements WishService {
    
    private WishDAO wishDao;

    public void setWishDao(WishDAO wishDao) {
        this.wishDao = wishDao;
    }

    @Override
    public List<WishDTO> getWishListProcess(String id) {
        return wishDao.selectWishList(id);
    }

    @Override
    public int addWishProcess(WishDTO wishDto) {
        return wishDao.insertWish(wishDto);
    }

    @Override
    public int removeWishProcess(int wish_key) {
        return wishDao.deleteWish(wish_key);
    }

    @Override
    public int moveWishToCartProcess(CartDTO cartDto) {
        // 장바구니에 상품을 추가하고
        int result = cartService.addToCart(cartDto);
        // 찜 목록에서 상품을 삭제하지 않습니다.
        return result;
    }
    
}
