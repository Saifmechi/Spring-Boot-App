package com.EMB.app_EMB.Services.Implementation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMB.app_EMB.Entity.Blog;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Repository.BlogRepository;
import com.EMB.app_EMB.Services.Interfaces.BlogInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BlogImpl implements BlogInterface{
	

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Blog not found with id " + id));

        existingBlog.setTitre(blog.getTitre());
        existingBlog.setDescription(blog.getDescription());
        existingBlog.setSendDate();
        existingBlog.setImage(blog.getImage());
        existingBlog.setCommentaires(blog.getCommentaires());

        return blogRepository.save(existingBlog);
    }

    public void deleteBlogById(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new RessourceNotFoundException("Blog not found with id " + id);
        }
        blogRepository.deleteById(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Blog not found with id " + id));
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
    
    @Override
    public List<Blog> getBlogByTitre(String titre){
    	Optional< List<Blog>> optional=blogRepository.findByTitre(titre);
    	List<Blog> blogs=optional.orElse(Collections.emptyList());
    			return blogs;
    }
}
