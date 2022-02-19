package crazyjaeger.rollcall.dominio

/**
 * Clase que implementa un grupo.
 * TODO: document!
 */
class Grupo(
    nombre: String,
    var descripcion: String?
) {

    var nombre: String = nombre
        set(value) {
            if (value.isEmpty())
                throw IllegalArgumentException("Argumento <nombre> no puede ser una cadena vacia")
            field = value
        }


}