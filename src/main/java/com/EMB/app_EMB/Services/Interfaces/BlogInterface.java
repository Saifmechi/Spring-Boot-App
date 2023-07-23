package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.EMB.app_EMB.Entity.Blog;

public interface BlogInterface {

    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id, Blog blog);
    void deleteBlogById(Long id);
    Blog getBlogById(Long id);
    List<Blog> getAllBlogs();
    List<Blog> getBlogByTitre(String titre);
}
