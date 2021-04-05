/*
 * Copyright (C) 2021 a.da.paz.silva
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.client;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import labs.pm.data.Product;
import labs.file.service.ProductFileManager;
import labs.pm.service.ProductManagerException;
import labs.pm.data.Rating;
import java.util.logging.Logger;

/**
 *
 * {@code shop} class represents xyz
 *
 * @version 4.0
 * @author a.da.paz.silva
 */
public class Shop {

    public static void main(String[] args) throws ProductManagerException {
        ProductFileManager pm = ProductFileManager.getInstance();

        AtomicInteger clientCount = new AtomicInteger(0);
        Callable<String> client = () -> {
            String clientId = "Client" + clientCount.incrementAndGet();
            String threadName = Thread.currentThread().getName();
            int productId = ThreadLocalRandom.current().nextInt(7) + 101;
            String languageTag = ProductFileManager.getSupportedLocales()
                    .stream()
                    .skip(ThreadLocalRandom.current().nextInt(6))
                    .findFirst()
                    .get();
            StringBuilder log = new StringBuilder();
            log.append(clientId + " " + threadName + "\n-\tstart of log\t-\n");
            log.append(pm.getDiscounts(languageTag)
                    .entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + entry.getValue())
                    .collect(Collectors.joining("\n")));            
            Product product = pm.reviewProduct(productId, Rating.NOT_RATED, "Yet another review");            
            log.append((product != null) 
                    ? "\nProduct " + productId + " reviewed\n" 
                    : "\nProduct " + productId + " not reviewed\n");
            pm.printProductReport(productId, languageTag, clientId);
            log.append(clientId + " generated report for " + productId + " product");
            log.append("\n-\tend of log\t-\n");
            return log.toString();
        };
        
        List<Callable<String>> clients = Stream.generate(()->client)
                                               .limit(5)
                                               .collect(Collectors.toList());
        
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Future<String>> result = executorService.invokeAll(clients);            
            result.stream().forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error retrieving client log", ex);
                }
            });            
            executorService.shutdown();
        } catch (InterruptedException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error invoke clients", ex);
        }

    }

    private static void createAndReviewProduct(ProductFileManager pm) {
        pm.createProduct(105, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.reviewProduct(105, Rating.FOUR_STAR, "Rather weak tea");
        pm.reviewProduct(105, Rating.THREE_STAR, "Nice hot cup of tea");
        pm.reviewProduct(105, Rating.FIVE_STAR, "Fine tea");
        pm.reviewProduct(105, Rating.TWO_STAR, "Good tea");
        pm.reviewProduct(105, Rating.FIVE_STAR, "Just add some tea");

    }

    private static void printAllProducts(ProductFileManager pm) {
        Comparator<Product> ratingSorter = (o1, o2) -> o2.getRating().ordinal() - o1.getRating().ordinal();
        Comparator<Product> priceSorter = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
        pm.printProducts(priceSorter, "en-US");
        pm.getDiscounts("en-US").forEach((k, v) -> System.out.println(k + " - " + v));
    }

}
