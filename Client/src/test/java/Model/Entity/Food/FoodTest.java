package Model.Entity.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void initTest() {
        for (int i = 0; i < 100; i++) {
            Food food = new Food();
            if (food.getSize() < 5 || food.getSize() > 19) {
                fail("Food size not initialized correctly");
            }
            if (food.getPosition().x < -2560 || food.getPosition().x > 2560) {
                fail("Food position not initialized correctly");
            }
            if (food.getPosition().y < -2560 || food.getPosition().y > 2560) {
                fail("Food position not initialized correctly");
            }
            if (food.getColor() == null) {
                fail("Food color not initialized correctly");
            }
        }
    }

}