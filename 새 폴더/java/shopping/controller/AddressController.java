package shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.dto.AuthInfo;
import shopping.dao.AddressDAO;
import shopping.dto.AddressDTO;
import shopping.service.AddressService;

//http://localhost:8090/myapp/index.do
//http://localhost:8090/myapp/shopping/delivery.do

@Controller
public class AddressController {
	
	private AddressService addressService;
	private AddressDAO addressDao;
	
	public AddressController() {
		
	}
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	public void setAddressDAO(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}
	
//	// 배송지 조회
//	@RequestMapping("/shopping/delivery.do") // 받는 것 //보내주는 것
//	public ModelAndView listExecute(@ModelAttribute("pv") String pv, ModelAndView mav) {
//		List<AddressDTO> aList = addressService.selectAllAddressesProcess(pv);
//	    mav.addObject("aList", aList);
//		mav.setViewName("shopping/delivery");
//		return mav;
//	}
	
	    // 배송지 조회로딩
		@RequestMapping("/shopping/delivery.do") // 받는 것 //보내주는 것
		public ModelAndView listExecute(HttpSession session, ModelAndView mav) {
			AuthInfo authInfo =(AuthInfo)session.getAttribute("authInfo");
			//System.out.println(authInfo.getId());
			List<AddressDTO> aList = addressService.selectAllAddressesProcess(authInfo.getId());
		    mav.addObject("aList", aList);
			mav.setViewName("shopping/delivery");
			return mav;
		}
		
		
		// 배송지 삭제기능
		@RequestMapping(value="/shopping/delivery.do", method=RequestMethod.POST)
		public String deleteAddressProcess(@ModelAttribute final AddressDTO dto, HttpSession session) {
		    AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		    System.out.println(dto.getDel_key());
		    addressService.deleteAddressProcess(dto.getDel_key());
		    return "redirect:/shopping/delivery.do";	
		    }

		// 배송지 추가로딩
		@RequestMapping(value="/shopping/post.do", method=RequestMethod.GET)
		public ModelAndView insertAddressForm(HttpSession session, ModelAndView mav) {
			AuthInfo authInfo =(AuthInfo)session.getAttribute("authInfo");
		    mav.addObject("addressDTO", new AddressDTO());
		    mav.setViewName("shopping/post");
		    return mav;
		}

		//배송지 추가기능
		@RequestMapping(value="/shopping/post.do", method=RequestMethod.POST)
		public String insertAddressProcess(@ModelAttribute("addressDTO") AddressDTO dto, HttpSession session) {
		    AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		    addressService.insertAddressProcess(dto);
		    return "redirect:/shopping/delivery.do";
		}
	
		// 배송지 수정
			
	
	
	
		
	
	
	

}
