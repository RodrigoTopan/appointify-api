package puc.appointify.application.rest.security;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.application.rest.security.dto.AuthenticationDTO;
import puc.appointify.application.rest.security.dto.AuthenticationResponseDTO;
import puc.appointify.application.rest.security.util.JwtTokenUtil;
import puc.appointify.domain.core.ports.in.user.UserCommandHandler;
import puc.appointify.domain.core.ports.in.user.contract.command.CreateUserCommand;
import puc.appointify.domain.core.ports.in.user.contract.command.CreateUserCommandResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserCommandHandler userCommandHandler;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/register")
    public ResponseEntity<CreateUserCommandResponse> registerUser(
            @RequestBody @Valid CreateUserCommand command) {

        var hashedPassword = passwordEncoder.encode(command.getPassword());
        command.setPassword(hashedPassword);

        return ResponseEntity.ok()
                .body(userCommandHandler.execute(command));
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> createAuthenticationToken(@RequestBody AuthenticationDTO authenticationRequest) {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final var userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final var token = jwtTokenUtil.generateToken(userDetails);
        final var mainRole = userDetails.getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow();
        return ResponseEntity.ok(new AuthenticationResponseDTO(token, userDetails.getUsername(), mainRole.getAuthority()));
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
