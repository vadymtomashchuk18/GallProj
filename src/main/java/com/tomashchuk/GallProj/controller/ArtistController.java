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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.tomashchuk.GallProj.entities.Artist;
import com.tomashchuk.GallProj.entities.Artist_Movement;
import com.tomashchuk.GallProj.entities.Movement;
import com.tomashchuk.GallProj.entities.Role;
import com.tomashchuk.GallProj.entities.User;
import com.tomashchuk.GallProj.service.ArtistService;
import com.tomashchuk.GallProj.service.MovementService;




@Controller
public class ArtistController {

	@Autowired
	ArtistService artistService;
	
	@Autowired
	MovementService movementService;
	
	@RequestMapping(value = "/allArtists", method = RequestMethod.GET)
	public ModelAndView allProd(ModelAndView model, @AuthenticationPrincipal User user) {


		List<Artist> artists = artistService.getAllArtists();
		
		//		List<Artist_Movement> artists = artistService.getDirectsForArtist();

		model.addObject("artists", artists);

		if (user.getRole() == Role.ADMIN) {
			model.setViewName("artists");
		} else {
			model.setViewName("artistsUser");
		}
		return model;

	}
	
	@RequestMapping(value = "/printArtists", method = RequestMethod.GET)
	public ModelAndView printProd(ModelAndView model) {

		List<Artist> artists = artistService.getAllArtists();
		model.addObject("artists", artists);
		model.setViewName("printArtists");

		return model;

	}
	
	
	@RequestMapping(value = "/adminAddArtist", method = RequestMethod.GET)
	public ModelAndView addProd(ModelAndView model) {
		Artist artist = new Artist();

		List<Movement> movs = movementService.getAllMovements();

		model.addObject("movs", movs);
		model.addObject("artist", artist);
		model.setViewName("addArtist");
		return model;
	}
	
	@RequestMapping(value = "/adminSaveArtist", method = RequestMethod.POST)
	public String saveArtist(@ModelAttribute Artist artist){
		artistService.addArtist(artist);
		return "redirect:/allArtists";
	} 
	
	@RequestMapping(value = "/adminEditArtist", method = RequestMethod.GET)
	public ModelAndView editProd(HttpServletRequest request) {

		int artistId = Integer.parseInt(request.getParameter("artistId"));
		Artist artist = artistService.getArtistId(artistId);
		System.out.println("Editing artist: " + artist);
		List<Movement> movs = movementService.getAllMovements();

		ModelAndView model = new ModelAndView("addArtist");

		model.addObject("movs", movs);
		model.addObject("artist", artist);

		return model;
	}
/*
	@RequestMapping(value = "/adminSaveArtist", method = RequestMethod.POST)
	public ModelAndView saveProd(@ModelAttribute Artist artist, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

// Write saving here

		redirectAttributes.addFlashAttribute("msg", "Product is successfully saved/updated");
		return new ModelAndView("redirect:/allArtists");
	}
*/
	@RequestMapping(value = "/adminDeleteArtist", method = RequestMethod.GET)
	public ModelAndView deleteProd(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int artistId = Integer.parseInt(request.getParameter("artistId"));

		artistService.deleteArtist(artistId);;
		redirectAttributes.addFlashAttribute("msg", "Artist is successfully deleted");
		return new ModelAndView("redirect:/allArtists");
	}
	
	@RequestMapping(value = "/searchArtistName", method = RequestMethod.POST)
	public String searchArtistName(@RequestParam String lastName, Model model, RedirectAttributes redirectAttributes) {
		List<Artist> artists = artistService.getLastName(lastName);

		if (artists == null) {
			redirectAttributes.addFlashAttribute("msg", "There is not such artists in the database");
			return "redirect:/allArtists";
		} else {
			model.addAttribute("artists", artists);
			return "findArtist";
		}

	}
	
	
	
	
	// handling errors

		@ExceptionHandler(DataIntegrityViolationException.class)
		public RedirectView handleMyException(DataIntegrityViolationException ex, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allArtists");

			FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
			if (outputFlashMap != null) {
				outputFlashMap.put("msg", "Sorry, this action is not permitted!");
			}
			return rw;
		}

		@ExceptionHandler({ SQLException.class, DataAccessException.class })
		public RedirectView databaseError(SQLException ex, DataAccessException ex2, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allArtists");

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
			RedirectView rw = new RedirectView("http://localhost:8080/GallProj/allArtists");
			ex.printStackTrace();
			FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
			if (outputFlashMap != null) {
				outputFlashMap.put("msg", "Sorry, an error has occured!");
			}
			return rw;
		}
}
