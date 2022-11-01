package midianet.mykudos.infra.database;

import midianet.mykudos.core.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, String> {

}
