package shopping.service;

import java.util.List;

import shopping.dao.WishDAO;
import shopping.dto.WishDTO;

public class WishServiceImp implements WishService {

    private WishDAO wishDao;
    
    public WishServiceImp() {
		
	}
    
    public void setWishDao(WishDAO wishDao) {
		this.wishDao = wishDao;
    }

    @Override
    public void addProductToWishList(String id, int pr_key) {
        wishDao.insertWish(id, pr_key);
    }

    @Override
    public List<WishDTO> getWishList(String id) {
        return wishDao.selectWishListByMemberId(id);
    }

    @Override
    public void addProductToCart(int wish_key) {
        wishDao.insertCartByWishKey(wish_key);
    }

    @Override
    public void deleteProductFromWishList(int wish_key) {
        wishDao.deleteWishByWishKey(wish_key);
    }
}
