package com.aniketkadam.wordcross

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordGridViewModel(
    private val wordChecker: WordChecker,
    private val wordGrid: WordGrid
) : ViewModel() {

    private val pWordGridDisplay = MutableLiveData<List<Char>?>()
    private val pScore = MutableLiveData<Int>(0)
    private val pCorrectWordsMade = MutableLiveData<List<String>>(emptyList())
    private val pIncorrectWordsMade = MutableLiveData<List<String>>(emptyList())
    private val pErrorEffect = SingleLiveEvent<String>()

    val wordGridDisplay: LiveData<List<Char>?>
        get() = pWordGridDisplay

    val score: LiveData<Int>
        get() = pScore

    fun startNewGame() {
        pWordGridDisplay.postValue(wordGrid.generateLetterGrid())
    }

    fun submitWord(word: String) {
        if (wordChecker.isWord(word)) {
            // Increment the score
            pScore.value = pScore.value!! + 1
            // Keep track of the words that were made
            pCorrectWordsMade.value = pCorrectWordsMade.value?.plus(word)
        } else {
            reportError(word)
        }
    }

    private fun reportError(word: String) {
        pErrorEffect.postValue(word)
        pIncorrectWordsMade.postValue(pIncorrectWordsMade.value?.plus(word))
    }

    override fun onCleared() {
        super.onCleared()
    }
}
