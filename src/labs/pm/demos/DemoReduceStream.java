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

import java.util.List;
import java.util.Optional;

/**
 *
 * @author a.da.paz.silva
 */
public class DemoReduceStream {
    public static void main(String[] args) {
        List<String> list = List.of("Adjackson", "Sheldon", "da", "Paz", "Silva");
        
        Optional x1 = list.stream().map(n -> n).reduce((s1, s2) -> s1 + " " + s2);
        
        String x2 = list.stream().map(n -> n).reduce("", (s1, s2) -> s1 + " " + s2);
        
        String x3 = list.stream().map(n -> n).reduce("", (s1, s2) -> s1 + " " + s2, (s1, s2) -> s1 + s2);
        
        System.out.println(x2);
        System.out.println(x3);
    }
}
