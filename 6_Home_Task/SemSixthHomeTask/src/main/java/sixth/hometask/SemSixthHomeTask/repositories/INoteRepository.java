package sixth.hometask.SemSixthHomeTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sixth.hometask.SemSixthHomeTask.domains.Note;
@Repository
public interface INoteRepository extends JpaRepository<Note, Long> {
}
