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

/**
 *
 * @author a.da.paz.silva
 */
public class Outer {

    public MemberInner createMemnerInner(){
        return new MemberInner();
    }
    
    public static void createShippingMode(String description){
        new ShippingMode(description);
    }
    
    private class MemberInner{}
    
    private static class ShippingMode {
        private String description;

        public ShippingMode(String description) {
            this.description = description;
        }      
    }    
}
