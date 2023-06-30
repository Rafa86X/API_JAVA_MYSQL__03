package aprendizagem.Api_BD_MySQL_3.infra.exeption;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // Essa classe é chamada sempre que ocorrerem erros nos endpoints, e é ela que devolve um retorno ao usuario informando o erro
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class) //devolve erro 404 - nao encontrado - ao invez do erro 500 erro no servidor
    public ResponseEntity errorHandler404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // essa função simplifica o retorno do erro 400 que quando alguma das validaçoes nao funcionaram,
    public ResponseEntity errorHandler400(MethodArgumentNotValidException ex){// ao invex de devolver um monte de informaçoes devolve apenas os campos em q falhou a validação
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(dataErros400::new).toList());
    }
    private record dataErros400(String campo, String menasgem){
        public dataErros400(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

}
