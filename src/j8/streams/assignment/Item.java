package j8.streams.assignment;

class Item{     
    private int id;     
    private String name;     
    public Item(int id, String name){         
        this.id = id;         
        this.name = name;     
    }     
    public Integer getId() {         
        return id;     
    }      
    public void setId(int id) {         
        this.id = id;     
    }      
    public String getName() {         
        return name;     
    }      
    public void setName(String name) {         
        this.name = name;     
    }     
    public String toString(){    // outputs the name   
        return name;     
    } 
}