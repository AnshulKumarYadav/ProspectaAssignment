package com.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.EntryDTO;
import com.app.Models.Entry;
import com.app.Service.EntryServiceImpl;

@RestController
@RequestMapping("/entries")
public class AppController {
	
	@Autowired
	private EntryServiceImpl entryServiceImpl;
	
	@GetMapping("/{category}")
	public List<EntryDTO> getEntries(@PathVariable("category") String category)
	{
		return entryServiceImpl.getEntries(category);
	}
	
	@PostMapping()
	public Entry saveEntry(@RequestBody Entry entry)
	{
		return entryServiceImpl.saveEntry(entry);
	}
	
}
