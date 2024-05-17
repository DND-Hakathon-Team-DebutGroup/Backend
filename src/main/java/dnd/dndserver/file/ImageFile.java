package dnd.dndserver.file;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.global.entity.BaseTimeEntity;
import dnd.dndserver.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageFile extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    private String uploadFileName;
    private String storeFileName;

    @OneToOne(mappedBy = "imageFile", cascade = CascadeType.ALL)
    private Article article;

    public ImageFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}