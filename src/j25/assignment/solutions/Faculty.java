package j25.assignment.solutions;

abstract public sealed class Faculty implements Educational permits
        EngineeringFaculty, HumanitiesFaculty, BusinessFaculty {
}
