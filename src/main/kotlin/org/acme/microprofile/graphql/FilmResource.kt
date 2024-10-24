package org.acme.microprofile.graphql

import jakarta.inject.Inject
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Name
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source

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

//    fun heroes(@Source film:Film): List<Hero> {
//        return service.getHeroesByFilm(film)
//    }

    /**
     * バッチ処理の形式でヒーローを取得する
     */
    fun heroes(@Source films: List<Film>): List<List<Hero>> {
        return films.map { service.getHeroesByFilm(it) }
    }
}