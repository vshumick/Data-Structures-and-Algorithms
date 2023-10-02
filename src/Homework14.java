import java.util.*;

public class Homework14 {
    static ArrayList<Product> backPack = new ArrayList<>();
    public static void main(String[] args) {
        int weight = 1600;

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500, 3700));
        products.add(new Product("Phone", 200, 450));
        products.add(new Product("Tablet", 500, 1200));

        int cost = maxCorrectCost(weight, products);

        System.out.println(cost);
        System.out.println(backPackContains());
    }

    private static int maxCorrectCost(int weight, ArrayList<Product> products){

        //Заполняем рюкзак товарами, начиная с тех у которых самый дорогой юнит.
        //Если рюкзак заполнен, но осталось пространство, которое меньше чем вес самого лёгкого товара,
        //попробуем выкинуть один самый тяжелый товар и вместо него комбинацию из более легких.
        //Запомним все расклада в possibleOptions и в конце выберем какой все таки был более выгодным.
        int cost = maxCost(weight, products);

        if (minWeight(products) > weight){
            return cost;
        }
            Map<Integer,ArrayList<Product>> possibleOptions = new HashMap<>();
            possibleOptions.put(cost, (ArrayList<Product>) backPack.clone());

            ArrayList<Product> copyProducts = (ArrayList<Product>) products.clone();

        while (!copyProducts.isEmpty()) {
            if (backpackWeight() < weight) {
                Product maxWeightInBackPack = maxWeight(backPack);
                backPack.remove(maxWeightInBackPack);
                copyProducts.remove(maxWeightInBackPack);
                cost -= maxWeightInBackPack.price;
                cost += maxCost(weight - backpackWeight(), copyProducts);
                possibleOptions.put(cost, (ArrayList<Product>) backPack.clone());
            } else {
                break;
            }
        }

        cost = (int) Collections.max(possibleOptions.keySet());
        backPack = possibleOptions.get(Integer.valueOf(cost));
        return cost;
    }

    static int backpackWeight(){
        int res = 0;
        for (Product p:backPack){
            res += p.weight;
        }
        return res;
    }

    private static int maxCost(int weight, ArrayList<Product> products) {
        int res = 0;
        Product bargain;
        if (products.isEmpty()) {
            return res;
        }

        //добавление в рюкзак товар с самым дорогим юнитом(стоимость грамма), если вес товара не больше weight
        if (minWeight(products) > weight){
            return res;
        }
        bargain = maxUnitCost(products, weight);
        res = bargain.price;
        if (bargain != null) {
            backPack.add(bargain);
        }
        res += maxCost(weight - bargain.weight, products);

        return res;
    }

    static Product maxUnitCost(ArrayList<Product> products, int weight) {
        Product res = null;
        double maxCost = 0;

        for (Product p : products) {
            if (p.weight <= weight && (double)p.price / (double)p.weight > maxCost) {
                maxCost = (double)p.price / (double)p.weight;
                res = p;
            }
        }
        return res;
    }

    static int minWeight(ArrayList<Product> products) {
        if (!products.isEmpty()) {
            int minWeight = products.get(0).weight;

            for (Product p : products) {
                if (p.weight < minWeight) {
                    minWeight = p.weight;
                }
            }
            return minWeight;
        }
        else {return 0;}
    }

    static Product maxWeight(ArrayList<Product> products) {
        Product maxWeight = products.get(0);

        for (Product p : products) {
            if (p.weight > maxWeight.weight) {
                maxWeight = p;
            }
        }
        return maxWeight;
    }

    static String backPackContains(){
        String res = "Backpack contains: ";
        for (Product p: backPack) {
            res += p.name + " ";
        }
        return res;
    }

    private static class Product {
        String name;
        int weight;
        int price;

        Product(String name, int weights, int price) {
            this.name = name;
            this.weight = weights;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return weight == product.weight && price == product.price && Objects.equals(name, product.name);
        }

        /*@Override
        public int hashCode() {
            return Objects.hash(name, weight, price);
        }*/
    }
}
