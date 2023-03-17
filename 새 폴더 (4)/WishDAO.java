package shopping.dao;

import java.util.List;
import shopping.dto.WishDTO;

public interface WishDAO {
    public int insertWish(WishDTO wish);
    public int deleteWish(int wish_key);
    public List<WishDTO> getWishList(String id);
}