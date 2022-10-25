package com.solvd.airport.myBatis;

import com.solvd.airport.models.Staff;
import com.solvd.airport.services.IStaffService;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class StaffServiceTest {
    private IStaffService staffService;
    private Staff staff;

    @BeforeClass
    public void setUp() {
        staffService = new com.solvd.airport.services.myBatisImpl.StaffService();
        staff = new Staff(2, "Pilot", 123);
    }

    @Test
    public void testCreateStaff() {
        List<Staff> staff1 = staffService.getAllStaff();
        int numStaff = staff1.size();
        staffService.createStaff(staff);
        Assert.assertEquals(staffService.getAllStaff().size(), numStaff + 1);
        System.out.println("I created staff");
    }

    @Test(priority = 1)
    public void testGetStaffById() {
        Staff creates = staffService.getStaffByID(2);
        Assert.assertEquals(creates, staff);
        System.out.println("Got staff by id");
    }

    @Test(priority = 2)
    public void testUpdateStaff() {
        Staff updateStaff = staffService.getStaffByID(2);
        staffService.updateStaff(updateStaff);
        Staff s = staffService.getStaffByID(2);
        Assert.assertEquals(s, updateStaff);
        System.out.println("update staff");
    }

    @AfterSuite
    public void destroy() {
        staffService.deleteStaff(2);
    }
}
