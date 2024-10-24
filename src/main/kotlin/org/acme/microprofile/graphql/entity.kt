package org.acme.microprofile.graphql;

import java.time.LocalDate

/**
 * GraphQLスキーマに対応するエンティティ
 */

class Film(val title:String, val episodeID:Int, val director:String, val releaseDate:LocalDate?) {


//    init {
//        this.title = title
//        this.episodeId = episodeId
//        this.openingCrawl = openingCrawl
//        this.releaseDate = releaseDate
//    }
}

class  Hero(override val name:String, override val surname:String, val height:Double, val mass:Int, val darkSide:Boolean, val lightSaber:LightSaber, val episodeIds:List<Int>): Character {

//        init {
//            this.name = name
//            this.surname = surname
//            this.height = height
//            this.mass = mass
//            this.darkSide = darkSide
//            this.lightSaber = lightSaber
//            this.episodeIds = episodeIds
//        }
}

enum class LightSaber {
    RED, BLUE, GREEN
}

/**
 * [Character] インターフェースのプロパティをオーバーライドする
 */
class Ally(override val name: String, override val surname: String, val partner: Hero? = null): Character {}

/**
    * Kotlinではプロパティにはデフォルトでゲッターが自動的に付与されている
 */
interface Character {
    val name: String
    val surname: String
}