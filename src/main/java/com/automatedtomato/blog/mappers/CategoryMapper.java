package com.automatedtomato.blog.mappers;

import com.automatedtomato.blog.domain.PostStatus;
import com.automatedtomato.blog.domain.dtos.CategoryDto;
import com.automatedtomato.blog.domain.dtos.CreateCategoryRequest;
import com.automatedtomato.blog.domain.entities.Category;
import com.automatedtomato.blog.domain.entities.Post;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }

    Category toEntity(CreateCategoryRequest createCategoryRequest);
}