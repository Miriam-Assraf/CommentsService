package com.cloudcomputing.commentsservice.logic.utils;

import com.cloudcomputing.commentsservice.boundaries.CommentBoundary;
import com.cloudcomputing.commentsservice.data.CommentEntity;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class CommentConverter {

    public CommentBoundary fromEntity(CommentEntity entity) {
        CommentBoundary rv = new CommentBoundary();
        rv.setId(entity.getId());
        rv.setUser(entity.getUser());
        rv.setBlog(entity.getBlog());
        rv.setTagSupport(entity.getTagSupport());
        rv.setCreatedTimestamp(entity.getCreatedTimestamp());
        rv.setUpdatedTimestamp(entity.getCreatedTimestamp());
        rv.setCountry(entity.getCountry());
        rv.setCommentType(entity.getCommentType());
        rv.setCommentContent(entity.getCommentContent());
        return rv;
    }

    public CommentEntity toEntity(CommentBoundary boundary) {
        CommentEntity rv = new CommentEntity();
        rv.setUser(boundary.getUser());
        rv.setBlog(boundary.getBlog());
        rv.setCreatedTimestamp(new Date());
        rv.setUpdatedTimestamp(new Date());
        rv.setCountry(boundary.getCountry());
        rv.setCommentType(boundary.getCommentType());
        rv.setCommentContent(boundary.getCommentContent());
        if(boundary.getCommentType()==COMMENT_TYPE.TEXT)    // change value only for text type
        {
            rv.setTagSupport(boundary.getTagSupport());
        }
        return rv;
    }
}
