package dnd.dndserver.article.domain;

import dnd.dndserver.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String fileName;
    @Column
    String city;
    @Column
    String district;
    @Column
    String temperature;
    @Column
    String wind;
    @Column
    String humidity;
    @Column
    String content;
    @Column
    String message;
    @Column
    int like;
}
