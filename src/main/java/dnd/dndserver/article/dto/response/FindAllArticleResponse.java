package dnd.dndserver.article.dto.response;

import dnd.dndserver.article.dto.AvgDTO;

import java.util.List;

public record FindAllArticleResponse(
        int tempAvg,
        int precipitationAvg,
        int sunshineAvg,
        List<FindArticleResponse> articles
) {

    public static FindAllArticleResponse of(AvgDTO avg, List<FindArticleResponse> articles) {
        return new FindAllArticleResponse(
                avg.getTemperatureAvg(),
                avg.getPrecipitationAvg(),
                avg.getSunshineAvg(),
                articles
        );
    }
}
