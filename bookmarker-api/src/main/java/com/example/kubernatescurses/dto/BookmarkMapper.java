package com.example.kubernatescurses.dto;

import com.example.kubernatescurses.domain.Bookmark;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
    public BookmarkDTO toDto(Bookmark bookmark){
        return new BookmarkDTO(bookmark.getId(),
                bookmark.getTitle(),
                bookmark.getUrl(),
                bookmark.getCreatedAt());
    }

}
