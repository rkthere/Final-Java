import java.util.*;

public class Laptop {

    private String laptopName;
    private int RAM_Size;
    private int MainMemoryStorage;
    private String OS_Name;
    private String color;
    private int price;

    public Laptop(String name, int RAM_Size, int MainMemoryStorage, String os, String color, int price) {
        this.laptopName = name;
        this.RAM_Size = RAM_Size;
        this.MainMemoryStorage = MainMemoryStorage;
        this.OS_Name = os;
        this.color = color;
        this.price = price;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public int getRAM_Size() {
        return RAM_Size;
    }

    public int getMainMemoryStorage() {
        return MainMemoryStorage;
    }

    public String getOS_Name() {
        return OS_Name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public void setRAM_Size(int RAM_Size) {
        this.RAM_Size = RAM_Size;
    }

    public void setMainMemoryStorage(int mainMemoryStorage) {
        this.MainMemoryStorage = mainMemoryStorage;
    }

    public void setOS_Name(String OS_Name) {
        this.OS_Name = OS_Name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCriteria(int criteria) {
        if (criteria == 1) {
            return this.RAM_Size + " GB";
        } else if (criteria == 2) {
            return this.MainMemoryStorage + " GB";
        } else if (criteria == 3) {
            return this.OS_Name;
        } else if (criteria == 4) {
            return this.color;
        } else
            return this.price + " RUB";
    }

    @Override
    public String toString() {
        return laptopName + "\t" + RAM_Size + " GB\t" + MainMemoryStorage + " GB\t" + color + "\t" + price + " RUB";
    }

    public static void filter(List<Laptop> laptops, Map<String, String> filterCriteria) {

        System.out.println("Enter the number that matches the required criteria:");

        for (String key : filterCriteria.keySet()) {
            System.out.println(key + " - " + filterCriteria.get(key));
        }

        Scanner scanner = new Scanner(System.in);

        int filterNumber = scanner.nextInt();

        String criteria = filterCriteria.get(String.valueOf(filterNumber));

        System.out.println("Name\t" + criteria + "");

        for (Laptop laptop : laptops) {
            System.out.println(laptop.getLaptopName() + "\t" + laptop.getCriteria(filterNumber));
        }
    }

    public static void printAll(List<Laptop> laptops) {
        System.out.println("Name\tRAM\tStorage\tOS\tColor\tPrice");
        for (Laptop l : laptops) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Dell", 2, 512, "Windows 8", "White", 3999);
        Laptop laptop2 = new Laptop("Acer", 4, 1024, "Windows 10", "Black", 4999);
        Laptop laptop3 = new Laptop("HP", 6, 512, "Windows 10", "Silver", 6999);
        Laptop laptop4 = new Laptop("Asus", 8, 256, "Windows 7", "Red", 5999);
        Laptop laptop5 = new Laptop("Lenovo", 8, 1024, "Windows 8", "Blue", 7999);

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);

        System.out.println("1. Вывод ноутбуков в консоль");
        for (Laptop l : laptops) {
            System.out.println(l);
        }

        System.out.println("\n2. Фильтрация списка ноутбуков по параметру");
        Map<String, String> filterCriteria = new HashMap<>();
        filterCriteria.put("1", "RAM");
        filterCriteria.put("2", "HDD volume");
        filterCriteria.put("3", "Operating system");
        filterCriteria.put("4", "Color");

        filter(laptops, filterCriteria);

        System.out.println("\n3. Фильтрация по имени и стоимости");

        laptops.sort(Comparator.comparing(Laptop::getLaptopName));
        laptops.sort(Comparator.comparing(Laptop::getPrice).reversed());

        printAll(laptops);
    }

}