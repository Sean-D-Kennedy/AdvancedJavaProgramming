package j25.stream_gatherers;

public record User(int id, String email, int purchases) {}

// Record generates accessors + canonical constructor + equals/hashCode/toString (all components, in order)
