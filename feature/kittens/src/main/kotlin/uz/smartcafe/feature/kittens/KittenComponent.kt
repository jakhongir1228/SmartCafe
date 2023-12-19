package uz.smartcafe.feature.kittens

import uz.smartcafe.feature.kittens.KittenView.Event
import uz.smartcafe.feature.kittens.datasource.KittenDataSource
import uz.smartcafe.feature.kittens.integration.KittenStoreNetwork
import uz.smartcafe.feature.kittens.integration.KittenStoreParser
import uz.smartcafe.feature.kittens.integration.toIntent
import uz.smartcafe.feature.kittens.integration.toModel
import uz.smartcafe.feature.kittens.store.KittenStore.State
import uz.smartcafe.feature.kittens.store.KittenStoreImpl
import com.badoo.reaktive.disposable.scope.DisposableScope
import com.badoo.reaktive.disposable.scope.disposableScope
import com.badoo.reaktive.observable.map
class KittenComponent internal constructor(dataSource: KittenDataSource) {

    constructor() : this(KittenDataSource())

    private val store =
        KittenStoreImpl(
            network = KittenStoreNetwork(dataSource = dataSource),
            parser = KittenStoreParser
        )

    private var view: KittenView? = null
    private var startStopScope: DisposableScope? = null

    fun onViewCreated(view: KittenView) {
        this.view = view
    }

    fun onStart() {
        val view = requireNotNull(view)

        startStopScope = disposableScope {
            store.map(State::toModel).subscribeScoped(onNext = view::render)
            view.events.map(Event::toIntent).subscribeScoped(onNext = store::onNext)
        }
    }

    fun onStop() {
        requireNotNull(startStopScope).dispose()
    }

    fun onViewDestroyed() {
        view = null
    }

    fun onDestroy() {
        store.dispose()
    }
}