package midianet.mykudos.infra.database;

import midianet.mykudos.core.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

}
