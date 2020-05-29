package com.aniketkadam.wordcross

import com.google.common.hash.BloomFilter
import com.google.common.hash.Funnels
import org.junit.Ignore
import org.junit.Test
import java.io.File

class BloomFilterMaker {

    /**
     * Un-ignore this test to generate a new set of bloom filter data to load at runtime
     */
    @Ignore
    @Test
    fun `make the bloom filter out of an existing text file`() {
        val filter = BloomFilter.create(
            Funnels.stringFunnel(Charsets.UTF_8),
            200000, // Round up from the current list of 131k words
            0.0001
        )

        getTextInFile("combined.txt")!!.bufferedReader().readLines()
            .forEach {
                filter.put(it)
            }

        val writeFile = File("src\\main\\res\\raw\\unicorn.txt").outputStream()
        filter.writeTo(writeFile)
        writeFile.close()
    }
}