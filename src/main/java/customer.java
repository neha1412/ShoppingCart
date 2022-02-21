public class customer {

    public eWallet wallet;
    public ShoppingCart cart;

    public customer(eWallet wallet) {
        this.wallet = wallet;
        cart= new ShoppingCart();
    }

    public void addToCart(Products products ){
        cart.addProduct(products);
    }

    public void removeToCart(Products products)
    {
        cart.removeProduct(products);
    }

    public void getWalletAmount(){
        wallet.getWalletBalance();
    }

    public void addMoneyToWallet(double amount){
        wallet.addBalance(amount);
    }
}
