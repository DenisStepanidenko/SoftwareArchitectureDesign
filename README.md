# ***Описание репозитория*** :book:
Здесь будет реализованы домашние задания на Java, по дисциплине **"Проектирование программной архитектуры"** 
# ***Авторы решений*** :star2:
## ***Степаниденко Денис и Матвей Пак*** :sparkles:

# Задание 1 :computer:
***1) Прочитать статью https://habr.com/ru/articles/144611/***

***2) Взять любое старое домашнее задание и отрефакторить его с точки зрения соблюдения трех принципов: DRY-KISS-YAGNI***

Мы использовали на практике рефактор кода с помощью принципа ***DRY*** 

Для начала посмотрим ***задание***:
![img.png](img.png)

Обратим внимание на старый код:
```java
package homeWorks.first.dry;

public class SquareAndPerimetrOld {

    /**
     * метод вычисляет периметр четырехугольника abcd
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param result - значение периметра
     * @return - возвращает true, если периметр был успешно найден,
     * в противном случае возвращает false
     */
    public static boolean perimetr(Point a, Point b, Point c, Point d, Double result) {
        // Проверим, существует ли такой четырехугольник в начале
        boolean flagRectangleExists = isRectanglePossible(a, b, c, d);
        if (!flagRectangleExists) {
            result = null;
            return false;
        }

        double sideAB = getDistance(a, b);
        double sideBC = getDistance(b, c);
        double sideCD = getDistance(c, d);
        double sideDA = getDistance(d, a);
        result = sideAB + sideBC + sideCD + sideDA;
        return true;
    }

    /**
     * метод вычисляет площадь четырехугольника abcd
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param result - значение площади
     * @return - возвращает true, если площадь была успешно найдена,
     * в противном случае возвращает false
     */

    public static boolean Square(Point a, Point b, Point c, Point d, Double result) {
        boolean flagRectangleExists = isRectanglePossible(a, b, c, d);
        if (!flagRectangleExists) {
            result = null;
            return false;
        }

        double sideAB = getDistance(a, b);
        double sideBC = getDistance(b, c);
        double sideCD = getDistance(c, d);
        double sideDA = getDistance(d, a);
        double sideBD = getDistance(b, d);

        double squareFirst = Heron(sideAB, sideBD, sideDA);
        double squareSecond = Heron(sideBC, sideCD, sideBD);
        result = squareFirst + squareSecond;
        return true;
    }

    /**
     * метод считает площадь треугольника по формуле Герона
     *
     * @param a
     * @param b
     * @param c
     * @return - возвращает значение площади треугольника
     */

    public static double Heron(double a, double b, double c) {
        double halfPerimetr = (a + b + c) / 2;
        return Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
    }

    /**
     * метод вычисления расстояния между точками
     *
     * @param point1 - первая точка
     * @param point2 - вторая точка
     * @return - возвращает расстояние между точками
     */
    public static double getDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }

    /**
     * метод определяет, возможно ли построить четырехугольник по четырем точкам
     * затем
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return - true, если по данным четырем точкам можно построить четырехугольник,
     * в противном случае вернет false
     */

    public static boolean isRectanglePossible(Point a, Point b, Point c, Point d) {
        // вычислим длины сторон прямоугольника и одной его диагонали
        double sideAB = getDistance(a, b);
        double sideBC = getDistance(b, c);
        double sideCD = getDistance(c, d);
        double sideDA = getDistance(d, a);
        double sideBD = getDistance(b, d);

        // теперь проверим неравенства для двух треугольников,
        // образованных разделением четырехугольника по диагонали
        boolean flag1 = isTriangleRuleCompleted(sideAB, sideBD, sideDA);
        boolean flag2 = isTriangleRuleCompleted(sideBC, sideCD, sideBD);
        return flag1 && flag2;
    }

    /**
     * метод проверяет, выполняется ли неравенство треугольника
     *
     * @param side1 - первая сторона треугольника
     * @param side2 - вторая сторона
     * @param side3 - третья сторона
     * @return - вернет true, если неравенство треугольника выполняется,
     * в противном случае вернет false
     */
    public static boolean isTriangleRuleCompleted(double side1, double side2, double side3) {
        // проверяем 3 неравенства треугольника
        if (side1 + side2 < side3) return false;
        if (side2 + side3 < side1) return false;
        if (side1 + side3 < side2) return false;
        return true;
    }
}
```
Но что же в нём плохого ***по принципу DRY?*** :santa:

