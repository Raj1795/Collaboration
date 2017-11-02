package com.trios.collaborate.dao;

import java.util.List;

import com.trios.collaborate.model.Blog;
import com.trios.collaborate.model.BlogComment;

public interface BlogDAO {

	public boolean createBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getBlogs(int approved);
	public void updateBlog(Blog blog);
	
	public void addBlogComment(BlogComment blogComment);
	public  List<BlogComment>getBlogComments(int Id);
	public boolean deleteBlog(int blogId);
	public List<Blog>getNotification(String userId);
}
