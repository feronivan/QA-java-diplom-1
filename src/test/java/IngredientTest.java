import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(FILLING, "След кометы", 50.0f);

    @Test
    public void ingredientTypeCheck() {
        String expectedType = String.valueOf(FILLING);
        String actualType = String.valueOf(ingredient.getType());
        Assert.assertEquals(expectedType, actualType);
    }

    @Test
    public void ingredientNameCheck() {
        String expectedName = "След кометы";
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void ingredientPriceCheck() {
        float expectedPrice = 50.0f;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
