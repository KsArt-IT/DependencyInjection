package pro.ksart.bicyclefactory.dagger

import dagger.Module
import dagger.Provides
import pro.ksart.bicyclefactory.data.entity.BicycleFactory
import pro.ksart.bicyclefactory.data.entity.FrameFactory
import pro.ksart.bicyclefactory.data.entity.WheelSupplier

@Module
class BicycleModule {

    @Provides
    fun provideBicycleFactory(
        frameFactory: FrameFactory,
        wheelSupplier: WheelSupplier
    ): BicycleFactory {
        return BicycleFactory(frameFactory, wheelSupplier)
    }
}
