package forohubV2.api.domain.post;

import jakarta.validation.constraints.NotNull;

public record DTOActualizarPost(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String status
) {
}
