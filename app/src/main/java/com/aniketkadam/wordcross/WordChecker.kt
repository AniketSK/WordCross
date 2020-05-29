package com.aniketkadam.wordcross

import com.google.common.hash.BloomFilter
import com.google.common.hash.Funnels

class WordChecker(wordDataLoader: WordDataLoader) {

    @Suppress("UnstableApiUsage")
    private val filter: BloomFilter<String> =
        BloomFilter.readFrom(wordDataLoader.loadData(), Funnels.stringFunnel(Charsets.UTF_8))

    /**
     * Something is a word if it is present in the dictionary
     * returns: True if such a word exists in the dictionary
     */
    fun isWord(chars: String): Boolean = filter.mightContain(chars)
}