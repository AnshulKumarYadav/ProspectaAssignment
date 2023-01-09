package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.app.DTO.EntryDTO;
import com.app.Exception.EntryException;
import com.app.Models.Entry;
import com.app.Models.FetchData;

public class EntryServiceImpl implements EntryService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Entry> resultEntries()
	{
		FetchData fetchData = restTemplate.getForObject("https://api.publicapis.org/entries", FetchData.class );
		
		return fetchData.getEntries();
	}

	@Override
	public List<EntryDTO> getEntries(String category) {
		if(resultEntries().size()==0) throw new EntryException("No entries found");
		return resultEntries().stream()
				              .filter(e -> e.getCategory().equals(category))
				              .map(e -> new EntryDTO(e.getApi(), e.getDescription()))
				              .toList();
	}

	@Override
	public Entry saveEntry(Entry entry) {
		resultEntries().add(entry);
		return entry;
	}

}
