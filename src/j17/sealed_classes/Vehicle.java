package j17.sealed_classes;

sealed interface Driveable permits Vehicle{
}
public sealed class Vehicle implements Driveable permits Car{
}
sealed class Car extends Vehicle permits Ford, Volvo{}

final class Ford extends Car{}
final class Volvo extends Car{}

//class Table implements Driveable{}