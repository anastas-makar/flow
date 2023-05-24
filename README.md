# Flow Library

Flow is a library for date navigation in your app using Jetpack Compose.

## Description

Flow allows you to create date navigation in your app with a user-friendly interface. The library provides a flexible way to display content associated with each individual date. It utilizes the Jetpack Compose library for building the user interface.
Features

*    Support for horizontal and vertical scrolling.
*    Synchronization of horizontal and vertical scrolling: when one component is scrolled, the other automatically scrolls to the corresponding date.
*    Calendar component for date selection with month scrolling and manual date input.
*    Flexible customization of the displayed content for each date.

## Example Usage

```kotlin

class FlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calendar { date: LocalDate -> MyText(date) }
        }
    }
}

@Composable
fun MyText(date: LocalDate) {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.getDefault())
    Text(
        text = "HELLO! Date: " + date.format(formatter),
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun CustomLayoutWithRecyclerViewPreview() {
    Calendar { date: LocalDate -> MyText(date) }
}
```

## Installation

To use Flow in your project, follow these steps:

*    In your module's build.gradle file, add the following dependencies:

```groovy

dependencies {
    implementation 'androidx.compose.ui:ui:1.1.0'
    implementation 'androidx.compose.ui:ui-tooling-preview:1.1.0'
    implementation 'androidx.compose.material:material:1.1.0'
// Other Jetpack Compose dependencies...
}
```

*    Add the Flow library to your project.

## License

Flow is distributed under the MIT License. See the LICENSE file for more information.
