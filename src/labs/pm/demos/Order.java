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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 *
 * @author a.da.paz.silva
 */
public class Order {

    private Set<Item> itens = new HashSet<>();
    
    private String customer;

    public void addItem(Product product, int quantity) {
        itens.add(new Item(product, quantity));
    }

    class Item {

        private Product product;
        private int quantity;

        private Item(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public static void main(String[] args) {
        List<Product> menu = new ArrayList<Product>();

        ProductManager pm = ProductManager.getInstance();

        Product p1 = pm.createProduct(101, "Cake", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now());
        Product p2 = pm.createProduct(102, "Coockie", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now());
        Product p3 = pm.createProduct(103, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        Product p4 = pm.createProduct(104, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        
        Order o1 = new Order();
        o1.setCustomer("Joe");
        o1.addItem(p1, 1);
        o1.addItem(p2, 1);
        
        Order o2 = new Order();
        o2.setCustomer("Bob");
        o2.addItem(p1, 1);
        o2.addItem(p2, 1);
        o2.addItem(p3, 1);
        o2.addItem(p4, 1);
        
        Order o3 = new Order();
        o3.setCustomer("Joe");
        o3.addItem(p1, 1);
        o3.addItem(p2, 1);
        o3.addItem(p3, 1);
        o3.addItem(p4, 1);
        
        List orders = List.of(o1, o2, o3);
//        
//        Object c = (Order o) -> o.getCustomer();
        
        
//        Map<String, Set<Product>> customerProducts = 
//                orders
//               .stream()
//               .collect(Collectors.groupingBy(o -> o.getCustomer(),
//                        Collectors.flatMapping(o -> o.getItens().stream(),
//                                                    Collectors.toSet()));
//        Collectors.flatMapping(o -> o.getItems().stream()), 
        
    }
}
