package co.grandcircus.HotelSearch.HotelSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {
	
	@Autowired
	HotelDao hoteldao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("cities", hoteldao.getCityCategories()); 
		return mav;
	}
	
	@RequestMapping("/results")
	public ModelAndView showResults(@RequestParam("city") String city) {
		
		ModelAndView mav = new ModelAndView("results");
		mav.addObject("city", city);
		
		mav.addObject("hotels",hoteldao.findbyCity(city));
		
		return mav;
	}

}
