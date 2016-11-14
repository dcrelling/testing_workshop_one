public class InsertEventHandler extends AbstractEventHandler
{
    private static final String TAG = InsertEventHandler.class.getName();

    public InsertEventHandler(MilestoneCache milestoneCache, MilestoneRepository milestoneRepository, AbstractDistanceMilestone distanceMilestone)
    {
        super(milestoneCache, milestoneRepository, distanceMilestone);
    }

    @Override
    public void handle(Trip trip)
    {

        if (!milestoneCache.containsActivity(trip.getUuid()))
        {
            milestoneCache.cacheActivity(trip);

            handleInsertActivity(trip);

            handleInsertDistance(trip);

        }
        else
        {
            LogUtil.w(TAG, "expected trip to not be in the activity cache but was found in the cache");
        }

    }
}


=================

public class InsertEventHandlerTest
{

    private static boolean CACHE_DOES_NOT_CONTAIN_ACTIVITY = false;
    private static boolean CACHE_DOES_NOT_CONTAIN_MILESTONE = false;
    private static Double SHORT_DISTANCE = 5.0;
    private static Double LONG_DISTANCE = 30.0;
    private long startDate;

    @Mock
    private MilestoneRepository mockMilestoneRepository;

    @Mock
    private MilestoneCache mockMilestoneCache;

    @Mock
    private AbstractDistanceMilestone mockDistanceMilestone;

    private InsertEventHandler insertEventHandler;

    @Before
    public void setUp()
    {

        insertEventHandler = new InsertEventHandler(mockMilestoneCache, mockMilestoneRepository, mockDistanceMilestone);
        startDate = new Date().getTime();
    }

    @Test
    public void testNewActivityEventDoesNotRewardActivityMilestone()
    {
        Trip trip = createShortTrip();
        when(mockMilestoneCache.containsActivity(anyLong())).thenReturn(CACHE_DOES_NOT_CONTAIN_ACTIVITY);
        when(mockMilestoneCache.getActivitiesCompleted()).thenReturn(1);
        when(mockDistanceMilestone.getNextMilestoneOnIncrease(anyDouble())).thenReturn(Optional.fromNullable(null));

        insertEventHandler.handle(trip);

    }
}