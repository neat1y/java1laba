package Mainpack;
import java.util.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
public class MainApplication {

    public static void main(String[] args){
        food[] breakfest=new food[20];
        int itemsSoFar=0;
        System.out.println("длинна массива аргументов "+ args.length);

        boolean sort_need=false;
        boolean  calor=false;
        int k=0;
        for(int i=0;i<args.length;i++){
            String arg=args[i];
            if(args[i].equals("-calories")){
                calor=true;
            }
            else if(args[i].equals("-sort")){
                sort_need=true;
            }
            else {
                String []parts=arg.split("/");
                try {
                    Class c = Class.forName("Mainpack." + parts[0]);
                    if (parts.length == 3) {

                        Constructor constructor = c.getConstructor(String.class, String.class);
                        breakfest[k] = (food) constructor.newInstance(parts[2], parts[1]);
                        breakfest[k].consume();
                    }

                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    System.out.print(ex);
                } catch (ClassNotFoundException с) {
                    System.out.println("Введите существующий класс!");
                } catch (NoSuchMethodException с) {
                    System.out.println("Введите правильные параметры класса!");
                }
                k++;
            }
        }
        int[] myarray=new int[k];
        for(int i=0;i< k;i++){
          myarray[i]=0;
        }
        for(int i=0;i< k;i++){
            int count =1;
            for(int j=i+1;j< k;j++){
                if(breakfest[i].equals(breakfest[j]) && myarray[i]==0){
                    myarray[j]=1;
                    count++;
                }
            }
            if(myarray[i]==0){
                breakfest[i].consume();
                System.out.println(count + "раз");
            }


        }
        if(calor==true){
            int calori=0;

            for(int i=0;i< k;i++){
               calori+=breakfest[i].calculateCalories();
            }
            System.out.println("завтрак в калориях =" +calori);
        }
        if(sort_need==true){
            Arrays.sort(breakfest, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if(o1==null) return 1;
                    if(o2==null) return -1;
                    if(((food)o1).calculateCalories()==((food)o2).calculateCalories()) return 0;
                    if(((food)o1).calculateCalories()>((food)o2).calculateCalories()) return -1;
                    return 1;
                }
            });
            System.out.println("отсортированный класс");
            for(int i=0;i<k;i++){
                breakfest[i].consume();
            }
        }

    }
}
