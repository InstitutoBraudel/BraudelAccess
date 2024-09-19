package br.org.braudel.braudel.models.escolas;

import br.org.braudel.braudel.models.endereco.CadastroEnderecoDTO;
import br.org.braudel.braudel.models.endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastroEscolasDTO(
        String nomeInstituicao,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String telefoneEscola,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String vinvulacaoEscola,
        @NotBlank
        String nomeCoordPedago,
        @NotBlank
        @Email
        String emailCoordPedago,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String telefoneCoordPedago,
        @NotBlank
        String anoAdesaoCL,
        @NotBlank
        String alunosParticipantesCL,
        @NotBlank
        String professoresParticipantesCL,
        @NotBlank
        String turmasParticipantesCL,
        Boolean autorizaContato,
        CadastroEnderecoDTO endereco
) {

}
