package dnd.dndserver.article.dto.request;

public record SaveArticleRequest(

        String userUUID,
        String city,
        String district,
        String town,
        int temperature,
        int precipitation,
        int sunshine,
        String content,
        String nowTemp
) {
}
