package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job testJob1 = new Job();
        Job testJob2 = new Job();

        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        Job testAllFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testAllFields.getName().getClass().getSimpleName().equals("String"));
        assertTrue(testAllFields.getEmployer() instanceof Employer);
        assertTrue(testAllFields.getLocation() instanceof Location);
        assertTrue(testAllFields.getPositionType() instanceof PositionType);
        assertTrue(testAllFields.getCoreCompetency() instanceof CoreCompetency);


        assertEquals(testAllFields.getName() , "Product tester");
        assertEquals(testAllFields.getEmployer().getValue(), "ACME");
        assertEquals(testAllFields.getLocation().getValue(), "Desert");
        assertEquals(testAllFields.getPositionType().getValue(), "Quality control");
        assertEquals(testAllFields.getCoreCompetency().getValue(), "Persistence");


    }

    @Test
    public void testJobsForEquality(){
        Job testEquality1= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testEquality2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testEquality1.equals(testEquality2));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testToString= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


        assertEquals(testToString.toString().charAt(0), '\n' );
        assertEquals(testToString.toString().charAt(testToString.toString().length() -1 ), '\n' );
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testLabels= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testOutput = "\n"+
        "ID: 1" + "\n"  +
        "Name: Product tester" +"\n"+
        "Employer: ACME" + "\n"+
        "Location: Desert" + "\n"+
        "Position Type: Quality control" + "\n"+
        "Core Competency: Persistence" + "\n";

    assertEquals(testLabels.toString(), testOutput);
    }


    @Test
    public void testToStringHandlesEmptyField(){
          Job testLabels= new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
          String testEmptyOutput = "\n"+
         "ID: 1" + "\n"  +
          "Name: Product tester" +"\n"+
         "Employer: Data not available" + "\n"+
          "Location: Desert" + "\n"+
          "Position Type: Quality control" + "\n"+
          "Core Competency: Persistence" + "\n";

            assertEquals(testLabels.toString(), testEmptyOutput);

        }
}