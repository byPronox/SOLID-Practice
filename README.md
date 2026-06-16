# SOLID Principles Refactoring - Comprehensive Implementation

**Author:** [byPronox](https://github.com/byPronox)

This repository contains the technical refactoring of five software modules to strictly comply with the SOLID principles of object-oriented design and clean architecture.

---

## 🇬🇧 English Section

### 1. Single Responsibility Principle (SRP)
* **Architectural Problem:** The `UserManager` class exhibited high coupling and low cohesion by managing business logic validation, database persistence, and external notifications simultaneously. This created multiple axes of change.
* **Technical Solution:** Separation of Concerns (SoC) was achieved by splitting the monolithic class into three independent, highly cohesive modules: `UserValidator`, `UserRepository`, and `NotificationService`. The `UserManager` now acts solely as an orchestrator.
* **Reflection:** Applying SRP significantly reduces cognitive load and minimizes merge conflicts in version control. By isolating responsibilities, changes in infrastructure layers (like database interactions) no longer risk breaking core business logic. The modularity achieved makes unit testing straightforward and highly reliable.

### 2. Open/Closed Principle (OCP)
* **Architectural Problem:** The `NotificationService` relied heavily on hardcoded `if/else` control flow blocks, violating OCP by requiring direct modifications to existing code whenever a new notification channel was introduced.
* **Technical Solution:** Polymorphism was implemented via a `Notification` interface. New notification types (Email, SMS, Push) are now encapsulated in their own concrete classes following the Strategy Pattern, allowing system extension without modifying the base service.
* **Reflection:** OCP is crucial for the long-term extensibility of any software. By depending on abstractions, adding new features becomes a strictly additive process. This prevents the introduction of regression bugs in tested, production-ready code, proving that the system is open for extension but firmly closed for modification.

### 3. Liskov Substitution Principle (LSP)
* **Architectural Problem:** Subclasses like `Fish` inherited from a base `Animal` class but were forced to inherit an inapplicable `walk()` method. This broke the base class contract, leading to `UnsupportedOperationException` runtime errors.
* **Technical Solution:** Behavioral segregation was applied. Movement capabilities were abstracted into a specific `Walkable` interface. Only entities capable of fulfilling this contract implement it, restoring total substitutability.
* **Reflection:** LSP enforces strict architectural integrity and Design by Contract. If a derived class cannot fully substitute its parent, the system becomes fragile, requiring defensive programming (like type checking). This refactoring eliminates unexpected runtime exceptions and ensures predictable polymorphic behavior.

### 4. Interface Segregation Principle (ISP)
* **Architectural Problem:** The monolithic `Device` interface forced lightweight clients (e.g., `DisposableCamera`) to implement an irrelevant `charge()` method, creating "fat" interfaces and dummy implementations.
* **Technical Solution:** Interface segregation was utilized to fracture the monolithic behavior into granular, client-specific contracts: `Switchable` and `Chargeable`. Clients now strictly depend only on the methods they invoke.
* **Reflection:** ISP prevents unnecessary recompilations and deep coupling. Highly cohesive, targeted interfaces make the codebase modular. It prevents "pollution" of classes with methods they do not need, making the architecture cleaner and easier to mock during the testing phase.

### 5. Dependency Inversion Principle (DIP)
* **Architectural Problem:** The high-level module `PaymentProcessor` was tightly coupled to the low-level detail `CreditCardPayment`, making it impossible to scale the payment system without invasive code changes.
* **Technical Solution:** Dependency injection via the constructor was implemented. Both high-level and low-level layers now depend on the `PaymentMethod` abstraction, completely decoupling the execution context from the specific implementation.
* **Reflection:** DIP is the backbone of scalable architectures. By inverting dependencies, components become plug-and-play. In modern infrastructures, such as SaaS RAG systems or microservices, this principle is vital; it allows swapping out underlying components (like databases, external APIs, or AI models) seamlessly without rewriting the core orchestrating logic.

---

## 🇪🇸 Sección en Español

### 1. Single Responsibility Principle (SRP)
* **Problema Arquitectónico:** La clase `UserManager` poseía alto acoplamiento y baja cohesión al gestionar simultáneamente validación de negocio, persistencia en base de datos y notificaciones. Esto generaba múltiples razones de cambio.
* **Solución Técnica:** Se aplicó la Separación de Preocupaciones (SoC), dividiendo la clase monolítica en tres módulos independientes y altamente cohesivos: `UserValidator`, `UserRepository` y `NotificationService`. `UserManager` ahora funciona únicamente como un coordinador o fachada.
* **Reflexión:** Aplicar SRP reduce drásticamente la carga cognitiva y minimiza los conflictos de fusión (merge conflicts). Al aislar responsabilidades, los cambios en las capas de infraestructura no corren el riesgo de romper la lógica de negocio. Esta modularidad facilita la implementación de pruebas unitarias precisas y confiables.

### 2. Open/Closed Principle (OCP)
* **Problema Arquitectónico:** El flujo de envío dependía de bloques de control `if/else` rígidos. Esto violaba el OCP, ya que requería modificar directamente la clase `NotificationService` para soportar nuevos canales.
* **Solución Técnica:** Se implementó polimorfismo mediante una interfaz `Notification`. Los nuevos tipos de notificación se manejan ahora mediante clases concretas (Patrón Estrategia), permitiendo inyectar el comportamiento en tiempo de ejecución.
* **Reflexión:** OCP es fundamental para la extensibilidad del sistema. Al depender de abstracciones, agregar funcionalidades se convierte en un proceso aditivo en lugar de destructivo. Esto evita introducir bugs de regresión en código ya probado, asegurando que la arquitectura esté abierta a la extensión pero cerrada a la modificación.

### 3. Liskov Substitution Principle (LSP)
* **Problema Arquitectónico:** Subclases como `Fish` heredaban de `Animal` un método inaplicable (`walk()`), violando el contrato de la clase base y generando excepciones en tiempo de ejecución (`UnsupportedOperationException`).
* **Solución Técnica:** Se segregó el comportamiento abstracto. La capacidad de movimiento se extrajo hacia una interfaz específica `Walkable`, asegurando que solo las entidades con esta capacidad la implementen, restaurando la sustituibilidad polimórfica.
* **Reflexión:** LSP garantiza el Diseño por Contrato y la integridad del software. Si una subclase no puede cumplir el contrato de su padre, se fomenta la programación defensiva y los sistemas frágiles. Esta refactorización elimina sorpresas en tiempo de ejecución y permite un uso seguro de la herencia.

### 4. Interface Segregation Principle (ISP)
* **Problema Arquitectónico:** La interfaz global `Device` obligaba a la clase `DisposableCamera` a implementar un método `charge()` irrelevante, creando interfaces "gordas" (fat interfaces).
* **Solución Técnica:** Se fraccionó el comportamiento general en contratos específicos y granulares: `Switchable` y `Chargeable`. Las clases ahora dependen de manera estricta y exclusiva de los métodos que realmente utilizan.
* **Reflexión:** ISP previene acoplamientos innecesarios. Las interfaces altamente cohesivas hacen que el código sea modular y previenen la "contaminación" de las clases con métodos inútiles. A nivel práctico, esto facilita la creación de mocks durante las pruebas y hace que el diseño sea semánticamente correcto.

### 5. Dependency Inversion Principle (DIP)
* **Problema Arquitectónico:** El módulo de alto nivel `PaymentProcessor` dependía de forma directa del detalle de bajo nivel `CreditCardPayment`, impidiendo la escalabilidad de la pasarela de pagos.
* **Solución Técnica:** Se generó la abstracción `PaymentMethod`. La dependencia concreta ahora se inyecta mediante el constructor (Inyección de Dependencias), logrando un desacoplamiento total entre las capas.
* **Reflexión:** DIP es el pilar de cualquier arquitectura escalable. Al invertir el flujo de dependencias, los componentes se vuelven intercambiables (plug-and-play). En ecosistemas modernos, como sistemas SaaS RAG o arquitecturas orientadas a microservicios, este principio es vital: permite intercambiar modelos, bases de datos o pasarelas de pago sin reescribir un solo bloque de la lógica central del procesador.