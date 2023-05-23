package test.se.kth.iv1350.pos.model;

import main.se.kth.iv1350.pos.dto.ItemDTO;
import main.se.kth.iv1350.pos.dto.SaleDTO;
import main.se.kth.iv1350.pos.model.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaleTest {

    private Sale sale;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
    }

    // Test methods will be added here
    @Test
    public void testAddItem() {
        ItemDTO item = new ItemDTO("1", "Banana", 10, 0.25);
        sale.addItem(item, 3);

        SaleDTO saleDTO = sale.generateSaleDTO();
        assertTrue(saleDTO.getItemsInCurrentSale().containsKey(item), "Item not found in the shopping cart");
        assertEquals(3, (int) saleDTO.getItemsInCurrentSale().get(item), "Item quantity does not match");
    }

    @Test
    public void testApplyDiscount() {
        ItemDTO item = new ItemDTO("1", "Banana", 10, 0.25);
        sale.addItem(item, 1);
        sale.applyDiscount(0.10);

        double expectedPrice = Math.round((10 * 1.25) * 0.9);
        assertEquals(expectedPrice, sale.getTotalPriceInclDiscount(), "Discounted price does not match");
    }

    @Test
    public void testGenerateSaleDTO() {
        ItemDTO item1 = new ItemDTO("1", "Banana", 10, 0.25);
        ItemDTO item2 = new ItemDTO("2", "Mango", 20, 0.25);
        sale.addItem(item1, 2);
        sale.addItem(item2, 1);
        sale.applyDiscount(0.10);

        SaleDTO saleDTO = sale.generateSaleDTO();

        assertEquals(2, (int) saleDTO.getItemsInCurrentSale().get(item1), "Item 1 quantity does not match");
        assertEquals(1, (int) saleDTO.getItemsInCurrentSale().get(item2), "Item 2 quantity does not match");
        assertEquals(0.10, saleDTO.getDiscount(), "Discount does not match");
    }

    @Test
    public void testPaidAmount() {
        double paidAmount = 100;
        sale.setPaidAmount(paidAmount);
        assertEquals(paidAmount, sale.getPaidAmount(), "Paid amount does not match");
    }

    @Test
    public void testChange() {
        double change = 20;
        sale.setChange(change);
        assertEquals(change, sale.getChange(), "Change does not match");
    }



}
