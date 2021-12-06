package br.com.demarqui.demarqui.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReturnRequest {
    private final boolean error;
    private final String info;
    private final Object returning;
}
