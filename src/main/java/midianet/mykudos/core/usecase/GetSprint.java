package midianet.mykudos.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import midianet.mykudos.core.entity.Event;
import midianet.mykudos.infra.database.EventRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class GetSprint {

    private final EventRepository repository;

    public Event execute(@NonNull final String id, @NonNull final String user) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sprint não econtrada"));
    }

}
