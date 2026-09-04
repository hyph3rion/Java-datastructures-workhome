# Sistema de Agendamiento - Consultorio Odontológico
**Actividad Individual 1 - Programación 2**

### Profe, un saludo
Le dejo por acá la entrega del primer taller. Quería aprovechar este espacio para comentarle de primera mano el porqué de mis fallas a las clases presenciales.

Actualmente trabajo liderando el área técnica y de arquitectura en una startup respaldada por fondos de inversión. En estos momentos estamos en plenos despliegues y sustentaciones que me han demandado bastante tiempo, entre auditorías metodológicas con el ICONTEC y revisiones de seguridad técnica con Bizagi. Sumado a eso, en mi experiencia laboral previa con una consultora trabajando para clientes como Cencosud y mi paso previo por la universidad, me acostumbré a trabajar siempre bajo patrones de diseño y arquitecturas limpias desde el día uno.

Por eso mismo me gusta tomar estos talleres no solo para cumplir con la nota, sino como un espacio personal para practicar, investigar y construir código ordenado y mantenible. Sé que el proyecto tiene capas y conceptos que van más allá del ejercicio básico, pero quería dejar claro que es un gusto e iniciativa propia por pulir mi trabajo; no busco para nada alterar el ritmo ni la dinámica que lleva con el resto del curso.


### Dónde revisar la rúbrica del taller
Para que no pierda tiempo navegando entre módulos y pueda calificar directamente lo que pide la guía, todo lo solicitado está concentrado en la pestaña **"Gestión de Pacientes"**:

* **Formulario completo:** En `PanelDatos` están todos los campos pedidos: cédula, nombre, teléfono, tipo de cliente, tipo de atención (con selección única), cantidad, prioridad y selector de fecha[cite: 2].
* **Control de la cantidad:** La caja de texto se ajusta sola según el procedimiento[cite: 2]. Si elige Limpieza o Diagnóstico, se bloquea automáticamente en 1[cite: 2]. Si elige Calzas o Extracción, se habilita para escribir cantidades mayores a cero[cite: 2].
* **Cálculo de tarifas:** El método `calculatePricing()` liquida el valor sumando la tarifa base de la cita más el costo del procedimiento multiplicado por la cantidad[cite: 2].
* **Estadísticas pedidas:** Apenas entra a la pestaña o registra a alguien, el panel de resultados muestra arriba:
  * Total de clientes registrados[cite: 2].
  * Ingresos totales recibidos[cite: 2].
  * Número de clientes para extracción de dientes[cite: 2].
* **Ordenamiento de mayor a menor:** La lista no se muestra al azar; pasa por un ordenamiento por inserción (*Insertion Sort*) en `Controlador` que organiza a los pacientes de mayor a menor según el valor total a pagar[cite: 2].
* **Búsqueda por cédula:** Arriba en el panel de pacientes puede consultar una cédula específica y el sistema le filtra los datos[cite: 2].



### Estructuras de datos utilizadas en el proyecto
Para cumplir con la materia y justificar el manejo de estructuras de datos en memoria, apliqué las siguientes colecciones según su caso de uso:

* **`HashMap<Integer, Cliente>`, `HashMap<Integer, Doctor>` y `HashMap<String, Cliente>`:** Utilizados como tablas hash clave-valor en la capa de persistencia (los DAO) y en las citas del consultorio para lograr indexación y búsquedas inmediatas en tiempo constante O(1) por cédula, ID o código de cita[cite: 2].
* **`ArrayList<Cliente>` y `ArrayList<Doctor>`:** Empleados para mantener las secuencias dinámicas en memoria cuando se necesita iterar, volcar datos a los `JTextArea`, filtrar y alimentar los algoritmos de ordenamiento[cite: 2].
* **`List<T>` (Polimorfismo de interfaces):** Utilizado en firmas de métodos y retornos (`listarTodos()`, algoritmos de ordenamiento) para programar contra abstracciones en lugar de acoplarse a implementaciones concretas[cite: 2].
* **Arreglos nativos (`String[]`):** Usados dentro de la entidad `Cliente` para manejar atributos atómicos como el tipo de cliente y la prioridad de atención, cumpliendo con el manejo de arreglos básicos requerido en la guía[cite: 2].
* **Cola de turnos sobre lista dinámica (ArrayList): Implementada en Consultorio para simular la cola de espera de pacientes bajo un flujo secuencial estándar (FIFO). La incluí meramente a modo de práctica e investigación personal, manteniendo la lógica acotada para no pisar ni adelantar por completo el manejo formal de prioridades (urgente vs. normal) previsto para la asignación 2.



### Extras de arquitectura y buenas prácticas
* **Patrón MVC y DAO:** La vista no toca datos directamente; todo el flujo pasa por el controlador y clases DAO independientes (`ClienteDao`, `DoctorDao`, `ConsultorioDao`)[cite: 2].
* **Persistencia binaria:** Implementé serialización con archivos binarios `.dat` (`pacientes.dat`, `doctores.dat`, `consultorios.dat`) para no perder la información al cerrar la app[cite: 2].
* **Java 21 limpio:** Usé `enum` con lógica interna de tarifas (`ClientType`, `ProcedureType`) y un `record` inmutable (`PricingBreakdown`) para transportar las liquidaciones[cite: 2].
* **Auditoría:** Manejo de un archivo plano `cancelaciones.log` que exige justificación obligatoria al cancelar turnos[cite: 2].

### Cómo correrlo
* **Java:** Diseñado sobre Java 21 LTS[cite: 2].
* **Ejecución:** En Eclipse o cualquier IDE, correr el archivo `controller.main.java`[cite: 2].
* **Código fuente:** En el repositorio va la carpeta limpia `/src` para evitar líos de compilación entre versiones de JDK[cite: 2].
