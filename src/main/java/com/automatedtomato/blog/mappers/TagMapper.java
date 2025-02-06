package com.automatedtomato.blog.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.automatedtomato.blog.domain.PostStatus;
import com.automatedtomato.blog.domain.dtos.TagResponse;
import com.automatedtomato.blog.domain.entities.Post;
import com.automatedtomato.blog.domain.entities.Tag;

@Mapper(componentModel =  "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    TagResponse toTagResponse(Tag tag);

    List<TagResponse> toTagResponseList(List<Tag> tags);

    @Named("calculatePostCount")
    default Integer calculatePostCount(Set<Post> posts) {
        if (posts == null) {
            return 0;
        }
        return (int) posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
