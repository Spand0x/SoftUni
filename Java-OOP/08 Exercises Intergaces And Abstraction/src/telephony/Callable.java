package telephony;

public interface Callable {
    default String call(){return "Calling... ";};
}
