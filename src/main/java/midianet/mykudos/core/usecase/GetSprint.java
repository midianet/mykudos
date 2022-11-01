package midianet.mykudos.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import midianet.mykudos.core.entity.Sprint;
import midianet.mykudos.infra.database.SprintRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class GetSprint {

    private final SprintRepository repository;

    public Sprint execute(@NonNull final String id, @NonNull final String user) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sprint não econtrada"));
    }

}
