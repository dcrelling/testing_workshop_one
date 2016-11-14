public call SimpleService implemnets Service{
    
    private Logger logger
    
    public SimpleService(Logger logger){
        this.logger = logger;
        setup();
    }
    
    private setup(){
        LogLevel level = logger.getLogLevel();
    }
}

public class LoggerStub implements Logger{
    
    public LogLevel getLogLevel(){
        return LogLevel.WARN; //this is not what the concrete class does
    }
}

public class TestSimpleService{
    
    @Before
    public void setUp(){
        SimpleService service = new SimpleService(new LoggerStub());
    }
    
}