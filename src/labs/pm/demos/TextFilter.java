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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import labs.pm.data.Product;

/**
 *
 * @author a.da.paz.silva
 */
public class TextFilter {

    public static boolean removeA(String s) {
        return s.equals("remove A");
    }

    public int sortText(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static void main(String[] args) {
        List<Product> menu = new ArrayList<>();
    }
}
