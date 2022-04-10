package com.letscode.exemploaulabancodados.config;

import com.letscode.exemploaulabancodados.exceptions.ErroMensagem;
import com.letscode.exemploaulabancodados.exceptions.ErroNotFind;
import com.letscode.exemploaulabancodados.exceptions.ErroValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacao> handlerValidation(MethodArgumentNotValidException exception){
        List<ErroValidacao> erros = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e->{
            String mensagemError = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroValidacao errorValidacao = new ErroValidacao(e.getField(), mensagemError);
            erros.add(errorValidacao);
        });
        return erros;
    }

    @ExceptionHandler(ErroNotFind.class)
    public ErroMensagem handlerNotFind(ErroNotFind e){
        return ErroMensagem.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Objeto não encontrado.")
                .message(e.getMessage()).build();
    }
}
