package com.blogwebsitebackend.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    
    private Long categoryId;

    @NotBlank
    @Size(min = 4,max = 30,message = "Size should be bewteen 4-30")
    private String categoryTitle;

    @NotBlank
    @Size(max = 100,message = "Max size should be 30")
    private String categoryDescription;
}
