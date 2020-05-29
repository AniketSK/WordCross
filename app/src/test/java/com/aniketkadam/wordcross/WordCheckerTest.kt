package com.aniketkadam.wordcross

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import java.io.InputStream

class WordCheckerTest {

    private val wc = WordChecker(object : WordDataLoader {
        override fun loadData(): InputStream =
            getTextInFile("unicorn.txt")!!
    })

    @Test
    fun `common words are detected by the word checker`() {
        assertThat(wc.isWord("DOG"), equalTo(true))
        assertThat(wc.isWord("SLENDER"), equalTo(true))
    }
    
    @Test
    fun `strings that are not words are correctly detected as not present`() {
        assertThat(wc.isWord("SLZK"), equalTo(false))
    }
}