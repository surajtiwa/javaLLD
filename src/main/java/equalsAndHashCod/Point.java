package equalsAndHashCod;

import java.util.Objects;

public  class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }else if(obj==null || obj.getClass()!=getClass()){
            return false;
        }
        Point point = (Point) obj;
        return this.x==point.x && this.y==point.y?true:false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}