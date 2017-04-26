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

import com.tomashchuk.GallProj.entities.Movement;
import com.tomashchuk.GallProj.entities.Role;
import com.tomashchuk.GallProj.entities.User;
import com.tomashchuk.GallProj.service.MovementService;


@Controller
public class MovementController {

	@Autowired
	MovementService movementService;
	
	@RequestMapping(value = "/allMovements", method = RequestMethod.GET)
	public ModelAndView allMovements(ModelAndView model, @AuthenticationPrincipal User user) {

		// Employee empl = (Employee) session.getAttribute("employee");

		List<Movement> movements = movementService.getAllMovements();

		model.addObject("movements", movements);

		if (user.getRole() == Role.ADMIN) {

			model.setViewName("movement");
		} else {
			model.setViewName("notForSimpleUser");
		}
		return model;

	}


	@RequestMapping(value = "/adminAddMovement", method = RequestMethod.GET)
	public ModelAndView addProd(ModelAndView model) {
		Movement movement = new Movement();
		model.addObject("movement", movement);
		model.setViewName("addMovement");
		return model;
	}

	@RequestMapping(value = "/adminEditMovement", method = RequestMethod.GET)
	public ModelAndView editProd(HttpServletRequest request) {

		int movementCode = Integer.parseInt(request.getParameter("movementCode"));
		Movement movement = movementService.getMovementId(movementCode);
		System.out.println("Editing direction: " + movement);
		
		ModelAndView model = new ModelAndView("addMovement");


		model.addObject("movement", movement);

		return model;
	}

	@RequestMapping(value = "/adminSaveMovement", method = RequestMethod.POST)
	public ModelAndView saveProd(@ModelAttribute Movement movement, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

		System.out.println("Product to save/ update: " + movement);

//		movementService.saveUpdateMovement(movement);
		redirectAttributes.addFlashAttribute("msg", "Movement is successfully saved/updated");
		return new ModelAndView("redirect:/allMovements");
	}

	@RequestMapping(value = "/adminDeleteMovement", method = RequestMethod.GET)
	public ModelAndView deleteProd(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int movementCode = Integer.parseInt(request.getParameter("movementCode"));

		movementService.deleteMovement(movementCode);
		redirectAttributes.addFlashAttribute("msg", "Movement is successfully deleted");
		return new ModelAndView("redirect:/allMovements");
	}

	@RequestMapping(value = "/searchMovementName", method = RequestMethod.POST)
	public String searchProdName(@RequestParam String nameOfMovement, Model model, RedirectAttributes redirectAttributes) {
		List<Movement> movements = movementService.getMovementName(nameOfMovement);

		if (movements == null) {
			redirectAttributes.addFlashAttribute("msg", "There is not such movement in the database");
			return "redirect:/allMovements";
		} else {
			model.addAttribute("movements", movements);
			return "findMovement";
		}

	}
	

	// handling errors

	@ExceptionHandler(DataIntegrityViolationException.class)
	public RedirectView handleMyException(DataIntegrityViolationException ex, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allMovements");

		FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
		if (outputFlashMap != null) {
			outputFlashMap.put("msg", "Sorry, this action is not permitted!");
		}
		return rw;
	}

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public RedirectView databaseError(SQLException ex, DataAccessException ex2, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allMovements");

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
		RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allMovements");

		FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
		if (outputFlashMap != null) {
			outputFlashMap.put("msg", "Sorry, an error has occured!");
		}
		return rw;
	}

	
}
