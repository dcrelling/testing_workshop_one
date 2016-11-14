//testable design if you wanted to test this class you woudl probably get a NPE 
//the static initializer is getting something from the Sytem which you don't have access to under test
public class DocumentRepository {
    private static final String API_KEY = "d869db7fe62fb07c";
    private static String sessionToken;
    static {
        String serverHostName = System.getenv("ACL_SERVER_HOST");
        SessionClient api = new SessionClientImpl(serverHostName);
        sessionToken = api.openSession(API_KEY);
    }
    public DocumentRepository() {
        ...
    }
}

====================================
//can't overide this static final method
private static final Collaborator getCollaborator() { ... }

@Test
public void test() {
    final Collaborator collaborator = new TestDouble();
    ObjectUnderTest o = new ObjectUnderTest() {@
        Override
        private static final getCollaborator() {
            return collaborator;
        }
    };
    ...
}

//avoid new how can you test this method?
public String createTagName(String topic) {
    Timestamper c = new Timestamper();
    return topic + c.timestamp();
}


//avoid logic in constructors also this class won't be able to be constructed on mac
//because of ipconfig is a windows comand
public class UUID {
    private String value;
    public UUID() {
        // First, obtain the computer's MAC address by
        // running ipconfig.exe and parsing its output
        long macAddress = 0;
        Process p = Runtime.getRuntime().exec(
            new String[] {
                "ipconfig", "/all"
            }, null);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(p.getInputStream()));
        String line = null;
        while (macAddress == null &&
            (line = in .readLine()) != null) {
            macAddress = extractMACAddressFrom(line);
        }
        // Obtain the UTC time and rearrange
        // its bytes for a version 1 UUID
        long timeMillis = (System.currentTimeMillis() * 10000) + 0x01B21DD213814000 L;
        long time = timeMillis << 32;
        time |= (timeMillis & 0xFFFF00000000 L) >> 16;
        time |= 0x1000 | ((timeMillis >> 48) & 0x0FFF);
        ...
    }
}

//here is a refactor but now we can override thoes methods
public class UUID {
    private String value;
    public UUID() {
        long macAddress = acquireMacAddress();
        long timestamp = acquireUuidTimestamp();
        value = composeUuidStringFrom(macAddress, timestamp);
    }
    protected long acquireMacAddress() {...
    }
    protected long acquireUuidTimestamp() {...
    }
    private static String composeUuidStringFrom(
        long macAddress, long timestamp) {...
    }
}

==========================
//singleton we can't sub this

public class Clock {
    private static final Clock singletonInstance = new Clock();
    // private constructor prevents instantiation from other classes
    private Clock() {}
    public static Clock getInstance() {
        return singletonInstance;
    }
}

//we are stuck we can't substitue a different impl of timestamp
public class Log {
    public void log(String message) {
        String prefix = "[" + Clock.getInstance().timestamp() + "] ";
        logFile.write(prefix + message);
    }
}


