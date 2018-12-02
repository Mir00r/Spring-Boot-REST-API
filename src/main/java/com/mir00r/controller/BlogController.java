package com.mir00r.controller;

import com.mir00r.dao.BlogMockedData;
import com.mir00r.dbrepository.BlogRespository;
import com.mir00r.model.Blog;
import com.mir00r.model.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    BlogRespository blogRespository;
    BlogMockedData blogMockedData = BlogMockedData.getInstance();

    @GetMapping("/blog")
    public List<Blog> index() {
        return blogMockedData.fetchBlogList();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogMockedData.getBlogById(blogId);
    }

    @PostMapping(value = "/api/login",
            //headers = {"Accept = application /x-www-form-urlencoded", "Content-Type=application/json"},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public LoginData postLogin(@RequestBody Map<String, String> body) {
        String userName = body.get("username");
        String password = body.get("password");
        return blogMockedData.getLoginToken(userName, password);
    }

    /*@RequestMapping(value = "/api/login", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    LoginData postLogin(@PathVariable("username") String userName, @PathVariable("password") String password) {
        return blogMockedData.getLoginToken(userName, password);
    }*/

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogMockedData.searchBlogList(searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return blogMockedData.createBlog(id, title, content);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return blogMockedData.updateBlog(blogId, title, content);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogMockedData.deleteBlog(blogId);
    }
}
