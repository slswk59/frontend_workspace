package shopping.service;

import java.util.List;

import shopping.dto.CartDTO;
import shopping.dto.WishDTO;

public interface WishService {

    public List<WishDTO> getWishListProcess(String id);
    
    public int addWishProcess(WishDTO wishDto);
    
    public int removeWishProcess(int wish_key);
    
    public int moveWishToCartProcess(CartDTO cartDto);
    
}