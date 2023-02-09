package puc.appointify.gateway.database.mapper;

public interface DataMapper<Domain, Entity> {
    Entity toEntity(Domain domain);
    Domain toDomain(Entity entity);
}