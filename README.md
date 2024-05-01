Course Spring Boot 3, Spring 6 & Hibernate for Beginners on Udemly (Section 10 AOP: Aspect Oriented Programming)

<h2>Aspect-Oriented Programming</h2>

Programming technique based on concept of an Aspect.

Aspect encapsulate cross-cutting-logic.

Concerns are the different aspects of functionality that the software system provides. Separation of Concerns (SoC) is a design principle that manages complexity by partitioning the software system so that each partition is responsible for a separate concern, minimizing the overlap of concerns as much as possible.

Concerns cannot be descomposed from the rest of the systems and it can result in code duplication, significant dependencies between systems or both. For example: logging a history of changes to the record database or user database, an authentication system, security, exception handling, etc.

Advices Types:

Before advice: run before the method </br>
After finally advice: run after the method (finally) </br>
After returning advice: run after the method (success execution) </br>
After throwing advice: run after method (if exception thrown) </br>
Around advice: run before and after method </br>

Concepts:

1. Aspect: module of code for a cross-cutting concern
2. advice: used in methods of aspect classes (@before, @after, etc.). It indicate
what action is taken and when it should be applied
3. JoinPoints: input parameter in advice methods
4. Pointcut expression: a predicate expression to match with name of methods (for where advice
should be applied)
5. ProceedingJointpoint: it is the handle which call the target method
6. Target method: business method
7. Join Point: a point during the execution of a program such as the
execution of a method or the handling of an exception
8. Weaving: when an aspect connects with the target object to create an
advised object. Types: compile-time, load-time, run-time
9. AOP Frameworks: AOP Spring and AspectJ

These programs contain example of how to use this technique.
