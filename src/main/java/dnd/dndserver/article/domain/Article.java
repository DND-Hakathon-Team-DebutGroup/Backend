package dnd.dndserver.article.domain;

import dnd.dndserver.file.ImageFile;
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
    private Long id;
    @Column
    private String city;
    @Column
    private String district;
    @Column
    private String town;
    @Column
    private int temperature;
    @Column
    private int precipitation;
    @Column
    private int sunshine;
    @Column
    private String content;
    @Column
    private String message;
    @Column
    private int heart;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private ImageFile imageFile;
}
