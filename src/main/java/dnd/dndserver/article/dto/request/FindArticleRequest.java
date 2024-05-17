package dnd.dndserver.article.dto.request;

public record FindArticleRequest(
        String city,
        String district,
        String town
) {
}
