package com.example.kubernatescurses.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "bookmark")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {
    @Id
    @SequenceGenerator(name = "bm_is_seq_gen", sequenceName = "bm_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_is_seq_gen")
    private Long id;
    @Column(nullable = false )
    private String title;
    @Column(nullable = false)
    private String url;
    private Instant createdAt;

}
