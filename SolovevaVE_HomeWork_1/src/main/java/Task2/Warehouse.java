package Task2;
import Task2.items.Beer;
import Task2.items.Book;
import Task2.items.Shoes;

public class Warehouse {

    public static void main(String[] args) {
        BoxWithBeer beerBox = new BoxWithBeer();
        BoxWithBooks bookBox = new BoxWithBooks();
        BoxWithShoes shoesBox = new BoxWithShoes();

        beerBox.put(new Beer("Heineken", 0.43));
        bookBox.put(new Book("Преступление и наказание", "Ф.М.Достоевский"));
        shoesBox.put(new Shoes("Кроссовки", "Adidas", 41));

        System.out.println("\nОткроем коробку, заберем пиво и попробуем снова забрать");
        beerBox.open();
        Beer beer = beerBox.removeFromBox();
        beerBox.open();
        Beer b = beerBox.removeFromBox();

        System.out.println("\nОткроем коробку, попробуем положить что то и посмотрим что будет внутри");
        Shoes shoe = shoesBox.open();
        shoesBox.put(new Shoes("Ботинки", "Ekonika", 38));
        shoe = shoesBox.open();
        System.out.println(shoe.getBrand());
    }
}
