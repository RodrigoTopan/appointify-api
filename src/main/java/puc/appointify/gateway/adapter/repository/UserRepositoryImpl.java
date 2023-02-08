package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.ports.out.repository.UserRepository;
import puc.appointify.gateway.entity.UserEntity;
import puc.appointify.gateway.jpa.UserJpaRepository;
import puc.appointify.gateway.mapper.DataMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final DataMapper<User, UserEntity> mapper;
    private final UserJpaRepository jpaRepository;

    @Override
    public User findByUsername(String username) {
        var entity = jpaRepository.findByUsername(username);
        if (entity == null) return null;
        return mapper.toDomain(entity);
    }

    @Override
    public User save(User user) {
        var entity = mapper.toEntity(user);
        var savedUser = jpaRepository.save(entity);
        return mapper.toDomain(savedUser);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User findById(UUID id) {
        return mapper.toDomain(jpaRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
