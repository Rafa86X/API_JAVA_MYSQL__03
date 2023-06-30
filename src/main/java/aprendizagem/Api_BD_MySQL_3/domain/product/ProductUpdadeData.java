package aprendizagem.Api_BD_MySQL_3.domain.product;

import jakarta.validation.constraints.NotNull;

public record ProductUpdadeData(
        @NotNull
        Long id, String description, float price) { }

