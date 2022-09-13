package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Knapsack {


    public static void main(String[] args) {

        select((Article a1,Article a2)-> a2.value-a1.value);


    }


    static void select(Comparator<Article> cmp){
        Article[] articles=new Article[]{
                new Article(35,10),new Article(30,40),
                new Article(60,30),
                new Article(40,35),
                new Article(25,30),
        };
        Arrays.sort(articles,cmp);

        int capacity=150,weight=0,value=0;
        List<Article> selectedArticle=new LinkedList<Article>();
        for(int i=0;i<articles.length;i++){

            if(weight+articles[i].weight<capacity){
                selectedArticle.add(articles[i]);
                value+=articles[i].value;
                weight+=articles[i].weight;
            }

        }
        System.out.println("value:"+value+"weight:"+weight);
        System.out.println(selectedArticle.toString());

    }
}
