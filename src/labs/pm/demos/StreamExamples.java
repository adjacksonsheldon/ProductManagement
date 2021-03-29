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
package labs.pm.demos;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 *
 * @author a.da.paz.silva
 */
public class StreamExamples {

    public static void main(String[] args) {
//
//        final List<Integer> l = List.of(1, 2, 8, 3, 6, 0);
//        
//        final Integer x = 2;
//        
//        IntStream.generate(() -> 2).takeWhile(n
//                -> {
//            System.out.println(n);
//            return n != 3;
//        }).sum();
//        
//        l.stream().parallel().takeWhile(n -> n != 3).mapToInt(v -> {
//            System.out.println(v);
//            return v;
//        }).sum();

//        l.stream().takeWhile(n -> n != 3).forEach(n -> System.out.println(n));
//        l.stream().takeWhile(n -> {
//            System.out.println(n);
//            return n != 3;
//        });
//        int x = IntStream.generate(() -> (int) (Math.random() * 10)).takeWhile(n
//                -> {
//            System.out.println(n);
//            return n != 3;
//        }).sum();
//
//        System.out.println(x);
//       int x = Stream.of("ONE", "TWO", "THREE", "FOUR")
//                .mapToInt(s -> s.length())
//                .peek(i -> System.out.println(i))
//                .filter(i -> i> 3)
//                .peek(i -> System.out.println(i))
//                .sum();
//       
//        System.out.println(x);
//        ProductManager pm = new ProductManager("pt-BR");
//
//        Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        Map<Product, Integer> items = new HashMap<>();
//        items.put(p1, 1);
//        items.put(p2, 3);
//        
//        items.forEach((p, q) -> p.getPrice().multiply(BigDecimal.valueOf(q.intValue())));
//        Predicate<Product> foodFilter =  p -> p instanceof Food;
//        Stream.of("A", "C", "B", "D", "B", "D")
//                .distinct()
//                .sorted()
//                .peek(l -> System.out.println(l))
//                .skip(2)
//                .forEach(l -> System.out.println(l));
//        Stream.of("B", "C", "A", "E", "D", "F")
//                .takeWhile(s -> !s.equals("D"))
//                .dropWhile(s -> !s.equals("C"))
//                .limit(2)
//                .forEach(l -> System.out.println(l));
//        String[] values = {"RED", "GREEN", "BLUE"};
//        boolean allGreen = Arrays.stream(values).allMatch(s -> s.equals("GREEN"));
//        boolean anyGreen = Arrays.stream(values).anyMatch(s -> s.equals("GREEN"));
//        boolean noneGreen = Arrays.stream(values).noneMatch(s -> s.equals("GREEN"));
//        
//        Optional<String> anyColor = Arrays.stream(values).findAny();
//        Optional<String> firstColor = Arrays.stream(values).findFirst();
        String[] values = {};
        long v1 = Arrays.stream(values).filter(s-> s.indexOf('R') != -1).count();
        int v2 = Arrays.stream(values).mapToInt(s -> s.length()).sum();
        OptionalDouble v3 = Arrays.stream(values).mapToInt(v -> v.length()).average();
        
        
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3.getAsDouble());
    }
}
