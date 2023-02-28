/**
 * Copyright (C) - 2023 Miguel Gomez Casado (a.k.a. Crazy Jaeger)
 *
 * This file is part of RollCall.
 * RollCall is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * RollCall is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * You should have received a copy of the GNU General Public License along with RollCall. If not,
 * see <https://www.gnu.org/licenses/>.
 */
package es.crazyjaeger.rollcall.modelo.indice

import jakarta.json.Json
import jakarta.json.JsonObject
import java.time.LocalDateTime

private const val NOMBRE_GRUPO = "nombreGrupo"
private const val NOMBRE_FICHERO = "nombreFichero"
private const val FECHA_CREACION = "fechaCreacion"

/**
 * Registro de grupo.
 *
 * Esta clase contiene la informacion minima necesaria para poder identificar a un grupo existente
 * que ha sido guardado en la aplicacion. Esta informacion se corresponderia con el nombre del grupo
 * y el nombre del fichero fisico donde se guarda la informacion del grupo. Esto permitira al
 * usuario identificar el grupo que desea visualizar y la aplicacion sabra donde localizar la
 * informacion solicitada.
 *
 * Lista de propiedades:
 * - nombreGrupo: nombre natural del grupo
 * - nombreFichero: nombre del fichero donde persiste el grupo
 * - fechaCreacion: fecha de creacion de este registro del grupo
 */
class RegistroGrupo {
    val nombreGrupo: String
    val nombreFichero: String
    val fechaCreacion: LocalDateTime

    /**
     * Inicializa un nuevo registro de grupo de forma manual.
     *
     * @param nombreGrupo nombre natural del grupo
     * @param nombreFichero nombre del fuchero donde se peristira el grupo
     * @param fechaCreacion fecha y hora de creacion del registro
     */
    constructor(nombreGrupo: String, nombreFichero: String, fechaCreacion: LocalDateTime) {
        this.nombreGrupo = nombreGrupo
        this.nombreFichero = nombreFichero
        this.fechaCreacion = fechaCreacion
    }

    /**
     * Inicializa un nuevo registro de grupo a partir de un objeto JSON.
     *
     * @param registro instancia de RegistroGrupo en formato JSON
     */
    constructor(registro: JsonObject) {
        nombreGrupo = registro.getString(NOMBRE_GRUPO)
        nombreFichero = registro.getString(NOMBRE_FICHERO)
        fechaCreacion = LocalDateTime.parse(registro.getString(FECHA_CREACION))
    }

    /**
     * Proporciona la representacion JSON de la instancia del registro.
     *
     * @return instancia del registro en formato JSON
     */
    fun toJson(): JsonObject {
        val builder = Json.createObjectBuilder()
        builder.add(NOMBRE_GRUPO, nombreGrupo)
        builder.add(NOMBRE_FICHERO, nombreFichero)
        builder.add(FECHA_CREACION, fechaCreacion.toString())

        return builder.build()
    }

    /**
     * Proporciona la representacion en formato de texto de la instancia del registro.
     */
    override fun toString(): String {
        return toJson().toString()
    }

    /**
     * Comprueba si dos instancias de RegistroGrupo son iguales.
     *
     * @param other elemento con el que se compara
     * @return true si son dos instancias iguales de RegistroGrupo, false en caso contrario
     */
    override fun equals(other: Any?): Boolean {
        return other is RegistroGrupo &&
                other.nombreGrupo == nombreGrupo &&
                other.nombreFichero == nombreFichero &&
                other.fechaCreacion == fechaCreacion
    }

    /**
     * Proporciona el codigo HASH de la instancia de RegistroGrupo
     *
     * @returns codigo HASH del registro grupo
     */
    override fun hashCode(): Int {
        var result = nombreGrupo.hashCode()
        result = 31 * result + nombreFichero.hashCode()
        result = 31 * result + fechaCreacion.hashCode()
        return result
    }
}