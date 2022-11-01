package midianet.mykudos.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.mykudos.core.entity.Sprint;
import midianet.mykudos.infra.database.SprintRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewSprint {
    private final SprintRepository repository;

    @Transactional
    public Sprint execute(@NonNull final In sprint){
        final var id = String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()));
        log.debug("Novo Sprint criado {}", id);
        return repository.save(Sprint.builder()
            .id(id)
            .date(LocalDateTime.now())
            .description(sprint.description)
            .kudos(new ArrayList<>())
            .build());
    }

    public record In(
        @NotBlank
        @Size(min = 3 , max = 60)
        String description){}

    public record Out(
        String description,
        String url){}

}
