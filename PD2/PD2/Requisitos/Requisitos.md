# Requisitos: Sistema de stands de la Filey

## 1. Descripción
Sistema que abstrae la gestión de stands de la feria: permite a los expositores consultar el mapa de stands, reservar uno y pagar el anticipo, y al administrador mantener el catálogo de stands.

## 2. Actores
| Actor | Descripción |
|---|---|
| Expositor | Persona o negocio que quiere rentar un stand |
| Administrador | Personal de la feria que gestiona los stands |

## 3. Requisitos funcionales
| ID | Requisito | Prioridad |
|---|---|---|
| RF-01 | El sistema debe mostrar el mapa con todos los stands, su tipo, zona, medidas, precio y estado | Alta |
| RF-02 | El sistema debe permitir consultar los stands disponibles | Alta |
| RF-03 | El sistema debe permitir filtrar los stands por zona (gastronómica, artesanal, comercial) | Media |
| RF-04 | El sistema debe calcular los metros cuadrados de cada stand (largo × ancho) | Alta |
| RF-05 | El sistema debe calcular el precio según el tipo de stand (gastronómico: cargo por servicios; artesanal: descuento; comercial: recargo por ubicación) | Alta |
| RF-06 | El expositor debe poder reservar un stand disponible | Alta |
| RF-07 | El sistema debe rechazar la reserva de un stand que no esté disponible | Alta |
| RF-08 | El sistema debe calcular el anticipo (30 %) y el saldo de cada reserva | Alta |
| RF-09 | El expositor debe poder pagar el anticipo con tarjeta o transferencia | Alta |
| RF-10 | Al confirmarse el pago, la reserva pasa a CONFIRMADA y el stand a OCUPADO | Alta |
| RF-11 | El expositor debe poder cancelar una reserva y el stand debe quedar disponible | Media |
| RF-12 | El administrador debe poder agregar stands y ponerlos en mantenimiento | Media |
| RF-13 | Un stand en mantenimiento no debe poder reservarse | Alta |

## 4. Requisitos no funcionales
| ID | Requisito |
|---|---|
| RNF-01 | El sistema debe estar desarrollado en Java usando programación orientada a objetos |
| RNF-02 | El diseño debe permitir agregar nuevos tipos de stand o métodos de pago sin modificar las clases existentes |
| RNF-03 | Los datos de cada clase deben estar encapsulados (atributos privados y acceso por métodos) |
| RNF-04 | Los errores (stand no disponible, pago rechazado) deben informarse con mensajes claros |
| RNF-05 | El código debe organizarse en paquetes: modelo, pagos y servicios |

## 5. Reglas de negocio
- Un stand tiene un solo estado a la vez: DISPONIBLE, RESERVADO, OCUPADO o MANTENIMIENTO.
- Una reserva tiene un solo estado: PENDIENTE, CONFIRMADA o CANCELADA.
- Un stand ocupado no puede pasar a mantenimiento.
- El anticipo es el 30 % del precio del stand.
- Las medidas de un stand deben ser mayores a cero.

## 6. Supuestos
- Los precios y porcentajes son valores de ejemplo, ajustables según los datos reales de la Filey.
- El cobro de los pagos es simulado.
