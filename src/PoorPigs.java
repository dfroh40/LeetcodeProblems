public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Can get (T+1)^x outcomes per x pigs and T tests
        // Honestly this is mostly a math problem with test cases
        int T = (minutesToTest/minutesToDie) + 1;
        return (int) Math.ceil(Math.log(buckets)/Math.log(T));
    }
}
