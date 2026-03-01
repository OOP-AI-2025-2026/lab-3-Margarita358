package org.example.task2;

import java.util.Arrays;

public class Cart {

    private Item[] contents;
    private int size;

    public Cart() {
        this.contents = new Item[10];
        this.size = 0;
    }

    public void add(Item item) {
        if (this.size == this.contents.length) {
            resize();
        }
        this.contents[this.size] = item;
        this.size++;
    }

    public void removeById(long id) {
        for (int i = 0; i < this.size; i++) {
            if (this.contents[i].getId() == id) {
                shiftLeft(i);
                return;
            }
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
        this.contents[this.size - 1] = null;
        this.size--;
    }

    private void resize() {
        this.contents = Arrays.copyOf(this.contents, this.contents.length * 2);
    }

    public Item[] getItems() {
        return Arrays.copyOf(this.contents, this.size);
    }

    public int getSize() {
        return this.size;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (int i = 0; i < this.size; i++) {
            sum += this.contents[i].getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return Arrays.toString(getItems());
    }
}