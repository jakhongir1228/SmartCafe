package uz.smartcafe.feature.kittens.integration

import com.badoo.reaktive.maybe.Maybe
import uz.smartcafe.feature.kittens.datasource.KittenDataSource
import uz.smartcafe.feature.kittens.store.KittenStoreImpl

internal class KittenStoreNetwork(
    private val dataSource: KittenDataSource
) : KittenStoreImpl.Network {

    override fun load(): Maybe<String> = dataSource.load(limit = 50, page = 0)
}