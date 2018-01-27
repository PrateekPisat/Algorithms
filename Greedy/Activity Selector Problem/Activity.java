/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author Prateek
 */
public interface Activity {
   
   //Returns: the name of the Avtivity
   String getName();
   
   //Returns: the start time of the Activity
   int getStartTime();
   
   //Returns: the end time of the Activity
   int getEndTime();
   
   
   List<Activity> getSolution(List<Activity> list);
}
