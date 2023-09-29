import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun TestButton(text: String) {
    val displayHover = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
    ) {
        Button(
            onClick = {
                displayHover.value = true
            },
            modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
        ) {
            Text(text)
        }
        DropdownMenu(
            displayHover.value,
            onDismissRequest = {
                displayHover.value = false
            },
            modifier = Modifier.background(MaterialTheme.colors.background),
        ) {
            Row(Modifier.width(200.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "My tooltip",
                )
                Text(
                    text = "2 tooltip",
                )
            }

        }
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
            TestButton("Hello, World!")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
