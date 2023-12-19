package uz.smartcafe.feature.kittens

import uz.smartcafe.feature.kittens.KittenView.Event
import uz.smartcafe.feature.kittens.KittenView.Model
import uz.smartcafe.feature.mvi.MviView

interface KittenView : MviView<Model, Event> {

    data class Model(
        val isLoading: Boolean,
        val isError: Boolean,
        val imageUrls: List<String>
    )

    sealed class Event {
        object RefreshTriggered : Event()
    }
}