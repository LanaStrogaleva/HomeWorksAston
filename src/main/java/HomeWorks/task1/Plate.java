package HomeWorks.task1;

public class Plate {
    int mealQuantity;

    public Plate(int mealQuantity) {
        this.mealQuantity = mealQuantity;
    }

    public int getMealQuantity() {
        return mealQuantity;
    }

    public void decreaseMeal(int mealQuantity) {
        this.mealQuantity -= mealQuantity;
    }
    public void addMeal(int mealQuantity) {
        this.mealQuantity += mealQuantity;
        System.out.println("В тарелку добавлено еды: " + mealQuantity);
    }

}
