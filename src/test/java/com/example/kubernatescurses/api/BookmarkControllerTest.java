package com.example.kubernatescurses.api;

import com.example.kubernatescurses.domain.Bookmark;
import com.example.kubernatescurses.repository.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demodb"
})
public class BookmarkControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookmarkRepository repository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark(null, "Some book", "http://somelink", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book2", "http://somelink2", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book3", "http://somelink3", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book4", "http://somelink4", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book5", "http://somelink5", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book6", "http://somelink6", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book7", "http://somelink7", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book8", "http://somelink8", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book9", "http://somelink9", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book10", "http://somelink10", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book11", "http://somelink11", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book12", "http://somelink12", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book13", "http://somelink13", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book14", "http://somelink14", Instant.now()));
        bookmarks.add(new Bookmark(null, "Some book15", "http://somelink15", Instant.now()));
        repository.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,15,2,1,true,false,true,false",
            "2,15,2,2,false,true,false,true"
    })
    public void shouldGetBookmarks(int pageNumber, int totalElements, int totalPages,
                                   int currentPage, boolean isFirst, boolean isLast,
                                   boolean hasNext, boolean hasPrev) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(("/api/bookmarks?page=" + pageNumber)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
               .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
               .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
               .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
               .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
               .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
               .andExpect(jsonPath("$.hasPrev", CoreMatchers.equalTo(hasPrev)));
    }

}