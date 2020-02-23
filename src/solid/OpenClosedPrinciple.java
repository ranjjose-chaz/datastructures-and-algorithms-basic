package solid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OpenClosedPrinciple {

    public static void main(String args[]){
        Product apple = new Product("Apple", Color.GREEN, Size.MEDIUM);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product broccoli = new Product("Broccoli", Color.GREEN, Size.MEDIUM);
        Product parrot = new Product("Parrot", Color.GREEN, Size.SMALL);
        Product house = new Product("House", Color.BLUE, Size.LARGE);
        Product iPhone = new Product("iPhone", Color.RED, Size.SMALL);
        Product car = new Product("Car", Color.BLUE, Size.MEDIUM);

        List<Product> products = List.of(apple, tree, house, iPhone, car, broccoli, parrot);
        ProductFilter pf = new ProductFilter();
        pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(p.name));

        BetterFilter bf = new BetterFilter();
        System.out.println("Green Products");
        bf.filter(products, new ColorSpecification(Color.GREEN)).forEach(g -> System.out.println(g.name));

        System.out.println("Medium Sized Products");
        bf.filter(products, new SizeSpecification(Size.MEDIUM)).forEach(g -> System.out.println(g.name));

        System.out.println("Medium Sized Green Products");
        bf.filter(products,
                new AndSpecification<>(new ColorSpecification(Color.GREEN),
                                        new SizeSpecification(Size.MEDIUM)))
                .forEach(g -> System.out.println(g.name));


        System.out.println("Medium sized OR blue colored Products");
        bf.filter(products,
                new OrSpecification<>(new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.MEDIUM)))
                .forEach(g -> System.out.println(g.name));

    }
}


enum Color {
    RED,
    GREEN,
    BLUE
};


enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

class Product{
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size){
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

/**
 * Violates open closed principle coz if you want to add new features, you need to edit the close that you
 * have written already. Basically you are not making it closed for mondification
 */
class ProductFilter{
    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter(x -> x.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter(x -> x.size == size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size){
        return products.stream().filter(x -> x.color == color && x.size == size);
    }

}


/**
 * Better approach is to make sure open closed principle is implemented
 */
interface Specification<T> {
    boolean isSatisfied(T item);
}

class AndSpecification<T> implements Specification<T>{

    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second){
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class OrSpecification<T> implements Specification<T>{

    private Specification<T> first, second;

    public OrSpecification(Specification<T> first, Specification<T> second){
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) || second.isSatisfied(item);
    }
}

interface Filter<T>{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product> {

    private final Color color;

    public ColorSpecification(Color color){
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == this.color;
    }
}


class SizeSpecification implements Specification<Product> {

    private final Size size;

    public SizeSpecification(Size size){
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == this.size;
    }
}

class BetterFilter implements Filter<Product>{

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(spec::isSatisfied);
    }
}






