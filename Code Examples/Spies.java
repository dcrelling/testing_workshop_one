
//how would you test this?
public String concat(String first, String second) {...
}


//How would you test this? there is no return value to asser against
public void filter(List<?> list, Predicate<?> predicate) { ... }



public class DLog {
    private final DLogTarget[] targets;

    public DLog(DLogTarget...targets) {
        this.targets = targets;
    }
    public void write(Level level, String message) {
        for (DLogTarget each: targets) {
            each.write(level, message);
        }
    }
}
public interface DLogTarget {
    void write(Level level, String message);
}

public class DLogTest {
    
    @Test
    public void writesEachMessageToAllTargets() throws Exception {
        SpyTarget spy1 = new SpyTarget();
        SpyTarget spy2 = new SpyTarget();
        DLog log = new DLog(spy1, spy2);
        log.write(Level.INFO, "message");
        assertTrue(spy1.received(Level.INFO, "message"));
        assertTrue(spy2.received(Level.INFO, "message"));
    }
    
    private class SpyTarget implements DLogTarget {
        private List < String > log = new ArrayList < String > ();@
        Override
        public void write(Level level, String message) {
            log.add(concatenated(level, message));
        }

        boolean received(Level level, String message) {
            return log.contains(concatenated(level, message));
        }
        private String concatenated(Level level, String message) {
            return level.getName() + ": " + message;
        }
    }
}

