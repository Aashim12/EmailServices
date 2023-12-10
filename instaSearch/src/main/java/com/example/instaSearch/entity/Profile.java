package com.example.instaSearch.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


@Getter
@Setter
@SolrDocument(collection = "insta")
public class Profile {

    @Id
    @Indexed(name = "userId" , type = "string")
    private String userId;

    @Indexed(name = "userName" ,type="string")
    private String userName;

    @Indexed(name = "name" ,type="string")
    private String name;

    @Indexed(name = "bio" , type = "string")
    private String bio;

}
