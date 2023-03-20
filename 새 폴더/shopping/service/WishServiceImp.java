package shopping.service;

import java.util.List;

import shopping.dao.WishDAO;
import shopping.dto.WishDTO;

public class WishServiceImp implements WishService {

    private WishDAO wishDao;

    public WishServiceImp(WishDAO wishDao) {
        this.wishDao = wishDao;
    }

    @Override
    public List<WishDTO> getWishListByMemberId(String memberId) {
        return wishDao.selectWishListByMemberId(memberId);
    }

    @Override
    public boolean addCartByWishKey(int wishKey) {
        int result = wishDao.insertCartByWishKey(wishKey);
        return result == 1;
    }

    @Override
    public boolean deleteWishByWishKey(int wishKey) {
        int result = wishDao.deleteWishByWishKey(wishKey);
        return result == 1;
    }
}
