import java.util.*;
import java.util.stream.Collectors;

public class JavaStreamExample {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        List<Float> productPriceList = new ArrayList<Float>();

        for(Product product: productsList){
            // filtering data of list without stream
            if(product.price<30000){
                productPriceList.add(product.price);    // adding price to a productPriceList
            }
        }
        System.out.println(productPriceList);   // displaying data

        System.out.println("-------------Using streams to filter and map data------------");   // displaying data

        List<Float> productPriceList2 =productsList.stream()
                .filter(p -> p.price <30000)// filtering data
                .map(p->p.price)        // fetching price
                .collect(Collectors.toList()); // collecting as list
        System.out.println(productPriceList2);

        System.out.println("-------------Using streams to filter and print data------------");   // displaying data

        // This is more compact approach for filtering data
        productsList.stream()
                .filter(product -> product.price == 30000)
                .forEach(product -> System.out.println(product.name));

        System.out.println("-------------Using streams to reduce(combine) data------------");   // displaying data

        Float totalPrice = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,(sum, price)->sum+price);   // accumulating price
        System.out.println(totalPrice);

        System.out.println("-------------Using streams to reduce(combine) data(More precise code)------------");   // displaying data
        // More precise code

        float totalPrice2 = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class
        System.out.println(totalPrice2);

        System.out.println("-------------Using streams to find max------------");   // displaying data
        // max() method to get max Product price
        Product productA = productsList.stream()
                .max((product1, product2)->
                        product1.price > product2.price ? 1: -1).get();
        System.out.println(productA.price);

        System.out.println("-------------Using streams to find min------------");   // displaying data
        // min() method to get min Product price
        Product productB = productsList.stream()
                .max((product1, product2)->
                        product1.price < product2.price ? 1: -1).get();
        System.out.println(productB.price);

        System.out.println("-------------Using streams to find count------------");   // displaying data
        // count number of products based on the filter
        long count = productsList.stream()
                .filter(product->product.price<30000)
                .count();
        System.out.println(count);

    }
}
