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
package labs.pm.app;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.function.Predicate;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 *
 * {@code shop} class represents xyz
 *
 * @version 4.0
 * @author a.da.paz.silva
 */
public class Shop {

    public static void main(String[] args) {

        ProductManager pm = new ProductManager("en-US");
        
        pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
//        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.printProductReport(101);
        pm.parseReview("101,0,Nice hot cup of tea");
        pm.parseReview("101,4,Rather weak tea");
        pm.parseReview("101,4,Fine tea");
        pm.parseReview("101,5,Good tea");
        pm.parseReview("101,3,Just add some tea");
        
        pm.printProductReport(101);
        
        
//        pm.changeLocale("ru-RU");

//        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.printProductReport(102);
//        pm.parseReview("102,3,Nice hot cup of tea");
//        pm.parseReview("102,5,Just add some tea");
//        pm.parseReview("102,5,Good tea");
//        Comparator<Product> ratingSorter = (o1, o2) -> o2.getRating().ordinal() - o1.getRating().ordinal();
//        Comparator<Product> priceSorter = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
//        pm.printProducts(ratingSorter.thenComparing(priceSorter));
//        Predicate<Product> filterCoffee = p -> p.getId() == 102;
//        pm.printProducts(filterCoffee, priceSorter.thenComparing(ratingSorter));
//        pm.getDiscounts().forEach((k, v) -> System.out.println(k + " - " + v));
    }

}
