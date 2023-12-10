package com.example.instaSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EnableSolrRepositories
public class InstaSearchApplication {

	public static void main(String[] args) {

		SpringApplication.run(InstaSearchApplication.class, args);
	}

}
