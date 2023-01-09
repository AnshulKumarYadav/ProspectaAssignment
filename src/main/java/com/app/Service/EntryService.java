package com.app.Service;

import java.util.List;

import com.app.DTO.EntryDTO;
import com.app.Models.Entry;

public interface EntryService {
	
	public List<EntryDTO> getEntries(String category);
	
	public Entry saveEntry(Entry entry);

}
