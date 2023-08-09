package com.example.kubernatescurses.service;

import com.example.kubernatescurses.domain.Bookmark;
import com.example.kubernatescurses.dto.BookmarkDTO;
import com.example.kubernatescurses.dto.BookmarkMapper;
import com.example.kubernatescurses.dto.BookmarksDto;
import com.example.kubernatescurses.dto.CreateBookmarkRequest;
import com.example.kubernatescurses.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper mapper;

    @Transactional(readOnly = true)
    public BookmarksDto getBookmarks(Integer page) {
        int pageN = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageN, 10, Sort.Direction.DESC, "createdAt");
        return new BookmarksDto(bookmarkRepository.findBookmarks(pageable));
    }

    @Transactional(readOnly = true)
    public BookmarksDto searchBookmarks(String query, Integer page) {
        int pageN = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageN, 10, Sort.Direction.DESC, "createdAt");
        return new BookmarksDto(bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable));
    }

    public BookmarkDTO createBookmark(CreateBookmarkRequest request) {
        Bookmark bookmark = new Bookmark(null, request.getTitle(), request.getUrl(), Instant.now());
        Bookmark savedBookmark = bookmarkRepository.save(bookmark);
        return mapper.toDto(savedBookmark);
    }
}
