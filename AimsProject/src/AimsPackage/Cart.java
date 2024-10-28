package AimsPackage;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private int qtyOrdered;
	private DigitalVideoDisc itemOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered]=disc;
			qtyOrdered+=1;
			System.out.println("Added item");
		}else {
			System.out.println("Max number reached");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i,j;
		for(i=0;i<qtyOrdered;i++) {
			if(itemOrdered[i]==disc) {
				for(j=i;j<qtyOrdered;j++) {
					itemOrdered[j]=itemOrdered[j+1];
				}
				break;
			}
		}
		if(i==qtyOrdered) {
			System.out.println("Item not found");
		}else {
			qtyOrdered-=1;
			System.out.println("Removed item");
		}
	}
	public float totalCost() {
		float total=0;
		int i;
		for(i=0;i<qtyOrdered;i++) {
			total+=itemOrdered[i].getCost();
		}
		return total;
	}
	public void listDVD() {
		int i;
		if(qtyOrdered==0) {
			System.out.println("Cart empty");
			return;
		}
		for(i=0;i<qtyOrdered;i++) {
			System.out.println(itemOrdered[i].getTitle());
		}
	}
	public void clearCart() {
		qtyOrdered=0;
		System.out.println("Cart cleared");
	}
	public void cartInfo() {
		System.out.printf("Total cost is: %.2f\n",totalCost());
		System.out.println("List of product: ");
		listDVD();
	}
}
