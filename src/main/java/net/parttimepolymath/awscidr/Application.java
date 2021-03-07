package net.parttimepolymath.awscidr;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.NotThreadSafe;
import net.parttimepolymath.iplib.IPRange;
import net.parttimepolymath.iplib.Ranges;

import java.util.List;

@Builder
@Slf4j
@NotThreadSafe
public class Application implements Runnable {
    private boolean servicesMode = false;
    private boolean regionsMode = false;
    private boolean ipv6 = false;
    private String regionFilter = null;
    private String serviceFilter = null;

    @Override
    public void run() {
        try {
            Ranges instance = new IPRange();
            List<String> result = null;
            if (regionsMode) {
                result = instance.getRegions();
            } else if (servicesMode) {
                result = instance.getServices();
            } else {
                if (serviceFilter != null && regionFilter != null) {
                    result = instance.getPrefixes(ipv6, regionFilter, serviceFilter);
                } else if (serviceFilter == null && regionFilter != null) {
                    result = instance.getPrefixes(ipv6, regionFilter);
                } else {
                    result = instance.getPrefixes(ipv6);
                }
            }

            if (result != null) {
                System.out.println(String.join("\n", result));
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}