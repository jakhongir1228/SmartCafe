package uz.smartcafe.feature.kittens.integration

import uz.smartcafe.feature.kittens.KittenView.Model
import uz.smartcafe.feature.kittens.KittenView.Event
import uz.smartcafe.feature.kittens.store.KittenStore.Intent
import uz.smartcafe.feature.kittens.store.KittenStore.State

internal fun State.toModel(): Model =
   Model(
        isLoading = isLoading,
        isError = when (data) {
            is State.Data.Images -> false
            is State.Data.Error -> true
        },
        imageUrls = when (data) {
            is State.Data.Images -> data.urls
            is State.Data.Error -> emptyList()
        }
    )

internal fun Event.toIntent(): Intent =
    when (this) {
        is Event.RefreshTriggered -> Intent.ReLoad
    }