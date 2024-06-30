import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient topping;

    @Before
    public void setUpBurger() {
        burger = new Burger();
    }

    @Test
    public void bunCheck() {
        burger.setBuns(bun);
        Bun actual = burger.bun;

        assertEquals(bun, actual);
    }

    @Test
    public void addIngredientCheck() {
        burger.addIngredient(ingredient);
        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals(expected, actual);
    }

    @Test
    public void burgerValidPriceCheck() {
        Mockito.when(bun.getPrice()).thenReturn(101.5f);
        Mockito.when(ingredient.getPrice()).thenReturn(100.5f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actual = burger.getPrice();;
        float expected = 303.5f;

        assertEquals(expected, actual, 0.01f);
    }

    @Test
    public void burgerMoveIngredientsCheck() {
        burger.addIngredient(sauce);
        burger.addIngredient(topping);

        burger.moveIngredient(0, 1);

        Ingredient actual = burger.ingredients.get(1);

        assertEquals(sauce, actual);
    }

    @Test
    public void burgerValidReceiptCheck() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Invisible bun");
        Mockito.when(bun.getPrice()).thenReturn(5.0f);
        Mockito.when(ingredient.getName()).thenReturn("A wonderful day");
        Mockito.when(ingredient.getPrice()).thenReturn(25.0f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);

        String expectedReceipt = String.format("(==== %s ====)%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n", bun.getName(), ingredient.getName(), bun.getName(), 35.0f);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
