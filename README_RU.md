# Flow Library

Flow - это библиотека для управления навигацией по датам в приложении с использованием Jetpack Compose.

## Описание

Flow позволяет создавать навигацию по датам в вашем приложении с помощью удобного пользовательского интерфейса. Библиотека предоставляет гибкий способ отображения контента, связанного с каждой отдельной датой. Она использует библиотеку Jetpack Compose для построения пользовательского интерфейса.

## Особенности

*    Поддержка горизонтального и вертикального скроллинга.
*    Синхронизация горизонтального и вертикального скроллинга: при прокрутке одного компонента, другой автоматически скроллится до соответствующей даты.
*    Компонент календаря для выбора даты с возможностью листания месяцев и ручного ввода даты.
*    Гибкая настройка отображаемого контента для каждой даты.

## Пример использования

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

## Установка

Для использования Flow в вашем проекте, вам необходимо выполнить следующие шаги:

*    В файле build.gradle вашего модуля добавьте следующие зависимости:

```groovy

dependencies {
    implementation 'androidx.compose.ui:ui:1.1.0'
    implementation 'androidx.compose.ui:ui-tooling-preview:1.1.0'
    implementation 'androidx.compose.material:material:1.1.0'
// Другие зависимости Jetpack Compose...
}
```

*    Добавьте библиотеку Flow в ваш проект.

## Лицензия

Flow распространяется под лицензией MIT. Подробную информацию о лицензии можно найти в файле LICENSE.