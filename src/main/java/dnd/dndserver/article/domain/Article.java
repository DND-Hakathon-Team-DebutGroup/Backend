package dnd.dndserver.article.domain;

import dnd.dndserver.article.dto.request.SaveArticleRequest;
import dnd.dndserver.file.ImageFile;
import dnd.dndserver.global.entity.BaseTimeEntity;
import dnd.dndserver.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private int heart;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private ImageFile imageFile;


    private Article(SaveArticleRequest request, ImageFile file) {
        this.city = request.city();
        this.district = request.district();
        this.town = request.town();
        this.temperature = request.temperature();
        this.precipitation = request.precipitation();
        this.sunshine = request.sunshine();
        this.content = request.content();
        this.heart = 0;
        this.imageFile = file;
    }

    private void regisUser(User user) {
        this.user = user;
        user.getArticles().add(this);
    }

    public static Article create(SaveArticleRequest request, ImageFile file, User user) {
        Article article = new Article(request, file);
        article.regisUser(user);
        return article;
    }
}
