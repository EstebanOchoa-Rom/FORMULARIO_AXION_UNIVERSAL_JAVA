# 🛠️ ESPECIFICACIÓN DE REQUERIMIENTOS // PROJECT: AXION_FORMULARIO_UNIVERSAL
### Documento Técnico de Requisitos del Sistema (v3.0.0)

Este documento detalla los requerimientos de hardware, software, dependencias y las capacidades funcionales/no funcionales de la **Consola Central de Registro Operativo AXION**.

---

## 1. Requerimientos del Entorno de Desarrollo y Ejecución (Hardware & Software)

### 1.1 Entorno del Servidor de Base de Datos
* **Motor de Base de Datos:** MySQL Server v8.0 o superior / MariaDB v10.4 o superior.
* **Puerto de Enlace Predeterminado:** `3306` (Configurable en `Conexion.java`).
* **Codificación de Caracteres:** `utf8mb4_unicode_ci` (Para asegurar compatibilidad con caracteres especiales y símbolos).

### 1.2 Entorno de la Aplicación Cliente (Compilación y Ejecución)
* **Java Development Kit (JDK):** Versión 17 LTS mínima requerida. *(Recomendado: JDK 21 LTS o JDK 26 para soporte completo de las características del compilador).*
* **Arquitectura de Sistema Operativo:** Compatible con arquitecturas x86_64 (Windows, GNU/Linux, macOS) gracias a la portabilidad nativa de la Máquina Virtual de Java (JVM).
* **Resolución Mínima de Pantalla:** 1280 x 720 píxeles (Dimensiones nativas fijadas de la UI: `1120 x 720` sin redimensionamiento para evitar clipping estético).

---

## 2. Dependencias de Librerías Externas (Stack Tecnológico)

El proyecto depende de dos módulos binarios (`.jar`) externos que deben estar presentes en el Classpath de compilación y en la carpeta de distribución `lib/`:

1. **`flatlaf-3.5.1.jar`**
   * **Tipo:** Look and Feel / Biblioteca Gráfica.
   * **Función:** Reemplaza el motor nativo de Swing (Metal/Nimbus) por un entorno gráfico optimizado de alto rendimiento con renderizado anti-aliasing automático, soporte para placeholders avanzados en text fields y estilización en modo oscuro (`FlatDarkLaf`).
2. **`mysql-connector-j-9.7.0.jar`**
   * **Tipo:** Controlador JDBC (Java Database Connectivity).
   * **Función:** Implementa los protocolos de red necesarios para permitir la comunicación bidireccional segura entre las consultas SQL ejecutadas por el `UsuarioDAO.java` y el motor MySQL remoto o local.

---

## 3. Requerimientos Funcionales (RF)

El sistema operativo de la consola debe ejecutar sin excepciones las siguientes operaciones de flujo:

* **RF-01 [Registro de Operador]:** El sistema debe permitir la inyección de un nuevo registro con los campos: Nombre, Correo, Clave (enmascarada), Teléfono, Tipo de cuenta y Entidad Corporativa.
* **RF-02 [Validación Estricta de Campos]:** El sistema no debe procesar registros si el campo 'Nombre' o 'Clave' están vacíos, o si el campo 'Correo de Enlace' carece del formato de dirección sintáctica válido (debe contener `@`).
* **RF-03 [Interfaz Reactiva de Tipo de Cuenta]:** Al conmutar el selector `Nivel de Acceso`, si la opción elegida es diferente a "Persona", la UI debe revelar dinámicamente el campo de texto e indicador para "Matriz de Organización / Corporación". Si se selecciona "Persona", dicho campo debe ocultarse de forma inmediata.
* **RF-04 [Sincronización del Datafeed]:** El sistema debe leer en tiempo real la tabla de la base de datos y renderizarla en un componente tabular limpio cada vez que se inicie la aplicación o se presione el comando de sincronización.
* **RF-05 [Alteración / Edición de Registros]:** Al seleccionar una fila activa de la tabla y ejecutar el comando de alteración, el formulario debe precargarse con la información existente permitiendo su actualización en la base de datos sin duplicar el registro.
* **RF-06 [Purga de Datos Seguro]:** Al ejecutar la eliminación de un nodo de datos, el sistema debe lanzar un cuadro de diálogo de advertencia crítico con confirmación doble (`YES/NO Option`) antes de remover de manera permanente el registro mediante la sentencia `DELETE`.

---

## 4. Requerimientos No Funcionales (RNF)

* **RNF-01 [Estética Avanzada HUD / No-IA]:** La interfaz gráfica debe alejarse de los layouts tradicionales de formularios corporativos grises. Debe emplear paletas de colores ultra oscuros (`#0A0C12`, `#121621`), tipografías monoespaciadas estilo terminal táctil militar, y micro-componentes de renderizado personalizado mediante la clase extendida `NeonPanel` y `Graphics2D`.
* **RNF-02 [Rendimiento y Telemetría]:** El procesamiento de la tabla local y el renderizado de filas bajo el efecto cebra personalizado no debe generar lags ni congelamientos en el hilo de despacho de eventos de Swing (EDT). El conteo analítico de la tarjeta HUD debe formatearse automáticamente a 3 dígitos (`%03d`).
* **RNF-03 [Portabilidad y Cero Configuración]:** El software compilado debe empaquetarse de manera autónoma en una estructura `dist/` transportable, garantizando que el archivo ejecutable `.jar` localice automáticamente sus dependencias de UI y base de datos dentro de la carpeta relativa `./lib/` sin requerir instalaciones del sistema global o variables de entorno adicionales.

---
_Especificación de Requerimientos Generada Exclusivamente para el Sistema Operativo AXION v3.0._
