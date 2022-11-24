package midianet.mykudos.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import midianet.mykudos.core.entity.User;
import midianet.mykudos.infra.database.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUser {
    private final UserRepository repository;

    @Transactional
    public User execute(@NonNull User user) {
        if(repository.findByEmail(user.getEmail()).isPresent())
            throw new RuntimeException("Email já utilizado.");
        return repository.save(user);
    }

}
