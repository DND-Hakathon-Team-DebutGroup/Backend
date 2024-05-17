package dnd.dndserver.article.application;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.article.dto.AvgDTO;
import dnd.dndserver.article.dto.request.FindArticleRequest;
import dnd.dndserver.article.dto.request.SaveArticleRequest;
import dnd.dndserver.article.dto.response.FindAllArticleResponse;
import dnd.dndserver.article.dto.response.FindArticleResponse;
import dnd.dndserver.article.dto.response.SaveArticleResponse;
import dnd.dndserver.article.infrastructure.ArticleRepository;
import dnd.dndserver.file.FileStore;
import dnd.dndserver.file.ImageFile;
import dnd.dndserver.user.User;
import dnd.dndserver.user.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileStore fileStore;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public FindAllArticleResponse find(FindArticleRequest request) {

        List<Article> articles = articleRepository.findByCityAndDistrictAndTown(request.city(), request.district(), request.town());

        return FindAllArticleResponse.of(
                getAvg(articles),
                articles.stream()
                        .map(FindArticleResponse::new)
                        .toList()
        );
    }

    private AvgDTO getAvg(List<Article> articles) {
        int tempSum = 0;
        int preSum = 0;
        int sunSum = 0;

        for (Article article : articles) {
            tempSum += article.getTemperature();
            preSum += article.getPrecipitation();
            sunSum += article.getSunshine();
        }

        return new AvgDTO(tempSum, preSum, sunSum);
    }

    @Transactional
    public SaveArticleResponse save(SaveArticleRequest request) throws IOException {
        User user = userRepository.findByUuid(request.userUUID());
        articleRepository.save(Article.create(request,
                new ImageFile(request.fileName(), request.fileName()),
                user));
        return new SaveArticleResponse(user.getNickName(), request.content());
    }
}
