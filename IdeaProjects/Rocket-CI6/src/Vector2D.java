public class Vector2D {
    public float x;
    public float y;


    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D vector2D){
        return this.set(vector2D.x, vector2D.y);
    }

    public Vector2D subtractBy(float x, float y){
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D subtractBy(Vector2D vector2D){
        return this.subtractBy(vector2D.x, vector2D.y);
    }

    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D vector2D){
        return this.subtract(vector2D.x, vector2D.y);
    }
    public Vector2D addUp(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D){
        return this.addUp(vector2D.x, vector2D.y);
    }

    public Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D vector2D){
        return this.add(vector2D.x, vector2D.y);
    }

    public Vector2D multiply(float number){
        return this.set(this.x*number, this.y*number);
    }

    public float length(){
        return (float) Math.sqrt(this.x*this.x+this.y*this.y);
    }

    public Vector2D copy(){
        return new Vector2D(this.x,this.y);
    }

    public Vector2D rotate(double angle){
        return new Vector2D( (float)( Math.cos(Math.toRadians(angle))*this.x-Math.sin(Math.toRadians(angle))*this.y),
                (float)( Math.cos(Math.toRadians(angle))*this.y+Math.sin(Math.toRadians(angle))*this.x));
    }

    public Vector2D normalize(){
        return new Vector2D(this.x/length(),this.y/length());
    }


}
