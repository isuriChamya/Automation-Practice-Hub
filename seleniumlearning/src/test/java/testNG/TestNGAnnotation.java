package testNG;

import org.testng.annotations.Test;

public class TestNGAnnotation {
        //Prioritizing
    @Test(priority = 0)
    public void login(){
        System.out.println("Login");
    }

    @Test(priority = 1)
    public void create(){
        System.out.println("create");
    }

    @Test(priority = 2)
    public void read(){
        System.out.println("read");
    }

    //If we want to disable edit
    @Test(priority = 3, enabled = false)
    public void edit(){
        System.out.println("edit");
    }

    @Test(priority = 4)
    public void delete(){
        System.out.println("delete");
    }

}
