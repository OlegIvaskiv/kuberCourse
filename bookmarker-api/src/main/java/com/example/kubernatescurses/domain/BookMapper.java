package com.example.kubernatescurses.domain;

import com.example.kubernatescurses.dto.BookmarkDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookmarkDTO toDto(Bookmark bookmark) {
        BookmarkDTO dto = new BookmarkDTO();
          dto.setId(bookmark.getId());
          dto.setTitle(bookmark.getTitle());
          dto.setUrl(bookmark.getUrl());
          dto.setCreatedAt(bookmark.getCreatedAt());
        return dto;
    }
}
