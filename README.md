
# Laboratorio 07-A - Clean Architecture

## Datos del estudiante

- Estudiante: Alex Mauricio Pizarro Acori
- Código: 27222109
- Curso: Construcción y Evolución de Software
- Universidad: UNSCH
- Modalidad: Individual

## Descripción

Sistema bancario desarrollado en Java aplicando los principios
de Clean Architecture.

## Requisitos

- JDK 17 o superior.
- IntelliJ IDEA.
- Git.

## Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Ingresar al paquete infraestructura.
3. Ejecutar la clase Main.java.
4. Seleccionar una opción del menú.

## Estructura

- Dominio: CuentaBancaria.
- Aplicación: CuentaService y MovimientoRepository.
- Infraestructura: ArchivoMovimientoRepository y Main.

## Regla de dependencias

El dominio no depende de otras capas. La aplicación depende
del dominio y utiliza una interfaz para registrar movimientos.
La infraestructura implementa dicha interfaz.

## Mejoras realizadas

- Separación de responsabilidades.
- Inversión de dependencias.
- Validación de operaciones bancarias.
- Prevención del registro múltiple de cuentas.
- Uso de BigDecimal para evitar errores de precisión.
- Manejo de excepciones.

## Limitaciones

El archivo movimientos.txt almacena el historial de operaciones,
pero no permite recuperar automáticamente la cuenta al reiniciar.
