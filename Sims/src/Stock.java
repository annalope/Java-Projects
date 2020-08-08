public class Stock {

    private double initialPrice;
    private double currentPrice;
    private String upOrDown;

    public Stock(double initialPrice) {
        this.initialPrice = initialPrice;
        this.currentPrice = initialPrice;
    }

    public void changeCurrentPrice(double percent) {
        currentPrice = roundIt(currentPrice * percent);
    }

    public void stockToString() {
        String dollar;
        String status;
        if (currentPrice == 1) {
           dollar = " dollar";
        } else {
            dollar = " dollars";
        }
        getUpOrDown();
        if (upOrDown.equalsIgnoreCase("even")) {
            status = "even with the price it was purchased for.";
        } else if(upOrDown.equalsIgnoreCase("above")) {
            status = "above the price it was purchased for.";
        } else {
            status = "below the price it was purchased for.";
        }

        System.out.println(currentPrice + dollar + " at the moment. It was purchased for " + initialPrice + " dollars. It is currently " + status);
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    private double roundIt(double unroundedNum) {
        return (Math.round(unroundedNum * 100))/(double) 100;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public String getUpOrDown() {
        if (currentPrice > initialPrice) {
            upOrDown = "above";
        } else if (currentPrice < initialPrice) {
            upOrDown = "below";
        } else {
            upOrDown = "even";
        }
        return upOrDown;
    }
}
