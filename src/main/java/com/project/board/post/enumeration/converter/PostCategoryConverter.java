package com.project.board.post.enumeration.converter;

import com.project.board.post.enumeration.PostCategory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PostCategoryConverter implements AttributeConverter<PostCategory, String> {
    @Override
    public String convertToDatabaseColumn(PostCategory attribute) {
        return attribute.getTitle();
    }

    @Override
    public PostCategory convertToEntityAttribute(String dbData) {
        return PostCategory.ofString(dbData);
    }
}