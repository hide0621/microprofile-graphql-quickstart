package org.acme.microprofile.graphql;

import java.time.LocalDate

/**
 * GraphQLスキーマに対応するエンティティ
 */

class Film(val title:String, val episodeId:Int, val openingCrawl:String, val releaseDate:LocalDate?) {


//    init {
//        this.title = title
//        this.episodeId = episodeId
//        this.openingCrawl = openingCrawl
//        this.releaseDate = releaseDate
//    }
}

class  Hero(val name:String, val surname:String, val height:Double, val mass:Int, val darkSide:Boolean, val lightSaber:LightSaber, val episodeIds:List<Int>) {

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