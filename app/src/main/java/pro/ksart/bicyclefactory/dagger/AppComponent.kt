package pro.ksart.bicyclefactory.dagger

import dagger.Component
import pro.ksart.bicyclefactory.data.entity.BicycleFactory
import javax.inject.Singleton

@Singleton
@Component(modules = [BicycleModule::class, OtherFactoryModule::class])
interface AppComponent {

    fun getBicycleFactory(): BicycleFactory
}
