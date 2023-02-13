package puc.appointify.domain.ports.in.user;

import puc.appointify.domain.ports.in.user.dto.query.FindUserQuery;
import puc.appointify.domain.ports.in.user.dto.query.FindUserQueryResponse;

public interface UserQueryHandler {
    FindUserQueryResponse find(FindUserQuery query);
}
