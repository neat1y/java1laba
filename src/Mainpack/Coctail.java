package Mainpack;
public class Coctail extends food {
    private String drink,fruit;
    public Coctail(String drin,String frui){
        super("Коктель");
        this.drink=drin;
        this.fruit=frui;
    }
    public Coctail(){
        super("Коктель");
        this.drink=null;
        this.fruit=null;
    }
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Coctail)) return false;
        return (drink.equals(((Coctail) obj).drink) && (fruit.equals(((Coctail) obj).fruit)));
    }
    public void consume() {
        System.out.println("коктель выпит с "+this.drink + " и "+this.fruit);
    }
    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getFruit() {
        return fruit;
    }

    @Override
    public int calculateCalories(){
        int sum=0;

        if(fruit.equals("манго")){
            sum+=25;
        }
        else if(fruit.equals("банан")){
            sum+=50;
        }
        else if(fruit.equals("груша")){
            sum+=10;
        }
        if(drink.equals("молоко")){
            sum+=40;
        }
        else if(drink.equals("спрайт")){
            sum+=250;
        }

        else if(drink.equals("кофе")){
            sum+=1000;
        }
        else if(drink.equals("вода")){
            sum+=1;
        }
        return sum;
    }

}
