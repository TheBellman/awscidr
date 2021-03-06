package net.parttimepolymath.awscidr;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.NotThreadSafe;
import net.parttimepolymath.iplib.IPRange;

@Builder
@Slf4j
@NotThreadSafe
public class Application implements Runnable {

    @Override
    public void run() {
        try {
            IPRange instance = new IPRange();
            System.out.println(String.join(", ", instance.getRegions()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}