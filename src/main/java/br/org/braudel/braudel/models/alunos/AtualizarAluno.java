package br.org.braudel.braudel.models.alunos;

import br.org.braudel.braudel.models.endereco.CadastroEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarAluno(
        @NotNull
        Long id,
        String nome,
        String telfone,
        String escola,
        String anoEscola,
        Boolean multiplicador,
        CadastroEnderecoDTO enderecoDTO
) {
}
