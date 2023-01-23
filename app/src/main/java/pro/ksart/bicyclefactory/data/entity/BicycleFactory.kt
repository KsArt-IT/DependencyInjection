package pro.ksart.bicyclefactory.data.entity

data class BicycleFactory(
    private val frameFactory: FrameFactory,
    private val wheelSupplier: WheelSupplier,
) {

    fun build(logo: Logo, color: Colors): Bicycle {

        val wheels = wheelSupplier.getWheels()
        val frame = frameFactory.getFrame(color = color, (1..10L).random())

        return Bicycle(
            frame = frame,
            wheelFirst = wheels.first,
            wheelsSecond = wheels.second,
            logo = logo,
        )
    }
}
