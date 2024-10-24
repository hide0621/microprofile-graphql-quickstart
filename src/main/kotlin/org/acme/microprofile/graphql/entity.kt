package org.acme.microprofile.graphql;

import io.smallrye.graphql.api.Union
import java.time.LocalDate

/**
 * GraphQLスキーマに対応するエンティティ
 */

class Film(val title:String, val episodeID:Int, val director:String, val releaseDate:LocalDate?): SearchResult {


//    init {
//        this.title = title
//        this.episodeId = episodeId
//        this.openingCrawl = openingCrawl
//        this.releaseDate = releaseDate
//    }
}

/**
 * [Character] インターフェースのプロパティをオーバーライドする
 */
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
interface Character: SearchResult {
    val name: String
    val surname: String
}

/**
 * 検索結果を表すインターフェース
 * [@Union]GraphQLのユニオン型を表すアノテーション
 * ユニオン型は、複数の異なる型を一つの型として扱うことができるGraphQLの機能
 */
@Union
interface SearchResult{}