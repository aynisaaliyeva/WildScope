WildScope

A Java console application for managing a nature documentary collection.
Built step by step while learning Java.

Features

- Add, view, search and remove documentaries
- Three documentary types: General, Ocean and Wildlife
- Rate documentaries (0-10) and mark them as watched
- Sort by rating or duration
- Filter by category, show long documentaries, show recommended and educational ones
- Statistics: documentaries per category, average rating, total duration
- Safe input handling: wrong input never crashes the program

How to run

1. Clone the repository
2. Open it in IntelliJ IDEA (JDK 21)
3. Run `Main.java` and choose an option from the menu

 Java topics used

| Topic | Where |
|---|---|
| Classes, encapsulation | `Documentary` |
| Inheritance, polymorphism | `OceanDocumentary`, `WildlifeDocumentary`, `GeneralDocumentary` |
| Abstract class | `Documentary` |
| Interfaces, marker interface | `Recommendable`, `Educational` |
| Overloading, `this(...)` | `GeneralDocumentary` constructors |
| Collections | `ArrayList`, `Iterator` |
| Comparable, Comparator | `Documentary.compareTo`, `Comparator.comparingInt` |
| Lambda, method references | `Main` |
| Functional interfaces | `Predicate`, `Consumer`, `Function`, `Supplier` |
| Stream API | `filter`, `map`, `sorted`, `reduce`, `collect`, `groupingBy` |
| Exceptions | `InvalidRatingException`, `try-catch-finally` |

 Author
Aynisa Aliyeva
