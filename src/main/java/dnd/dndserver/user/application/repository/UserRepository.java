package dnd.dndserver.user.application.repository;

import dnd.dndserver.article.domain.Article;
import dnd.dndserver.user.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUuid(String UUID);
}
