package dnd.dndserver.article.dto.response;

import dnd.dndserver.article.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindArticleResponse {

    private Long id;

    private String city;

    private String district;

    private String town;

    private int temperature;

    private int precipitation;

    private int sunshine;

    private String content;

    private int heart;

    private String user;

    private String fileName;

    private String nowTemp;

    public FindArticleResponse(Article article) {
        this.id = article.getId();
        this.city = article.getCity();
        this.district = article.getDistrict();
        this.town = article.getTown();
        this.temperature = article.getTemperature();
        this.precipitation = article.getPrecipitation();
        this.sunshine = article.getSunshine();
        this.content = article.getContent();
        this.heart = article.getHeart();
        this.user = article.getUser().getNickName();
        this.fileName = article.getImageFile().getStoreFileName();
        this.nowTemp = article.getNowTemp();
    }
}
