package uz.smartcafe.feature.kittens.androidMain

import uz.smartcafe.feature.kittens.datasource.KittenDataSource

internal actual fun KittenDataSource(): KittenDataSource = KittenDataSourceImpl()