package pro.ksart.bicyclefactory.dagger

import dagger.Module
import dagger.Provides
import pro.ksart.bicyclefactory.data.entity.FrameFactory
import pro.ksart.bicyclefactory.data.entity.WheelSupplier
import javax.inject.Singleton

@Module
class OtherFactoryModule {

    @Singleton
    @Provides
    fun provideWheelSupplier(): WheelSupplier = WheelSupplier()

    @Singleton
    @Provides
    fun provideFrameFactory(): FrameFactory = FrameFactory()

}
