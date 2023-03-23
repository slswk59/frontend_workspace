package shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.dto.AuthInfo;
import shopping.dto.AddressDTO;
import shopping.service.AddressService;

//http://localhost:8090/myapp/shopping/delivery.do

@Controller
public class AddressController {
	
	private AddressService addressService;
	
	public AddressController() {
		
	}
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
//	// 배송지 조회
//	@RequestMapping("/shopping/delivery.do") // 받는 것 //보내주는 것
//	public ModelAndView listExecute(@ModelAttribute("pv") String pv, ModelAndView mav) {
//		List<AddressDTO> aList = addressService.selectAllAddressesProcess(pv);
//	    mav.addObject("aList", aList);
//		mav.setViewName("shopping/delivery");
//		return mav;
//	}
	
	    // 배송지 조회
		@RequestMapping("/shopping/delivery.do") // 받는 것 //보내주는 것
		public ModelAndView listExecute(HttpSession session, ModelAndView mav) {
			AuthInfo authInfo =(AuthInfo)session.getAttribute("authInfo");
			System.out.println(authInfo.getId());
			List<AddressDTO> aList = addressService.selectAllAddressesProcess(authInfo.getId());
		    mav.addObject("aList", aList);
			mav.setViewName("shopping/delivery");
			return mav;
		}
		
		
		// 배송지 삭제
		@RequestMapping(value="/shopping/delivery/deleteAddress.do", method=RequestMethod.POST)
		public ModelAndView deleteAddressProcess(@RequestParam("del_key") int del_key, HttpSession session, ModelAndView mav) {
		    AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		    addressService.deleteAddressProcess(del_key, authInfo.getId());
		    mav.setViewName("redirect:/shopping/delivery.do");
		    return mav;
		}

		
		
	// 배송지 수정
	
	
	
	
		
	// 배송지 추가
	
	

}
