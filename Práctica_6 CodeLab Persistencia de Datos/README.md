# Una vez completado deben subir un documento a esta tarea con la siguiente información:

Enlace al repositorio de Git con el CodeLab

Capturas de pantalla de la App en el emulador

Incluye un apartado en tu informe donde reflejes tu opinión sobre el CodeLab, las dificultades técnicas encontradas y cualquier otro aspecto relevante de tu experiencia




## NOTAS DURANTE COLAB:

### Introducción a la programación en Kotlin


=================   TU PRIMER PROGRAMA KOTLIN
Un programa de Kotlin requiere una función principal como punto de entrada del programa.
Para definir una función en Kotlin, usa la palabra clave fun seguida del nombre de la función, cualquier entrada encerrada entre paréntesis, seguida del cuerpo de la función entre llaves.
El nombre de una función debe seguir la convención de mayúsculas y minúsculas, y comenzar con una letra minúscula.
Usa la llamada a la función println() para imprimir texto en el resultado.
Consulta la guía de estilo de Kotlin para conocer las convenciones de código y formato que debes seguir cuando codifiques en Kotlin.
La solución de problemas es el proceso de resolver errores en tu código.


=================  Crea y usa variables en Kotlin
Una variable es un contenedor de un único dato.
Debes declarar una variable antes de usarla.
Usa la palabra clave val para definir una variable que sea de solo lectura, en la que el valor no puede cambiar una vez que se asigne.
Usa la palabra clave var a fin de definir una variable que sea mutable o modificable.
En Kotlin, se prefiere usar val en lugar de var cuando sea posible.
Para declarar una variable, comienza con la palabra clave val o var. Luego, especifica el nombre de la variable, el tipo de datos y el valor inicial. Por ejemplo: val count: Int = 2.
Con la inferencia de tipo, omite el tipo de datos en la declaración de variable si se proporciona un valor inicial.
Algunos tipos comunes de datos de Kotlin incluyen: Int, String, Boolean, Float y Double.
Usa el operador de asignación (=) para asignar un valor a una variable durante la declaración de la variable o cuando se actualiza la variable.
Solo puedes actualizar una variable que se haya declarado como variable mutable (con var).
Usa el operador de incremento (++) o el operador de disminución (--) para aumentar o disminuir el valor de una variable de número entero en 1, respectivamente.
Usa el símbolo + para concatenar strings. También puedes concatenar variables de otros tipos de datos, como Int y Boolean, a Strings.
Más información



=================  Cómo crear y usar funciones en Kotlin
Las funciones se definen con la palabra clave fun y contienen fragmentos de código reutilizables.
Las funciones facilitan el mantenimiento de los programas más grandes y evitan la repetición innecesaria de código.
Las funciones pueden mostrar un valor que puedes almacenar en una variable para usarlo más tarde.
Las funciones pueden tomar parámetros, que son variables disponibles dentro del cuerpo de una función.
Los argumentos son los valores que pasas cuando llamas a una función.
Puedes nombrar argumentos cuando llamas a una función. Cuando usas argumentos con nombre, puedes reordenarlos sin afectar el resultado.
Puedes especificar un argumento predeterminado que te permita omitirlo cuando llames a una función.




=================  Problemas prácticos: Conceptos básicos de Kotlin

(PROBLEMA 1)

fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
}

¿Puedes definir la función add() de modo que el programa imprima este resultado?

10 + 5 = 15
10 + 8 = 18


Solucion:

fun add(number1:Int, number2:Int):Int {
    return number1 + number2
}


(PROBLEMA 2)



fun main() {
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    println(displayAlertMessage(operatingSystem, emailId))
}

// Define your displayAlertMessage() below this line.



¿Puedes implementar la función displayAlertMessage() en este programa de modo que imprima el resultado que se muestra?




Solucion:


fun displayAlertMessage(operatingSystem: String, emailId: String): String {
    return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
}


(PROBLEMA 3)

¿Puedes cambiar el nombre de las funciones, de los parámetros de las funciones y de las variables utilizados en este programa según las prácticas recomendadas?

fun main() {
    val Steps = 4000
    val caloriesBurned = PEDOMETERstepsTOcalories(Steps);
    println("Walking $Steps steps burns $caloriesBurned calories")
}

fun PEDOMETERstepsTOcalories(NumberOFStepS: Int): Double {
    val CaloriesBURNEDforEachStep = 0.04
    val TotalCALORIESburned = NumberOFStepS * CaloriesBURNEDforEachStep
    return TotalCALORIESburned
}


Solucion: 
fun main() {
    val stepsWalked = 4000
    val caloriesBurned = calculateCaloriesBurned(stepsWalked)
    println("Walking $stepsWalked steps burns $caloriesBurned calories")
}

fun calculateCaloriesBurned(numberOfSteps: Int): Double {
    val caloriesBurnedPerStep = 0.04
    val totalCaloriesBurned = numberOfSteps * caloriesBurnedPerStep
    return totalCaloriesBurned
}




(PROBLEMA 4)

En este ejercicio, implementarás una función que compara la cantidad de minutos que usaste el teléfono hoy y ayer. La función acepta dos parámetros de números enteros y muestra un valor booleano.

El primer parámetro contiene la cantidad de minutos de uso de hoy, y el segundo, la cantidad de minutos de uso de ayer. La función muestra un valor true si pasaste más tiempo en el teléfono hoy que ayer. De lo contrario, muestra un valor false.


Solucion:

fun comparePhoneUsage(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}

fun main() {
    val timeSpentToday = 300
    val timeSpentYesterday = 250

    val result = comparePhoneUsage(timeSpentToday, timeSpentYesterday)

    if (result) {
        println("Pasaste más tiempo en el teléfono hoy que ayer.")
    } else {
        println("No pasaste más tiempo en el teléfono hoy que ayer.")
    }

}
