package com.example.config;

import com.example.template.PostsTemplate;
import com.example.template.TimeAgoMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreemakerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    PostsTemplate postsTemplate;


    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("timeAgo", new TimeAgoMethod());
        configuration.setSharedVariable("posts", postsTemplate);

    }
}
