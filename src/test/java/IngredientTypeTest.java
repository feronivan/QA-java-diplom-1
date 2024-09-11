import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void sauceEnumCheck() {
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingEnumCheck() {
        Assert.assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
