package Mainpack;

public abstract class food implements consumable, Nutritious{
    private String name=null;
    public food(String name){
        this.name=name;
    }
    public food(){
        this.name=null;
    }
    @Override
    public int calculateCalories() {
        return 0;
    }


    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof food)) return false;
        if (name==null || ((food)arg0).name==null) return false;
        return name.equals(((food)arg0).name);
    }



}
