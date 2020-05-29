package com.aniketkadam.wordcross

import java.io.InputStream

interface WordDataLoader {
    fun loadData(): InputStream
}