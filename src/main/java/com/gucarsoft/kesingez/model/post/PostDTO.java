package com.gucarsoft.kesingez.model.post;

import com.gucarsoft.kesingez.model.Image;
import com.gucarsoft.kesingez.model.address.Address;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

@Data
public class PostDTO {
    private Long userID;
    private String userName;
    private String name;
    private String detail;
    private List<Futures> futuresList;
    private List<Category> categoryList;
    private List<Image> imageList;
    private Long reportCount;
    private Address address;
    private boolean showPost;
    private Long likeCount;

}
