package j21.assignment;

abstract public sealed class Faculty implements Educational permits
        EngineeringFaculty, HumanitiesFaculty, BusinessFaculty {
}
