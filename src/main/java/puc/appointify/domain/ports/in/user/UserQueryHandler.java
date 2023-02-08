package puc.appointify.domain.ports.in.user;

import puc.appointify.domain.ports.in.user.contract.query.FindUserQuery;
import puc.appointify.domain.ports.in.user.contract.query.FindUserQueryResponse;

public interface UserQueryHandler {
    FindUserQueryResponse find(FindUserQuery query);
}
