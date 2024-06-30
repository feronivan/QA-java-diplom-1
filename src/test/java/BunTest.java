import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Секретная булка", 100},
                {"Invisible bun", 200},
                {null, 300},
                {"b0n", 0},
                {"", 123},
        };
    }

    @Before
    public void setUpBun() {
        bun = new Bun(name, price);
    }

    @Test
    public void bunNameValidCheck() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void bunPriceValidCheck() {
        assertEquals(price, bun.getPrice(), 0.0f);
    }

}
