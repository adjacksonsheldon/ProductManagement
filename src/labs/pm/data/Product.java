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
package labs.pm.data;

import java.io.Serializable;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.Objects;

/**
 * {@code produtct} class represents xyz do produto
 *
 * @version 4.0
 * @author a.da.paz.silva
 */
public abstract class Product implements Comparable<Product>, Cloneable, Rateable<Product>, Serializable{

    private static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private int id;
    private String name;
    private BigDecimal price;
    public BigDecimal discount;
    private Rating rating;

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Calcula o desconto com base no valor do produto
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link java.math.BigDecimal BigDecimal} value of the discount
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public void setFiscalDetails(double... values) {
        for (double value : values) {
            System.out.println(value);
        }
    }

    /**
     * Get the value of bestBefore
     *
     * @return the value of bestBefore
     */
    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    public Rating getRating() {
        return rating;
    }

    public abstract Product applyRating(Rating newRating);

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price
                + ", DISCOUNT = " + this.getDiscount() + ", Rating = " + rating.getStars() + 
                ", BestBefore = " + this.getBestBefore() + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Product) {            
            final Product other = (Product) obj;            
            return this.id == other.getId();
        }
        
        return false;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    @Override
    public int compareTo(Product otherProduct){
        return this.name.compareTo(otherProduct.getName());
    }
}