Заметим, что ***код*** далее:
```java
    double sideAB = getDistance(a, b);
    double sideBC = getDistance(b, c);
    double sideCD = getDistance(c, d);
    double sideDA = getDistance(d, a);
    double sideBD = getDistance(b, d);
```
повторяется в трёх методах. 

Это отличный шанс применить принцип ***DRY*** и создать отдельный метод для этого. :closed_book:

Далее приведён исправленный код :clapper:
```java
public class SquareAndPerimetrNew {
    /**
     * метод вычисляет периметр четырехугольника abcd
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param result - значение периметра четырехугольника
     * @return - возвращает true, если периметр был успешно найден,
     * в противном случае возвращает false
     */
    public static boolean perimetr(Point a, Point b, Point c, Point d, Double result) {

        // Сначала проверим, существует ли такой четырехугольник
        boolean flagRectangleExists = isRectanglePossible(a, b, c, d);
        if (!flagRectangleExists) {
            result = null;
            return false;
        }

        // вычислим длины сторон четырехугольника
        var sides = getSidesAndDiagonal(a, b, c, d);

        // найдем периметр
        result = sides[0] + sides[1] + sides[2] + sides[3];
        return true;
    }


    /**
     * метод вычисляет площадь четырехугольника abcd
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param result - значение площади четрыехугольника
     * @return - возвращает true, если площадь была успешно найдена,
     * в противном случае возвращает false
     */

    public static boolean Square(Point a, Point b, Point c, Point d, Double result) {

        // Сначала проверим, существует ли такой четырехугольник
        boolean flagRectangleExists = isRectanglePossible(a, b, c, d);
        if (!flagRectangleExists) {
            result = null;
            return false;
        }

        // вычислим длины сторон четырехугольника и одной его диагонали
        var sides = getSidesAndDiagonal(a, b, c, d);

        // теперь найдем площадь четырехугольника, используя формулу Герона
        double squareFirst = Heron(sides[0], sides[4], sides[3]);
        double squareSecond = Heron(sides[1], sides[2], sides[4]);
        result = squareFirst + squareSecond;
        return true;
    }

    /**
     * метод считает площадь треугольника по формуле Герона
     *
     * @param a
     * @param b
     * @param c
     * @return - возвращает значение площади треугольника
     */

    public static double Heron(double a, double b, double c) {
        double halfPerimetr = (a + b + c) / 2;
        return Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
    }

    /**
     * метод вычисления расстояния между точками
     *
     * @param point1 - первая точка
     * @param point2 - вторая точка
     * @return - возвращает расстояние между точками
     */
    public static double getDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }

    /**
     * метод получает длины сторон и диагонали четрыехугольника по его четырем вершинам
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return - возвращает массив с длинами сторон и диагонали четырехугольника
     */
    public static double[] getSidesAndDiagonal(Point a, Point b, Point c, Point d) {
        double[] sidesAndDiagonal = new double[5];
        sidesAndDiagonal[0] = getDistance(a, b);
        sidesAndDiagonal[1] = getDistance(b, c);
        sidesAndDiagonal[2] = getDistance(c, d);
        sidesAndDiagonal[3] = getDistance(d, a);
        sidesAndDiagonal[4] = getDistance(b, d);

        return sidesAndDiagonal;
    }

    /**
     * метод определяет, возможно ли построить четырехугольник по четырем точкам
     * затем
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return - true, если по данным четырем точкам можно построить четырехугольник,
     * в противном случае вернет false
     */
    public static boolean isRectanglePossible(Point a, Point b, Point c, Point d) {
        // вычислим длины сторон четырехугольника и одной его диагонали
        var sides = getSidesAndDiagonal(a, b, c, d);

        // теперь проверим неравенства для двух треугольников,
        // образованных разделением четырехугольника по диагонали
        boolean flag1 = isTriangleRuleCompleted(sides[0], sides[4], sides[3]);
        boolean flag2 = isTriangleRuleCompleted(sides[1], sides[2], sides[4]);
        return flag1 && flag2;
    }

    /**
     * метод проверяет, выполняется ли неравенство треугольника
     *
     * @param side1 - первая сторона треугольника
     * @param side2 - вторая сторона
     * @param side3 - третья сторона
     * @return - вернет true, если неравенство треугольника выполняется,
     * в противном случае вернет false
     */
    public static boolean isTriangleRuleCompleted(double side1, double side2, double side3) {
        // проверяем 3 неравенства треугольника
        if (side1 + side2 < side3) return false;
        if (side2 + side3 < side1) return false;
        if (side1 + side3 < side2) return false;
        return true;
    }
}
```

