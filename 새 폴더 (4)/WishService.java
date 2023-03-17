package shopping.service;

import java.util.List;
import shopping.dto.WishDTO;

public interface WishService {
    public int insertWishProcess(WishDTO wish);
    public int deleteWishProcess(int wish_key);
    public List<WishDTO> getWishListProcess(String id);

}
