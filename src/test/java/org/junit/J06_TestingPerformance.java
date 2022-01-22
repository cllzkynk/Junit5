package org.junit;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import static org.junit.jupiter.api.Assertions.assertTimeout;
public class J06_TestingPerformance {
    @Test
    void performance() {
        //assertTimeout(Duration.ofSeconds(2),()-> IntStream.rangeClosed(0,100).sum());
        //assertTimeout(Duration.ofSeconds(2),()-> IntStream.rangeClosed(0,100000).forEach(System.out::print));//print komutu performansa dahil
        //assertTimeout(Duration.ofSeconds(1),()-> IntStream.rangeClosed(0,100000)).forEach(System.out::print);//print komutu performansa dahil değil
        assertTimeout(Duration.ofMillis(1),()-> LongStream.rangeClosed(0,100000000)).forEach(System.out::print);//print komutu performansa dahil değil
    }
}