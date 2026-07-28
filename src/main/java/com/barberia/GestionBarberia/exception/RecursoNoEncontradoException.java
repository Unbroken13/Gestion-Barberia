package com.barberia.GestionBarberia.exception;

public class RecursoNoEncontradoException extends RuntimeException{


    public RecursoNoEncontradoException(String mensaje){
        super(mensaje);// Le pasamos el mensaje a la clase padre (RuntimeException)

    }


}
