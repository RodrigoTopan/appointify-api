package puc.appointify.gateway.mapper;

public interface DataMapper<Domain, Entity> {
    Entity toEntity(Domain domain);
    Domain toDomain(Entity entity);
}