package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        Thread monkey1 = new Thread(unsafeCopier);
        Thread monkey2 = new Thread(unsafeCopier);
        Thread monkey3 = new Thread(unsafeCopier);
        Thread monkey4 = new Thread(unsafeCopier);
        Thread monkey5 = new Thread(unsafeCopier);
        monkey1.start();
        monkey2.start();
        monkey3.start();
        monkey4.start();
        monkey5.start();

        SafeCopier safeCopier = new SafeCopier(introduction);
        Thread monkey6 = new Thread(safeCopier);
        Thread monkey7 = new Thread(safeCopier);
        Thread monkey8 = new Thread(safeCopier);
        Thread monkey9 = new Thread(safeCopier);
        Thread monkey10 = new Thread(safeCopier);
        monkey6.start();
        monkey7.start();
        monkey8.start();
        monkey9.start();
        monkey10.start();

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(unsafeCopier.copied);
        System.out.println(safeCopier.copied);
    }
}