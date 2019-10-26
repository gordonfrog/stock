package com.lanl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lanl.dto.WatchlistForm;
import com.lanl.model.WatchList;
import com.lanl.repository.WatchlistRepository;
import com.lanl.util.WatchlistMapper;

@Controller
@RequestMapping("/admin/watchlist")
public class WatchListController {

	@Autowired
	private WatchlistRepository watchlistRepository;
	
	@Autowired
	private WatchlistMapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showWatchlistPage(Model model) {
		List<WatchList> watchlists = (List<WatchList>) watchlistRepository.findAll();
		
		model.addAttribute("watchlists", watchlists);
		
		WatchlistForm watchlistForm = new WatchlistForm();
		
		model.addAttribute("watchlistForm", watchlistForm);
		
		return "watchlist";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postWatchlistForm(@ModelAttribute("watchlistForm") @Valid WatchlistForm watchlistForm, BindingResult result) {
		if (result.hasErrors())
			return "watchlist";
		
		WatchList watchlist = mapper.map(watchlistForm);
		
		System.out.println("Saving:");
		System.out.println(watchlist.getActive());
		System.out.println(watchlist.getId());
		System.out.println(watchlist.getSymbol());
		System.out.println(watchlist.getWatchlistcode());
		watchlistRepository.save(watchlist);
		
		return "redirect:/admin/watchlist";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editWatchlistPage(@RequestParam(value = "symbol", required = true) String symbol) {
		ModelAndView modelAndView = new ModelAndView("watchlist-edit");
		System.out.println("finding: "+symbol);
		WatchList watchlist = watchlistRepository.findBySymbol(symbol);
		System.out.println("found it: " + watchlist.getId());
		System.out.println("adding to map..");
		WatchlistForm watchlistForm = mapper.map(watchlist);
		System.out.println("done, now adding to model");
		modelAndView.addObject(watchlistForm);
		System.out.println("done, now returning");
		
		return modelAndView;		
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postWatchlistPage(@ModelAttribute("watchlistForm") @Valid WatchlistForm watchlistForm, BindingResult result) {
		if (result.hasErrors())
			return "watchlist-edit";
		
		WatchList watchlist = mapper.map(watchlistForm);
		
		watchlistRepository.save(watchlist);
		
		return "redirect:/admin/watchlist";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteWatchlistPage(@RequestParam(value = "symbol", required = true) String symbol) {
		WatchList watchlist = new WatchList();
		watchlist.setSymbol(symbol);
		System.out.println("deleting it: " + watchlist.getId());
		watchlistRepository.delete(watchlist);
		
		return "redirect:/admin/watchlist";		
	}
	
}
