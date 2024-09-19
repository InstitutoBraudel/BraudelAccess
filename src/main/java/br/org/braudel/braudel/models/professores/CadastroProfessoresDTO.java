package br.org.braudel.braudel.models.professores;

import br.org.braudel.braudel.models.endereco.CadastroEnderecoDTO;
import br.org.braudel.braudel.models.endereco.Endereco;
import br.org.braudel.braudel.models.enuns.Etinia;
import br.org.braudel.braudel.models.enuns.Sexo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroProfessoresDTO(
        @NotBlank
        String nome,
        @NotBlank
        String idade,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String disciplina,
        @NotBlank
        String escola,
        @NotBlank
        String tempoParticipacaoCL,
        @NotBlank
        String religiao,
        @NotNull
        Etinia etinia,
        @NotNull
        Sexo sexo,
        Boolean imigrante,
        Boolean deficiente,
        @NotNull
        @Valid
        CadastroEnderecoDTO endereco
) {
}
