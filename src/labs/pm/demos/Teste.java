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

import static java.lang.System.out;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import labs.pm.data.Drink;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 *
 * @author a.da.paz.silva
 */
public class Teste {

    public static void main(String[] args) {

        List<Product> menu = new ArrayList<Product>();

        ProductManager pm = ProductManager.getInstance();

        menu.add(pm.createProduct(101, "Cake", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now()));
        menu.add(pm.createProduct(102, "Coockie", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now()));
        menu.add(pm.createProduct(103, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED));
        menu.add(pm.createProduct(104, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED));
        
        DoubleSummaryStatistics stats = menu.stream()
                .collect(Collectors.summarizingDouble(p -> p.getPrice().doubleValue()));

        String s1 = menu.stream()
                .collect(Collectors.mapping(p -> p.getName(), Collectors.joining(", ")));

        List<Product> drinks = menu.stream()
                .filter(p -> p instanceof Drink)
                .collect(Collectors.toList());

//        drinks.forEach(p -> System.out.println(p));
//
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.UK);

        ToDoubleFunction<Product> mapper = p -> p.getPrice().doubleValue();

        String s2 = menu.stream()
                .collect(Collectors.collectingAndThen(Collectors.averagingDouble(mapper),
                        n -> fmt.format(n)));
        
        Map<Boolean, List<Product>> productTypes = menu.stream().collect(
                Collectors.partitioningBy(p -> p instanceof Drink));
        
        Map<LocalDate, List<Product>> productGroups = menu.stream().collect(Collectors.groupingBy(p -> p.getBestBefore()));
        
        System.out.println(productGroups);

//        System.out.println(s2);

    }

}
