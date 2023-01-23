package pro.ksart.bicyclefactory.data.entity

class WheelSupplier {

    fun getWheels(): Pair<Wheel, Wheel> = getWheel() to getWheel()

    private fun getWheel() = Wheel(serialNumber = (1_000_001L..1000_000_000L).random())
}
