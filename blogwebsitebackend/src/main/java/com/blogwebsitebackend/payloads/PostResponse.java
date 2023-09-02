package com.blogwebsitebackend.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
public class PostResponse {
    
    private List<PostDto> content;
    private int pageNumber;
    private int PageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;
}
