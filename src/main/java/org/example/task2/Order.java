package org.example.task2;

public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String formOrderBill(Cart cart) {

        StringBuilder builder = new StringBuilder();
        builder.append("Order number ")
                .append(this.id)
                .append(" for customer ")
                .append(this.customer);
        builder.append("\n------------------\n");

        double sum = 0.0;

        Item[] items = cart.getItems();

        for (Item item : items) {

            sum += item.getPrice();

            builder.append("Item id: ")
                    .append(item.getId())
                    .append(" name: ")
                    .append(item.getName())
                    .append(" price: ")
                    .append(item.getPrice())
                    .append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ").append(sum);

        return builder.toString();
    }
}
