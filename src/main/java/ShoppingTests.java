import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingTests {

    eWallet wallet;

    @BeforeTest
    public void intialize() {
        wallet = new eWallet(500);
    }

    @Test
    public void addProductTotheCart() {
        customer customer1 = new customer(wallet);
        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(1, 30.00, "Royal gala");
        Newspaper n1 = new Newspaper(2, 5.00, "The Hindu");
        cart1.addProduct(a1);
        cart1.addProduct(n1);
        System.out.println("items in the Cart for customer " + customer1 + cart1.getShopppingList());

    }

    @Test
    public void getsubTotalForProducts() {
        customer customer1 = new customer(wallet);
        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(6, 30.00, "Royal gala");
        cart1.addProduct(a1);
        System.out.println("subtotal for apples is " + cart1.subTotal(a1));

        Newspaper n1 = new Newspaper(2, 5.00, "The Hindu");
        cart1.addProduct(n1);
        System.out.println("subtotal for newspaper is " + cart1.subTotal(n1));

        Milk m1 = new Milk(2, 80.00, "Cow Milk");
        cart1.addProduct(m1);
        System.out.println("subtotal for milk is " + cart1.subTotal(m1));

    }

    @Test
    public void getTotalBill() {
        customer customer1 = new customer(wallet);
        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(6, 30.00, "Royal gala");
        Newspaper n1 = new Newspaper(2, 5.00, "The Hindu");
        Milk m1 = new Milk(2, 80.00, "Cow Milk");
        cart1.addProduct(a1);
        customer1.addToCart(a1);
        cart1.addProduct(n1);
        customer1.addToCart(n1);
        cart1.addProduct(m1);
        customer1.addToCart(m1);

        System.out.println("Total bill amount is " + cart1.total());
        Assert.assertEquals(350.00, cart1.total());
    }

    @Test
    public void toPayViaWallet() {
        customer customer1 = new customer(wallet);
        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(6, 30.00, "Royal gala");
        Newspaper n1 = new Newspaper(2, 5.00, "The Hindu");
        Milk m1 = new Milk(2, 80.00, "Cow Milk");
        cart1.addProduct(a1);
        customer1.addToCart(a1);
        cart1.addProduct(n1);
        customer1.addToCart(n1);
        cart1.addProduct(m1);
        customer1.addToCart(m1);

        System.out.println("Total bill amount is " + cart1.total());
        double totalAfterDed = 0.00;

        // Applying offer : discount of 5% if cost of customer is >= 100
        if (cart1.total() >= 100)
            totalAfterDed = cart1.total() - (cart1.total() * 0.5);
        wallet.deductBalance(totalAfterDed);
        System.out.println("Wallet balance is " + wallet.getBalance());
        Assert.assertEquals(325.00, wallet.getBalance());


    }
}


