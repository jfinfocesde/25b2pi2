# Ejecutar el archivo JAR desde la consola

## Prerrequisitos

- Java Runtime Environment (JRE) o Java Development Kit (JDK) versión 21 o superior instalado en su sistema
- El archivo JAR del proyecto (`proyecto-integrador-0.0.1-SNAPSHOT.jar`)

## Verificar la instalación de Java

Antes de ejecutar el archivo JAR, verifique que tiene Java instalado correctamente:

```bash
java --version
```

Debería ver una salida similar a:

```
java 21.0.x
Java(TM) SE Runtime Environment...
```

## Comando básico para ejecutar el JAR

1. Abra una terminal o línea de comandos
2. Navegue hasta el directorio donde se encuentra el archivo JAR
3. Ejecute el siguiente comando:

```bash
java -jar proyecto-integrador-0.0.1-SNAPSHOT.jar
```

## Opciones adicionales de ejecución

### Especificar un puerto diferente
Por defecto, la aplicación se ejecuta en el puerto 8080. Para usar un puerto diferente:

```bash
java -jar proyecto-integrador-0.0.1-SNAPSHOT.jar --server.port=8081
```

### Asignar memoria
Para asignar más memoria a la aplicación:

```bash
java -Xmx512m -jar proyecto-integrador-0.0.1-SNAPSHOT.jar
```

## Solución de problemas

### Error: No se encuentra el archivo JAR
- Verifique que está en el directorio correcto
- Confirme que el nombre del archivo es exactamente `proyecto-integrador-0.0.1-SNAPSHOT.jar`

### Error: No se encuentra Java
- Asegúrese de que Java está instalado
- Verifique que la variable de entorno JAVA_HOME está configurada correctamente
- Agregue Java al PATH del sistema

### Error: Puerto en uso
- Verifique si otro proceso está usando el puerto 8080
- Use un puerto diferente como se muestra en las opciones adicionales

## Detener la aplicación

Para detener la aplicación:
1. Windows: Presione `Ctrl + C` en la consola
2. Unix/Linux: Presione `Ctrl + C` o use el comando `kill`

## Notas adicionales

- La aplicación mostrará mensajes de inicio en la consola
- Una vez iniciada, puede acceder a ella a través de `http://localhost:8080`
- Mantenga la ventana de la consola abierta mientras la aplicación esté en ejecución