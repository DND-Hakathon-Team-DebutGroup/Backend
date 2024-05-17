package dnd.dndserver.user.application;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.article.dto.request.FindArticleRequest;
import dnd.dndserver.article.dto.response.FindAllArticleResponse;
import dnd.dndserver.article.dto.response.FindArticleResponse;
import dnd.dndserver.article.infrastructure.ArticleRepository;
import dnd.dndserver.file.FileStore;
import dnd.dndserver.file.ImageFile;
import dnd.dndserver.user.User;
import dnd.dndserver.user.application.repository.UserRepository;
import dnd.dndserver.user.dto.UserJoinDto;
import dnd.dndserver.user.dto.UserLoginRequest;
import dnd.dndserver.user.dto.UserLoginResponse;
import dnd.dndserver.user.dto.UserMyPageResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final FileStore fileStore;
    private final ArticleRepository articleRepository;

    public User find(String uuid) {
        return userRepository.findByUuid(uuid);
    }

    @Transactional
    public UserLoginResponse login(UserLoginRequest request) throws IOException {

        MultipartFile multipartFile = request.getImageFile();

        if (multipartFile == null) {
            throw new RuntimeException();
        }

        ImageFile imageFile = fileStore.storeFile(multipartFile);

        User user = User.create(new UserJoinDto(
                request.getNickName(),
                UUID.randomUUID().toString(),
                imageFile
        ));

        userRepository.save(user);

        String uuid = user.getUuid();

        return new UserLoginResponse(
                request.getNickName(),
                uuid
        );
    }

    @Transactional(readOnly = true)
    public UserMyPageResponse getProfile(String uuid) {

        List<Article> articles = articleRepository.findByUuid(uuid);
        User user = userRepository.findByUuid(uuid);

        List<FindArticleResponse> articleResponses = articles.stream()
                .map(article -> new FindArticleResponse(
                        article.getId(),
                        article.getCity(),
                        article.getDistrict(),
                        article.getTown(),
                        article.getTemperature(),
                        article.getPrecipitation(),
                        article.getSunshine(),
                        article.getContent(),
                        article.getHeart(),
                        article.getUser().getNickName(), // 예를 들어, Article 엔티티가 User 엔티티와 연관관계를 가지고 있다고 가정
                        article.getImageFile().getStoreFileName()
                ))
                .collect(Collectors.toList());

        return UserMyPageResponse.from(user.getNickName(),
                user.getImageFile().getStoreFileName(), articleResponses);
    }

}
