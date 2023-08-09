package com.example.kubernatescurses.dto;

import com.example.kubernatescurses.domain.Bookmark;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookmarksDto {
    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirstPage;
    @JsonProperty("isLast")
    private boolean isLastPage;
    private boolean hasNext;
    private boolean hasPrev;

    public BookmarksDto(Page<BookmarkDTO> bookmarks){
        this.setData(bookmarks.getContent());
        this.setTotalElements(bookmarks.getTotalElements());
        this.setTotalPages(bookmarks.getTotalPages());
        this.setCurrentPage(bookmarks.getNumber() + 1);
        this.setFirstPage(bookmarks.isFirst());
        this.setLastPage(bookmarks.isLast());
        this.setHasNext(bookmarks.hasNext());
        this.setHasPrev(bookmarks.hasPrevious());
    }
}
