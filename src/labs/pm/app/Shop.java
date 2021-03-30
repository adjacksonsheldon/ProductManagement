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
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.ProductManagerException;
import labs.pm.data.Rating;

/**
 *
 * {@code shop} class represents xyz
 *
 * @version 4.0
 * @author a.da.paz.silva
 */
public class Shop {

    public static void main(String[] args) throws ProductManagerException {

        ProductManager pm = new ProductManager("en-US");

//        pm.printAllProducts();
    }

    private static void createAndReviewProduct(ProductManager pm) {
        pm.createProduct(105, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.reviewProduct(105, Rating.FOUR_STAR, "Rather weak tea");
        pm.reviewProduct(105, Rating.THREE_STAR, "Nice hot cup of tea");
        pm.reviewProduct(105, Rating.FIVE_STAR, "Fine tea");
        pm.reviewProduct(105, Rating.TWO_STAR, "Good tea");
        pm.reviewProduct(105, Rating.FIVE_STAR, "Just add some tea");

    }
    
    private static void printAllProducts(ProductManager pm) {
        Comparator<Product> ratingSorter = (o1, o2) -> o2.getRating().ordinal() - o1.getRating().ordinal();
        Comparator<Product> priceSorter = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
        pm.printProducts(priceSorter);
//        pm.getDiscounts().forEach((k, v) -> System.out.println(k + " - " + v));
    }
    
}
