# WaveAlgo - Lee algorithm
Simpliest Lee algorithm on Java for 4 direction moves on field with coordinates.

## How to use?
* Use `Position` class to manage pairs of X and Y
* Collect constraints:
```java
    int fieldWidth = getSomeValue();
    int fieldHeight = getSomeValue();
    //borders - impassable blocks
    List<Position> borders = new ArrayList<>();
    //random filling - the 'wall' f.e.
    for (int i = 0; i < fileHeight - 2; i++) {
        borders.add(new Position(3, i));
    }
```
* Define start and goal positions (should be into field rechtangle (0 <= X < fieldWidth and 0 <= Y < fieldHeight)):
```java
    Position start = new Position(getSomeValue(),getSomeValue());
    Position goal = new Position(getSomeValue(), getSomeValue());
```
* Get result:
```java
    //path includes start and goal positions
    List<Position> path = WaveAlgo.FindPath(fieldWidth, fieldHeight,
                start, goal, borders);
```
* Run `Program` to see simpliest workflow with two walls on field
* Feel free to change algo statements to add additional directions (diagonal, etc)
