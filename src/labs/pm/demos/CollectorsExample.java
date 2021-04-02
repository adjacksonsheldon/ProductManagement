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

import java.math.BigDecimal;
import java.text.Collator;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 *
 * @author a.da.paz.silva
 */
public class CollectorsExample {
    public static void main(String[] args) {
        ProductManager pm = ProductManager.getInstance();
        
        Product p1 = pm.createProduct(101, "Cake", BigDecimal.valueOf(2.99), Rating.THREE_STAR, LocalDate.now());
        Product p2 = pm.createProduct(102, "Coockie", BigDecimal.valueOf(2.99), Rating.THREE_STAR, LocalDate.now());
        Product p3 = pm.createProduct(103, "Coffee", BigDecimal.valueOf(1.99), Rating.FIVE_STAR);
        Product p4 = pm.createProduct(104, "Tea", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);

        List<Product> list = List.of(p1, p2, p3, p4);
        
        list.stream().collect(Collectors.groupingBy(p -> p.getRating().ordinal()
                                , Collectors.filtering(p -> p.getRating().ordinal() > 3, Collectors.toSet())))
                .forEach((r, p) -> System.out.println(p));
    }
}
