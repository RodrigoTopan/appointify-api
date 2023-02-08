package puc.appointify.domain.ports.in.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.user.mapper.UserMapper;
import puc.appointify.domain.ports.in.user.UserQueryHandler;
import puc.appointify.domain.ports.in.user.contract.query.FindUserQuery;
import puc.appointify.domain.ports.in.user.contract.query.FindUserQueryResponse;
import puc.appointify.domain.ports.out.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserQueryHandlerImpl implements UserQueryHandler {
    private final UserMapper userMapper;
    private final UserRepository userRepository;


    @Override
    public FindUserQueryResponse find(FindUserQuery query) {
        var user = userRepository.findByUsername(query.getUsername());
        return userMapper.userToFindUserQueryResponse(user);
    }
}
