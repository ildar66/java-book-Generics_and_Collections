package chapter12.section01;

public final class PhoneTask extends Task {

    private final String name;
    private final String number;

    public PhoneTask(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    /**
     * We assume we never create two phone tasks with the same name and different numbers;
     * if we did, it would be wrong to test equality using the result returned by toString.
     */
    public String toString() {
        return "phone " + name;
    }
}
