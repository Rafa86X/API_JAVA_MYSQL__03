package aprendizagem.Api_BD_MySQL_3.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRegistrationData(
                                       @NotBlank
                                       String description,
                                       @NotNull
                                       Float price
                                        ) { }
