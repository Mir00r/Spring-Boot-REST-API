package com.mir00r.dbrepository;

import com.mir00r.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mir00r on 13-Nov-18
 */
@Repository
public interface BlogRespository extends JpaRepository<Blog, Integer> {

    // custom query to search to blog post by title or content
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

}