Как мы видим, был создан новый метод, который по введённым точкам - определяет все стороны и диагональ четырёхугольника :diamonds:
```java
 public static double[] getSidesAndDiagonal(Point a, Point b, Point c, Point d) {
        double[] sidesAndDiagonal = new double[5];
        sidesAndDiagonal[0] = getDistance(a, b);
        sidesAndDiagonal[1] = getDistance(b, c);
        sidesAndDiagonal[2] = getDistance(c, d);
        sidesAndDiagonal[3] = getDistance(d, a);
        sidesAndDiagonal[4] = getDistance(b, d);

        return sidesAndDiagonal;
    }
```
***

# Задание 2 :computer:
*Необходимо придумать задачи (или задачу), где можно было бы применить такие паттерны, как **Singleton, Objects Pools, Lazy Initialization*** :mortar_board:  
Мы постарались придумать такой кейс, где можно было бы применить сразу все данные паттерны.
## Техническое задание :ledger:
*Необходимо создать систему управления автомобилями для автосервиса, который выдаёт машины различных марок в аренду. Данный автосервис в основном должен делать две вещи - выдать автомобиль пользователю по бренду, модели и цвету, а также вернуть в автосервис машину, взятую пользователем в аренду* :car:
## Техническое описание :clapper:
## Классы и главные методы :crystal_ball:
### Класс Car implements Comparable \<Car\> :ballot_box_with_check:
*Данный класс описывает машину в виде названия бренда, модели и цвета. Также он реализовывает интерфейс Comparable, чтобы сравнивать объекты типа Car между собой( по умолчанию идёт сравнение по ссылкам, но нам это не подходит).*
***
### Класс CarPool :ballot_box_with_check:
*Основной класс, в котором прописана бизнес логика, представляет из себя пул объектов типа Car.*
### Метод *public static CarPool getInstance()* :white_check_mark:
*Данный метод вовзращает ссылку на единственный экземпляр типа CarPool.*
### Метод *public Car rentCar(String brand, String model, String color)* :white_check_mark:
*Данный метод ищет машину в доступных по бренду, модели и цвету и возвращает ссылку на объект типа Car. Также в данном методе происходит логика удаления данной машины из доступных, а также добавление в текущий список арендованных автомобилей.*
### Метод *public void finishRental(Car rentedCar)* :white_check_mark:
*Данный метод принимает в качестве параметра ссылку на объект типа Car и добавляет машину снова в доступные для аренды в нашем автосервисе. А также удаляет данный автомобиль из списка арендованных на данный момент.*
### Метод *private List\<Car\> loadCars()* :white_check_mark:
*Данный метод при создании объекта типа CarPool инициализирует список доступных автомобилей.*
***
## Реализация паттернов :collision:
Понятное дело, что наш автосервис должен представлять из себя пул объектов, а именно пул объектов типа Car. Это и будет наша реализация паттерна ***Objects Pool*** :anger:   
Ниже приведена реализация данного класса, который представляет из себя пул объектов.
```java
public class CarPool {
    private static CarPool instance;
    List<Car> availableCars;
    List<Car> rentedCars;

    private CarPool() {
        rentedCars = new ArrayList<>();
        availableCars = loadCars();
    }

    public static CarPool getInstance() {
        if (instance == null) {
            instance = new CarPool();
        }
        return instance;
    }

    private List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", "Accord", "White"));
        cars.add(new Car("Skoda", "Octavia", "Green"));
        cars.add(new Car("Nissan", "X-Trail", "Silver"));
        cars.add(new Car("Hyundai", "Solaris", "Yellow"));
        cars.add(new Car("Toyota", "Camry", "Snowy-white"));
        cars.add(new Car("Mazda", "6", "Red"));
        cars.add(new Car("UAZ", "Hunter", "Green"));
        cars.add(new Car("Volkswagen", "Polo", "Black"));
        cars.add(new Car("Renault", "Duster", "Orange"));
        cars.add(new Car("Lada", "Granta", "Carnelian"));

        return cars;
    }

    public Car rentCar(String brand, String model, String color) {

        Car neededCar = new Car(brand, model, color);

        for (var car : availableCars) {
            if (car.compareTo(neededCar) == 0) {
                rentedCars.add(car);
                availableCars.remove(car);
                System.out.printf("The car (Brand: %s, Model: %s, Color: %s) rental has started.\n", neededCar.brand, neededCar.model, neededCar.color);
                return car;
            }
        }
        System.out.printf("We are sorry. There is no car with such parameters (Brand: %s, Model: %s, Color: %s) at the moment.\n", neededCar.brand, neededCar.model, neededCar.color);
        return null;
    }

    public void finishRental(Car rentedCar) {
        availableCars.add(rentedCar);
        rentedCars.remove(rentedCar);

        System.out.printf("The car (Brand: %s, Model: %s, Color: %s) rental is finished.\n", rentedCar.brand, rentedCar.model, rentedCar.color);
    }
}
``` 
Также данный пул объектов типа Car должен реализовывать паттерн ***Singleton***, так как у нас один единственный автосервис, и не должно быть две разные ссылки на данный класс :dizzy:  
Но ещё можно отметить, что именно здесь можно применять паттерн ***Lazy Initialization***. Ведь нам не нужно сразу же инициализировать всеми машинами наш автосервис, вдруг им никто и не воспользуется :disappointed:  
Посмотрим на реализацию этих двух паттернов :scroll:
```java
private static CarPool instance;
private CarPool() {
        rentedCars = new ArrayList<>();
        availableCars = loadCars();
}
public static CarPool getInstance() {
        if (instance == null) {
            instance = new CarPool();
        }
        return instance;
}
private List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", "Accord", "White"));
        cars.add(new Car("Skoda", "Octavia", "Green"));
        cars.add(new Car("Nissan", "X-Trail", "Silver"));
        cars.add(new Car("Hyundai", "Solaris", "Yellow"));
        cars.add(new Car("Toyota", "Camry", "Snowy-white"));
        cars.add(new Car("Mazda", "6", "Red"));
        cars.add(new Car("UAZ", "Hunter", "Green"));
        cars.add(new Car("Volkswagen", "Polo", "Black"));
        cars.add(new Car("Renault", "Duster", "Orange"));
        cars.add(new Car("Lada", "Granta", "Carnelian"));

        return cars;
}

```
***
# Задание 3 :computer:
*Придумать задачу, где можно было бы применить такие паттерны, как ***Abstract Factory/Factory Method**** :mortar_board:  
## Техническое задание :ledger:
*Представим, что у нас есть приложение для онлайн-магазина, который продаёт различные виды электроники: смартфоны, ноутбуки, планшеты. И нам нужно реализовать функциональность для создания заказов на различные категории продуктов* :iphone:  
## Техническое описание :clapper:  
## Классы и главные методы :crystal_ball:
### Interface ElectronicProductFactory :ballot_box_with_check:
*Данный интерфейс и является абстрактной фабрикой, которая в себе хранит фабричные методы для создания различной электроники*
### Метод *Smartphone createSmartphone()* :white_check_mark:
*Данный метод возвращает объект типа Smartphone*
### Метод *Laptop createLaptop()* :white_check_mark:
*Данный метод возвращает объект типа Laptop*
### Метод *Pad createPad()* :white_check_mark:
*Данный метод возвращает объект типа Pad* 
***
### Class AppleProductFactory implements ElectronicProductFactory :ballot_box_with_check:
*Реализация конкретной фабрики, которая будет выдавать разлчиную продукцию компании Apple* 
***
### Class SamsungProductFactory implements ElectronicProductFactory :ballot_box_with_check:
*Реализация конкретной фабрики, которая будет выдавать различную продукцию компании Samsung*
***
### Interface Laptop :ballot_box_with_check:
*Общий интерфейс для сущности - ноутбук*
### Метод *void showInfo()* :white_check_mark:
*Данный метод выводит информацию об объекте*
***
### Interface Pad :ballot_box_with_check:
*Общий интерфейс для сущности - планшет*
### Метод *void showInfo()* :white_check_mark:
*Данный метод выводит информацию об объекте*
***
### Interface Smartphone :ballot_box_with_check:
*Общий интерфейс для сущности - смартфон*
### Метод *void showInfo()* :white_check_mark:
*Данный метод выводит информацию об объекте*
***
### Class Galaxy implements Smartphone :ballot_box_with_check:
*Конкретная реализация интерфейса Smartphone, представляет смартфон компании Samsung*
***
### Class GalaxyBook implements Laptop :ballot_box_with_check:
*Конкретная реализция интерфейса Laptop, представляет из себя ноутбук компании Samsung*
***
### Class GalaxyTab implements Pad :ballot_box_with_check:
*Конкретная реализация интерфейса Pad, представляет из себя планшет компании Samsung*
***
### Class IPhone implements Smartphone :ballot_box_with_check:
*Конкретная релазиация интерфейса Smartphone, представляет из себя смартфон компании Apple*
***
### Class MacBook implements Laptop :ballot_box_with_check:
*Конкретная реализация интерфейса Laptop, представляет из себя ноутбук компании Apple*
***
### Class IPad implements Pad :ballot_box_with_check:
*Конкретная реализация интерфейса Pad, представляет из себя планшет компании Pad*
***
## Реализация паттернов :collision: 
Абстрактная фабрика в нашей задаче реализована следующим образом :space_invader:
```java
public interface ElectronicProductFactory {
    Smartphone createSmartphone();
    Laptop createLaptop();
    Pad createPad();
}
```
Данная абстрактная фабрика имеет три метода для создания различной электроники. Далее в программе электроника ранжируется в зависимости от производителя :high_brightness:  
Рассмотрим конкретные реализации данной фабрики :pencil:  

