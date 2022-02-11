public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;
    private String errorMsg = "";

    public Elevator(int minFloor, int maxFloor){    //конструктор
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown(){
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp(){
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public boolean isCanMove(int floor){
        if(floor < minFloor || floor > maxFloor){
            errorMsg = "указанного этажа нет в здании";
            return false;
        } else if(currentFloor == floor){
            errorMsg = "вы ввели текущий этаж - ехать ненужно!";
            return false;
        } return true;
    }

    public void move(int floor){
        if (isCanMove(floor) && currentFloor < floor){
            while (currentFloor < floor){
                moveUp();
                System.out.println("Лифт движется вверх, текущий этаж " + getCurrentFloor() + ((currentFloor == floor) ? " Вы приехали!" : ""));
            }
        } else if(isCanMove(floor)){
            while (currentFloor > floor) {
                moveDown();
                System.out.println("Лифт движется вниз, текущий этаж " + getCurrentFloor() + ((currentFloor == floor) ? " Вы приехали!" : ""));
            }
        } else {
            System.out.println(errorMsg);
        }
    }
}
