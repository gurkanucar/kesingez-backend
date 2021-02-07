package com.gucarsoft.kesingez.repository;


import com.gucarsoft.kesingez.model.post.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends BaseRepository<Post, Long> {

}
