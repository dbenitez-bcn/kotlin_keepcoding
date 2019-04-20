package com.logicgear.appofthrones

import java.util.*

object CharactersRepo {
    val characters: MutableList<Character> = mutableListOf()
        get() {
            if (field.isEmpty()) {
                field.addAll(dummyCharacters())
            }
            return field
        }

    private fun dummyCharacters(): MutableList<Character> {
        return (1..10).map {
            intToCharacter(it)
        }.toMutableList()
    }

    fun findCharacterById(id: String): Character? {
        return characters.find { character ->
            character.id == id
        }
    }

    private fun intToCharacter(int: Int): Character {
        return Character(
                name = "Personaje ${int}",
                title = "Titulo ${int}",
                born = "Nació en ${int}",
                actor = "Actor ${int}",
                quote = "Frase ${int}",
                father = "Padre ${int}",
                mother = "Madre ${int}",
                spouse = "Espos@ ${int}",
                house = dummyHouse()
        )
    }

    private fun dummyHouse(): House{
        val ids = arrayOf("start", "lannister", "tyrrel", "arryn", "baratheon", "tully")
        val randomIdPosition = Random().nextInt(ids.size)

        return House(ids[randomIdPosition], "Region", "Lema")
    }

}