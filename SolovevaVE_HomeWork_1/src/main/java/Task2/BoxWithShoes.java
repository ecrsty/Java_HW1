package Task2;

import Task2.items.Shoes;

public class BoxWithShoes implements Box<Shoes> {
    private Shoes shoes = null;
    @Override
    public Shoes open() {
        System.out.println("Вы открыли коробку с обувью!");
        if (shoes != null)
            return shoes;
        else System.out.println("Тут пусто..");
        return null;
    }

    @Override
    public void put(Shoes item) {
        if (shoes == null) {
            shoes = item;
            System.out.println("Обувь добавлена в коробку.");
        }
        else System.out.println("Коробка занята.");
    }

    @Override
    public Shoes removeFromBox() {
        if (shoes != null) {
            System.out.println("Обувь забрана из коробки.");
            Shoes s = shoes;
            shoes = null;
            return s;
        }
        else System.out.println("Из пустой коробки ничего не заберешь.");
        return null;
    }
}
