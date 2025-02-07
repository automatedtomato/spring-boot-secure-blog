package com.automatedtomato.blog.services;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.automatedtomato.blog.domain.entities.Tag;

public interface TagService {
    List<Tag> getTags();
    List<Tag> createTags(Set<String> tagNames);
    void deleteTag(UUID id);
    Tag getTagById(UUID id);
    List<Tag> getTagByIds(Set<UUID> postId);
}
