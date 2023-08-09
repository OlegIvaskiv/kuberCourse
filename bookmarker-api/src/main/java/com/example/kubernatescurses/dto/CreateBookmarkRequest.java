package com.example.kubernatescurses.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookmarkRequest {
    @NotEmpty(message = "should not be empty")
    private String title;
    @NotEmpty(message = "should not be empty")
    private String url;
}
