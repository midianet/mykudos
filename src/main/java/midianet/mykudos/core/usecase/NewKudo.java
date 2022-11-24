package midianet.mykudos.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.mykudos.core.entity.Event;
import midianet.mykudos.infra.database.EventRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewKudo {
    private final EventRepository repository;

    @Transactional
    public Event.Kudo execute(@NonNull final In kudo){
//        final var persistent = repository.save(Sprint.Kudo.builder()
//                .id(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())))
//                .user(kudo.user)
//                .praised(kudo.praised)
//                .message(kudo.message)
//                .build());
//        log.debug("Novo produto criado {}", kudo.getId());
//        return persistent;
        return  null;
    }


    public record In(
        @NotBlank
        @Size(min = 3 , max = 60)
        String user,

        @NotBlank
        @Size(min = 3 , max = 60)
        String praised,

        @NotBlank
        @Size(min = 10 , max = 500)
        String message){}


}
