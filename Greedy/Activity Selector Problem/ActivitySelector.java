import java.util.*;



public class ActivitySelector implements Activity
{
    String name;
    int startTime, endTime;
    
    //Constructor
    protected ActivitySelector(String name, int st, int et)
    {
        this.name = name;
        this.startTime = st;
        this.endTime = et;
    }
    
    //static factory method
    //Given: the name, start time and end time for the activity.
    //Returns: A new Activity with the given name, start time and end time
    public static Activity make(String name, int st, int et)
    {
        return new ActivitySelector(name, st, et);
    }
    
    //Returns: the name of this activity.
     @Override
    public String getName() {
        return this.name;
    }

    //Returns: the start time of this activity.
    @Override
    public int getStartTime() {
        return this.startTime;
    }

    //Returns: the end time of this activity.
    @Override
    public int getEndTime() {
        return this.endTime;
    }
    
    //Given: A list of activities
    //Returns: A list of activites sorted in the ascending order of their end
    //          times.
    private List<Activity> sort(List<Activity> list)
    {
        List<Activity> sortedList = new ArrayList();
        for(int i=0;i<list.size();i++)
        {
            sortedList = insert(list.get(i),sortedList);
        }
        return sortedList;
    }
    
    private List<Activity> insert(Activity a, List<Activity> list)
    {
        if(list.size()==0)
        {
            list.add(a);
            return list;
        }
        else
        {
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getEndTime()>a.getEndTime())
                {
                    list.add(i, a);
                    return list;
                }
            }
        }
        list.add(a);
        return list;
    }
    
    //Given: A list of Activities
    //Where: the list is sorted in the ascending order of their end times.
    //Returns: the Result set of the problem
    public List<Activity> getSolution(List<Activity> list)
    {
        list = sort(list);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).getName()+" "+list.get(i).getStartTime()+" "+list.get(i).getEndTime());
        List<Activity> sol = new ArrayList();
        for(int i=0;i<list.size();i++)
        {
            if(i==0)
                sol.add(list.get(i));
            else
            {
                if(list.get(i).getStartTime()>=sol.get(sol.size()-1).getEndTime())
                    sol.add(list.get(i));
            }
        }
        return sol;
    }
    
    public static void main(String ar[]) throws Exception
    {
        Activity a1 = make("A1", 0,6);
        Activity a2 = make("A2", 3,4);
        Activity a3 = make("A3", 1,2);
        Activity a4 = make("A4", 5,9);
        Activity a5 = make("A5", 5,7);
        Activity a6 = make("A6", 8,9);
        
        List<Activity> activities = new ArrayList();
        activities.add(a1);
        activities.add(a2);
        activities.add(a3);
        activities.add(a4);
        activities.add(a5);
        activities.add(a6);
        
        List<Activity> sol = a1.getSolution(activities);
        System.out.println("Solution");
        for(int i=0;i<sol.size();i++)
        {
            System.out.println(sol.get(i).getName());
        }
    }
}