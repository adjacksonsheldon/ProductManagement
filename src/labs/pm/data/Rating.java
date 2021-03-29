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

/**
 *
 * @author a.da.paz.silva
 */
public enum Rating {
    
    NOT_RATED("NOT_RATED"),
    ONE_STAR("ONE_STAR"),
    TWO_STAR("TWO_STAR"),
    THREE_STAR("THREE_STAR"),
    FOUR_STAR("FOUR_STAR"),
    FIVE_STAR("FIVE_STAR");
    
    private String stars;

    private Rating(String stars) {
        this.stars = stars;
    }
    
    public String getStars(){
        return this.stars;
    }
}
