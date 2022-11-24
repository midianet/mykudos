package midianet.mykudos.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import midianet.mykudos.core.entity.User;
import midianet.mykudos.infra.database.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class GetUserById {
    private final UserRepository repository;

    public User execute(@NonNull final String id){
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

}
