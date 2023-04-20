# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

---
## 📬 Contacto

🧡 <strong>Cristian Franco</strong></br>
<a href="https://www.linkedin.com/in/cris7cf/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

#### 🔹 ¡Visita mi Portfolio clic aquí! [Link Portfolio](https://noon-syzygy-48b.notion.site/Portafolio-6050536391b546f2974742099ea9f08e) 📃
</br>

## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- Biblioteca JCalendar
- MySql
- Plugin WindowBuilder </br>

---
## ⚠️ Importante! ⚠️

☕ Usar Java versión 8 o superior para compatibilidad. </br></br>
📝 Recomiendo usar el editor de Eclipse para compatibilidad con la Interfaz Gráfica. </br></br>

---

## 🔍 ¡Analizando nuestro repositorio!

### Este es el repositorio de mi proyecto, en el encontrarás:
#### 🔹 src/factory: carpeta con el desarrollo del codigo para esteablecer la conexion con la base de datos de MySQL;
#### 🔹 src/pruebas: carpeta con una pruba para esteablecer la conexion con la base de datos de MySQL exitosa;
#### 🔹 src/modelo: carpeta con todos los getters y setters necesarios para desarrollar el programa;
#### 🔹 src/dao: carpeta con todo el codigo para hacer funcionar la funciones de la interfaz gráfica;
#### 🔹 src/controller: carpeta con toda la implementacion de dao para despues ser ejecutada en las views;
#### 🔹 src/views: carpeta con toda la interfaz gráfica de las pantallas necesarias para desarrollar el programa;
#### 🔹 src/imagenes: carpeta con imágenes que puedes usar en tu proyecto. Siéntete libre de usar otros, si lo deseas;
#### 🔹 src/main: carpeta con la funcion de ejecutar el programa;
</br>


## 🚧 Proyecto

### Al ejecutar el proyecto en Eclipse veremos:

### Menu Pricipal:
- Donde vamos a poder darle click al boton de login que nos mandara a la siguente ventana.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/122054865/233222639-c37e44d7-32da-4567-8a83-7682d0c30e0e.png">
</p>

### Login:
- Aquí vamos a poder ingresar nuestro Usuario y Contraseña donde los datos se corroboraran en la base de datos, en caso de ser validos nos mandara a la ventana siguente.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/122054865/233223062-25d31fb0-8871-4039-9ba1-d346ca26f9a1.png">
</p>

### Menu Usuario:
- Aquí vamos a tener dos opciones: La primera es el "Registro de reservas" y la segunda es "Busqueda". Dependiendo de la seleccion nos mandara a la ventana siguente.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/122054865/233224173-8cdca85a-e4e9-4e53-b344-db5be1589d00.png">
</p>

### Registro reserva:
- Aquí vamos introducir las fechas de entrada y salida, con esos datos se va a generar un valor a pagar, el ultimo dato es como se desea realizar el pago de ese valor. Despues de dar en siguente nos mandara a la ventana de Registro de Huesped.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/122054865/233224986-f0e3e3d3-0b2a-4f43-a242-c4d59c421382.png">
</p>

### Registro huesped:
- Aquí vamos introducir los datos que nos piden y automaticamente se va a generar un id de reserva, éste tiene una Foregin Key. Despues para confirmar que todos los datos fueron guardados con exito aparecera una ventana, al dar "Ok" nos mandara a la ventana de Menu Usuario.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/122054865/233225522-c7f21b4e-b262-49c8-876b-38450e75c749.png">
</p>
<p align="center" >
     ![image](https://user-images.githubusercontent.com/122054865/233225863-1e4487fd-0abf-4de7-b423-583df74a0879.png)
</p>

### Busqueda:
- En esta ultima ventana vamos a poder: hacer una busqueda de las reservas y huespedes mediante el id, editar y eliminar datos de las tabas de reservas y huespedes.

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/122054865/233226524-75bfe63b-b684-47b2-b5de-2abc28321339.png">
</p>


## 📊 Base de Dados

### Modelado de tablas:

Para este reto tenemos dos tablas: <strong>Reservas</strong> y <strong>Huéspedes</strong>. La tabla de huéspedes contiene la clave externa <em>(foreign key)</em> <strong>idReserva</strong>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/169529338-09a4d4c2-1b5a-41dc-b305-38498ebc29a8.png">
</p>
