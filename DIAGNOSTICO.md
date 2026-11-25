
# Diagnóstico de arquitectura

## Laboratorio 07-A - Clean Architecture
Modalidad: Individual

## Responsabilidades de SistemaBancario

| Responsabilidad | Código involucrado | Cambio que afectaría la clase |
|---|---|---|
| Capturar datos | Scanner | Implementar una interfaz gráfica |
| Validar operaciones | Condiciones if | Cambiar las reglas bancarias |
| Actualizar saldos | Variable saldo | Modificar el manejo de importes |
| Guardar movimientos | FileWriter | Migrar a una base de datos |
| Mostrar resultados | System.out.println | Cambiar la presentación |
| Coordinar operaciones | Método main | Incorporar nuevas opciones |

## Problemas identificados

- Exceso de responsabilidades en una sola clase.
- Alto acoplamiento entre negocio, presentación y almacenamiento.
- El registro de otra cuenta reemplaza la cuenta anterior.
- El archivo movimientos.txt no permite recuperar la cuenta.
- El tipo double puede generar imprecisiones monetarias.

## Justificación

Se aplica Clean Architecture para separar las responsabilidades,
facilitar el mantenimiento y permitir cambiar la tecnología de
almacenamiento sin modificar las reglas del negocio.
