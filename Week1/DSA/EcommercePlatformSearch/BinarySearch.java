package Week1.DSA.EcommercePlatformSearch;

import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + "]";
    }
}

class LinearSearch {
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }
}

public class BinarySearch {
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];
            int compareResult = midProduct.getProductId().compareTo(targetId);

            if (compareResult == 0) {
                return midProduct;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("1", "Laptop", "Electronics"),
                new Product("2", "Shirt", "Clothing"),
                new Product("3", "Book", "Books"),
                new Product("4", "Smartphone", "Electronics"),
                new Product("5", "Shoes", "Footwear")
        };

        Arrays.sort(products, Comparator.comparing(Product::getProductId));

        // Linear Search
        Product result = LinearSearch.linearSearch(products, "3");
        System.out.println("Linear Search Result: " + (result != null ? result : "Product not found"));

        // Binary Search
        result = binarySearch(products, "3");
        System.out.println("Binary Search Result: " + (result != null ? result : "Product not found"));
    }
}
