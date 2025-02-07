package com.automatedtomato.blog.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.automatedtomato.blog.domain.CreatePostRequest;
import com.automatedtomato.blog.domain.UpdatePostRequest;
import com.automatedtomato.blog.domain.dtos.CreatePostRequestDto;
import com.automatedtomato.blog.domain.dtos.PostDto;
import com.automatedtomato.blog.domain.dtos.UpdatePostRequestDto;
import com.automatedtomato.blog.domain.entities.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);
    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);
    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}
