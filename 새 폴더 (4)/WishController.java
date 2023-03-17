package shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopping.dto.WishDTO;
import shopping.service.WishService;

//http://localhost:8090/myapp/wish.do

@Controller
public class WishController {
	
	private WishService wishService;
	private HttpSession session;
	
	@Autowired
	public WishController(WishService wishService, HttpSession session) {
		this.wishService = wishService;
		this.session = session;
	}
	
	public void setIdAttribute(WishDTO wish) {
		String id = (String) session.getAttribute("id");
		wish.setId(id);
	}
	
    // 위시리스트 페이지로 이동
    @RequestMapping(value = "/wishList", method = RequestMethod.GET)
    public String wishList(Model model, @RequestParam String id) {
        List<WishDTO> wishList = wishService.getWishListProcess(id);
        model.addAttribute("wishList", wishList);
        return "wishList";
    }

    // 위시리스트에 상품 추가
    @RequestMapping(value = "/addWish", method = RequestMethod.POST)
    public String addWish(WishDTO wish) {
        setIdAttribute(wish);
        wishService.insertWishProcess(wish);
        return "redirect:/wishList?id=" + wish.getId();
    }

    // 위시리스트에서 상품 삭제
    @RequestMapping(value = "/deleteWish", method = RequestMethod.GET)
    public String deleteWish(@RequestParam int wish_key, @RequestParam String id) {
        wishService.deleteWishProcess(wish_key);
        return "redirect:/wishList?id=" + id;
    }

}
