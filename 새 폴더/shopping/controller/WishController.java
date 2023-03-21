package shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.dto.MemberDTO;
import shopping.dto.ProductDTO;
import shopping.dto.WishDTO;
import shopping.service.WishService;

// http://localhost:8090/myapp/shopping/wish.do
@Controller
public class WishController {

	private WishService wishService;

	public WishController() {
		
	}

	public void setWishService(WishService wishService) {
		this.wishService = wishService;
	}

	// 1. 상품 찜하기
	@RequestMapping(value="/shopping/.do", method=RequestMethod.POST)
	public ModelAndView addWish(@RequestParam int pr_key, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/goods/view.do?pr_key=" + pr_key);
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if(member != null) {
			WishDTO wish = new WishDTO();
			ProductDTO productDTO = new ProductDTO();
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.getId();
			productDTO.setPr_key(pr_key);
			wishService.addProductToWishList(null, pr_key);
		}
		return mav;
	}

	// 2. 찜 목록 조회하기
	@RequestMapping(value="/wish/wish.do", method=RequestMethod.GET)
	public String getWishList(Model model, HttpSession session) {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if(member != null) {
			List<WishDTO> wishList = wishService.getWishList(member.getId());
			model.addAttribute("wishList", wishList);
		}
		return "/shopping/wish";
	}

	// 3. 찜한 상품 카트에 추가하기
	@RequestMapping(value="/wish/cart.do", method=RequestMethod.POST)
	public ModelAndView addToCart(@RequestParam int pr_key, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/shopping/cart.do");
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if(member != null) {
			WishDTO wish = new WishDTO();
			ProductDTO productDTO = new ProductDTO();
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.getId();
			productDTO.setPr_key(pr_key);
			wishService.addProductToCart(pr_key);
		}
		return mav;
	}

	// 4. 찜 목록에서 삭제하기
	@RequestMapping(value="/wish/wish.do/{wish_key}", method=RequestMethod.DELETE)
	public ModelAndView deleteWish(@PathVariable int wish_key, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/wish/wish.do");
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if(member != null) {
			WishDTO wish = new WishDTO();
			wish.setWish_key(wish_key);
			wishService.deleteProductFromWishList(wish_key);
		}
		return mav;
	}
}
