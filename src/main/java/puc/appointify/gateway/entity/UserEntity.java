package puc.appointify.gateway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    private UUID id;

    private String firstName;
    private String lastName;

    @Column(unique=true)
    private String username;
    @Column(unique=true)
    private String email;
    private String password;

    private String role;
}
