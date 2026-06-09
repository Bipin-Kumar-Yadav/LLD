# FacadeAndFlyExercise

Small Java demo illustrating the Facade and Flyweight patterns.

## Build & Run
From the repository root:

```bash
# compile all .java files into out/
find . -name "*.java" | xargs javac -d out

# run the Facade demo
java -cp out FacadeAndFlyExercise.Gateway
```

Expected output (approx):
```
Game Started!!!
Player spawned Player1
Player spawned Player2
Player spawned Player3
Player Player1 fired ak47
Player Player2 fired m416
Player Player3 fired m416
Game ended
All player removed
```

## Notes
- The Facade uses `WeaponFactory` as a simple flyweight provider for `WeaponType`.
- The Flyweight solution under `FlyWeightPattern/Solution` demonstrates reducing duplicate bullet type creation.
