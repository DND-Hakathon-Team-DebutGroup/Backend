package dnd.dndserver.article.infrastructure;

import dnd.dndserver.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("""
            SELECT a
            FROM Article a
            LEFT JOIN FETCH a.imageFile
            WHERE a.city = :city
            AND a.district = :district
            AND a.town = :town
            """)
    List<Article> findByCityAndDistrict(
            String city,
            String district,
            String town
    );
}
