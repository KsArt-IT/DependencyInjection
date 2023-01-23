package pro.ksart.bicyclefactory.koin

import org.koin.dsl.module
import pro.ksart.bicyclefactory.data.entity.FrameFactory
import pro.ksart.bicyclefactory.data.entity.WheelSupplier

val otherModule = module {
    single { WheelSupplier() }
    factory { FrameFactory() }
}
