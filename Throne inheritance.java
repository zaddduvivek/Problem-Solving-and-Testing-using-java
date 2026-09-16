import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();

        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        children.putIfAbsent(childName, new ArrayList<>());
        children.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();

        dfs(king, order);

        return order;
    }

    private void dfs(String person, List<String> order) {
        // Add person if alive
        if (!dead.contains(person)) {
            order.add(person);
        }

        // Visit children from oldest to youngest
        for (String child : children.get(person)) {
            dfs(child, order);
        }
    }
}
