package com.example.graphql.demo.repo;

import com.example.graphql.demo.model.api.DataServiceCoordiante;
import com.example.graphql.demo.model.api.DataServiceProtein;
import com.example.graphql.demo.model.api.DataServiceVariation;

public interface UniprotAPIRepo {

	DataServiceVariation getVariation(String accession);

	DataServiceProtein getProtein(String accession);

	DataServiceCoordiante getGene(String accession);

	Object getPDBe(String accession, long begin);

}
