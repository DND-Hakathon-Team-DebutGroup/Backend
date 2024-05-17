package dnd.dndserver.article.application;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.article.dto.request.FindArticleRequest;
import dnd.dndserver.article.dto.request.SaveArticleRequest;
import dnd.dndserver.article.dto.response.FindAllArticleResponse;
import dnd.dndserver.article.dto.response.FindArticleResponse;
import dnd.dndserver.article.dto.response.SaveArticleResponse;
import dnd.dndserver.article.infrastructure.ArticleRepository;
import dnd.dndserver.file.FileStore;
import dnd.dndserver.user.User;
import dnd.dndserver.user.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileStore fileStore;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public FindAllArticleResponse find(FindArticleRequest request) {

        List<Article> articles = articleRepository.findByCityAndDistrict(request.city(), request.district(),
                request.town());

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
                        article.getImageFile().getStoreFileName(),
                        article.getNowTemp()
                ))
                .collect(Collectors.toList());

        return FindAllArticleResponse.from(articleResponses);
    }

    @Transactional
    public SaveArticleResponse save(SaveArticleRequest request, MultipartFile file) throws IOException {
        User user = userRepository.findByUuid(request.userUUID());
        articleRepository.save(Article.create(request, fileStore.storeFile(file), user));
        return new SaveArticleResponse(user.getNickName(), request.content());
    }
}
