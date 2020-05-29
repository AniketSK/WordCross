package com.aniketkadam.wordcross

import java.io.InputStream

fun getTextInFile(fileName: String): InputStream? = ClassLoader.getSystemResourceAsStream(fileName)
