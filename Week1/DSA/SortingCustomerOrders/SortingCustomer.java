package Week1.DSA.SortingCustomerOrders;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerName=" + customerName + ", totalPrice=" + totalPrice + "]";
    }
}

class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot.getTotalPrice()) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}

public class SortingCustomer {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("1", "Alice", 300.0),
                new Order("2", "Bob", 150.0),
                new Order("3", "Charlie", 200.0),
                new Order("4", "Dave", 250.0),
                new Order("5", "Eve", 100.0)
        };

        // Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("Sorted Orders by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Quick Sort
        Order[] ordersForQuickSort = {
                new Order("1", "Alice", 300.0),
                new Order("2", "Bob", 150.0),
                new Order("3", "Charlie", 200.0),
                new Order("4", "Dave", 250.0),
                new Order("5", "Eve", 100.0)
        };
        QuickSort.quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        System.out.println("Sorted Orders by Quick Sort:");
        for (Order order : ordersForQuickSort) {
            System.out.println(order);
        }
    }
}
