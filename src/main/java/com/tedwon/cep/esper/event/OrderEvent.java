package com.tedwon.cep.esper.event;

/**
 * Order Event Class.
 * <p/>See http://www.espertech.com/esper/quickstart.php
 * <p>
 * <p/>Creating a Java POJO Event Class
 */
public class OrderEvent {

   private String itemName;
   private double price;

   public OrderEvent(String itemName, double price) {
      this.itemName = itemName;
      this.price = price;
   }

   public String getItemName() {
      return itemName;
   }

   public double getPrice() {
      return price;
   }

   @Override
   public String toString() {
      return "OrderEvent{" +
            "itemName='" + itemName + '\'' +
            ", price=" + price +
            '}';
   }
}
