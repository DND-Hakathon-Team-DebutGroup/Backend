package dnd.dndserver.user;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.file.ImageFile;
import dnd.dndserver.global.entity.BaseTimeEntity;
import dnd.dndserver.user.dto.UserJoinDto;
import dnd.dndserver.user.dto.UserLoginRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지 차단
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickName;

    private String uuid;

    private String profileImageUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    private User(UserJoinDto userJoinDto) {
        this.uuid = UUID.randomUUID().toString();
        this.nickName = userJoinDto.getNickName();
        this.profileImageUrl = userJoinDto.getProfileImageUrl();
    }

    public static User create(UserJoinDto userJoinDto) {
        User user = new User(userJoinDto);
        return user;
    }
}
