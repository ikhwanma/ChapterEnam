package ikhwan.binar.chapterenam.datastore.latihandatastoresatu

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LatihanSatuDataStoreManager(context: Context) {
    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs")
    private val loginDataStore : DataStore<Preferences> = context.createDataStore(name = "login_prefs")

    suspend fun registerUser(userName:String, password: String){
        dataStore.edit {
            it[USERNAME] = userName
            it[PASSWORD] = password
        }
    }

    suspend fun setLogin(boolean: Boolean){
        loginDataStore.edit {
            it[BOOLEAN] = boolean
        }
    }

    suspend fun clearData(){
        loginDataStore.edit {
            it.clear()
        }
    }

    val userName: Flow<String> = dataStore.data.map {
        it[USERNAME] ?: ""
    }

    val password: Flow<String> = dataStore.data.map {
        it[PASSWORD] ?: ""
    }

    val boolean: Flow<Boolean> = loginDataStore.data.map {
        it[BOOLEAN] ?: false
    }

    companion object{
        val USERNAME = preferencesKey<String>("USER_USERNAME")
        val PASSWORD = preferencesKey<String>("USER_PASSWORD")
        val BOOLEAN = preferencesKey<Boolean>("USER_BOOLEAN")
    }
}