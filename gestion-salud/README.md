## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# 🏥 Sistema de Gestión de Órdenes Médicas y Turnos

Aplicación desarrollada en Java con base de datos MySQL para la gestión de pacientes, turnos y órdenes médicas en consultorios de salud.

---

## 🧠 Descripción

El sistema permite digitalizar y optimizar procesos administrativos en el ámbito de la salud, reduciendo errores y mejorando la trazabilidad de la información.

Incluye funcionalidades para:

- Registro de pacientes
- Gestión de turnos (con validación de disponibilidad)
- Registro de órdenes médicas
- Asociación con obras sociales
- Persistencia de datos en MySQL

---

## 🧱 Tecnologías utilizadas

- Java (JDK)
- MySQL
- JDBC (MySQL Connector/J)
- Visual Studio Code

---

## 📦 Dependencias

### MySQL Connector/J

Descargar desde:

https://dev.mysql.com/downloads/connector/j/

👉 Elegir: **Platform Independent (ZIP)**  
👉 Extraer `.jar` y colocarlo en:

```text
lib/sz
