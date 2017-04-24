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

import com.tomashchuk.GallProj.entities.Exhibition;
import com.tomashchuk.GallProj.entities.Painting;
import com.tomashchuk.GallProj.entities.Role;
import com.tomashchuk.GallProj.entities.User;
import com.tomashchuk.GallProj.service.PaintingService;

@Controller
public class PaintingController {

	@Autowired
	PaintingService paintingService;
	
	@RequestMapping(value = "/allPaintings", method = RequestMethod.GET)
	public ModelAndView allExhibitions(ModelAndView model, @AuthenticationPrincipal User user) {

		List<Painting> painting = paintingService.getAllPaintings();

		model.addObject("paintings", painting);
		if (user.getRole() == Role.ADMIN) {
			model.setViewName("painting");
		} else {
			model.setViewName("paintingUser");
		}
		return model;
	}
	
	@RequestMapping(value = "/adminAddPainting", method = RequestMethod.GET)
	public ModelAndView addProd(ModelAndView model) {
		Painting painting = new Painting();
		model.addObject("painting", painting);
		model.setViewName("addPainting");
		return model;
	}
	
	@RequestMapping(value = "/adminSavePainting", method = RequestMethod.POST)
	public String savePainting(@ModelAttribute Painting painting){
		paintingService.addPainting(painting);;
		return "redirect:/allPaintings";
	} 
	
	@RequestMapping(value = "/adminEditPainting", method = RequestMethod.GET)
	public ModelAndView editProd(HttpServletRequest request) {

		int paintingId = Integer.parseInt(request.getParameter("paintingId"));
		Painting painting = paintingService.getByPaintingId(paintingId);
		System.out.println("Editing picture: " + painting);

		ModelAndView model = new ModelAndView("addPainting");

		model.addObject("painting", painting);

		return model;
	}
	
	/*
	@RequestMapping(value = "/adminSavePainting", method = RequestMethod.POST)
	public ModelAndView saveProd(@ModelAttribute Painting painting, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

// Write saving here

		redirectAttributes.addFlashAttribute("msg", "Painting is successfully saved/updated");
		return new ModelAndView("redirect:/allPaintings");
	}

*/
	@RequestMapping(value = "/adminDeletePainting", method = RequestMethod.GET)
	public ModelAndView deleteProd(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int paintingId = Integer.parseInt(request.getParameter("paintingId"));

		paintingService.deletePainting(paintingId);;
		redirectAttributes.addFlashAttribute("msg", "Painting is successfully deleted");
		return new ModelAndView("redirect:/allPaintings");
	}
	
	@RequestMapping(value = "/searchPaintingsName", method = RequestMethod.POST)
	public String searchExhbName(@RequestParam String nameOfPainting, Model model, RedirectAttributes redirectAttributes) {
		List<Painting> paintings = paintingService.getByPaintingName(nameOfPainting);

		if (paintings == null) {
			redirectAttributes.addFlashAttribute("msg", "There is not such paintings in the database");
			return "redirect:/allPaintings";
		} else {
			model.addAttribute("paintings", paintings);
			return "findPainting";
		}

	}
	
	
	
	// handling errors
				@ExceptionHandler(DataIntegrityViolationException.class)
				public RedirectView handleMyException(DataIntegrityViolationException ex, HttpServletRequest request,
						HttpServletResponse response) throws IOException {
					RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allPaintings");

					FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
					if (outputFlashMap != null) {
						outputFlashMap.put("msg", "Sorry, this action is not permitted!");
					}
					return rw;
				}

				@ExceptionHandler({ SQLException.class, DataAccessException.class })
				public RedirectView databaseError(SQLException ex, DataAccessException ex2, HttpServletRequest request,
						HttpServletResponse response) throws IOException {
					RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allPaintings");

					FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
					if (outputFlashMap != null) {
						outputFlashMap.put("msg", "Sorry, an database error has occured!");
					}
					return rw;
				}

				// Total control - setup a model and return the view name yourself. Or
				// consider subclassing ExceptionHandlerExceptionResolver (see below).
				@ExceptionHandler(Exception.class)
				public RedirectView handleError(Exception ex, HttpServletRequest request, HttpServletResponse response)
						throws IOException {
					RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allPaintings");

					FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
					if (outputFlashMap != null) {
						outputFlashMap.put("msg", "Sorry, an error has occured!");
					}
					return rw;
				}

}
