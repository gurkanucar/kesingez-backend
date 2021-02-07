package com.gucarsoft.kesingez.model.post.comment;

import lombok.Data;

@Data
public class CommentDTO {

    private Long id;
    private Long userID;
    private Long postID;
    private String comment;
    private Long reportCount;
    private Boolean showComment;

}
