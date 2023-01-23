package pro.ksart.bicyclefactory.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.java.KoinJavaComponent.inject
import pro.ksart.bicyclefactory.appComponent
import pro.ksart.bicyclefactory.data.entity.BicycleFactory
import pro.ksart.bicyclefactory.data.entity.Colors
import pro.ksart.bicyclefactory.data.entity.Logo
import kotlin.random.Random

@Composable
fun showDIScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                val bicycleFactory = context.appComponent.getBicycleFactory()
                manufacturedBike(context, "Dagger", bicycleFactory)
            }) {
                Text(text = "Dagger")
            }
            Spacer(
                modifier = Modifier
                    .width(32.dp)
            )
            Button(onClick = {
                val bicycleFactory: BicycleFactory by inject(BicycleFactory::class.java)
                manufacturedBike(context, "Koin", bicycleFactory)
            }) {
                Text(text = "Koin")
            }
        }
    }
}

private fun manufacturedBike(context: Context, diName: String, bicycleFactory: BicycleFactory) {
    val bicycle = bicycleFactory.build(
        logo = Logo.values()[Random.nextInt(Logo.values().size)],
        color = Colors((0..0xFFFFFF).random())
    )
    context.showToast(
        "$diName: manufactured bike with:\n" +
            "Logo: ${bicycle.logo.id}\n" +
            "Frame: ${bicycle.frame.serialNumber} - ${bicycle.frame.color.rgb}\n" +
            "Wheels: ${bicycle.wheelFirst.serialNumber} - ${bicycle.wheelsSecond.serialNumber}"
    )
}

@Preview
@Composable
fun viewDIScreen() {
    showDIScreen()
}
