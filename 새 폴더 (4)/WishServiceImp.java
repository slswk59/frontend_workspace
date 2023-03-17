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
    public int insertWishProcess(WishDTO wish) {
        return wishDao.insertWish(wish);
    }

    @Override
    public int deleteWishProcess(int wish_key) {
        return wishDao.deleteWish(wish_key);
    }

    @Override
    public List<WishDTO> getWishListProcess(String id) {
        return wishDao.getWishList(id);
    }
    
}