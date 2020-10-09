package com.example.graphql.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.demo.model.Protein;
import com.example.graphql.demo.model.Variation;
import com.example.graphql.demo.model.api.DataServiceVariation;
import com.example.graphql.demo.model.api.Feature;
import com.example.graphql.demo.repo.UniprotAPIRepo;

@Service
public class ProteinResolver implements GraphQLResolver<Protein> {

	@Autowired
	private UniprotAPIRepo uniprotAPIRepo;

	public Variation variation(Protein protein) {
		System.out.println("ProteinResolver - Variation: Processing accession : " + protein.getAccession());
		DataServiceVariation dsv = uniprotAPIRepo.getVariation(protein.getAccession());
		Variation variation = new Variation();
		Feature feature = dsv.getFeatures().get(0);
		variation.setAlternativeSequence(feature.getMutatedType());
		variation.setWildType(feature.getWildType());
		variation.setBegin(feature.getBegin());
		variation.setEnd(feature.getEnd());
		return variation;
	}

	public Object getComments(Protein protein) {
		System.out.println("ProteinResolver - Structure: Processing accession : " + protein.getAccession());
		return "dummy comments";
	}
}
