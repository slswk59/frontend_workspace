package shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.dto.MemberDTO;
import shopping.dto.CartDTO;
import shopping.dto.WishDTO;

import shopping.service.WishService;

//http://localhost:8090/myapp/shopping/wish.do

@Controller
public class WishController {
	
	@Autowired
	private WishService wishService;
	
	
	
	
	public WishController() {
		
	}
	
	public void setWishService(WishService wishService) {
		this.wishService = wishService;
	}
	
	// 찜 목록 페이지로 이동하는 메서드
	@RequestMapping(value = "/wish.do/{id}", method = RequestMethod.GET)
	public String wishList(@PathVariable("id") String id, Model model) {
		model.addAttribute("wishList", wishService.getWishList(id));
		return "wishList";
	}
	
	// 찜 목록에서 상품을 삭제하는 메서드
	@RequestMapping(value = "/delete/{wish_key}", method = RequestMethod.GET)
	public String deleteFromWishList(@PathVariable("wish_key") int wish_key) {
		wishService.deleteProductFromWishList(wish_key);
		return "redirect:/wish/list";
	}
		
	// 찜 목록에서 상품을 카트에 추가하는 메서드
	@RequestMapping(value = "/cart/{wish_key}", method = RequestMethod.GET)
	public String addToCartFromWishList(@PathVariable("wish_key") int wish_key) {
		wishService.addProductToCart(wish_key);
		return "redirect:/wish/list";
	}
	
	// 상품을 찜 목록에 추가하는 메서드
	@RequestMapping(value = "/add/{id}/{pr_key}", method = RequestMethod.GET)
	public String addToWishList(@PathVariable("id") String id, @PathVariable("pr_key") int pr_key) {
		wishService.addProductToWishList(id, pr_key);
		return "redirect:/product/detail/" + pr_key;
	}
	
	
}
		