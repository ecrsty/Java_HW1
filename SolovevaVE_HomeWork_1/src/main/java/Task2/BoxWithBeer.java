package Task2;

import Task2.items.Beer;

public class BoxWithBeer implements Box<Beer>{
    private Beer beer = null;

    @Override
    public Beer open() {
        System.out.println("Вы открыли коробку с пивом!");
        if (beer != null)
            return beer;
        else System.out.println("Тут пусто..");
        return null;
    }

    @Override
    public void put(Beer item) {
        if (beer == null) {
            beer = item;
            System.out.println("Пиво добавлено в коробку.");
        }
        else System.out.println("Коробка занята.");
    }

    @Override
    public Beer removeFromBox() {
        if (beer != null) {
            System.out.println("Пиво забрано из коробки.");
            Beer b = beer;
            beer = null;
            return b;
        }
        else System.out.println("Из пустой коробки ничего не заберешь.");
        return null;
    }
}
