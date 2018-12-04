package com.mir00r.controller;

import com.mir00r.dao.BlogMockedData;
import com.mir00r.dbrepository.BlogRespository;
import com.mir00r.model.Blog;
import com.mir00r.model.LoginData;
import com.mir00r.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /*@PostMapping(value = "/api/login",
            //headers = {"Accept = application /x-www-form-urlencoded", "Content-Type=application/json"},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public LoginData postLogin(@RequestBody Map<String, String> body) {
        String userName = body.get("username");
        //String userName = String.valueOf(body.get("username"));
        String password = body.get("password");
        //String password = String.valueOf(body.get("password"));
        return blogMockedData.getLoginToken(userName, password);
    }*/

    /*@RequestMapping(value = "/api/login", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    LoginData postLogin(@PathVariable("username") String userName, @PathVariable("password") String password, MultiValueMap paramMap) throws Exception{
        if(paramMap == null && paramMap.get("password") == null) {
            throw new IllegalArgumentException("Password not provided");
        }
        return blogMockedData.getLoginToken(userName, password);
    }*/

    @RequestMapping(value = "/api/login")
    public LoginData postLogin(@Valid @RequestBody LoginRequest request) {
        return blogMockedData.getLoginToken(request.getUsername(), request.getPassword());
    }

    /*@RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public LoginData postLogin(@Valid @RequestBody Map<String, String> body) {
        String userName = body.get("username");
        String password = body.get("password");
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