Фабрика для производителя ***Apple*** :dart:
```java
public class AppleProductFactory implements ElectronicProductFactory {

    @Override
    public Smartphone createSmartphone() {
        return new IPhone();
    }

    @Override
    public Laptop createLaptop() {
        return new MacBook();
    }

    @Override
    public Pad createPad() {
        return new IPad();
    }
}
```

Фабрика для производителя ***Samsung*** :dart:

```java
public class SamsungProductFactory implements ElectronicProductFactory {

    @Override
    public Smartphone createSmartphone() {
        return new Galaxy();
    }

    @Override
    public Laptop createLaptop() {
        return new GalaxyBook();
    }

    @Override
    public Pad createPad() {
        return new GalaxyTab();
    }
}
```
Интерфейс ***Smartphone***  
```java
public interface Smartphone {
    void showInfo();
}
```
Интерфейс ***Laptop***
```java
public interface Laptop {
    void showInfo();
}
```
Интерфейс ***Pad***
```java
public interface Pad {
    void showInfo();
}
```
Класс ***IPad***
```java
public class IPad implements Pad {
    @Override
    public void showInfo() {
        System.out.println("You have created IPad.");
    }
}
```
Класс ***Iphone***
```java
public class IPhone implements Smartphone {

    @Override
    public void showInfo() {
        System.out.println("You have created IPhone.");
    }
}
```
Класс ***MacBook***
```java
public class MacBook implements Laptop {
    @Override
    public void showInfo() {
        System.out.println("You have created MacBook.");
    }
}
```
Класс ***Galaxy***
```java
public class Galaxy implements Smartphone {
    @Override
    public void showInfo() {
        System.out.println("You have created Galaxy.");
    }
}
```
Класс ***GalaxyBook***
```java
public class GalaxyBook implements Laptop {
    @Override
    public void showInfo() {
        System.out.println("You have created GalaxyBook.");
    }
}
```
Класс ***GalaxyTab***
```java
public class GalaxyTab implements Pad {
    @Override
    public void showInfo() {
        System.out.println("You have created GalaxyTab.");
    }
}
```











