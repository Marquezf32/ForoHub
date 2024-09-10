package forohubV2.api.domain.post;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOPost(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String fecha,

        @NotBlank
        String status,

        @NotBlank
        @Email
        String autor,

        @NotNull
        Curso curso

){

}
