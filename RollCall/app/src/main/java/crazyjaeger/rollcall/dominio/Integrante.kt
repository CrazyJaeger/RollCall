package crazyjaeger.rollcall.dominio

import java.time.LocalDate


class Integrante(
    nombre: String,
    apellidos: String,
    var fNacimiento: LocalDate,
    var anotaciones: String?,
    var eliminado : Boolean = false,
    var tfno1: String? = null,
    var tfno2: String? = null
) {
    var nombre: String = nombre
    set(value){
        if(value.isEmpty())
            throw IllegalArgumentException("Argumento <nombre> no puede ser una cadena vacia")
        field = value
    }

    var apellidos: String = apellidos
    set(value){
        if(value.isEmpty())
            throw IllegalArgumentException("Argumento <apellidos> no puede ser una cadena vacia")
        field = value;
    }
}