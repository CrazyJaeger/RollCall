package crazyjaeger.rollcall.dominio

import java.time.LocalDateTime

class Asistencia (
    val momento: LocalDateTime,
    var presente: Boolean
    ){
}