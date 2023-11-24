package Task2;

import Task2.items.Book;

public class BoxWithBooks implements Box<Book>{
    private Book book = null;
    @Override
    public Book open() {
        System.out.println("Вы открыли коробку с книгами!");
        if (book != null)
            return book;
        else System.out.println("Тут пусто..");
        return null;
    }

    @Override
    public void put(Book item) {
        if (book == null) {
            book = item;
            System.out.println("Книга добавлена в коробку.");
        }
        else System.out.println("Коробка занята.");
    }

    @Override
    public Book removeFromBox() {
        if (book != null) {
            System.out.println("Книга забрана из коробки.");
            Book b = book;
            book = null;
            return b;
        }
        else System.out.println("Из пустой коробки ничего не заберешь.");
        return null;
    }
}
