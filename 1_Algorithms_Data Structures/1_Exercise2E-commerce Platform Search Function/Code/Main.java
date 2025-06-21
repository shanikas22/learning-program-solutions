public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Chair", "Furniture"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Table", "Furniture"),
            new Product(105, "Shoes", "Apparel")
        };

        String searchItem = "Phone";

        // Linear Search
        Product foundLinear = SearchEngine.linearSearch(products, searchItem);
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        // Binary Search
        Product foundBinary = SearchEngine.binarySearch(products, searchItem);
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}
