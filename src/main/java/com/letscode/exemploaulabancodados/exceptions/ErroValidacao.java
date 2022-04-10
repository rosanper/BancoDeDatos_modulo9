package com.letscode.exemploaulabancodados.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErroValidacao {
    private String campo;
    private String mensagemErro;
}
