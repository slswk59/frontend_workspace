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
    public List<WishDTO> getWishListProcess(String id) {
        return wishDao.selectWishListById(id);
    }

    @Override
    public void deleteWishProcess(int wishKey) {
        wishDao.deleteWish(wishKey);
    }

    @Override
    public void addCartFromWishProcess(int wishKey, String id) {
        wishDao.addCartFromWish(wishKey, id);
    }
}
