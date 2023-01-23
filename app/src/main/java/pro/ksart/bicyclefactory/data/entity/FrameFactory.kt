package pro.ksart.bicyclefactory.data.entity

class FrameFactory {
    fun getFrame(color: Colors, serialNumber: Long): Frame {
        return Frame(
            serialNumber=serialNumber,
            color = color)
    }
}
