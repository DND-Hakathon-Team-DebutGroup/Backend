package dnd.dndserver.file.application.repository;

import dnd.dndserver.file.ImageFile;
import dnd.dndserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<ImageFile, Long> {
}