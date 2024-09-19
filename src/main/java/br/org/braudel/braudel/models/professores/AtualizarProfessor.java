package br.org.braudel.braudel.models.professores;

import br.org.braudel.braudel.models.endereco.CadastroEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarProfessor(
        @NotNull
        Long id,
        String nome,
        String telfone,
        String escola,
        String disciplica,
        CadastroEnderecoDTO enderecoDTO
) {
}
