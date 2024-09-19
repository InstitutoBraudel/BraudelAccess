package br.org.braudel.braudel.models.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enderecos")
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String municipio;
    private String numero;
    private String uf;
    private String cep;
    private String complemento;

    public Endereco(CadastroEnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public void atualizarInformacoes(CadastroEnderecoDTO cadastroEnderecoDTO) {
        if (cadastroEnderecoDTO.logradouro() != null) {
            this.logradouro = cadastroEnderecoDTO.logradouro();
        }
        if (cadastroEnderecoDTO.bairro() != null) {
            this.bairro = cadastroEnderecoDTO.bairro();
        }
        if (cadastroEnderecoDTO.cep() != null) {
            this.cep = cadastroEnderecoDTO.cep();
        }
        if (cadastroEnderecoDTO.uf() != null) {
            this.uf = cadastroEnderecoDTO.uf();
        }
        if (cadastroEnderecoDTO.cidade() != null) {
            this.cidade = cadastroEnderecoDTO.cidade();
        }
        if (cadastroEnderecoDTO.numero() != null) {
            this.numero = cadastroEnderecoDTO.numero();
        }
        if (cadastroEnderecoDTO.complemento() != null) {
            this.complemento = cadastroEnderecoDTO.complemento();
        }
    }
}
