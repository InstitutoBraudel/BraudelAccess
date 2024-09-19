package br.org.braudel.braudel.models.alunos;

import br.org.braudel.braudel.models.endereco.CadastroEnderecoDTO;
import br.org.braudel.braudel.models.endereco.Endereco;
import br.org.braudel.braudel.models.enuns.Etinia;
import br.org.braudel.braudel.models.enuns.Sexo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroAlunosDTO(

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
        String escola,

        @NotBlank
        String serieEscola,


        Boolean multiplicador,

        @NotBlank
        String semestreMultiplicador,

        @NotNull
        Etinia etinia,

        @NotNull
        Sexo sexo,
        Boolean imigrante,
        Boolean deficiente,
        String religiao,

        @NotNull
        @Valid
        CadastroEnderecoDTO endereco
) {
}
