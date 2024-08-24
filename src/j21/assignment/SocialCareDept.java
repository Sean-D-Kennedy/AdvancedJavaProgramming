package j21.assignment;

public final class SocialCareDept extends Department{
    public void socialCare(){
        System.out.println("Custom social care");
    }
    @Override
    public String toString(){
        return "Social Care";
    }
}
