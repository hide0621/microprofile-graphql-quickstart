package org.acme.microprofile.graphql

import jakarta.enterprise.context.ApplicationScoped
import java.time.LocalDate
import java.time.Month

@ApplicationScoped
class GalaxyService {

    // addメソッドを使うので、MutableListを使う
    private val heroes:MutableList<Hero> = mutableListOf()

    private val films:MutableList<Film> = mutableListOf()

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
    }

    fun getAllFilms(): List<Film> {
        return films
    }

    fun getFilm(id: Int): Film {
        return films[id]
    }

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


}