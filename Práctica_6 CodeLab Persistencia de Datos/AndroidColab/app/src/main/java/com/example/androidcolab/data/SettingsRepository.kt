package com.example.androidcolab.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepository(private val dataStore: DataStore<Preferences>) {


    suspend fun saveValues(name:String, checked:Boolean){
        dataStore.edit { preference ->
            preference[stringPreferencesKey("name")] = name
            preference[booleanPreferencesKey("vip")] = checked
        }
    }

    fun getValues()= dataStore.data.map { preference ->
        UserProfile(
            name = preference[stringPreferencesKey("name")].orEmpty(),
            vip =  preference[booleanPreferencesKey("vip")]?:false
        )
    }

}
