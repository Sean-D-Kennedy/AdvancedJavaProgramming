import j21.assignment.*;
import java.util.SequencedCollection;
import java.util.ArrayList;
import java.util.SequencedSet;
import java.util.LinkedHashSet;
import java.util.SequencedMap;
import java.util.LinkedHashMap;
import java.util.Map;


    void main() {
		seqColl();
		seqSet();
		seqMap();
		
		EngineeringFaculty engFaculty      = new EngineeringFaculty();
		SoftwareEngineeringDept swEngDept  = new SoftwareEngineeringDept();
        LecturerRecord mikeBloggs          = new LecturerRecord("Mike Bloggs", 44, engFaculty, swEngDept);
		recordPatterns(mikeBloggs);
		
		BusinessFaculty businessFaculty    = new BusinessFaculty();
		AccountingDept accountingDept      = new AccountingDept();
        LecturerRecord alanAustin          = new LecturerRecord("Alan Austin", 64, businessFaculty, accountingDept);
		recordPatterns(alanAustin);
		
		HumanitiesFaculty humanitiesFaculty = new HumanitiesFaculty();
		SocialCareDept socialCareDept       = new SocialCareDept();
        LecturerRecord lisaBloggs           = new LecturerRecord("Lisa Bloggs", 65, humanitiesFaculty, socialCareDept);
		recordPatterns(lisaBloggs);

    }
	void seqColl(){
        // A sequenced collection is a Collection whose elements have a defined encounter order.
        SequencedCollection<LecturerRecord> engColl = new ArrayList<>();

		EngineeringFaculty engFaculty      = new EngineeringFaculty();
		SoftwareEngineeringDept swEngDept  = new SoftwareEngineeringDept();
        LecturerRecord janeBloggs          = new LecturerRecord("Jane Bloggs", 24, engFaculty, swEngDept);
        LecturerRecord anneBloggs          = new LecturerRecord("Dr. Anne Bloggs", 35, engFaculty, swEngDept);
        LecturerRecord joeBloggs           = new LecturerRecord("Joe Bloggs PhD", 54, engFaculty, swEngDept);

		engColl.addFirst(janeBloggs);		// Jane
		engColl.addFirst(anneBloggs);		// Anne, Jane
		engColl.addLast(joeBloggs);			// Anne, Jane, Joe
		System.out.println(engColl);  		// Anne, Jane, Joe
		System.out.println("getFirst() : "+engColl.getFirst());  		// Anne
		System.out.println("getLast() : "+engColl.getLast());  			// Joe
		System.out.println("removeLast() : "+engColl.removeLast());  	// Joe - [Anne, Jane]
		System.out.println(engColl);  			// Anne, Jane
		
		// front to last
		System.out.println("Forwards...");  	// Anne, Jane
		for(LecturerRecord lecturer:engColl){
			System.out.println(lecturer);
		}
		// reverse order
		System.out.println("Backwards...");  	// Jane, Anne
		for(LecturerRecord lecturer:engColl.reversed()){
			System.out.println(lecturer);
		}
    }
	void seqSet(){
		// A sequenced set is a SequencedCollection with no duplicate elements.
		SequencedSet<LecturerRecord> busSet = new LinkedHashSet<>();

		BusinessFaculty businessFaculty    = new BusinessFaculty();
		AccountingDept accountingDept      = new AccountingDept();
        LecturerRecord janeAustin          = new LecturerRecord("Jane Austin", 24, businessFaculty, accountingDept);
        LecturerRecord charlotteBronte     = new LecturerRecord("Dr. Charlotte Bronte", 35, businessFaculty, accountingDept);
        LecturerRecord anneBronte          = new LecturerRecord("Anne Bronte PhD", 54, businessFaculty, accountingDept);

		busSet.addFirst(janeAustin);		// Jane
		busSet.addFirst(janeAustin);		// Jane
		busSet.addFirst(janeAustin);		// Jane
		busSet.addFirst(charlotteBronte);	// Charlotte, Jane
		busSet.addLast(janeAustin);			// Charlotte, Jane
		busSet.addLast(anneBronte);			// Charlotte, Jane, Anne
		System.out.println(busSet);  		// Charlotte, Jane, Anne
		System.out.println("getFirst() : "+busSet.getFirst());  	// Charlotte
		System.out.println("getLast() : "+busSet.getLast());  		// Anne
		System.out.println("removeFirst() : "+busSet.removeFirst());// Charlotte - [Jane, Anne]
		System.out.println(busSet);  		// Jane, Anne
		
		// front to last
		System.out.println("Forwards...");  // Jane, Anne
		for(LecturerRecord lecturer:busSet){
			System.out.println(lecturer);
		}
		// reverse order
		System.out.println("Backwards..."); // Anne, Jane
		for(LecturerRecord lecturer:busSet.reversed()){
			System.out.println(lecturer);
		}
	}
	void seqMap(){
        // A sequenced map is a Map whose entries have a defined encounter order.
        SequencedMap<LecturerRecord, String> humanitiesMap = new LinkedHashMap<>();

		HumanitiesFaculty humanitiesFaculty = new HumanitiesFaculty();
		SocialCareDept socialCareDept       = new SocialCareDept();
        LecturerRecord kingLear             = new LecturerRecord("King Lear", 88, humanitiesFaculty, socialCareDept);
        LecturerRecord goneril              = new LecturerRecord("Goneril", 55, humanitiesFaculty, socialCareDept);
        LecturerRecord regan                = new LecturerRecord("Regan", 50, humanitiesFaculty, socialCareDept);
        LecturerRecord cordelia             = new LecturerRecord("Cordelia", 45, humanitiesFaculty, socialCareDept);

		humanitiesMap.putFirst(goneril, "Eldest");	// goneril=Eldest
		humanitiesMap.putFirst(regan, "Middle");	// regan=Middle, goneril=Eldest
		humanitiesMap.putLast(cordelia, "Youngest");// regan=Middle, goneril=Eldest, cordelia=Youngest
		humanitiesMap.putLast(kingLear, "Father");	// regan=Middle, goneril=Eldest, cordelia=Youngest, kingLear=Father
		System.out.println(humanitiesMap);  		// {regan=Middle, goneril=Eldest, cordelia=Youngest, kingLear=Father}
		System.out.println("firstEntry() : "+humanitiesMap.firstEntry());  			// regan=Middle
		System.out.println("lastEntry() : "+humanitiesMap.lastEntry());  			// kingLear=Father
		System.out.println("pollLastEntry() :"+humanitiesMap.pollLastEntry());  	// kingLear=Father {regan=Middle, goneril=Eldest, cordelia=Youngest}
		System.out.println(humanitiesMap);  		// {regan=Middle, goneril=Eldest, cordelia=Youngest}
		
		// front to last
		System.out.println("Forwards...");  	// {regan=Middle, goneril=Eldest, cordelia=Youngest}
		for(Map.Entry<LecturerRecord, String> entry:humanitiesMap.entrySet()){
			System.out.println(entry.getKey() + "; " + entry.getValue());
		}
		// reverse order
		System.out.println("Backwards...");  	// cordelia=Youngest, goneril=Eldest, regan=Middle
		for(Map.Entry<LecturerRecord, String> entry:humanitiesMap.reversed().entrySet()){
			System.out.println(entry.getKey() + "; " + entry.getValue());
		}

    }
	void recordPatterns(Object obj){		
		// Calculate the staff that either should be retired or are reaching retirement  age
		// within the next year i.e. age >= 64 (retirement age is 65). 
        System.out.println(
            switch(obj){
                case LecturerRecord(String name, Integer age, Faculty faculty, Department dept)
				when age >= 64    -> {
					String output = """
						Name: %s,
						Age: %s,
						Faculty: %s,
						Department: %s
					""".formatted(name, age, faculty, dept);
					yield output;
				}
                case null, default -> "";
            }
        );
		
	}

