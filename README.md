#Operacion Fuego de Quasar

El siguiente repositiorio contiene la implementacion de un API Rest, con diferentes servicios que permiten recuperar o enviar informacion para obtener datos de la nave de carga o modificar los datos de un satelite.
Esta Aplicacion se encuntra desarrollada utilizando un patron de diseño muy similiar a MVC. Siendo en este caso los controladores quienes se comunican tanto con los modelos y los servicios, para completar las solicitudes.


La documentacion de la API desarrollada con los diferentes endpoints que posee se puede encontar en el siguiente link https://operation-quasar-fire.onrender.com/api/swagger-ui/index.html

A su vez esta API se encunetra deployada en un repositorio en la nube, con lo cual las consultas a los distinos servicios porvistos por esta son accesibles a traves de los as disintas urls:
https://operation-quasar-fire.onrender.com/topsecret
https://operation-quasar-fire.onrender.com/topsecret_split
https://operation-quasar-fire.onrender.com/topsecret_split/{sateliteName}

Para ejecutar la aplicacion localmente primero se debe genear el archivo .JAR ejecutable mediante el comando

./gradlew build

El cual suele alamcenarse dentro de la carpeta build/libs/

Luego ejecutar la aplicaion mediante el comando

./gradlew bootRun

La misma se desplegara dentro del puerto 8009, siendo accesible a traves de la url http://localhost:8009
