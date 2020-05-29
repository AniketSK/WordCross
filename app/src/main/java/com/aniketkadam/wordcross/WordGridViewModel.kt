package com.aniketkadam.wordcross

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordGridViewModel(
    private val wordChecker: WordChecker,
    private val wordGrid: WordGrid
) : ViewModel() {

    private val pWordGridDisplay = MutableLiveData<List<Char>?>()

    val wordGridDisplay: LiveData<List<Char>?>
        get() = pWordGridDisplay

    fun startNewGame() {
        pWordGridDisplay.postValue(wordGrid.generateLetterGrid())
    }

    override fun onCleared() {
        super.onCleared()
    }
}
