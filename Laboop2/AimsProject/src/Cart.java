public class Cart {
  public static final int MAX_NUMBERS_ORDERD = 20;
  private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERD];
  private int qtyOrdered = 0;

  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    if (qtyOrdered == MAX_NUMBERS_ORDERD) {
      System.out.println("The cart is almost full");
      return;
    }

    itemsOrdered[qtyOrdered++] = disc;
    System.out.println("The disc has been added");
  }
  public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    int addedCount = 0; // Biến đếm số lượng đĩa DVD đã thêm thành công

	    for (DigitalVideoDisc disc : dvdList) {
	        if (qtyOrdered == MAX_NUMBERS_ORDERD) { // Kiểm tra xem giỏ hàng đã đầy chưa
	            System.out.println("The cart is almost full. Can't add more disc");
	            break;
	        } else {
	            // Thêm đĩa DVD vào giỏ hàng
	            itemsOrdered[qtyOrdered++] = disc;
	            qtyOrdered++;
	            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
	            addedCount++;
	        }
	    }

	    return addedCount; // Trả về số lượng đĩa DVD đã thêm
	}
  public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
      if (qtyOrdered + 1 >= MAX_NUMBERS_ORDERD) {
          System.out.println("The cart is almost full. Can't add more discs");
          return 0;
      } else {
          itemsOrdered[qtyOrdered] = dvd1;
          qtyOrdered++;
          System.out.println("The DVD " + '\"' + dvd1.getTitle() + '\"' + " has been added!");

          itemsOrdered[qtyOrdered] = dvd2;
          qtyOrdered++;
          System.out.println("The DVD " + '\"' + dvd2.getTitle() + '\"' + " has been added!");

          return 2; //Tra ve so dia DVD da them duoc
      }
  }

  public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
      if(itemsOrdered[0] ==  null) {
          System.out.println("Your cart is empty!");
          return 0;
      }
      for(int i =0; i < qtyOrdered;i++) {
          if(itemsOrdered[i].equals(disc)) {
              for(int j = i;i<qtyOrdered-1;i++) {
                  itemsOrdered[i] = itemsOrdered[i+1];
              }
              itemsOrdered[qtyOrdered-1] = null;
              qtyOrdered--;
              System.out.println("Remove DVD " + '\"'+ disc.getTitle() + '\"' + " successfully!");
              return 1;
          }
      }
      System.out.println("No DVD match!");
      return 0;
  }
  //Hàm tính tổng giá tiền đĩa
  public float totalCost() {
      float sum = 0.00f;
      for(int i =0;i< qtyOrdered;i++) {
          sum += itemsOrdered[i].getCost();
      }
      return sum;
  }

  public void print() {
      StringBuilder output = new StringBuilder("*********************CART************************** \nOrdered items: \n");
      for (int i = 0; i < qtyOrdered;i++) {
          output.append(i+1 + ".[" + itemsOrdered[i].getTitle() + "] - [" + itemsOrdered[i].getCategory() + "] - ["
                  + itemsOrdered[i].getDirector() + "] - [" + itemsOrdered[i].getLength() + "]: "
                  + itemsOrdered[i].getCost() + " $\n");
      }
      output.append("total: ").append(totalCost()).append(" $\n");
      output.append("***************************************************\n");
      System.out.println(output);
  }
  public void searchById(int i) {
      if(i > qtyOrdered) {
          System.out.println("No match found !");
      } else {
          System.out.println("Result: " +  "[" + itemsOrdered[i-1].getTitle() +
                  "] - [" + itemsOrdered[i-1].getCategory() + "] - ["
                  + itemsOrdered[i-1].getDirector() + "] - ["
                  + itemsOrdered[i-1].getLength() + "]: " +itemsOrdered[i-1].getCost() + " $\n");
      }

  }
}