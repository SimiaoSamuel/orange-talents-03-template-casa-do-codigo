package com.orangetalents.casadocodigo.cliente;

import com.orangetalents.casadocodigo.estadopais.Estado;
import com.orangetalents.casadocodigo.estadopais.EstadoRepository;
import com.orangetalents.casadocodigo.estadopais.Pais;
import com.orangetalents.casadocodigo.estadopais.PaisRepository;
import com.orangetalents.casadocodigo.validation.Exist;
import com.orangetalents.casadocodigo.validation.NotDuplicatedGenerico;
import com.orangetalents.casadocodigo.validation.ValidationStateCountry;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ValidationStateCountry
public class ClienteForm {
    @NotBlank
    @Email
    @NotDuplicatedGenerico(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    /***
     * Tava em duvida de como fazer essa parte, ai eu olhei na implementação do @CPF e @CNPJ
     * E vi que usava regex, então eu fui procurar no google como que faz regex já que não lembrava muito bem
     * talvez não seja a melhor solução, mas foi a que eu pensei
     */
    @Pattern(regexp = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})",
            message = "CPF/CNPJ Errado")
    @NotBlank
    @NotDuplicatedGenerico(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @Exist(domainClass = Pais.class, fieldName = "id")
    private Integer paisId;

    private Integer estadoId;

    public Integer getPaisId() {
        return paisId;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                       @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                       @NotBlank String cidade, @NotNull Integer paisId,
                       Integer estadoId, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toCliente(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        Pais pais = paisRepository.getOne(paisId);
        Estado estadoValidated = null;

        if (estadoId != null)
            estadoValidated = estadoRepository.getOne(estadoId);

        /*
        boolean isValuePresent = !estado.isEmpty();

        if(isValuePresent && estadoId == null) {
             throw new RuntimeException("Esse país tem um estado, você precisa passá-lo");
        }
        else if(isValuePresent){
            estadoValidated = estado.stream().filter(e -> e.getId().equals(estadoId)).findFirst()
                    .orElseThrow(() -> new RuntimeException("Esse estado não existe nesse país!"));
        }
        else if(estadoId != null){
            throw new RuntimeException("Esse país não tem estado!");
        }
*/
        return new Cliente(
                email, nome, sobrenome, documento, endereco, complemento, cidade, estadoValidated, pais, telefone, cep
        );
    }
}
