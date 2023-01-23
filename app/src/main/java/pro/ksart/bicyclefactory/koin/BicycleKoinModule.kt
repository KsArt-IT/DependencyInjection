package pro.ksart.bicyclefactory.koin

import org.koin.dsl.module
import pro.ksart.bicyclefactory.data.entity.BicycleFactory

val bicycleModule = module {
    factory { BicycleFactory(get(), get()) }
}
