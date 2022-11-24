package midianet.mykudos.core.usecase;

import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import midianet.mykudos.core.entity.User;
import midianet.mykudos.infra.database.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUser {
    private final UserRepository repository;
    private final GetUserById getById;

    @Transactional
    public void execute(@NonNull String id, @NonNull User user) {
        final var persistent = getById.execute((id));
        BeanUtils.copyProperties(persistent,user,"id");
        repository.save(persistent);
    }

}
