package j17.assignment;

sealed interface Educational permits Faculty{}

abstract public sealed class Faculty implements Educational permits
        EngineeringFaculty, HumanitiesFaculty, BusinessFaculty {
}
final class EngineeringFaculty extends Faculty {
    public void engineering(){ // custom EngineeringFaculty method
        System.out.println("We teach computer science, civil engineering etc...");
    }
    @Override
    public String toString(){
        return "Engineering";
    }
}
final class HumanitiesFaculty extends Faculty {
    public void humanities(){ // custom HumanitiesFaculty method
        System.out.println("We teach social care, European studies etc...");
    }
    @Override
    public String toString(){
        return "Humanities";
    }
}
final class BusinessFaculty extends Faculty {
    public void business(){ // custom BusinessFaculty method
        System.out.println("We teach accountancy, law, economics etc...");
    }
    @Override
    public String toString(){
        return "Business";
    }
}
