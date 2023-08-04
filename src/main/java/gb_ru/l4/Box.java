package gb_ru.l4;

public class Box {
    private Integer ballsCount;

    public Box() {
        ballsCount = 0;
    }



    public Integer getBallsCount() {
        return ballsCount;
    }


    public void addBall() {
        ballsCount++;
    }

    public void deleteBall() throws BoxIsEmptyExeption {
        if(ballsCount==0) {
            throw new BoxIsEmptyExeption();
        }
        ballsCount--;
    }





}
