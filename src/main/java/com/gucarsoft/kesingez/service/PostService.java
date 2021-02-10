package com.gucarsoft.kesingez.service;

import com.gucarsoft.kesingez.model.post.PostDTO;
import com.gucarsoft.kesingez.model.post.comment.Comment;
import com.gucarsoft.kesingez.model.post.Post;
import com.gucarsoft.kesingez.model.post.PostFilter;
import com.gucarsoft.kesingez.model.post.comment.CommentDTO;
import com.gucarsoft.kesingez.repository.CommentRepository;
import com.gucarsoft.kesingez.repository.PostAddressRepository;
import com.gucarsoft.kesingez.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService extends BaseService {

    @Autowired
    PostRepository repository;

    @Autowired
    CommentRepository commentRepos;

    @Autowired
    PostAddressRepository postAddressRepos;

    public ResponseEntity getAllFilteredPosts(PostFilter filter) {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity getAllPosts() {
        List<Post> postList = repository.findAll();
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : postList
        ) {
            if (post.isShow()) {
                if (post.getUser() != null) {
                    postDTOS.add(convertPostToDTO(post));
                }
            }
        }

        return new ResponseEntity<>(postDTOS, HttpStatus.OK);
    }

    public ResponseEntity getMyPosts() {
        List<Post> postList = repository.findAll();
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : postList
        ) {
            if (post.isShow()) {
                if (post.getUser() != null && post.getUser().equals(getUser())) {
                    postDTOS.add(convertPostToDTO(post));
                }
            }
        }
        return new ResponseEntity<>(postDTOS, HttpStatus.OK);
    }

    public ResponseEntity getpostByID(Long id) {
        Post post = repository.findById(id).get();
        PostDTO postDTO = new PostDTO();
        if (post.isShow()) {
            if (post.getUser() != null && post.getUser().equals(getUser())) {
                postDTO = convertPostToDTO(post);
            }

        } else {
            postDTO = null;
        }
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    public ResponseEntity createPost(Post entity) {
        entity.setShow(true);
        entity.setLikeCount(0L);
        entity.setReportCount(0L);
        postAddressRepos.save(entity.getAddress());
        return new ResponseEntity<>(repository.save(entity), HttpStatus.OK);
    }

    public ResponseEntity updatePost(Post entity) {
        Post temp = repository.findById(entity.getId()).get();
        temp.setCategoryList(entity.getCategoryList());
        //temp.setCommentList(entity.getCommentList());
        temp.setImageList(entity.getImageList());
        temp.setFuturesList(entity.getFuturesList());
        temp.setDetail(entity.getDetail());
        return new ResponseEntity<>(repository.save(temp), HttpStatus.OK);
    }

    public ResponseEntity deletePost(Long id) {
        Post post = repository.findById(id).get();
        post.setDeleted(true);
        return new ResponseEntity<>(repository.save(post), HttpStatus.OK);
    }

    public ResponseEntity reportPost(Long id) {
        Post post = repository.findById(id).get();
        Long reportCount = post.getReportCount();
        post.setReportCount(reportCount + 1L);
        return new ResponseEntity<>(repository.save(post), HttpStatus.OK);
    }

    public ResponseEntity getComments(Long id) {

        List<Comment> commentList = commentRepos.findAllByPostId(id);
        List<CommentDTO> commentDTOS = new ArrayList<>();

        for (Comment comment :
                commentList) {
            commentDTOS.add(convertCommentToDTO(comment));
        }


        return new ResponseEntity<>(commentDTOS, HttpStatus.OK);
    }

    public ResponseEntity addComment(Comment comment) {
        commentRepos.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    public ResponseEntity deleteComment(Long commentId) {
        commentRepos.deleteById(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    PostDTO convertPostToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setUserID(post.getUser().getId());
            postDTO.setId(post.getId());
        if (post.getUser().getUsername() != null)
            postDTO.setUserName(post.getUser().getUsername());
        if (post.getUser().getName() != null)
            postDTO.setName(post.getUser().getName());
        if (post.getDetail() != null)
            postDTO.setDetail(post.getDetail());
        if (post.getFuturesList() != null)
            postDTO.setFuturesList(post.getFuturesList());
        if (post.getCategoryList() != null)
            postDTO.setCategoryList(post.getCategoryList());
        if (post.getImageList() != null)
            postDTO.setImageList(post.getImageList());
        if (post.getReportCount() != null)
            postDTO.setReportCount(post.getReportCount());
        if (post.getAddress() != null)
            postDTO.setAddress(post.getAddress());
        if (post.getLikeCount() != null)
            postDTO.setLikeCount(post.getLikeCount());
        return postDTO;
    }

    CommentDTO convertCommentToDTO(Comment comment){
        CommentDTO commentDTO=new CommentDTO();

        commentDTO.setComment(comment.getComment());
        commentDTO.setId(comment.getId());
        commentDTO.setPostID(comment.getPost().getId());
        commentDTO.setUserID(comment.getUser().getId());
        commentDTO.setReportCount(comment.getReportCount());
        commentDTO.setShowComment(comment.isShow());

        return  commentDTO;
    }

}
