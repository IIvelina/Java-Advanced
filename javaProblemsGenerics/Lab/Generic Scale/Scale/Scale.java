package Scale;
//extends Comparable<T>  -> задължително вс. данни могат да се
// сравняват с compareTo
public class Scale<T extends Comparable<T> >{
    private T left;
    private T right;

    public Scale(T left, T right) {
        //нова везна
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        //compareTo -> сравнява разл. типове данни
        //сравнява 2 елемента и ако получим 1, 0 , -1
        //0 -> е1==е2
        //1 -> е1>е2
        //-1 -> е1<е2
        if (this.left.compareTo(this.right) > 0){
            return this.left;
        }
        if (this.left.compareTo(this.right) < 0){
            return this.right;
        }
        return null; //равни стойности
    }
}
