package com.aniketkadam.wordcross

import androidx.annotation.WorkerThread

class WordGrid @WorkerThread constructor(val rows: Int, val columns: Int) {
    // Represent this with a two dimensional grid of letters
    private val allowedCharacters = ('A'..'Z')

    fun generateLetterGrid(): List<Char> =
        List(rows * columns) { allowedCharacters.random() }

    // What if we had a single string instead of a grid of characters?
    // The most reasonable way to represent a grid is a goddamn recyclerview =/
    // The recyclerview would then need a list of characters instead of a single string.
    // Not so, the list given could be a

    // Possible to iterate over a string as well if jetpack compose was there.
    // row number = index % rownum
    // column number = index % colnum

}