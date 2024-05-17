package dnd.dndserver.article.application;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.article.dto.request.FindArticleRequest;
import dnd.dndserver.article.dto.request.SaveArticleRequest;
import dnd.dndserver.article.dto.response.FindAllArticleResponse;
import dnd.dndserver.article.infrastructure.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public FindAllArticleResponse find(FindArticleRequest request) {

        List<Article> article = articleRepository.findByCityAndDistrict(request.city(), request.district(), request.town());

        return FindAllArticleResponse.from(article);
    }

    @Transactional
    public void save(SaveArticleRequest request) {

        articleRepository.save(new Article(request));
    }
}
