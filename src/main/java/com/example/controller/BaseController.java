package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.CommentService;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @Autowired
    HttpServletRequest req;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    public Page getPage(){
        int pn = ServletRequestUtils.getIntParameter(req,"pn",1);
        int size =ServletRequestUtils.getIntParameter(req,"size",3);
        return new Page(pn,size);
    }
}
