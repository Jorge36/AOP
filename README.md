Course Spring Boot 3, Spring 6 & Hibernate for Beginners on Udemly

<h2>Aspect-Oriented Programming</h2>

Programming technique based on concept of an Aspect.

Aspect encapsulate cross-cutting-logic.

Concerns cannot be descomposed from the rest of the systems and it can result in code duplication, significant dependencies between systems or both.
For example: logging a history of changes to the record database or user database, an authentication system, security, exception handling, etc.

Advices Types:

Before advice: run before the method
After finally advice: run after the method (finally)
After returning advice: run after the method (success execution)
After throwing advice: run after method (if exception thrown)
Around advice: run before and after method

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
