package shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cart.service.CartService;
import shopping.dto.ProductDTO;
import shopping.dto.WishDTO;
import shopping.service.ProductService;
import shopping.service.WishService;

// http://localhost:8090/wish.do

@Controller
public class WishController {
    
    @Autowired
    private WishService wishService;
    
    @Autowired
    private ProductService productService;
    
    // 해당 유저의 찜 목록을 조회하는 기능
    @RequestMapping("/wish.do/{userId}")
    public String getWishListByUserId(@PathVariable("userId") int userId, Model model) {
        List<WishDTO> wishList = wishService.getWishListByUserId(userId);
        List<ProductDTO> productList = productService.getProductListByWishList(wishList);
        
        model.addAttribute("userId", userId);
        model.addAttribute("wishList", wishList);
        model.addAttribute("productList", productList);
        return "wish/list";
    }
    
 // 찜 목록에 있는 상품을 카트에 추가하는 기능
    @RequestMapping("/add/cart/{userId}/{productId}")
    public String addProductToCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
        // 카트 서비스의 addCart 메서드를 호출하여 상품을 카트에 추가
        CartService.addCart(userId, productId);
    }
    
    // 찜 목록에서 상품을 삭제하는 기능
    @RequestMapping("/delete/{userId}/{productId}")
    public String deleteProductFromWishList(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
        wishService.deleteProductFromWishList(userId, productId);
        return "redirect:/wish/list/" + userId;
    }
}
