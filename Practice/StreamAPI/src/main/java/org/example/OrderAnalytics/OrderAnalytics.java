package org.example.OrderAnalytics;


import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalytics{
    public static void main(String[] args){
        List<Order> orders = Arrays.asList(
                new Order(101, "Ravi", "Electronics", 55000, "Delhi", "PAID"),
                new Order(102, "Sita", "Clothing", 12000, "Mumbai", "PENDING"),
                new Order(103, "Amit", "Furniture", 75000, "Delhi", "PAID"),
                new Order(104, "Priya", "Electronics", 30000, "Chennai", "PAID"),
                new Order(105, "Raj", "Clothing", 8000, "Delhi", "CANCELLED"),
                new Order(106, "Anita", "Furniture", 25000, "Mumbai", "PAID"),
                new Order(107, "Vikram", "Electronics", 95000, "Bangalore", "PAID"),
                new Order(108, "Meena", "Clothing", 60000, "Delhi", "PAID")
        );

        // Paid Orders
        List<Order> paidOrders =  orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("PAID"))
                .collect(Collectors.toList());
        System.out.println("-- PAID ORDERS --");
        paidOrders.forEach(System.out::println);

        // totalOrders
        int totalOrders = (int) orders.stream().count();
        System.out.println("\nTotal size: " + totalOrders);

        //total Revenue
        int totalRevenue = paidOrders.stream()
                .mapToInt(Order::getAmount)
                .sum();

        System.out.println("\nTotal Revenue: " + totalRevenue);

        //Highest Value
        Optional<Order> highest = orders.stream()
                .max(Comparator.comparingInt(Order::getAmount));

        OptionalInt highestOrderValue = orders.stream()
                .mapToInt(Order::getAmount).max();

        System.out.println("Highest Order value: " + highestOrderValue.getAsInt());


        // Lowest paid Order Value
        OptionalInt lowestPaidValueOrder = paidOrders.stream()
                .mapToInt(Order::getAmount).min();

        System.out.println("Lowest Paid Order Amount: " + lowestPaidValueOrder.getAsInt());

        //unique Names
        List<String> uniqueNames = orders.stream()
                .map(Order::getCustomerName)
                .distinct()
                .toList();

        System.out.println("Unique Names: " + uniqueNames);

        // Names above 50000 order value
        List<String> cNames = orders.stream()
                .filter(o -> o.getAmount() > 50000)
                .map(Order::getCustomerName)
                .collect(Collectors.toList());
        System.out.println("Customer Name with Order value above 50000" + cNames);

        //Sort Customers by Order amount Desc
        List<Order> sortedByAmount = orders.stream()
                .sorted(Comparator.comparingInt(Order::getAmount).reversed())
                .toList();
        System.out.println("\nSoretd by Order amount");
        sortedByAmount.forEach(o -> System.out.println("\t" + o.getCustomerName() + " " + o.getAmount()));

        List<Order> topThreeHighest = orders.stream()
                .sorted(Comparator.comparingInt(Order::getAmount).reversed())
                .limit(3).toList();
        System.out.println("\nTop 3 highest Order amount");
        topThreeHighest.forEach(o -> System.out.println("\t" + o.getCustomerName() + " " + o.getAmount()));


        System.out.println("\n\n-----------------------------");
        System.out.println("|          groupBy          |");
        System.out.println("-----------------------------");
        // Group by
        Map<String, List<Order>> groupByCat = orders.stream()
                .collect(Collectors.groupingBy(Order::getCategory));

        groupByCat.forEach((n, o) -> {
                    System.out.println("Category: [" + n + "]");
                    o.forEach(or -> System.out.println("\t" + or));
        });

        // group by cat and count
        Map<String,Long> countOrderPerCat = orders.stream()
                .collect(
                        Collectors.groupingBy(Order::getCategory, Collectors.counting())
                );
        countOrderPerCat.forEach((cat, count) -> {
            System.out.println(cat + " " + count);
        });

        // group by cat , total sales
        Map<String,Integer> totalSalesPerCat = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.summingInt(Order::getAmount)
                        )
                );

        totalSalesPerCat.forEach((cat, sales) -> {
            System.out.println(cat + " -> " + sales);
        });

        // maximum order value per cat
        Map<String, Optional<Order>> maxOrderValuePerCat = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.maxBy(
                                Comparator.comparingInt(Order::getAmount)
                        )
                        )
                );

        maxOrderValuePerCat.forEach((cat, order) -> {
            System.out.print(cat + " -> " + order.get().getAmount());
        });

        // Avg order value per cat
        Map<String,Double> avgOrderValuePerCat = orders.stream()
                .collect(Collectors.groupingBy(
                            Order::getCategory,
                            Collectors.averagingInt(Order::getAmount)
                        )
                );
        avgOrderValuePerCat.forEach((cat, value) -> {
            System.out.print("\n" + cat + " -> " + value);
        });

        System.out.println("\n\n-- group Order by city --");
        Map<String, List<Order>> groupOrderByCity = orders.stream()
                .collect(Collectors.groupingBy(Order::getCity));
        groupOrderByCity.forEach((city, order) -> {
                System.out.println(city);
                order.forEach(o -> System.out.println("\t" + o));
            }
        );

        System.out.println("\n-- City with Highest Total revenue");
        orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCity,
                        Collectors.summingInt(Order::getAmount)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> {
                    System.out.println(entry.getKey()+ " " + entry.getValue());
                });
        System.out.println("-- Average order value per city");
        Map<String, Double> avgValueperCity = orders.stream()
                .collect(Collectors.groupingBy(Order::getCity,
                        Collectors.averagingInt(Order::getAmount)));

        avgValueperCity.forEach((city, avg) -> {
            System.out.println("City: " + city + " avg: " + avg);
        });


        System.out.println("\n\n-----------------------------");
        System.out.println("|        partitionBy        |");
        System.out.println("-----------------------------");

        System.out.println("\n-- Partition orders into PAID vs NON-PAID --");
        Map<Boolean, List<Order>> partitioned = orders.stream()
                .collect(Collectors.partitioningBy(
                        o -> o.getStatus().equalsIgnoreCase("PAID")
                ));
        partitioned.forEach((isPaid, order) -> {
            if(isPaid) System.out.println("PAID: ");
            else System.out.println("NON-PAID: ");
            order.forEach(System.out::println);
        });


        System.out.println("\n-- Count orders in each partition --");
        Map<Boolean, Long> partitionCount = orders.stream()
                .collect(Collectors.partitioningBy(
                        Order::isPaid,
                        Collectors.counting()
                ));
        partitionCount.forEach((isPaid, count) -> {
            if(isPaid) System.out.print("PAID: ");
            else System.out.print("NON-PAID: ");
            System.out.println(count);
        });


        System.out.println("\n-- Find max order amount in each partition --");
        Map<Boolean,Optional<Order>> partitionMaximum = orders.stream()
                .collect(Collectors.partitioningBy(
                        Order::isPaid,
                        Collectors.maxBy(Comparator.comparingInt(Order::getAmount))
                ));
        partitionMaximum.forEach((isPaid, maxOrder) -> {
            if(isPaid) System.out.print("PAID: ");
            else System.out.print("NON-PAID: ");
            System.out.println(maxOrder.get().getAmount());
        });




        String sentence = "hello world hello java world";

        System.out.println(Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(
                    s -> s,
                        Collectors.counting()
                )));
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        Map<Boolean, Long> partitionEven = list.stream()
                .collect(Collectors.partitioningBy(
                        x -> x % 2 == 0,
                        Collectors.counting()
                ));

        System.out.println(partitionEven);

        List<String> str = Arrays.asList("abc", "bcd", "edf");


        Map<String,Integer> map = str.stream()
                .collect(Collectors.toMap(
                        s->s,
                        v -> 1
                ));

        System.out.println(map);

        System.out.println("\nSecond highest order Amount");
        Optional<Order> secondHighest = orders.stream()
                .sorted(Comparator.comparingInt(Order::getAmount).reversed())
                .skip(1)
                .findFirst();
        System.out.println(secondHighest);

        System.out.println("\nMap of id -> amount");
        Map<Integer,Integer> idToAmount = orders.stream()
                .collect(Collectors.toMap(Order::getOrderId, Order::getAmount));
        System.out.println(idToAmount);

        System.out.println("\n-- find duplicate order Amount --");
        Map<Integer,Long> duplicateOrderAmount = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getAmount, 
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        System.out.println(duplicateOrderAmount);

        System.out.println("\n-- Sort Category by totalRevenue --");
        orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.summingInt(Order::getAmount)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        System.out.println("\n-- Check if any cancelled order is above 50,000 --");
        orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("CANCELLED"))
                .filter(o -> o.getAmount() > 50000)
                .findFirst()
                .ifPresent(System.out::println);





    }
}


