public class Supermassive {

    public long massiveFunction(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        } else if (size == 1 || size == 2) {
            return 1;
        } else {
            return massiveFunction(size - 1) * massiveFunction(size - 2);
        }

    }

    public long anotherMassiveFunction(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        } else if (size == 1 || size == 2) {
            return 1;
        } else {
            return massiveFunction(size - 1) * massiveFunction(size - 2);
        }

    }

}