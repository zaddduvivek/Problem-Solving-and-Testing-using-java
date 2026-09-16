class ParkingSystem {
    private int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        int index = carType - 1;

        if (spaces[index] > 0) {
            spaces[index]--;
            return true;
        }

        return false;
    }
}
