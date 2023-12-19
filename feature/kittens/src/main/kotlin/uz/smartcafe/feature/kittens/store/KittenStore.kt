package uz.smartcafe.feature.kittens.store

import uz.smartcafe.feature.kittens.store.KittenStore.Intent
import uz.smartcafe.feature.kittens.store.KittenStore.State
import uz.smartcafe.feature.mvi.Store

internal interface KittenStore : Store<Intent, State>{
    sealed class Intent{
        object ReLoad:Intent()
    }
    data class State(
        val isLoading:Boolean = false,
        val data: Data
    ){
        sealed class Data{
            data class Images(val urls:List<String> = emptyList()):Data()

            object Error: Data()
        }
    }
}