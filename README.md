# CalculadoraCursoProm

## Descripción

CalculadoraCursoProm es una aplicación de calculadora simple desarrollada en Kotlin para Android. La aplicación permite a los usuarios realizar operaciones básicas como suma, resta, multiplicación y división.

## Requisitos

- Android Studio
- SDK de Android 21 o superior
- Conocimientos básicos de programación en Kotlin y desarrollo de aplicaciones Android

## Estructura del Proyecto

El proyecto contiene una sola actividad principal `MainActivity` que gestiona la interfaz de usuario y las operaciones de la calculadora.

### Archivos Clave

- **MainActivity.kt**: Clase principal de la aplicación, que extiende `AppCompatActivity` e implementa `View.OnClickListener`.
- **activity_main.xml**: Layout de la interfaz de usuario de la calculadora.

## Funcionalidades

- **Interfaz de usuario intuitiva**: Permite la entrada de números y operaciones mediante botones.
- **Operaciones soportadas**: Suma, resta, multiplicación y división.
- **Entrada de números**: Los usuarios pueden ingresar números de forma secuencial y ver el resultado en pantalla.
- **Reinicio**: Opción para limpiar la pantalla y reiniciar los números y la operación.

## Uso

1. **Inicialización**: La aplicación se inicializa con un valor de `0` en la pantalla.
2. **Ingresar Números**: Presiona los botones numéricos (0-9) para ingresar los números.
3. **Seleccionar Operación**: Presiona los botones de operación (+, -, x, /) para seleccionar la operación deseada.
4. **Calcular Resultado**: Presiona el botón `=` para calcular y mostrar el resultado.
5. **Limpiar**: Presiona el botón `C` para reiniciar la calculadora.

## Implementación

### MainActivity.kt

La clase `MainActivity` gestiona la lógica de la calculadora, incluyendo:

- Inicialización del binding para acceder a las vistas del layout.
- Manejo de eventos de clic para los botones numéricos y de operación.
- Métodos para procesar entradas numéricas, seleccionar operaciones y calcular resultados.

### Métodos

1. **onCreate(savedInstanceState: Bundle?)**:
    - Método llamado al crear la actividad. Inicializa el binding y configura los listeners para los botones de la calculadora.

2. **onClick(view: View?)**:
    - Maneja los eventos de clic en los botones de la calculadora. Dependiendo del botón presionado, llama al método correspondiente para procesar números u operaciones.

3. **onNumberPressed(number: String)**:
    - Maneja la entrada de números. Actualiza la pantalla con el número presionado y verifica si hay una operación en curso.

4. **renderScreen(number: String)**:
    - Actualiza la pantalla de la calculadora con el número proporcionado, concatenando el nuevo número a lo que ya se muestra.

5. **checkOperation()**:
    - Verifica si hay una operación activa. Si no hay operación, asigna el primer número, de lo contrario, asigna el segundo número.

6. **onOperationPressed(operation: String)**:
    - Maneja la selección de una operación. Almacena la operación seleccionada y establece el primer número.

7. **onEqualPressed()**:
    - Método que se ejecuta al presionar el botón de igual. Realiza la operación seleccionada y muestra el resultado en la pantalla.

8. **onClearPressed()**:
    - Método que reinicia la calculadora. Limpia la pantalla y restablece los números y la operación a su estado inicial.