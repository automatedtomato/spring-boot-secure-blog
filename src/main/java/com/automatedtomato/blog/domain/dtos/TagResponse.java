package com.automatedtomato.blog.domain.dtos;

import java.util.UUID;

import org.springframework.data.repository.NoRepositoryBean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoRepositoryBean
@AllArgsConstructor
public class TagResponse {
    private UUID id;
    private String name;
    private Integer postCount;
}
