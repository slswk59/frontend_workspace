package shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopping.dto.AddressDTO;
import shopping.dto.PageDTO;
import shopping.service.AddressService;

//http://localhost:8090/myapp/shopping/delivery.do
//http://localhost:8090/myapp/member/signup.do

@Controller
public class AddressController {
	
	private AddressService addressService;
	
	public AddressController() {
		
	}
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping("/shopping/delivery.do") // 받는 것 //보내주는 것
	public ModelAndView listExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
		System.out.println("pv:" + pv.getCurrentPage());
		int totalRecord = AddressService.countProcess();
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				pv.setCurrentPage(1);

			this.pdto = new PageDTO(pv.getCurrentPage(), totalRecord);
			mav.addObject("pv", this.pdto);
			mav.addObject("aList", AddressService.listProcess(this.pdto));
		}
		mav.setViewName("shopping/delivery");
		return mav;
	}
	
	

}
