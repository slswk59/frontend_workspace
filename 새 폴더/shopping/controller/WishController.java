package com.example.wishlist.controller;

import com.example.wishlist.dto.WishDTO;
import com.example.wishlist.dto.WishListDTO;
import com.example.wishlist.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/wish")
public class WishController {

    private final WishService wishService;

    @Autowired
    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping
    public String viewWishList(Model model, HttpSession session) {
        String memberId = (String) session.getAttribute("memberId");
        WishListDTO wishList = wishService.getWishList(memberId);
        model.addAttribute("wishList", wishList);
        return "wish/list";
    }

    @GetMapping("/add")
    public String addWishForm(Model model) {
        model.addAttribute("wish", new WishDTO());
        return "wish/add";
    }

    @PostMapping("/add")
    public String addWish(@ModelAttribute("wish") @Valid WishDTO wish, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "wish/add";
        }
        String memberId = (String) session.getAttribute("memberId");
        wishService.addWish(memberId, wish);
        return "redirect:/wish";
    }

    @PostMapping("/{wishId}/delete")
    public String deleteWish(@PathVariable Long wishId, HttpSession session) {
        String memberId = (String) session.getAttribute("memberId");
        wishService.deleteWish(memberId, wishId);
        return "redirect:/wish";
    }

}
