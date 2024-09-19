package br.org.braudel.braudel.models.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastroEnderecoDTO(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String estado,

        @NotBlank
        String municipio,


        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String uf,

        String complemento,
        String numero
) {
}
