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
    public List<WishDTO> getWishListByMemberId(String memberId) {
        return wishDao.selectWishListByMemberId(memberId);
    }

    @Override
    public boolean addCartByWishKey(int wishKey) {
        boolean result = false;
        WishDTO wishDto = wishDao.selectWishByWishKey(wishKey);
        if (wishDto != null) {
            result = cartService.addCart(wishDto.getProductKey(), wishDto.getMemberId());
            if (result) {
                wishDao.deleteWishByWishKey(wishKey);
            }
        }
        return result;
    }

    @Override
    public boolean deleteWishByWishKey(int wishKey) {
        return wishDao.deleteWishByWishKey(wishKey);
    }
}
