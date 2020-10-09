package com.example.graphql.demo.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.demo.model.Gene;
import com.example.graphql.demo.model.api.DSCGnCoordinate;
import com.example.graphql.demo.model.api.DataServiceCoordiante;
import com.example.graphql.demo.repo.UniprotAPIRepo;

import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;

@Service
public class Query implements GraphQLQueryResolver {

	@Autowired
	private UniprotAPIRepo uniprotAPIRepo;

	public List<Gene> genes(List<String> accessions, DataFetchingEnvironment env) {
		List<Gene> genes = new ArrayList<>();
		accessions.forEach(accession -> {
			GraphQLContext graphQLServletContext = (GraphQLContext) env.getContext();
			graphQLServletContext.getHttpServletRequest().get().setAttribute("accession", accession);
			env.getArguments().put("accession", accession);
			System.out.println("Query: Processing accession : " + accession);
			DataServiceCoordiante dsc = uniprotAPIRepo.getGene(accession);
			Gene gene = new Gene();
			gene.setAccession(accession);
			DSCGnCoordinate dscGnCoordinate = dsc.getGnCoordinate().get(0);
			gene.setChromosome(dscGnCoordinate.getGenomicLocation().getChromosome());
			gene.setEnsgId(dscGnCoordinate.getEnsemblGeneId());
			gene.setEnspId(dscGnCoordinate.getEnsemblTranslationId());
			gene.setEnstId(dscGnCoordinate.getEnsemblTranscriptId());
			genes.add(gene);
		});
		return genes;
	}

}
