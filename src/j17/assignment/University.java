package j17.assignment;

public class University {
    public static void main(String[] args) {
        // 1. Force an exception
//        LecturerRecord joe = new LecturerRecord("", 22, new BusinessFaculty(), new SocialCareDept());
//        LecturerRecord joe = new LecturerRecord("Joe Bloggs", -3, new BusinessFaculty(), new SocialCareDept());

        // 2. Create a valid lecturer - output details using toString() and individual accessor methods
        LecturerRecord jane = new LecturerRecord("Jane Bloggs", 24, new EngineeringFaculty(), new SoftwareEngineeringDept());
        System.out.println(jane);
//        System.out.println("Name is "+jane.name());
//        System.out.println("Age is "+jane.age());
//        System.out.println("Faculty is "+jane.faculty());
//        System.out.println("Department is "+jane.dept());
//        jane.whichFaculty();
//        jane.whichDept();
//        System.out.println(jane.hasPhd());

//        LecturerRecord anne = new LecturerRecord("Dr. Anne Bloggs", 35, new BusinessFaculty(), new AccountingDept());
//        System.out.println(anne);
//        System.out.println(anne.hasPhd());// true
//        String s = anne.hasPhd() ? "Anne has a PhD" : "Ann does not have a PhD";
//        System.out.println(s);
//        System.out.println(anne.hasPhd() ? "Anne has a PhD" : "Ann does not have a PhD");

//        LecturerRecord joe = new LecturerRecord("Joe Bloggs PhD", 54, new HumanitiesFaculty(), new SocialCareDept());
//        System.out.println(joe);
//        System.out.println(joe.hasPhd() ? "Joe has a PhD" : "Joe does not have a PhD");
    }
}
