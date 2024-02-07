package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.ports.out.repository.UserRepository;
import puc.appointify.gateway.database.entity.UserEntity;
import puc.appointify.gateway.database.jpa.UserJpaRepository;
import puc.appointify.gateway.database.mapper.DataMapper;
import puc.appointify.gateway.database.mapper.impl.UserDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public User findByUsername(String username) {
        var entity = jpaRepository.findByUsername(username);
        if (entity == null) return null;
        return UserDataAccessMapper.toDomain(entity);
    }

    @Override
    public User save(User user) {
        var entity = UserDataAccessMapper.toEntity(user);
        var savedUser = jpaRepository.save(entity);
        return UserDataAccessMapper.toDomain(savedUser);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(UserDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User findById(UUID id) {
        return UserDataAccessMapper.toDomain(jpaRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
