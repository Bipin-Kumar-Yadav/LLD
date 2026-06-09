# FacadeAndFlyExercise

Small Java demo illustrating the Facade and Flyweight patterns.

## Overview
- Facade example (game): simplified game API to spawn players, manage weapons and players.
  - Core facade: [`FacadeAndFlyExercise.GameFacade`](FacadeAndFlyExercise/GameFacade.java)
  - Entry point: [`FacadeAndFlyExercise.Gateway`](FacadeAndFlyExercise/Gateway.java)
- Flyweight example (bullets): reuse shared bullet types to reduce object creation.
  - Flyweight factory: [`Solution.BulletTypeFactory`](FlyWeightPattern/Solution/BulletTypeFactory.java)
  - Bullet implementation: [`Solution.Bullet`](FlyWeightPattern/Solution/Bullet.java)

## Key classes (Facade example)
- [`FacadeAndFlyExercise.GameFacade`](FacadeAndFlyExercise/GameFacade.java)
- [`FacadeAndFlyExercise.WeaponManager`](FacadeAndFlyExercise/WeaponManager.java)
- [`FacadeAndFlyExercise.WeaponFactory`](FacadeAndFlyExercise/WeaponFactory.java)
- [`FacadeAndFlyExercise.WeaponType`](FacadeAndFlyExercise/WeaponType.java)
- [`FacadeAndFlyExercise.Weapon`](FacadeAndFlyExercise/Weapon.java)
- [`FacadeAndFlyExercise.PlayerManager`](FacadeAndFlyExercise/PlayerManager.java)
- [`FacadeAndFlyExercise.Player`](FacadeAndFlyExercise/Player.java)
- Launcher: [`FacadeAndFlyExercise.Gateway`](FacadeAndFlyExercise/Gateway.java)

## Files in this repo
- FacadeAndFlyExercise/
  - [Gateway.java](FacadeAndFlyExercise/Gateway.java)
  - [GameFacade.java](FacadeAndFlyExercise/GameFacade.java)
  - [Player.java](FacadeAndFlyExercise/Player.java)
  - [PlayerManager.java](FacadeAndFlyExercise/PlayerManager.java)
  - [Weapon.java](FacadeAndFlyExercise/Weapon.java)
  - [WeaponFactory.java](FacadeAndFlyExercise/WeaponFactory.java)
  - [WeaponManager.java](FacadeAndFlyExercise/WeaponManager.java)
  - [WeaponType.java](FacadeAndFlyExercise/WeaponType.java)
- FlyWeightPattern/
  - Problem and Solution folders with bullet examples:
    - [FlyWeightPattern/Problem/Bullet.java](FlyWeightPattern/Problem/Bullet.java)
    - [FlyWeightPattern/Solution/Bullet.java](FlyWeightPattern/Solution/Bullet.java)
    - [FlyWeightPattern/Solution/BulletTypeFactory.java](FlyWeightPattern/Solution/BulletTypeFactory.java)
    - [FlyWeightPattern/Solution/BulletType.java](FlyWeightPattern/Solution/BulletType.java)
- FacadePattern/ (Problem & Solution samples)

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
Player spawned Bipin
Player spawned Shradha
Player spawned Vishnu
Player Bipin fired ak47
Player Shradha fired m416
Player Vishnu fired m416
Game ended
All player removed
```

## Notes
- The Facade uses `WeaponFactory` as a simple flyweight provider for `WeaponType`.
- The Flyweight solution under `FlyWeightPattern/Solution` demonstrates reducing duplicate bullet type creation.
