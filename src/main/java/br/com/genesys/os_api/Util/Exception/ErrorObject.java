package br.com.genesys.os_api.Util.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorObject {

    private final String info;
    private final String campo;
    private final Object conteudo;
}