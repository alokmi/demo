package com.example.graphql.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.demo.model.Gene;
import com.example.graphql.demo.model.Protein;
import com.example.graphql.demo.model.api.DataServiceProtein;
import com.example.graphql.demo.repo.UniprotAPIRepo;

import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;

@Service
public class GeneResolver implements GraphQLResolver<Gene> {
	@Autowired
	private UniprotAPIRepo uniprotAPIRepo;

	public Protein getProtein(Gene gene, DataFetchingEnvironment env) {
		GraphQLContext graphQLServletContext = (GraphQLContext) env.getContext();
		String accession = (String)graphQLServletContext.getHttpServletRequest().get().getAttribute("accession");
		System.out.println("GeneResolver - Protein: Processing accession : " + accession);
		
		DataServiceProtein dsp = uniprotAPIRepo.getProtein(accession);
		Protein protein = new Protein();
		protein.setAccession(gene.getAccession());

		if (dsp.getProtein().getRecommendedName() != null)
			protein.setName(dsp.getProtein().getRecommendedName().getFullName().getValue());
		if (dsp.getProtein().getSubmittedName() != null && !dsp.getProtein().getSubmittedName().isEmpty())
			protein.setName(dsp.getProtein().getSubmittedName().get(0).getFullName().getValue());
		protein.setType(dsp.getInfo().getType());
		return protein;
	}
}
