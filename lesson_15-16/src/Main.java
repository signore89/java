//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    SpeedVehicles[] vehicles = SpeedVehicles.values();
    for (SpeedVehicles v : vehicles){
        System.out.printf("Скорость %s составляет %d миль в час!%n",v.getName(),v.getSpeed());
    }

}

enum SpeedVehicles{
    AIRPLANE(600,"Самолёта"),CAR(65,"Машины"),TRUCK(55,"Автобуса"),TRAIN(70,"Поезда"),BOAT(22,"Лодки");

    private final int speed;
    private final String name;

    SpeedVehicles(int speed,String name) {
        this.speed = speed;
        this.name = name;
    }

    public int getSpeed(){return speed;}
    public String getName(){return name;}
}
