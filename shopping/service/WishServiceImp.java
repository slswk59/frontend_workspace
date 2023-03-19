package shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.service.CartService;
import shopping.dao.WishDAO;
import shopping.dto.WishDTO;

@Service
public class WishServiceImp implements WishService {

    @Autowired
    private WishDAO wishDao;

    @Autowired
    private CartService cartService;

    @Override
    public List<WishDTO> getWishListByUserId(int userId) {
        return wishDao.selectWishListByUserId(userId);
    }

    @Override
    public void addProductToCart(int userId, int productId) {
        // 카트 서비스의 addCart 메서드를 호출하여 상품을 카트에 추가
        cartService.addCart(userId, productId);
    }

    @Override
    public void deleteProductFromWishList(int userId, int productId) {
        wishDao.deleteWishByUserIdAndProductId(userId, productId);
    }
}
