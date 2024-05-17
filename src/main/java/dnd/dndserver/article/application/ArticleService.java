package dnd.dndserver.article.application;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.article.dto.request.FindArticleRequest;
import dnd.dndserver.article.dto.response.FindAllArticleResponse;
import dnd.dndserver.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public FindAllArticleResponse find(FindArticleRequest request) {

        List<Article> article = articleRepository.findByCityAndDistrict(request.city(), request.district());

        return FindAllArticleResponse.from(article);
    }
}
