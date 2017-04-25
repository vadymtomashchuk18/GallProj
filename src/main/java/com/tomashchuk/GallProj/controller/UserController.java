package com.tomashchuk.GallProj.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
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

import com.tomashchuk.GallProj.entities.User;
import com.tomashchuk.GallProj.service.UserService;



@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/adminUsers", method = RequestMethod.GET)
	public ModelAndView getUsers(ModelAndView model) {
		List<User> usrs = userService.getAllUsers();

		model.addObject("usrs", usrs);
		model.setViewName("users");
		return model;

	}
	
	@RequestMapping(value = "adminSearch", method = RequestMethod.POST)
	public String search(@RequestParam String login, Model model, RedirectAttributes redirectAttributes) {
		List<User> usrs = userService.getUsersByLogin(login);
		
		if (usrs == null) {
			redirectAttributes.addFlashAttribute("msg", "There is not such user in the database");
			return "redirect:/adminUsers";
		} else {
			model.addAttribute("usrs", usrs);
			return "findUsers";
		}

	}
	
	
	@RequestMapping(value = "/adminAddUser", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("addUsers");
		return model;
	}

	@RequestMapping(value = "/adminSaveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {
		userService.addUser(user);
		return "redirect:/adminUsers";
	}

	@RequestMapping(value = "/adminDeleteUser", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		userService.deleteUser(userId);
		redirectAttributes.addFlashAttribute("msg", "User is successfully deleted");
		return new ModelAndView("redirect:/adminUsers");
	}

	@RequestMapping(value = "/adminEditUser", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = userService.getUserId(userId);
		System.out.println("Editing empl: " + user);
		ModelAndView model = new ModelAndView("addUser");
		model.addObject("user", user);

		return model;
	}
	
	
	
	
	
	
	// handling errors

	@ExceptionHandler(DataIntegrityViolationException.class)
	public RedirectView handleMyException(DataIntegrityViolationException ex, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		RedirectView rw = new RedirectView("http://localhost:8080/GallProj/adminUsers");

		FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
		if (outputFlashMap != null) {
			outputFlashMap.put("msg", "Sorry, this action is not permitted!");
		}
		return rw;
	}

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public RedirectView databaseError(SQLException ex, DataAccessException ex2, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		RedirectView rw = new RedirectView("http://localhost:8080/GallProj/adminUsers");

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
		RedirectView rw = new RedirectView("http://localhost:8080/GallProj/adminUsers");

		FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
		if (outputFlashMap != null) {
			outputFlashMap.put("msg", "Sorry, an error has occured!");
		}
		return rw;
	}
}
