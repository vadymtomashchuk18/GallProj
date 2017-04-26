package com.tomashchuk.GallProj.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.tomashchuk.GallProj.entities.Artist;
import com.tomashchuk.GallProj.entities.Exhibition;
import com.tomashchuk.GallProj.entities.Movement;
import com.tomashchuk.GallProj.entities.Role;
import com.tomashchuk.GallProj.entities.User;
import com.tomashchuk.GallProj.service.ExhibitionService;


@Controller
public class ExhibitionController {
	
	@Autowired
	ExhibitionService exhibitionService;
	
	@RequestMapping(value = "/allExhibitions", method = RequestMethod.GET)
	public ModelAndView allExhibitions(ModelAndView model, @AuthenticationPrincipal User user) {

		List<Exhibition> exhibitions = exhibitionService.getAllExhb();

		model.addObject("exhibitions", exhibitions);
		if (user.getRole() == Role.ADMIN) {
			model.setViewName("exhibitions");
		} else {
			model.setViewName("exhibitionsUser");
		}
		return model;
	}
	
	@RequestMapping(value = "/printExhb", method = RequestMethod.GET)
	public ModelAndView printProd(ModelAndView model) {

		List<Exhibition> exhbs = exhibitionService.getAllExhb();
		model.addObject("exhbs", exhbs);
		model.setViewName("printExhbs");

		return model;

	}
	
	@RequestMapping(value = "/adminAddExhb", method = RequestMethod.GET)
	public ModelAndView addProd(ModelAndView model) {
		Exhibition exhb = new Exhibition();
		model.addObject("exhb", exhb);
		model.setViewName("addExhibition");
		return model;
	}
	
	@RequestMapping(value = "/adminEditExhb", method = RequestMethod.GET)
	public ModelAndView editProd(HttpServletRequest request) {

		int exhibitionId = Integer.parseInt(request.getParameter("exhibitionId"));
		Exhibition exhibition = exhibitionService.getExhbId(exhibitionId);
		System.out.println("Editing exhibition: " + exhibition);

		ModelAndView model = new ModelAndView("addExhibition");

		model.addObject("exhibition", exhibition);

		return model;
	}
	
	@RequestMapping(value = "/adminSaveExhb", method = RequestMethod.POST)
	public String saveExhibition(@ModelAttribute Exhibition exhb){
		exhibitionService.addExhb(exhb);;
		return "redirect:/allExhibitions";
	} 
	
/*	
	@RequestMapping(value = "/adminSaveExhb", method = RequestMethod.POST)
	public ModelAndView saveProd(@ModelAttribute Exhibition exhb, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

// Write saving here

		redirectAttributes.addFlashAttribute("msg", "Exhibition is successfully saved/updated");
		return new ModelAndView("redirect:/allExhibitions");
	}
*/
	@RequestMapping(value = "/adminDeleteExhb", method = RequestMethod.GET)
	public ModelAndView deleteProd(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int exhibitionId = Integer.parseInt(request.getParameter("exhibitionId"));

		exhibitionService.deleteExhb(exhibitionId);;
		redirectAttributes.addFlashAttribute("msg", "Exhibition is successfully deleted");
		return new ModelAndView("redirect:/allExhibitions");
	}
	
	@RequestMapping(value = "/searchExhbName", method = RequestMethod.POST)
	public String searchExhbName(@RequestParam String exhibitionName, Model model, RedirectAttributes redirectAttributes) {
		List<Exhibition> exhbs = exhibitionService.getExhbName(exhibitionName);

		if (exhbs == null) {
			redirectAttributes.addFlashAttribute("msg", "There is not such exhibitions in the database");
			return "redirect:/allExhibitions";
		} else {
			model.addAttribute("exhbs", exhbs);
			return "findExhb";
		}

	}
	
	
	
	
//	
//	// handling errors
//			@ExceptionHandler(DataIntegrityViolationException.class)
//			public RedirectView handleMyException(DataIntegrityViolationException ex, HttpServletRequest request,
//					HttpServletResponse response) throws IOException {
//				RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allExhibitions");
//
//				FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
//				if (outputFlashMap != null) {
//					outputFlashMap.put("msg", "Sorry, this action is not permitted!");
//				}
//				return rw;
//			}
//
//			@ExceptionHandler({ SQLException.class, DataAccessException.class })
//			public RedirectView databaseError(SQLException ex, DataAccessException ex2, HttpServletRequest request,
//					HttpServletResponse response) throws IOException {
//				RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allExhibitions");
//
//				FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
//				if (outputFlashMap != null) {
//					outputFlashMap.put("msg", "Sorry, an database error has occured!");
//				}
//				return rw;
//			}
//
//			// Total control - setup a model and return the view name yourself. Or
//			// consider subclassing ExceptionHandlerExceptionResolver (see below).
//			@ExceptionHandler(Exception.class)
//			public RedirectView handleError(Exception ex, HttpServletRequest request, HttpServletResponse response)
//					throws IOException {
//				RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allExhibitions");
//
//				FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
//				if (outputFlashMap != null) {
//					outputFlashMap.put("msg", "Sorry, an error has occured!");
//				}
//				return rw;
//			}

}