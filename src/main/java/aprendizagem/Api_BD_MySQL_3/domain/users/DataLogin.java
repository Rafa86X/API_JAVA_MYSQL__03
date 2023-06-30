package aprendizagem.Api_BD_MySQL_3.domain.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataLogin(
        @NotBlank
        String login,

        @NotBlank
        String password ) {
}
