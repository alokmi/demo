package com.example.graphql.demo.model.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Citation {
	
	private String type;
	private String title;
	private List<String> authors;

}
