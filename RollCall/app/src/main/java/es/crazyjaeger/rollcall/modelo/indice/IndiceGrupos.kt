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

import jakarta.json.JsonObject
import java.time.LocalDateTime

private const val GRUPOS = "grupos"
private const val FECHA_CREACION = "fechaCreacion"
private const val FECHA_MODIFICACION = "fechaModificacion"

/**
 * Indice de grupos registrados en la aplicacion.
 *
 * El indice de grupos contiene un listado con la informacion minima necesaria para identificar
 * cada grupo asi como la informacion para que la aplicacion sea capaz de cargar los datos.
 * @see RegistroGrupo
 *
 * Lista de propiedades:
 * - grupos: lista de registros de grupo registrados en el indice
 * - fechaCreacion: fecha de creacion del indice de grupos
 * - fechaModificacion: fecha de modificacion del indice de grupos
 */
class IndiceGrupos {
    val grupos: MutableList<RegistroGrupo>
    val fechaCreacion: LocalDateTime
    val fechaModificacion: LocalDateTime

    /**
     * Inicializa un nuevo indice de grupos vacio.
     *
     * @param fecha fecha de creacion del indice
     */
    constructor(fecha: LocalDateTime){
        //TODO: null checks
        grupos = mutableListOf()
        fechaCreacion = fecha
        fechaModificacion = fecha
    }

    /**
     * Inicializa un nuevo indice de grupos a partir de una instancia en formato JSON
     *
     * @param indice instancia de un indice de grupos en formato JSON
     */
    constructor(indice: JsonObject){
        // TODO: null checks
        grupos = mutableListOf()
        val gruposJa = indice.getJsonArray(GRUPOS)
        for(grupoJv in gruposJa){
            grupos.add(RegistroGrupo(grupoJv.asJsonObject()))
        }

        fechaCreacion = LocalDateTime.parse(indice.getString(FECHA_CREACION))
        fechaModificacion = LocalDateTime.parse((indice.getString((FECHA_MODIFICACION))))
    }
}