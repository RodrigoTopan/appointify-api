package puc.appointify.domain.ports.in.user;

import puc.appointify.domain.ports.in.user.contracts.query.FindUserQuery;
import puc.appointify.domain.ports.in.user.contracts.query.FindUserQueryResponse;

public interface UserQueryHandler {
    FindUserQueryResponse find(FindUserQuery query);
}
