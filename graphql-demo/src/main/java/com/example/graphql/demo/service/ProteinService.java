package com.example.graphql.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.demo.model.api.Citation;
import com.example.graphql.demo.model.api.DataServiceProtein;
import com.example.graphql.demo.repo.UniprotAPIRepo;

@Service
public class ProteinService {

	@Autowired
	private UniprotAPIRepo uniprotAPIRepo;

	public static int count = -1;

	public Citation getCitation(String accession) {
		count++;
		DataServiceProtein dsp = uniprotAPIRepo.getProtein(accession);
		if (count >= dsp.getReferences().size())
			count = 0;
		return dsp.getReferences().get(count).getCitation();

	}

}
