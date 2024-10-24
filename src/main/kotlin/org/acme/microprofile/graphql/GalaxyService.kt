package org.acme.microprofile.graphql

import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import java.time.LocalDate
import java.time.Month

@ApplicationScoped
class GalaxyService {

    // addメソッドを使うので、MutableListを使う
    private val heroes:MutableList<Hero> = mutableListOf()

    private val films:MutableList<Film> = mutableListOf()

    private val allies:MutableList<Ally> = mutableListOf()

    init {
        val aNewHope = Film("A New Hope", 4, "George Lucas", LocalDate.of(1977, Month.MAY, 25))
        val theEmpireStrikesBack = Film("The Empire Strikes Back", 5, "George Lucas", LocalDate.of(1980, Month.MAY, 21))
        val returnOfTheJedi = Film("Return Of The Jedi", 6, "George Lucas", LocalDate.of(1983, Month.MAY, 25))

        films.add(aNewHope)
        films.add(theEmpireStrikesBack)
        films.add(returnOfTheJedi)

        val luke = Hero("Luke", "Skywalker", 1.7, 73, false, LightSaber.GREEN, listOf(4, 5, 6))
        val leia = Hero("Leia", "Organa", 1.5, 51, false, LightSaber.BLUE, listOf(4, 5, 6))
        val vader = Hero("Darth", "Vader", 1.9, 89, true, LightSaber.RED, listOf(4, 5, 6))

        heroes.add(luke)
        heroes.add(leia)
        heroes.add(vader)

        val jarjar = Ally("Jar Jar", "Binks")
        allies.add(jarjar)
    }

    fun getAllFilms(): List<Film> {
        return films
    }

    /**
     * このメソッドは、[films]リストから指定されたIDの映画を取得する
     * 同期処理用のゲッター
     */
    fun getFilm(id: Int): Film {
        return films[id]
    }

    /**
     * このメソッドは、[films]リストから指定されたIDの映画を取得する
     * 非同期処理用のゲッター
     */
//    fun getFilm(id: Int): Uni<Film> {
//        return Uni.createFrom().item(films[id])
//    }

    fun getHeroesByFilm(film: Film): List<Hero> {
        /**
         * この場合、[heroes.filter] のラムダ式内で [it] は [heroes] リストの各要素（つまり [Hero] オブジェクト）を指す
         */
        return heroes.filter { it.episodeIds.contains(film.episodeID) }
    }

    fun addHero(hero: Hero) {
        heroes.add(hero)
    }

    fun deleteHero(id: Int): Hero? {
        return if (id in heroes.indices) heroes.removeAt(id) else null
    }

    fun getHeroesBySurname(surname: String): List<Hero> {
        return heroes.filter { it.surname == surname }
    }

    fun getAllAllies(): List<Ally> {
        return allies
    }

    fun getAllCharacters(): List<Character> {
        val characters:MutableList<Character> = mutableListOf()
        characters.addAll(heroes)
        characters.addAll(allies)
        return characters
    }

}