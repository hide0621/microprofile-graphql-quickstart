package org.acme.microprofile.graphql

import jakarta.inject.Inject
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Name
import org.eclipse.microprofile.graphql.Query

/**
 * GraphQL APIのエンドポイントになるクラス
 */
@GraphQLApi
class FilmResource {

    @Inject
    lateinit var service: GalaxyService

    /**
     * [allFilms]という名前のクエリを定義
     */
    @Query("allFilms")
    @Description("Get all Films from a galaxy far far away")
    fun getAllFilms(): List<Film> {
        return service.getAllFilms()
    }

    /**
     * [film]という名前のクエリを定義
     */
    @Query
    @Description("Get a Films from a galaxy far far away")
    fun getFilm(@Name("filmId") id:Int):Film {
        return service.getFilm(id)
    }
}