package shopping.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.dto.AuthInfo;
import shopping.dto.Or_detailDTO;
import shopping.dto.PageDTO;
import shopping.dto.ProductDTO;
import shopping.service.ProductService;

//http://localhost:8090/index.do

@Controller
public class ProductController {

	private ProductService productService;
	private PageDTO pdto;

	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 상품상세페이지 로딩
	@RequestMapping("/shopping/goods.do")
	public ModelAndView oneListExecute(String pr_key, ModelAndView mav) {
		mav.addObject("dto", productService.selectOneProcess(Integer.parseInt(pr_key)));
		mav.setViewName("shopping/goods");
		return mav;
	}

	// 신상품페이지 로딩
	@RequestMapping("/shopping/newList.do")
	public ModelAndView newListExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
		int totalRecord = productService.countProcess();
		// mav.addObject("count", totalRecord);
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				pv.setCurrentPage(1);
			this.pdto = new PageDTO(pv.getCurrentPage(), totalRecord);
			mav.addObject("pv", this.pdto);
			mav.addObject("aList", productService.newListProcess(this.pdto));
		}
		mav.setViewName("shopping/newList");
//		System.out.printf("currentPage: %d, totalRecord: %d", pv.getCurrentPage(), totalRecord);
		return mav;
	}

	// 특가페이지 로딩
	@RequestMapping("/shopping/salesList.do")
	public ModelAndView salesListExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
		int totalRecord = productService.countProcess();
		// mav.addObject("count", totalRecord);
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				pv.setCurrentPage(1);
			this.pdto = new PageDTO(pv.getCurrentPage(), totalRecord);
			mav.addObject("pv", this.pdto);
			mav.addObject("aList", productService.salesListProcess(this.pdto));
		}
		mav.setViewName("shopping/salesList");
		return mav;
	}

	// 카테고리페이지 로딩
	@RequestMapping("/shopping/ctgProductList.do")
	public ModelAndView ctgProductListExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav, @RequestParam String category) {
		System.out.println(pv);
		int totalRecord = productService.ctgProductCountProcess(category); // product의 전체 카운트를 가지고 온다.
		// mav.addObject("count", totalRecord);
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				pv.setCurrentPage(1);
			this.pdto = new PageDTO(pv.getCurrentPage(), totalRecord, pv.getCategory());

			mav.addObject("pv", this.pdto);
			mav.addObject("aList", productService.ctgProductListProcess(this.pdto));
		}

		String viewName = "shopping/ctgProductList?categorList=" + category;
		System.out.println(viewName);

		mav.addObject("ctgProductList", category);
		mav.setViewName("shopping/ctgProductList");
		return mav;
	}

	// 드라마 추천
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(@ModelAttribute("pv") PageDTO pv, Model model) {
		pv.setStartRow(0);
		pv.setEndRow(12);
		List<ProductDTO> listDrama = productService.dThemeListProcess(pv);
		List<ProductDTO> listOrganic = productService.oThemeListProcess(pv);
		List<ProductDTO> saleList = productService.salesListProcess(pv);
		model.addAttribute("dramaList", listDrama);
		model.addAttribute("organicList", listOrganic);
		model.addAttribute("saleL", saleList);

//		String url = "http://127.0.0.1:8000/autocoder";
//		String sb = "";
		String sb = "[23,46,44,30]";
//		try {
//			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
//			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				sb = sb + line + "\n";
//				
//			}
//			if (sb.toString().contains("ok")) {
//				System.out.println("test");	
//			}
//			br.close();
			System.out.println("" + sb.toString());
			List<ProductDTO> curatingList = new ArrayList<ProductDTO>();

			// 1. 문자열에서 쉼표와 대괄호를 제거하여 숫자만 추출
			String numStr = sb.toString().replaceAll("[^0-9,]", "");

			// 2. 추출한 숫자들을 문자열 배열로
			String[] numArr = numStr.split(",");

			// 3. 문자열 배열을 숫자 배열로 변환
			int[] intArr = new int[numArr.length];
			for (int i = 0; i < numArr.length; i++) {
			    intArr[i] = Integer.parseInt(numArr[i]);
			    ProductDTO pdto = productService.selectOneProcess(intArr[i]);
			    curatingList.add(pdto);
			}
			model.addAttribute("curatingList", curatingList);
		
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "index";
	}
	
	//genderage
	@RequestMapping(value = "/shopping/genderage.do", method = RequestMethod.GET)
	public ModelAndView curatingListExecute(ModelAndView mav) {
		List<ProductDTO> g10afList = productService.g10afListProcess();
		List<ProductDTO> g20afList = productService.g20afListProcess();
		List<ProductDTO> g30afList = productService.g30afListProcess();
		List<ProductDTO> g10amList = productService.g10amListProcess();
		List<ProductDTO> g20amList = productService.g20amListProcess();
		List<ProductDTO> g30amList = productService.g30amListProcess();
		mav.addObject("g10afList", g10afList);
		mav.addObject("g20afList", g20afList);
		mav.addObject("g30afList", g30afList);
		mav.addObject("g10amList", g10amList);
		mav.addObject("g20amList", g20amList);
		mav.addObject("g30amList", g30amList);
		mav.setViewName("shopping/genderage");

		return mav;
	}

	// 검색
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search(@ModelAttribute("pv") PageDTO pv, Model model) {
		try {
			List<ProductDTO> list = productService.searchProcess(pv);
			System.out.println(list);
			model.addAttribute("searchList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "search";
	}

	// 베스트
	@RequestMapping(value = "/shopping/best.do", method = RequestMethod.GET)
	public ModelAndView BestListExecute(ModelAndView mav) {
		List<ProductDTO> bestList = productService.bestListProcess();
		mav.addObject("bestList", bestList);
		mav.setViewName("shopping/best");

		return mav;
	}

	// 추천
	@RequestMapping(value = "/shopping/chuchun.do", method = RequestMethod.GET)
	public ModelAndView chuchunListExecute(ModelAndView mav) { 
		List<ProductDTO> chuchunList = productService.chuchunListProcess();
		mav.addObject("chuchunList", chuchunList);
		mav.setViewName("shopping/chuchun");
		return mav;
	}
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public ModelAndView Test() {
		ModelAndView mav = new ModelAndView();
		
		String url = "http://127.0.0.1:8000/autocoder";
		String sb = "";
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb = sb + line + "\n";
			}
			if (sb.toString().contains("ok")) {
				System.out.println("test");	
			}
			br.close();
			System.out.println("" + sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("test1", sb.toString()); // "test1"는 jsp파일에서 받을때 이름, 
        						//sb.toString은 value값(여기에선 test)
		mav.addObject("fail", false);
		mav.setViewName("test");   // jsp파일 이름
		return mav;
	}

	

}
