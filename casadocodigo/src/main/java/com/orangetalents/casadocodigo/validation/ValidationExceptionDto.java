package com.orangetalents.casadocodigo.validation;

public class ValidationExceptionDto {
    private String campo;
    private String erro;

    public ValidationExceptionDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
