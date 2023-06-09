package com.example.room_practice

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
    //데이터 초기화
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAll(){
        wordDao.deleteAll()
    }
}