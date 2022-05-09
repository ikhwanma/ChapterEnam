package ikhwan.binar.chapterenam.datastore.kelassatu

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class KelasDataStoreManager(context: Context) {

    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs")

    suspend fun saveData(name:String, age: Int){
        dataStore.edit {
            it[NAME] = name
            it[AGE] = age
        }
    }

    suspend fun clearData(){
        dataStore.edit {
            it.clear()
        }
    }

    val userName : Flow<String> = dataStore.data.map {
        it[NAME] ?: ""
    }

    val userAge : Flow<Int> = dataStore.data.map {
        it[AGE] ?: 0
    }

    companion object{
        val NAME = preferencesKey<String>("USER_NAME")
        val AGE = preferencesKey<Int>("USER_AGE")
    }

}