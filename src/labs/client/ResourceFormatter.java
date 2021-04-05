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

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import labs.pm.data.Product;
import labs.pm.data.Review;

/**
 *
 * @author a.da.paz.silva
 */
public class ResourceFormatter {

    private final Locale locale;
    private final ResourceBundle resources;
    private final DateTimeFormatter dateFormat;
    private final NumberFormat moneyFormat;

    public ResourceFormatter(Locale locale) {
        this.locale = locale;
        resources = ResourceBundle.getBundle("labs.client.resources", locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }

    public String formatProduct(Product product) {
        return MessageFormat.format(
                resources.getString("product"),
                product.getName(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())
        );
    }

    public String formatReview(Review review) {
        return MessageFormat.format(resources.getString("review"),
                review.getRating().getStars(), review.getComments());
    }

    public String getText(String key) {
        return resources.getString(key);
    }

    public NumberFormat getMoneyFormat() {
        return moneyFormat;
    }

}
