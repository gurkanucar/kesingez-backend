package com.gucarsoft.kesingez.repository;


import com.gucarsoft.kesingez.model.post.comment.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends BaseRepository<Comment, Long> {

    List<Comment> findAllByPostId(Long id);

}
